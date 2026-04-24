package APS;

import java.util.Scanner;

public class MenuPrincipal {

    public Personagens criarMenu(Scanner sc){

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
                    return new Personagens("Cavaleiro", 60, 9, 14, 20);

                case 2:
                    return new Personagens("Mago", 40, 6, 3, 20);

                case 3:
                    return new Personagens("Espadachim", 45, 15, 5, 20);

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
