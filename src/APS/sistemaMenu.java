package APS;

import java.util.InputMismatchException;
import java.util.Scanner;


public class sistemaMenu {

    public static void status(Personagens p, Personagens e) {

        System.out.println("\n====================");
        System.out.println(p.getNome() + " HP: " + p.getHp() + "/" + p.getMaxHp() +
                " MP " + p.getMp() + "/" + p.getMaxMp()
                + " | ATK:" + p.getAtk() + " DEF:" + p.getDefTotal());
        System.out.println(e.getNome() + " HP: " + e.getHp() + "/" + e.getMaxHp()
                + " | ATK:" + e.getAtk() + " DEF:" + e.getDefTotal());
        System.out.println("====================");
    }

    public static Action turnoJogador(Personagens p, Scanner sc) {

        while (true) {

            System.out.println("\n1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Magia");
            System.out.println("4 - Inventario");

            try {
                int escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 1)
                    return Action.ATTACK;
                if (escolha == 2)
                    return Action.DEFEND;
                if (escolha == 3)
                    return Action.MAGIA;
                if (escolha == 4)
                    return Action.INV;

                System.out.println("Opção inválida.");

            } catch (InputMismatchException ex) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
            }
        }
    }
}