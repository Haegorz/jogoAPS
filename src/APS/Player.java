package APS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player extends Personagens {

	private int level = 1;
	private int exp = 0;
	private int proximoLevel = 50;
	private EquipItem armadura;
	private EquipItem arma;
	private HashMap<String, Integer> inventario;
	private HashMap<String, Item> catalogo;
	private ArrayList<Skill> skills;
	private int moedas;

	public Player(String nome, int hp, int atk, int def, int mp) {
		super(nome, hp, atk, def, mp);
		this.inventario = new HashMap<>();
		this.catalogo = new HashMap<>();
		skills = new ArrayList<>();
		this.moedas = 100;
	}

	public int getLevel() {
		return level;
	}

	public void ganharMoedas(int quantidade) {
		this.moedas += quantidade;
	}

	public void ganharXP(int quantidade, Scanner sc) {
		exp += quantidade;

		while (exp >= proximoLevel) {
			subirNivel(sc);
		}
	}

	public void getInventario() {
		for (String item : inventario.keySet()) {
			System.out.println(item + "--------" + inventario.get(item));
		}
	}

	public void getBattleInventario() {
		for (String item : inventario.keySet()) {
			if (catalogo.get(item) instanceof BattleItem) {
				System.out.println(item + "--------" + inventario.get(item));
			} else {
				continue;
			}

		}
	}

	private void subirNivel(Scanner sc) {
		level++;
		exp -= proximoLevel;
		proximoLevel = (int) (proximoLevel * 1.5);
		if (proximoLevel <= 0)
			proximoLevel = 1;

		System.out.println("\n" + getNome() + " subiu para o nível " + level + "!");

		while (true) {
			System.out.println("\nEscolha um atributo para evoluir:");
			System.out.println("1 - Força (ATK +3)");
			System.out.println("2 - Vitalidade (HP +15)");
			System.out.println("3 - Defesa (DEF +2)");
			System.out.println("4 - Magia (MP+10) ");

			try {
				int escolha = sc.nextInt();
				sc.nextLine();

				switch (escolha) {
					case 1:
						aumentarAtk(3);
						System.out.println("Força aumentada!");
						break;

					case 2:
						aumentarMaxHp(15);
						System.out.println("Vida aumentada!");
						break;

					case 3:
						aumentarDef(2);
						System.out.println("Defesa aumentada!");
						break;
					case 4:
						aumentarMaxMp(10);
						System.out.println("MP aumentado!");
						break;

					default:
						System.out.println("Escolha inválida.");
						continue;
				}
				break;

			} catch (Exception e) {
				System.out.println("Digite um número válido!");
				sc.nextLine();
			}
		}

		curarTotal();
		mpTotal();

	}

	public void atacarEspecial(Mobs inimigo) {

		System.out.println("\n" + getNome() + " usa sua habilidade!");

		switch (nome) {

			case "Cavaleiro":

				int danoCav = getAtk() - inimigo.getDefTotal();
				if (danoCav < 1)
					danoCav = 1;

				inimigo.receberDano(danoCav);

				System.out.println("Ataque pesado causou " + danoCav + " de dano!");

				// bônus defensivo
				this.defender(5);
				System.out.println("Você aumentou sua defesa!");

				break;

			case "Mago":

				int danoMago = getAtk() * 2; // ignora defesa
				inimigo.receberDano(danoMago);

				System.out.println("Magia poderosa causou " + danoMago + " de dano!");

				break;

			case "Espadachim":

				int hits = 2 + (int) (Math.random() * 2); // 2 ou 3 ataques

				System.out.println("Ataque rápido! " + hits + " golpes!");

				for (int i = 0; i < hits; i++) {

					int danoEsp = getAtk() - inimigo.getDefTotal();
					if (danoEsp < 1)
						danoEsp = 1;

					// chance de crítico
					if (Math.random() < 0.25) {
						danoEsp *= 2;
						System.out.println("CRÍTICO!");
					}

					inimigo.receberDano(danoEsp);
					System.out.println("Golpe causou " + danoEsp);
				}

				break;

			default:
				sistemaDeAcao.atacar(this, inimigo);
		}

		// ===== STUN GLOBAL =====
		if (Math.random() < 0.15) {
			System.out.println("O inimigo ficou atordoado!");
			inimigo.setStun(true);
		}
	}

	public void addFlag(String flag) {
		flags.add(flag);
	}

	public boolean temFlag(String flag) {
		return flags.contains(flag);
	}

	public void removeFlag(String flag) {
		flags.remove(flag);
	}

	private Set<String> flags = new HashSet<>();

	public void aprenderSkill(Skill skill) {
		skills.add(skill);
	}

	public void adicionarItem(String nome, Item item, int quantidade) {
		nome = nome.toLowerCase();

		if (inventario.containsKey(nome)) {
			int novaQuant = inventario.get(nome) + quantidade;
			inventario.replace(nome, novaQuant);
		} else {
			inventario.put(nome, quantidade);
		}

		catalogo.put(nome, item);
	}

	public void removerItem(String nome) {

		Integer quantidade = inventario.get(nome);

		if (quantidade != null) {
			quantidade--;

			if (quantidade <= 0) {
				inventario.remove(nome);
			} else {
				inventario.put(nome, quantidade);
			}
		}
	}

	public boolean usarItem(String nome, Mobs enemy, Player player) {
		nome = nome.toLowerCase();
		Item item = catalogo.get(nome);
		Integer quantidade = inventario.get(nome);

		if (item == null || quantidade == null || quantidade <= 0) {
			System.out.println("Item não encontrado!");

			return false;
		}

		if (item instanceof BattleItem) {

			Scanner scan = new Scanner(System.in);

			System.out.println("Em quem deseja usar?");
			System.out.println("1 - Inimigo");
			System.out.println("2 - Player");

			int alvo = scan.nextInt();
			scan.nextLine();

			switch (alvo) {

				case 1:
					removerItem(nome);
					((BattleItem) item).usar(enemy);
					return true;
				case 2:
					removerItem(nome);
					((BattleItem) item).usar(player);
					return true;
				default:
					System.out.println("Alvo inválido!");
					return false;
			}
		}

		if (item instanceof EquipItem) {

			System.out.println(
					"Equipamentos não podem ser usados em batalha!");

			return false;
		}

		return false;
	}

	public void mostrarSkills() {

		System.out.println("===== SKILLS =====");

		for (Skill skill : skills) {
			System.out.println(
					skill.getNome()
							+ " | DMG: " + skill.getDano()
							+ " | MP: " + skill.getCustoMp());
		}
	}

	public boolean usarMagia(String nomeSkill, Mobs enemy) {

		for (Skill skill : skills) {

			if (skill.getNome().equalsIgnoreCase(nomeSkill)) {

				if (mp < skill.getCustoMp()) {
					System.out.println("MP insuficiente!");
					return false;
				}

				mp -= skill.getCustoMp();
				System.out.println( getNome() + " usou " + skill.getNome());
				enemy.receberDano(skill.getDano());

				return true;
			}
		}

		System.out.println("Skill não encontrada.");
		return false;
	}

	public boolean usarItemForaDeBatalha(String nome) {
		nome = nome.toLowerCase();
		Item item = catalogo.get(nome);

		Integer quantidade = inventario.get(nome);

		if (item == null || quantidade == null || quantidade <= 0) {
			System.out.println("Você não possui esse item.");
			return false;
		}

		// ITEM DE BATALHA
		if (item instanceof BattleItem) {
			((BattleItem) item).usar(this);
			removerItem(nome);

			return true;
		}

		// EQUIPAMENTO
		if (item instanceof EquipItem) {
			EquipItem equip = (EquipItem) item;
			switch (equip.getType()) {
				case ATK:
					aumentarAtk(equip.status);
					arma = equip;
					removerItem(nome);
					System.out.println(equip.getNome() + " equipada!");
					break;

				case DEF:

					aumentarDef(equip.status);
					armadura = equip;
					removerItem(nome);
					System.out.println( equip.getNome() + " equipada!");
					break;
			}

			return true;
		}

		System.out.println(
				"Esse item não pode ser usado agora.");

		return false;
	}

	public int getMoedas() {
		return moedas;
	}

	public int setMoedas(int moedas) {
		return this.moedas += moedas;
	}
}