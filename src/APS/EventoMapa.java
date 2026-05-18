package APS;

import java.util.Random;
import java.util.Scanner;

public class EventoMapa {

    private static Random rand = new Random();

    public static ResultadoEvento eventoA1( Player player, Scanner sc ) {

        if (rand.nextInt(100) < 25) {

            spawnLixoFraco(player, sc);

            if (!player.vivo()) {
                return ResultadoEvento.MORREU;
            }

        } else {

            TextControler.textInstant(" A área está silenciosa..." );
        }

        System.out.println("\n=== A1 ===");
        System.out.println("1 - Procurar inimigos");
        System.out.println("2 - Inventário");
        System.out.println("3 - Sair");

        int op;

        try {
            op = sc.nextInt();
            sc.nextLine();

        } catch (Exception e) {

            System.out.println(
                "Entrada inválida."
            );

            sc.nextLine();

            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {

            case 1:
                if (rand.nextInt(100) < 75) {
                    spawnLixoFraco(player, sc);

                    if (!player.vivo()) {
                        return ResultadoEvento.MORREU;
                    }

                } else {

                    System.out.println("Nenhum inimigo encontrado...");
                }

                return ResultadoEvento.CONTINUAR;

            case 2:
                abrirInventario(player, sc);
                return ResultadoEvento.CONTINUAR;

            case 3:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }


    public static ResultadoEvento eventoA2( Player player, Scanner sc ) {

        if (rand.nextInt(100) < 35) {
            spawnLixoMedio(player, sc);

            if (!player.vivo()) {
                return ResultadoEvento.MORREU;
            }

        } else {
            TextControler.textInstant(" Você escuta barulhos metálicos ao longe...");
        }

        System.out.println("\n=== A2 ===");
        System.out.println("1 - Explorar sucata");
        System.out.println("2 - Inventário");
        System.out.println("3 - Sair");

        int op;

        try {
            op = sc.nextInt();
            sc.nextLine();

        } catch (Exception e) {
            System.out.println(
                "Entrada inválida."
            );
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {

            case 1:
                if (rand.nextInt(100) < 80) {
                    spawnLixoMedio(player, sc);
                    if (!player.vivo()) {
                        return ResultadoEvento.MORREU;
                    }

                } else {
                    System.out.println("Nada além de lixo...");
                }

                return ResultadoEvento.CONTINUAR;

            case 2:
                abrirInventario(player, sc);
                return ResultadoEvento.CONTINUAR;

            case 3:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }


    public static ResultadoEvento eventoA3( Player player, Scanner sc ) {

        if (rand.nextInt(100) < 45) {
            spawnLixoForte(player, sc);

            if (!player.vivo()) {
                return ResultadoEvento.MORREU;
            }

        } else {
            System.out.println("O cheiro tóxico domina a área...");
        }

        System.out.println("\n=== A3 ===");
        System.out.println("1 - Vasculhar área tóxica");
        System.out.println("2 - Inventário");
        System.out.println("3 - Sair");

        int op;

        try {
            op = sc.nextInt();
            sc.nextLine();

        } catch (Exception e) {
            System.out.println(
                "Entrada inválida."
            );
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {

            case 1:
                if (rand.nextInt(100) < 85) {

                    spawnLixoForte(player, sc);

                    if (!player.vivo()) {
                        return ResultadoEvento.MORREU;
                    }

                } else {
                    System.out.println( "Você não encontrou nada..." );
                }

                return ResultadoEvento.CONTINUAR;

            case 2:
                abrirInventario(player, sc);
                return ResultadoEvento.CONTINUAR;

            case 3:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }


    private static void abrirInventario( Player player, Scanner sc ) {

        player.getInventario();
        while (true) {
            System.out.println("Digite o item para usar");
            System.out.println("(Digite sair para voltar)");
            String item = sc.nextLine();

            if (item.equalsIgnoreCase("sair")) {
                break;
            }

            boolean usou = player.usarItemForaDeBatalha(item);

            if (usou) {
                break;
            }
        }
    }

    private static void spawnLixoFraco( Player player, Scanner sc ) {

        System.out.println("Um Monstro de Plástico apareceu!");
        Mobs enemy = new Mobs( "Monstro de Plástico", 45, 8, 5, 30, 1, 12 );
        enemy.escalarComPlayer(player.getLevel());

        if (rand.nextInt(100) < 20) {

            System.out.println("⚠ Uma Garrafa Assassina apareceu!");
            enemy = new Mobs( "Garrafa Assassina", 65, 15, 6, 55, 1, 25 );
            enemy.setTipo("RAPIDO");
            enemy.bossEscale(player.getLevel());
        }
        sistemaDeCombate.iniciarCombate(player,enemy,sc);
    }

    
    private static void spawnLixoMedio( Player player, Scanner sc ) {

        System.out.println( "Um Ferro Velho Vivo apareceu!" );
        Mobs enemy = new Mobs( "Ferro Velho Vivo", 80, 16, 15, 50, 1, 35 );
        enemy.escalarComPlayer(player.getLevel());
        

        if (rand.nextInt(100) < 25) {
            System.out.println( "⚠ Um Triturador apareceu!" );
            enemy = new Mobs( "Triturador", 120, 15, 15, 80, 1, 60 );
            enemy.setTipo("TANK");
            enemy.bossEscale(player.getLevel());
        }
        sistemaDeCombate.iniciarCombate(player,enemy,sc);
    }

 
    private static void spawnLixoForte( Player player, Scanner sc ) {

        System.out.println( "Uma Massa Tóxica apareceu!" );
        Mobs enemy = new Mobs( "Massa Tóxica", 150, 18, 10, 100, 1, 80 );
        enemy.escalarComPlayer(player.getLevel());
        
        if (rand.nextInt(100) < 30) {

            System.out.println( "⚠ O Rei do Lixão apareceu!" ); 
            enemy = new Mobs( "Grande Lixão", 200, 22, 12, 150, 1, 120 );
            enemy.setTipo("AGRESSIVO");
            enemy.bossEscale(player.getLevel());
        }

        sistemaDeCombate.iniciarCombate(player,enemy,sc);
    }
}