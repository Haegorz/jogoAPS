package APS;

import java.util.Scanner;

public class MenuPrincipal {

    public Player criarMenu(Scanner sc) {

        while (true) {

            System.out.println("//######################################\\\\");
            System.out.println("//              JAVA QUEST              \\\\");
            System.out.println("//                                      \\\\");
            System.out.println("//  1 - COMEÇA O JOGO COMO CAVALEIRO    \\\\");
            System.out.println("//  2 - COMEÇA O JOGO COMO MAGO         \\\\");
            System.out.println("//  3 - COMEÇA O JOGO COMO ESPADACHIM   \\\\");
            System.out.println("//######################################\\\\");

            int oji = sc.nextInt();
            sc.nextLine();

            switch (oji) {
                case 1:
                    Player player = new Player("Cavaleiro", 60, 9, 14, 15);
                    player.aprenderSkill(new Skill("Grito de Guerra", 15, 5));
                    player.adicionarItem("pocao_hp", new BattleItem("Poção HP", TipoItem.HP, 20), 1);
                    player.adicionarItem("pocao_mp", new BattleItem("Poção MP", TipoItem.MP, 20), 1);
                    return player;

                case 2:
                    Player player2 = new Player("Mago", 40, 6, 3, 40);
                    player2.adicionarItem("pocao_hp", new BattleItem("Poção HP", TipoItem.HP, 20), 1);
                    player2.adicionarItem("pocao_mp", new BattleItem("Poção MP", TipoItem.MP, 20), 1);
                    player2.aprenderSkill(new Skill("Fireball", 30, 10));
                    player2.aprenderSkill(new Skill("Thunder", 45, 20));
                    return player2;

                case 3:
                    Player player3 = new Player("Espadachim", 45, 15, 5, 25);
                    player3.adicionarItem("pocao_hp", new BattleItem("Poção HP", TipoItem.HP, 20), 1);
                    player3.adicionarItem("pocao_mp", new BattleItem("Poção MP", TipoItem.MP, 20), 1);
                    player3.aprenderSkill(new Skill("Fireball", 30, 10));
                    return player3;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
