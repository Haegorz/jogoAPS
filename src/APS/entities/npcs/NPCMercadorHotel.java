package APS.entities.npcs;

import APS.entities.personagens.Player;
import APS.events.ResultadoEvento;
import APS.items.BattleItem;
import APS.items.EquipItem;
import APS.items.TipoItem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NPCMercadorHotel extends NPC {
    private int flag;

    public NPCMercadorHotel() {
        super("Mercador");
        flag = 0;
    }

    @Override
    public ResultadoEvento conversar(Player player, Scanner sc) {

        System.out.println("\n======= MERCADOR =======");
        System.out.println("Moedas: " + player.getMoedas());

        System.out.println("1 - Poção HP (+20 HP) ........ 20 moedas");
        System.out.println("2 - Poção MP (+20 MP) ........ 15 moedas");
        System.out.println("3 - Espada de Ferro (+15 ATK) . 200 moedas");
        System.out.println("4 - Armadura de Couro (+15 DEF) 190 moedas");
        System.out.println("5 - Sair");

        int op;

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

                if (player.getMoedas() < 200) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-200);
                player.adicionarItem("espada de mithril",new EquipItem("Espada de Mithril",TipoItem.ATK,15),1);
                System.out.println("Você comprou uma Espada de Mithril!");

                return ResultadoEvento.CONTINUAR;

            case 4:

                if (player.getMoedas() < 190) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-190);
                player.adicionarItem("armadura de mithril",new EquipItem("Armadura de Mithril",TipoItem.DEF,15),1);
                System.out.println("Você comprou uma Armadura de Mithril!");
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