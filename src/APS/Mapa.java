package APS;

import java.util.Scanner;

public class Mapa {

    private TipoMapa tipo;
    private String nome;

    private Mapa norte;
    private Mapa sul;
    private Mapa leste;
    private Mapa oeste;

    private NPC npcAtual = null;
    private NPC npc1 = new NPCEscola();
    private NPC npc2 = new NPCMercador();
    private NPC gamble = new NPCGambler();
    private NPC hotelNPC = new NPCHotel();

    public Mapa(TipoMapa tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNorte(Mapa mapa) { this.norte = mapa; }
    public void setSul(Mapa mapa) { this.sul = mapa; }
    public void setLeste(Mapa mapa) { this.leste = mapa; }
    public void setOeste(Mapa mapa) { this.oeste = mapa; }

    public Mapa proximoMapa(Direction direcao) {
        switch (direcao) {
            case NORTE: return norte;
            case SUL: return sul;
            case LESTE: return leste;
            case OESTE: return oeste;
            default: return null;
        }
    }

    public void mostrarMiniMapa() {

        String n = (norte != null) ? norte.getNome() : " ";
        String s = (sul != null) ? sul.getNome() : " ";
        String l = (leste != null) ? leste.getNome() : " ";
        String o = (oeste != null) ? oeste.getNome() : " ";

        System.out.println("\n=============================== MAPA ================================\n");

        if (norte != null) {
            System.out.println("                    [" + n + "]");
            System.out.println("                      Norte");
            System.out.println("                        |");
        } else {
            System.out.println("                        |");
        }

        if (oeste != null) {
            System.out.print("[" + o + "] Oeste");
        } else {
            System.out.print("     ");
        }

        if (oeste != null) {
            System.out.print(" -- [Player] -- ");
        } else {
            System.out.print("             -- [Player] -- ");
        }

        if (leste != null) {
            System.out.println("Leste [" + l + "]");
        } else {
            System.out.println("");
        }

        if (sul != null) {
            System.out.println("                        |");
            System.out.println("                       Sul");
            System.out.println("                    [" + s + "]");
        } else {
            System.out.println("                        |");
        }

        System.out.println("\n====================================================================");
    }

    public ResultadoEvento aoEntrar(Player player, Scanner sc) {

    	if (npcAtual == null) {
    	    System.out.println("\nVocê está em: " + nome);
    	}

        switch (tipo) {

            case A1:
                return EventoMapa.eventoA1(player, sc);

            case ESCOLA:
                return eventoEscola(player, sc);

            case HOTEL:
                return eventoHotel(player, sc);

            case QUADRA:
               return eventoQuadra(player, sc);
                
            case CASA_MUNCKS:
                System.out.println("Lugar tranquilo.");
                System.out.println("1-Descançar");
                System.out.println("2-Sair");
                int op = sc.nextInt();
                sc.nextLine();
                switch (op){
                    case 1:
                        player.curarTotal();
                        break;
                    case 2:
                        return ResultadoEvento.SAIR_MAPA;
                }

            case PARQUE:
                System.out.println("Um inimigo poderoso surge na Area!");

                Mobs boss = new Mobs( "Guardião de Ferro", 120, 15, 8, 80, 0, 100 );
                boss.setTipo("TANK");

                sistemaDeCombate.iniciarCombate(player, boss, sc);

                if (!player.vivo()) return ResultadoEvento.MORREU;

                return ResultadoEvento.SAIR_MAPA;

            case MERCADO:
                System.out.println("Uma presença veloz te ataca!");

                Mobs boss1 = new Mobs( "Lâmina de Vidro", 110, 20, 3, 100, 1, 170 );
                boss1.setTipo("RAPIDO");

                sistemaDeCombate.iniciarCombate(player, boss1, sc);

                if (!player.vivo()) return ResultadoEvento.MORREU;

                return ResultadoEvento.SAIR_MAPA;
                
            case BIBLIOTECA:
                System.out.println("Uma presença veloz te ataca!");

                Mobs boss2 = new Mobs( "Paladino da Sucata", 200, 17, 20, 200, 1, 350 );
                boss2.setTipo("TANK");

                sistemaDeCombate.iniciarCombate(player, boss2, sc);

                if (!player.vivo()) return ResultadoEvento.MORREU;

                return ResultadoEvento.SAIR_MAPA;
                
            case A2:
                return EventoMapa.eventoA2(player, sc);

            case LOJA:
                return eventoBar(player, sc);

            case A3:
                return EventoMapa.eventoA3(player, sc);

            case USINA:

                System.out.println("O REI DAS SOMBRAS aparece!");

                // ===== FASE 1 =====
                Mobs boss11 = new Mobs( "Rei do Lixão", 250, 20, 15, 250, 1, 0 );
                boss11.setTipo("INTELIGENTE");

                sistemaDeCombate.iniciarCombate(player, boss11, sc);

                if (!player.vivo()) return ResultadoEvento.MORREU;

                // ===== ESCOLHA FINAL =====
                System.out.println("\nO rei cai de joelhos...");
                System.out.println("1 - Poupar o rei");
                System.out.println("2 - Finalizar o rei");

                int escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 1) {

                    System.out.println("\nO rei sorri...");
                    System.out.println("Você caiu em uma armadilha!");

                    // ===== FASE 2 (SURPRESA) =====
                    Mobs bossFinal = new Mobs( "Rei do Lixão Supremo", 150, 30, 20, 250, 1, 0 );
                    bossFinal.setTipo("AGRESSIVO");

                    sistemaDeCombate.iniciarCombate(player, bossFinal, sc);

                    if (!player.vivo()) {
                    	Ending.finalRuim();
                    	return ResultadoEvento.MORREU;
                    }
                    Ending.finalSecreto();
                    return ResultadoEvento.MORREU;

                } else {
                	Ending.finalBom();
                	return ResultadoEvento.MORREU;
                }

            default:
                return ResultadoEvento.CONTINUAR;
        }
    }

