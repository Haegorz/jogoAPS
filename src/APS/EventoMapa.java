package APS;

import java.util.Random;
import java.util.Scanner;

public class EventoMapa {

    private static Random rand = new Random();

    public static void eventoFloresta(Personagens player, Scanner sc) {

        while(true) {

            if (rand.nextInt(100) < 25) {
                spawnGoblin(player, sc);
            } else {
                System.out.println("A floresta está silenciosa...");
            }

            System.out.println("opções da floresta");
            System.out.println("1 - Procurar Goblin");
            System.out.println("2 - Sair");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    if (rand.nextInt(100) < 75) {
                        spawnGoblin(player, sc);
                    } else {
                        System.out.println("Nenhum goblin perto...");
                    }
                    break;

                case 2:
                    System.out.println("Saindo da floresta...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void spawnGoblin(Personagens player, Scanner sc) {
        System.out.println("Um inimigo apareceu!");
        Personagens enemy = new Personagens("Goblin", 50, 10, 4, 20);
        sistemaDeCombate.iniciarCombate(player, enemy, sc);
    }
    public static void eventoCidade(Personagens player, Scanner sc) {

    while (true) {

        System.out.println("\n=== CIDADE ===");
        System.out.println("1 - Curar");
        System.out.println("2 - NPC1");
        System.out.println("3 - Sair");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                player.setHp(player.getMaxHp());
                System.out.println("Você foi curado!");
                break;

            case 2:
                while (true) {

                    System.out.println("ola esse é um dialogo de teste!");
                    System.out.println("1 - ola como vc esta?");
                    System.out.println("2 - oq é essa cidade");
                    System.out.println("3 - onde posso encontra goblins");
                    System.out.println("4 - bye bye");

                    int ou = sc.nextInt();
                    sc.nextLine();

                    switch (ou) {
                        case 1:
                            System.out.println("estou bem a cidade é um lugar seguro afinal");
                            break;
                        case 2:
                            System.out.println("essa é a cidade de (placeholder) lindo lugar como vc pode ver!");
                            break;
                        case 3:
                            if (!player.temFlag("goblinBoss")) {
                                System.out.println("SURPRESA!!! Eu sOu uM gObLiN HEHEHE");
                                Personagens enemy = new Personagens("Goblin Secreto", 1000, 15, 6, 1000);
                                sistemaDeCombate.iniciarCombate(player, enemy, sc);
                                player.addFlag("goblinBoss");
                            } else {
                                System.out.println("vc ja viu essa cena cai fora");
                            }
                            break;
                        case 4:
                            System.out.println("ate mais!!");
                            return;
                        default:
                            System.out.println("Opção inválida.");
                    }
                }

            case 3:
                return;

            default:
                System.out.println("Opção inválida.");
        	}
    	}
	}
}