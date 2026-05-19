package APS;

import java.util.Scanner;
import java.util.InputMismatchException;

public class sistemaMenu {

    private static Scanner sc = new Scanner(System.in);

    public static void status(Personagens p, Personagens e) {
        System.out.println("\n=======================================================");
        // Adicionamos o print do AP para o jogador e para o inimigo
        System.out.println(p.getNome() + " | HP: " + p.getHp() + "/" + p.getMaxHp()
                + " | AP: " + p.getApAtual() + "/" + p.getApMax() 
                + " | ATK:" + p.getAtk() + " DEF:" + p.getDefTotal());
                
        System.out.println(e.getNome() + " | HP: " + e.getHp() + "/" + e.getMaxHp()
                + " | AP: " + e.getApAtual() + "/" + e.getApMax() 
                + " | ATK:" + e.getAtk() + " DEF:" + e.getDefTotal());
        System.out.println("=======================================================");
    }

    public static Action turnoJogador(Personagens p) {

        while (true) {

            System.out.println("\nO que você vai fazer?");
            System.out.println("1 - Atacar   (Custo: 6 AP)");
            System.out.println("2 - Defender (Recupera: 5 AP)");
            System.out.println("3 - Esquivar (Custo: 8 AP)");
            System.out.println("4 - Usar Item");

            try {
                int escolha = sc.nextInt();

                if (escolha == 1) return Action.ATTACK;
                if (escolha == 2) return Action.DEFEND;
                if (escolha == 3) return Action.DODGE;
                if (escolha == 4) return Action.USE_ITEM;
                System.out.println("Opção inválida.");

            } catch (InputMismatchException ex) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
            }
        }
    }

    public static void upgradeMenu(Personagens p) {
        System.out.println("\n=== UPGRADE DE STATUS ===");
        System.out.println("1 - Aumentar HP (10 pontos)");
        System.out.println("2 - Aumentar ATK (3 pontos)");
        System.out.println("3 - Aumentar AP (5 pontos)");
        System.out.println("4 - Aumentar DEF (3 pontos)");

        while (true) {
            try {
                int escolha = sc.nextInt();

                if (escolha == 1) {
                    p.aumentarHp(10);
                    break;
                }
                if (escolha == 2) {
                    p.aumentarAtk(3);
                    break;
                }
                if (escolha == 3) {
                    p.aumentarDef(3);
                    break;
                }
                if (escolha == 4) {
                    p.aumentarAp(5);
                    break;
                }
                System.out.println("Opção inválida.");

            } catch (InputMismatchException ex) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
            }
        }
    }
}