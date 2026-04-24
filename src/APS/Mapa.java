package APS;

import java.util.Scanner;

public class Mapa {

    private TipoMapa tipo;
    private String nome;

    private Mapa norte;
    private Mapa sul;
    private Mapa leste;
    private Mapa oeste;

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

        String n;
        if (norte != null) {
            n = norte.getNome();
        } else {
            n = " ";
        }

        String s;
        if (sul != null) {
            s = sul.getNome();
        } else {
            s = " ";
        }

        String l;
        if (leste != null) {
            l = leste.getNome();
        } else {
            l = " ";
        }

        String o;
        if (oeste != null) {
            o = oeste.getNome();
        } else {
            o = " ";
        }

        System.out.println("\n=============================== MAPA ================================\n");

        if (norte != null) {
            System.out.println("                        [" + n + "]");
            System.out.println("                          Norte");
            System.out.println("                            |");
        } else {
            System.out.println("                            |");
        }

        if (oeste != null) {
            System.out.print("[" + o + "] Oeste");
        } else {
            System.out.print("     ");
        }

        if (oeste != null) {
            System.out.print(" -- [Player] -- ");
        } else {
            System.out.print("                 -- [Player] -- ");
        }

        if (leste != null) {
            System.out.println("Leste [" + l + "]");
        } else {
            System.out.println("");
        }

        if (sul != null) {
            System.out.println("                            |");
            System.out.println("                           Sul");
            System.out.println("                        [" + s + "]");
        } else {
            System.out.println("                            |");
        }

        System.out.println("\n====================================================================");
    }
    public void aoEntrar(Personagens player, Scanner sc) {

        System.out.println("\nVocê está em: " + nome);

        if (tipo == TipoMapa.FLORESTA) {
            EventoMapa.eventoFloresta(player, sc);
        }

        if (tipo == TipoMapa.CIDADE) {
            EventoMapa.eventoCidade(player, sc);
        }

        if (tipo == TipoMapa.VILA) {
            System.out.println("Lugar tranquilo.");
        }
    }
}