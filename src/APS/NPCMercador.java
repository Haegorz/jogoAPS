package APS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NPCMercador extends NPC {

    public NPCMercador() {
        super("Mercador");
    }

    @Override
    public ResultadoEvento conversar(Player player, Scanner sc) {

        System.out.println("\n======= MERCADOR =======");
        System.out.println("Moedas: " + player.getMoedas());

        System.out.println("1 - Poção HP (+20 HP) ........ 20 moedas");
        System.out.println("2 - Poção MP (+20 MP) ........ 15 moedas");
        System.out.println("3 - Super Poção HP (+20 HP) .. 40 moedas");
        System.out.println("4 - Espada de Ferro (+5 ATK) . 70 moedas");
        System.out.println("5 - Armadura de Couro (+4 DEF) 60 moedas");
        System.out.println("6 - Sair");

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

                BattleItem hpPotion =
                    new BattleItem("Poção HP", TipoItem.HP, 20);

                player.adicionarItem( "Poção HP", hpPotion, 1 );

                System.out.println("Você comprou uma Poção HP!");

                return ResultadoEvento.CONTINUAR;

            case 2:

                if (player.getMoedas() < 15) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-15);
                BattleItem mpPotion = new BattleItem( "Poção MP", TipoItem.MP, 20 );
                player.adicionarItem( "Poção MP", mpPotion, 1 );
                System.out.println("Você comprou uma Poção MP!");
                return ResultadoEvento.CONTINUAR;

            case 3:

                if (player.getMoedas() < 40) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-40);

                BattleItem superPotion = new BattleItem( "Super Poção", TipoItem.HP, 50 );

                player.adicionarItem( "Super Poção", superPotion, 2 );

                System.out.println("Você comprou Super Poções!");

                return ResultadoEvento.CONTINUAR;

            case 4:

                if (player.getMoedas() < 70) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-70);
                EquipItem espada = new EquipItem( "Espada de Ferro", TipoItem.ATK, 5 );
                player.adicionarItem( "Espada de Ferro", espada, 1 );
                System.out.println("Você comprou uma Espada de Ferro!");
                return ResultadoEvento.CONTINUAR;

            case 5:

                if (player.getMoedas() < 60) {

                    System.out.println("Moedas insuficientes!");
                    return ResultadoEvento.CONTINUAR;
                }

                player.ganharMoedas(-60);
                EquipItem armadura = new EquipItem( "Armadura de Couro", TipoItem.DEF, 4 );
                player.adicionarItem( "Armadura de Couro", armadura, 1 );
                System.out.println("Você comprou uma Armadura de Couro!");
                return ResultadoEvento.CONTINUAR;

            case 6:
                System.out.println("Mercador: Volte sempre!");
                return ResultadoEvento.SAIR_MAPA;

            default:
                System.out.println("Opção inválida!");
                return ResultadoEvento.CONTINUAR;
        }
    }
}