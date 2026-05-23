package APS.combat;

import APS.entities.personagens.Mobs;
import APS.entities.personagens.Player;
import APS.entities.personagens.enemyAI;
import APS.ui.SistemaMenu;
import java.util.Scanner;

public class SistemaDeCombate {

    // (Polimorfismo de Classe) - O método aceita qualquer variação ou subclasse de Player e Mobs de maneira genérica
    public static void iniciarCombate(Player player, Mobs enemy, Scanner sc) {

        System.out.println("\nCombate iniciado!");

        // (Encapsulamento) - Verificação de estado interno dos objetos via métodos públicos
        while (player.vivo() && enemy.vivo()) {

            SistemaMenu.status(player, enemy);

            Action playerAction = SistemaMenu.turnoJogador(player, sc);

            // MAGIAS
            if (playerAction == Action.MAGIA) {

                boolean voltarMenu = false;

                while (!voltarMenu) {
                    player.mostrarSkills();
                    System.out.println("Digite a magia:");
                    System.out.println("Ou digite 'sair' para voltar");

                    String skillEscolhida = sc.nextLine();

                    if (skillEscolhida.equalsIgnoreCase("sair")) {

                        voltarMenu = true;
                        SistemaMenu.status(player, enemy);
                        playerAction = SistemaMenu.turnoJogador(player, sc);

                        if (playerAction != Action.MAGIA) {
                            break;
                        }
                        continue;
                    }

                    // (Encapsulamento) - O objeto processa uma lógica interna(gastar mana, aplicar efeito) expondo apenas o sucesso ou falha da ação
                    boolean usou = player.usarMagia(skillEscolhida, enemy);

                    if (usou) {
                        break;
                    }
                }
            }

            // INVENTARIO
            if (playerAction == Action.INV) {

                boolean voltarMenu = false;

                while (!voltarMenu) {

                    // (Encapsulamento) - Método acessor de listagem que esconde como a coleção interna do inventário está estruturada
                    player.getInventario();

                    System.out.println("Digite o Item a ser usado");
                    System.out.println("Ou digite 'sair' para voltar");

                    String itemToUse = sc.nextLine();

                    if (itemToUse.equalsIgnoreCase("sair")) {

                        voltarMenu = true;
                        SistemaMenu.status(player, enemy);
                        playerAction = SistemaMenu.turnoJogador(player, sc);

                        if (playerAction != Action.INV) {
                            break;
                        }
                        continue;
                    }

                    boolean usou = player.usarItem(itemToUse, enemy, player);

                    if (usou) {
                        break;
                    }
                }
            }

            // IA INIMIGA
            Action enemyAction = enemyAI.decidir(enemy, player);

            // (Encapsulamento) - Uso de gets públicos para ler os dados do inimigo sem acessar diretamente os atributos privados
            if (enemy.getHp() < enemy.getMaxHp() * 0.3) {
                System.out.println(enemy.getNome() + " parece fraco...");
            }

            // DEFESA PLAYER
            if (playerAction == Action.DEFEND) {
                int defesa = 3 + (int) (Math.random() * 5);
                // (Encapsulamento) - Altera o estado de defesa do jogador passando um parâmetro calculado externamente
                player.defender(defesa);
                System.out.println(player.getNome() + " se preparou! DEF +" + defesa);
            }

            // DEFESA INIMIGO
            if (enemyAction == Action.DEFEND) {
                enemy.defender(5);
                System.out.println(enemy.getNome() + " levantou a guarda!");
            }

            if (enemyAction == Action.CAUTIOUS) {
                enemy.defender(2);
                System.out.println(enemy.getNome() + " está cauteloso.");
            }

            // HABILIDADE AGRESSIVA
            if (enemy.getTipo() != null &&
                    enemy.getTipo().equals("AGRESSIVO")) {

                if (Math.random() < 0.4) {
                    System.out.println("O boss ataca duas vezes!");
                    SistemaDeAcao.atacar(enemy, player);
                }
            }

            // QUEBRA DEFESA
            if (playerAction == Action.DEFEND && Math.random() < 0.3) {
                System.out.println(enemy.getNome() + " quebra sua defesa!");
                player.receberDano(5);
            }

            // ATAQUE PLAYER
            if (playerAction == Action.ATTACK) {

                if (Math.random() < 0.25) {
                    System.out.println("Ataque especial!");
                    player.atacarEspecial(enemy);

                } else {
                    SistemaDeAcao.atacar(player, enemy);
                }
            }

            // TURNO INIMIGO

            if (enemy.isStun()) {
                System.out.println(enemy.getNome() + " está atordoado e perdeu o turno!");
                // (Encapsulamento) - Modificação direta de uma propriedade de controle via método set público
                enemy.setStun(false);

            } else if (enemy.vivo() &&
                    enemyAction == Action.ATTACK) {

                // counter defesa
                if (playerAction == Action.DEFEND) {
                    System.out.println("Defesa perfeita! Dano reduzido!");
                    player.defender(
                            player.getDefTotal() + 5);
                }

                // HABBILIDADES ESPECIAIS
                if (enemy.getTipo() != null) {

                    if (enemy.getTipo().equals("AGRESSIVO") && Math.random() < 0.3) {
                        System.out.println("O boss entrou em fúria!");
                        SistemaDeAcao.atacar(enemy, player);
                    }
                    if (enemy.getTipo().equals("INTELIGENTE") && Math.random() < 0.2) {
                        System.out.println("O boss previu seu ataque!");
                        enemy.defender(10);
                    }
                }

                SistemaDeAcao.atacar(enemy, player);
            }

            // RESET TURNO
            player.resetTurno();
            enemy.resetTurno();
        }

        // RESULTADO FINAL
        SistemaMenu.status(player, enemy);
        System.out.println("\n===== RESULTADO =====");

        if (player.vivo()) {

            System.out.println("Você venceu!");
            System.out.println("EXP ganho: " + enemy.getXpDrop() + "\nDinheiro ganho: " + enemy.getMoedasDrop());

            player.ganharXP(enemy.getXpDrop(), sc);
            player.ganharMoedas(enemy.getMoedasDrop());
            player.setKillCount(player.getKillCount() + 1);
            player.statUper();

        } else {
            System.out.println("Você perdeu...");
        }
    }
}