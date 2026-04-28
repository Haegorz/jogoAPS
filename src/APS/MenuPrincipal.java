package APS;

import java.util.Scanner;

public class MenuPrincipal {

    public Player criarMenu(Scanner sc){

        while(true) {

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
                    return new Player("Cavaleiro", 60, 9, 14);

                case 2:
                    return new Player("Mago", 40, 6, 3);

                case 3:
                    return new Player("Espadachim", 45, 15, 5);

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
