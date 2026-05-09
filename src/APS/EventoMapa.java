package APS;

import java.util.Random;
import java.util.Scanner;

public class EventoMapa {

    private static Random rand = new Random();

    public static ResultadoEvento eventoFloresta(Player player, Scanner sc) {

        // Evento ao entrar
        if (rand.nextInt(100) < 25) {
            spawnGoblin(player, sc);
            if (!player.vivo())
                return ResultadoEvento.MORREU;
        } else {
            System.out.println("A floresta está silenciosa...");
        }

        // Menu
        System.out.println("opções da floresta");
        System.out.println("1 - Procurar Goblin");
        System.out.println("2 - Inventario");
        System.out.println("3 - Sair");

        int op;

        try {
            op = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Digite um número.");
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {

            case 1:

                if (rand.nextInt(100) < 75) {

                    spawnGoblin(player, sc);

                    if (!player.vivo()) {
                        return ResultadoEvento.MORREU;
                    }

                } else {

                    System.out.println(
                            "Nenhum goblin perto...");
                }

                return ResultadoEvento.CONTINUAR;

            case 2:

                player.getInventario();

                while (true) {

                    System.out.println(
                            "Digite o item para usar");

                    System.out.println(
                            "(Digite sair para voltar)");

                    String item = sc.nextLine();

                    if (item.equalsIgnoreCase("sair")) {
                        break;
                    }

                    boolean usou = player.usarItemForaDeBatalha(item);

                    if (usou) {
                        break;
                    }
                }

                return ResultadoEvento.CONTINUAR;

            case 3:

                System.out.println(
                        "Saindo da floresta...");

                return ResultadoEvento.SAIR_MAPA;

            default:

                System.out.println("Opção inválida.");

                return ResultadoEvento.CONTINUAR;
        }
    }

    private static void spawnGoblin(Player player, Scanner sc) {

        System.out.println("Um Goblin apareceu!");

        Mobs enemy = new Mobs("Goblin", 50, 10, 4, 20, 1);

        // chance de boss
        if (rand.nextInt(100) < 20) {
            System.out.println("⚠ Um Goblin Rei apareceu!");
            enemy = new Mobs("Goblin Rei", 80, 12, 5, 50, 1);
            enemy.setTipo("AGRESSIVO");
        }

        sistemaDeCombate.iniciarCombate(player, enemy, sc);
    }
}