package APS;

import java.util.Scanner;
import java.util.InputMismatchException;

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

            try {
                int escolha = sc.nextInt();

                if (escolha == 1) return Action.ATTACK;
                if (escolha == 2) return Action.DEFEND;

                System.out.println("Opção inválida.");

            } catch (InputMismatchException ex) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
            }
        }
    }
}