    private ResultadoEvento eventoEscola(Player player, Scanner sc) {

        if (npcAtual != null) {

            ResultadoEvento r = npcAtual.conversar(player, sc);

            if (r == ResultadoEvento.SAIR_MAPA) {
                npcAtual = null;
                return ResultadoEvento.CONTINUAR;
            }

            return r;
        }

        System.out.println("\n=== ESCOLA ===");
        System.out.println("1 - Curar");
        System.out.println("2 - Falar com Prof. Ito");
        System.out.println("3 - Falar com Mercador");
        System.out.println("4 - Sair");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                player.setHp(player.getMaxHp());
                System.out.println("Você foi curado!");
                return ResultadoEvento.CONTINUAR;

            case 2:
                npcAtual = npc1;
                return ResultadoEvento.CONTINUAR;

            case 3:
                npcAtual = npc2;
                return ResultadoEvento.CONTINUAR;

            case 4:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }
    private ResultadoEvento eventoQuadra(Player player, Scanner sc) {

        if (npcAtual != null) {

            ResultadoEvento r = npcAtual.conversar(player, sc);

            if (r == ResultadoEvento.SAIR_MAPA) {
                npcAtual = null;
                return ResultadoEvento.CONTINUAR;
            }

            return r;
        }

        System.out.println("\n=== QUADRA ===");
        System.out.println("1 - Falar com o Cara Suspeito");
        System.out.println("2 - Sair");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                npcAtual = gamble;
                return ResultadoEvento.CONTINUAR;

            case 2:
                return ResultadoEvento.SAIR_MAPA;

            default:
                System.out.println("Opção inválida!");
                return ResultadoEvento.CONTINUAR;
        }
    }
    private ResultadoEvento eventoHotel( Player player, Scanner sc ) {

        if (npcAtual != null) {

            ResultadoEvento r =
                npcAtual.conversar(player, sc);

            if (r == ResultadoEvento.SAIR_MAPA) {

                npcAtual = null;

                return ResultadoEvento.CONTINUAR;
            }

            return r;
        }

        System.out.println("\n=== HOTEL ===");
        System.out.println("1 - Descansar");
        System.out.println("2 - Falar com Mercador");
        System.out.println("3 - Falar com Lata de Lixo Falante");
        System.out.println("4 - Sair");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                player.curarTotal();
                player.mpTotal();

                System.out.println(
                    "Você descansou e recuperou tudo!"
                );

                return ResultadoEvento.CONTINUAR;

            case 2:
                npcAtual = npc2;
                return ResultadoEvento.CONTINUAR;
            case 3:
                npcAtual = hotelNPC;
                return ResultadoEvento.CONTINUAR;
            case 4:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }
    private ResultadoEvento eventoBar( Player player, Scanner sc ) {

        if (npcAtual != null) {

            ResultadoEvento r =
                npcAtual.conversar(player, sc);

            if (r == ResultadoEvento.SAIR_MAPA) {

                npcAtual = null;

                return ResultadoEvento.CONTINUAR;
            }

            return r;
        }

        System.out.println("\n=== BAR ===");
        System.out.println("1 - Falar com Mercador");
        System.out.println("2 - Sair");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                npcAtual = npc2;
                return ResultadoEvento.CONTINUAR;

            case 2:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }
}