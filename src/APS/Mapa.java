package APS;

import java.util.Scanner;
import java.util.Random;

public class Mapa {

    private String nome;

    private Mapa norte;
    private Mapa sul;
    private Mapa leste;
    private Mapa oeste;

    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public Mapa(String nome) {
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

    public void mostrarDirecoes() {
        System.out.println("\nDireções disponíveis:");
        if (norte != null) System.out.println("- NORTE");
        if (sul != null) System.out.println("- SUL");
        if (leste != null) System.out.println("- LESTE");
        if (oeste != null) System.out.println("- OESTE");
    }

    public void aoEntrar(Personagens player) {

        System.out.println("\nVocê está em: " + nome);

        if (nome.equalsIgnoreCase("Floresta")) {
            eventoFloresta(player);
        }

        if (nome.equalsIgnoreCase("Cidade")) {
            menuCidade(player);
        }

        if (nome.equalsIgnoreCase("Vila")) {
            System.out.println("Lugar tranquilo.");
        }
    }

    //Eventinhos so fiz da cidade e da floresta n tem muita coisa pra trabalha alem disso :|

    private void eventoFloresta(Personagens player) {

        if (rand.nextInt(100) < 50) {
            System.out.println("Um inimigo apareceu!");

            Personagens enemy = new Personagens("Goblin", 50, 10, 4);
            sistemaDeCombate.iniciarCombate(player, enemy);
        } else {
            System.out.println("A floresta está silenciosa...");
        }
    }

    private void menuCidade(Personagens player) {

        while (true) {

            System.out.println("\n=== CIDADE ===");
            System.out.println("1 - Curar");
            System.out.println("2 - Sair");

            int op = sc.nextInt();

            if (op == 1) {
                player.setHp(player.getMaxHp());
                System.out.println("Você foi curado!");
            }
            else if (op == 2) {
                break;
            }
            else {
                System.out.println("Opção inválida.");
            }
        }
    }
}