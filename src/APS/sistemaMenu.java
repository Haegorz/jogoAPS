package APS;

import java.util.Scanner;

class sistemaMenu {

    static Scanner sc = new Scanner(System.in);

    static void mostrarStatus(Personagens p, Personagens e) {
        System.out.println("\n====================");
        System.out.println(p.nome + " HP: " + p.hp + "/" + p.maxHp);
        System.out.println(e.nome + " HP: " + e.hp);
        System.out.println("====================");
    }

    static void turnoJogador(Personagens p, Personagens e) {

        while (true) {
            System.out.println("\n1 - Atacar");
            System.out.println("2 - Defender");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                	sistemaDeAcao.atacar(p, e);
                    return;

                case 2:
                	sistemaDeAcao.defender(p);
                    return;
            }
        }
    }
}