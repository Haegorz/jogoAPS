package APS.entities.npcs;

import APS.entities.personagens.Player;
import APS.events.ResultadoEvento;
import APS.items.BattleItem;
import APS.items.EquipItem;
import APS.items.TipoItem;
import java.util.InputMismatchException;
import java.util.Scanner;

// (Herança) - NPCMercadorEscola estende a superclasse NPC, herdando sua estrutura base
public class NPCMercadorEscola extends NPC {

    // (Método Construtor) - Inicializa o objeto chamando o construtor pai para definir o nome "Mercador"
    public NPCMercadorEscola() {
        super("Mercador");
    }

    // (Sobrescrita) - Altera o comportamento do método 'conversar' definido na classe mãe NPC usando a anotação @Override
    @Override
    public ResultadoEvento conversar(Player player, Scanner sc) {

        System.out.println("\n======= MERCADOR =======");
        // (Encapsulamento) - Obtém o valor do atributo privado de moedas do Player usando o método get público
        System.out.println("Moedas: " + player.getMoedas());

        System.out.println("1 - Poção HP (+20 HP) ........ 20 moedas");
        System.out.println("2 - Poção MP (+20 MP) ........ 15 moedas");
        System.out.println("3 - Espada de Ferro Encantada (+10 ATK) . 130 moedas");
        System.out.println("4 - Armadura de Couro Encantada (+10 DEF) 120 moedas");
        System.out.println("5 - Sair");

        int op;

        // (Tratamento de Exceções) - Bloco try-catch para lidar com possíveis erros de tipo de dado na entrada do Scanner
        try {

            op = sc.nextInt();
            sc.nextLine();

        } catch (InputMismatchException e) {

            System.out.println("Digite um número válido!");
            sc.nextLine();

            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {


            case 1:

                if (player.getMoedas() < 20) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-20);

                // (Instanciação de Objeto) - Cria uma nova instância de BattleItem diretamente na passagem de parâmetros
                player.adicionarItem("pocao_hp", new BattleItem("Poção HP", TipoItem.HP, 20), 1);
                System.out.println("Você comprou uma Poção HP!");

                return ResultadoEvento.CONTINUAR;

            case 2:

                if (player.getMoedas() < 15) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-15);
                player.adicionarItem("pocao_mp", new BattleItem("Poção MP", TipoItem.MP, 20), 1);
                System.out.println("Você comprou uma Poção MP!");
                return ResultadoEvento.CONTINUAR;

            case 3:

                if (player.getMoedas() < 130) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-130);
                // (Instanciação de Objeto) - Cria  um objeto do tipo EquipItem
                player.adicionarItem("espada de ferro encantada",new EquipItem("Espada de Ferro Encantada",TipoItem.ATK,10),1);
                System.out.println("Você comprou uma Espada de Ferro Encantada!");
                return ResultadoEvento.CONTINUAR;

            case 4:

                if (player.getMoedas() < 120) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-120);
                player.adicionarItem("armadura de couro encantada",new EquipItem("Armadura de Couro Encantada",TipoItem.DEF,10),1);
                System.out.println("Você comprou uma Armadura de Couro Encantada!");
                return ResultadoEvento.CONTINUAR;

            case 5:
                System.out.println("Mercador: Volte sempre!");
                return ResultadoEvento.SAIR_MAPA;

            default:
                System.out.println("Opção inválida!");
                return ResultadoEvento.CONTINUAR;
        }
    }
}