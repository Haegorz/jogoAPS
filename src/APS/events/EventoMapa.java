package APS.events;

import APS.combat.SistemaDeCombate;
import APS.entities.personagens.Mobs;
import APS.entities.personagens.Player;
import APS.ui.TextControler;
import java.util.Random;
import java.util.Scanner;

public class EventoMapa {

    // (Atributo Estático) - Atributo estruturado diretamente na classe, compartilhado globalmente
    private static Random rand = new Random();

    // (Atributo Estático) - Método estático que gerencia os eventos da área A1 sem necessitar de uma instância da classe
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

        // (Tratamento de Exceções) - Captura de erros caso o jogador forneça uma entrada de dados inválida
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


    // (Atributo Estático) - Método utilitário de classe responsável pela lógica da área A2
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

        // (Tratamento de Exceções) - Bloco de captura para blindar o menu de erros de digitação do usuário
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


    // (Atributo Estático) - Função utilitária estática para o gerenciamento das interações do mapa A3
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

        // (Tratamento de Exceções) - Captura e tratamento de falhas em tempo de execução no fluxo do menu
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


    // (Atributo Estático) - Rotina estática interna para o acesso seguro fora de combate
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

    // (Atributo Estático) - Método estático responsável por instanciar e escalar os monstros mais simples do mapa
    private static void spawnLixoFraco( Player player, Scanner sc ) {

        System.out.println("Um Monstro de Plástico apareceu!");
        // (Instanciação de Objeto) - Criação  de uma nova instância da classe Mobs na memória
        Mobs enemy = new Mobs( "Monstro de Plástico", 45, 8, 5, 30, 1, 12 );
        enemy.escalarComPlayer(player.getLevel());

        if (rand.nextInt(100) < 20) {

            System.out.println("⚠ Uma Garrafa Assassina apareceu!");
            // (Instanciação de Objeto) - Alocação  de um novo objeto alternativo de Mobs
            enemy = new Mobs( "Garrafa Assassina", 65, 15, 6, 55, 1, 25 );
            enemy.setTipo("RAPIDO");
            enemy.bossEscale(player.getLevel());
        }
        // (Polimorfismo de Classe) - Encaminha referências genéricas válidas ao gerenciador do sistema de combate
        SistemaDeCombate.iniciarCombate(player,enemy,sc);
    }

    
    // (Atributo Estático) - Rotina estática encarregada do sorteio e geração de adversários de nível médio
    private static void spawnLixoMedio( Player player, Scanner sc ) {

        System.out.println( "Um Ferro Velho Vivo apareceu!" );
        // (Instanciação de Objeto) - Cria  na memória um monstro intermediário
        Mobs enemy = new Mobs( "Ferro Velho Vivo", 80, 16, 15, 50, 1, 35 );
        enemy.escalarComPlayer(player.getLevel());
        

        if (rand.nextInt(100) < 25) {
            System.out.println( "⚠ Um Triturador apareceu!" );
            // (Instanciação de Objeto) - Nova instância específica alocada  à referência
            enemy = new Mobs( "Triturador", 120, 15, 15, 80, 1, 60 );
            enemy.setTipo("TANK");
            enemy.bossEscale(player.getLevel());
        }
        SistemaDeCombate.iniciarCombate(player,enemy,sc);
    }

 
    // (Atributo Estático) - Método utilitário de classe estruturado para o spawn do boss e inimigos de elite
    private static void spawnLixoForte( Player player, Scanner sc ) {

        System.out.println( "Uma Massa Tóxica apareceu!" );
        // (Instanciação de Objeto) - Aloca  o monstro avançado base
        Mobs enemy = new Mobs( "Massa Tóxica", 150, 18, 10, 100, 1, 80 );
        enemy.escalarComPlayer(player.getLevel());
        
        if (rand.nextInt(100) < 30) {

            System.out.println( "⚠ O Rei do Lixão apareceu!" ); 
            // (Instanciação de Objeto) - Alocação  do boss final da área do lixão
            enemy = new Mobs( "Grande Lixão", 200, 22, 12, 150, 1, 120 );
            enemy.setTipo("AGRESSIVO");
            enemy.bossEscale(player.getLevel());
        }

        SistemaDeCombate.iniciarCombate(player,enemy,sc);
    }
}