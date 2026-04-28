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
    private NPC npc1 = new NPCMarcelo();
    private NPC npc2 = new NPCMercador();

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

            case FLORESTA:
                return EventoMapa.eventoFloresta(player, sc);

            case CIDADE:
                return eventoCidade(player, sc);

            case VILA:
                System.out.println("Lugar tranquilo.");
                return ResultadoEvento.SAIR_MAPA;
            
            case MONTANHA:
                System.out.println("Não tem ninguem na montanha mais...");
                return ResultadoEvento.SAIR_MAPA;

            case CAVERNA:
                System.out.println("A caverna esta vazia...");
                return ResultadoEvento.SAIR_MAPA;
                
            case PLANICES:
                System.out.println("As planices estao silenciosas...");
                return ResultadoEvento.SAIR_MAPA;
                
            case FAZENDA:
                System.out.println("A fazenda está silenciosa...");
                return ResultadoEvento.SAIR_MAPA;

            case LOJA:
                System.out.println("O mercador não esta...");
                return ResultadoEvento.SAIR_MAPA;

            case CASTELO:
                System.out.println("O castelo esta vazio...");
                return ResultadoEvento.SAIR_MAPA;
                
            case SALA_REI:
                System.out.println("O rei não esta aqui...");
                return ResultadoEvento.SAIR_MAPA;

            default:
                return ResultadoEvento.CONTINUAR;
        }
    }

    private ResultadoEvento eventoCidade(Player player, Scanner sc) {

        if (npcAtual != null) {

            ResultadoEvento r = npcAtual.conversar(player, sc);

            if (r == ResultadoEvento.SAIR_MAPA) {
                npcAtual = null;
                return ResultadoEvento.CONTINUAR;
            }

            return r;
        }

        System.out.println("\n=== CIDADE ===");
        System.out.println("1 - Curar");
        System.out.println("2 - Falar com Marcelinho mete bala");
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
}