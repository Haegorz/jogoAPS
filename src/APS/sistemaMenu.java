package APS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class sistemaMenu {

    private static Scanner sc = new Scanner(System.in);

    public static void status(Personagens p, Personagens e) {

        System.out.println("\n====================");
        System.out.println(p.getNome() + " HP: " + p.getHp() + "/" + p.getMaxHp()
                + " | ATK:" + p.getAtk() + " DEF:" + p.getDefTotal());
        System.out.println(e.getNome() + " HP: " + e.getHp() + "/" + e.getMaxHp()
                + " | ATK:" + e.getAtk() + " DEF:" + e.getDefTotal());
        System.out.println("====================");
    }

    public static Action turnoJogador(Personagens p) {

        while (true) {

            System.out.println("\n1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Inventario");

            try {
                int escolha = sc.nextInt();
                
                switch (escolha){
                    case 1:
                        return Action.ATTACK;
                    case 2:
                        return Action.DEFEND;
                    case 3:
                        return Action.INV;
                    default:
                        System.out.println("Opção inválida.");

                }

                System.out.println("Opção inválida.");

            } catch (InputMismatchException ex) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
            }
        }
    }
}