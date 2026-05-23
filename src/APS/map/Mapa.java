package APS.map;

import APS.combat.SistemaDeCombate;
import APS.entities.npcs.*;
import APS.entities.personagens.*;
import APS.events.*;
import APS.ui.*;
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
    private NPC mercador = new NPCMercador();
    private NPC gamble = new NPCGambler();
    private NPC hotelNPC = new NPCHotel();
    private NPC secret = new SecretNPC();
    private NPC mercador2 = new NPCMercadorEscola();
    private NPC mercador3 = new NPCMercadorHotel();
    private NPC donoHotel = new NPCDonoHotel();

    private boolean bossDerrotado = false;
    private boolean boss2Derrotado = false;
    private boolean boss3Derrotado = false;

    public Mapa(TipoMapa tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNorte(Mapa mapa) {
        this.norte = mapa;
    }

    public void setSul(Mapa mapa) {
        this.sul = mapa;
    }

    public void setLeste(Mapa mapa) {
        this.leste = mapa;
    }

    public void setOeste(Mapa mapa) {
        this.oeste = mapa;
    }

    public Mapa proximoMapa(Direction direcao) {
        switch (direcao) {
            case NORTE:
                return norte;
            case SUL:
                return sul;
            case LESTE:
                return leste;
            case OESTE:
                return oeste;
            default:
                return null;
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
            TextControler.textInstant("\nVocê está em: " + nome + " ");
        }

        switch (tipo) {

            case A1:
                if (!bossDerrotado) {
                    return EventoMapa.eventoA1(player, sc);
                } else {
                    TextControler.textFast("\nA área está calma, exceto por um monte de lixo no chão.");
                    TextControler.textFast("\nPessoas parece estar voltando a frequentar a área...");
                    return ResultadoEvento.SAIR_MAPA;
                }

            case ESCOLA:
                return eventoEscola(player, sc);

            case HOTEL:
                return eventoHotel(player, sc);

            case QUADRA:
                return eventoQuadra(player, sc);

            case CASA_MUNCKS:
                return eventoCasa(player, sc);

            case PARQUE:
                if (!boss3Derrotado) {
                    TextControler.textInstant("Um inimigo poderoso surge na Area!");

                    Mobs boss = new Mobs("Guardião de Ferro", 290, 30, 40, 280, 0, 270);
                    boss.setTipo("TANK");
                    boss.bossEscale(player.getLevel());

                    player.setKillCount(player.getKillCount() + 9);
                    SistemaDeCombate.iniciarCombate(player, boss, sc);

                    if (!player.vivo()) {
                        return ResultadoEvento.MORREU;
                    }
                    boss3Derrotado = true;
                    TextControler.textDramatic("É uma luta fútil heroi...");
                    return ResultadoEvento.SAIR_MAPA;
                } else {
                    TextControler.textFast("O parque está vazio, exceto por um banco quebrado.");
                    return ResultadoEvento.SAIR_MAPA;
                }

            case MERCADO:
                if (!bossDerrotado) {
                    TextControler.textInstant("\nUma presença veloz te ataca!");

                    Mobs boss1 = new Mobs("Lâmina de Vidro", 200, 35, 20, 200, 1, 170);
                    boss1.setTipo("RAPIDO");
                    boss1.bossEscale(player.getLevel());
                    player.setKillCount(player.getKillCount() + 9);
                    SistemaDeCombate.iniciarCombate(player, boss1, sc);

                    if (!player.vivo()) {
                        return ResultadoEvento.MORREU;
                    }
                    TextControler.textDramatic("Você é forte heroi... \n");
                    TextControler.textDramatic("mas não o suficiente para derrotar nosso rei!");
                    bossDerrotado = true;
                    return ResultadoEvento.SAIR_MAPA;
                } else {
                    TextControler.textFast("\nO mercado está vazio, exceto por uma barraca de frutas podres.");
                    TextControler.textFast("\nPessoas parece estar voltando a frequentar o mercado...");
                    return ResultadoEvento.SAIR_MAPA;
                }

            case BIBLIOTECA:
                if (!boss2Derrotado) {
                    TextControler.textInstant("Uma grande massa de ferro avança para você!");

                    Mobs boss2 = new Mobs("Paladino da Sucata", 330, 35, 40, 400, 1, 350);
                    boss2.setTipo("TANK");
                    boss2.bossEscale(player.getLevel());

                    player.setKillCount(player.getKillCount() + 9);
                    SistemaDeCombate.iniciarCombate(player, boss2, sc);

                    if (!player.vivo()) {
                        return ResultadoEvento.MORREU;
                    }
                    boss2Derrotado = true;
                    TextControler.textDramatic("O paladino cai de joelhos...\n");
                    TextControler.textDramatic("Heroi... Hoje eu cairei, mas meu rei viverá para sempre!\n");
                    return ResultadoEvento.SAIR_MAPA;
                } else {
                    TextControler.textFast(" A biblioteca está silenciosa, exceto por um livro empoeirado no chão.");
                    return ResultadoEvento.SAIR_MAPA;
                }

            case A2:
                if (!boss3Derrotado) {
                    return EventoMapa.eventoA2(player, sc);
                } else {
                    TextControler.textFast("Os sons de metal parecem ter cessado...");
                    TextControler.textFast("\nO local parece mais seguro, mas ainda há um ar de mistério no ar.");
                    return ResultadoEvento.SAIR_MAPA;
                }

            case LOJA:
                return eventoBar(player, sc);

            case A3:
                return EventoMapa.eventoA3(player, sc);

            case USINA:

                TextControler.textInstant("\nVocê entra na usina abandonada");
                TextControler.textDramatic("\nE sente uma presença ameaçadora...\n");
                TextControler.textFast("O Rei do Lixão aparece, pronto para o confronto final!");

                // ===== FASE 1 =====
                Mobs boss11 = new Mobs("Rei do Lixão", 350, 70, 85, 350, 1, 0);
                boss11.setTipo("INTELIGENTE");
                boss11.bossEscale(player.getLevel());
                player.setKillCount(player.getKillCount() + 9);

                SistemaDeCombate.iniciarCombate(player, boss11, sc);

                if (!player.vivo())
                    return ResultadoEvento.MORREU;

                // ===== ESCOLHA FINAL =====
                TextControler.textDramatic("\nO rei cai de joelhos...");
                TextControler.textInstant("\n1 - Poupar o rei");
                TextControler.textInstant("\n2 - Finalizar o rei");

                int escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 1) {
                    if (player.getBadKarma() < 2) {

                        TextControler.textDramatic("\nO rei sorri...");
                        TextControler.textFast("\nVocê caiu em uma armadilha!");

                        // ===== FASE 2 (SURPRESA) =====
                        Mobs bossFinal = new Mobs("Rei do Lixão Supremo", 400, 85, 70, 0, 1, 0);
                        bossFinal.setTipo("AGRESSIVO");
                        bossFinal.bossEscale(player.getLevel());
                        SistemaDeCombate.iniciarCombate(player, bossFinal, sc);

                        if (!player.vivo()) {
                            Ending.finalRuim();
                            return ResultadoEvento.MORREU;
                        } else {
                            Ending.finalSecreto();
                            return ResultadoEvento.MORREU;
                        }
                    } else {
                        Ending.finalRuimMaligno();
                        return ResultadoEvento.MORREU;
                    }
                } else if (player.getBadKarma() >= 2) {
                    Ending.finalSecretoKarma();
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

        int op;
        try {
            op = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido!");
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {

            case 1:
                player.setHp(player.getMaxHp());
                TextControler.textInstant("Você foi curado!");
                return ResultadoEvento.CONTINUAR;

            case 2:
                npcAtual = npc1;
                return ResultadoEvento.CONTINUAR;

            case 3:
                npcAtual = mercador2;
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

        int op;
        try {
            op = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido!");
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

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

    private ResultadoEvento eventoHotel(Player player, Scanner sc) {

        if (npcAtual != null) {

            ResultadoEvento r = npcAtual.conversar(player, sc);

            if (r == ResultadoEvento.SAIR_MAPA) {

                npcAtual = null;

                return ResultadoEvento.CONTINUAR;
            }

            return r;
        }

        System.out.println("\n=== HOTEL ===");
        System.out.println("1 - Descansar");
        System.out.println("2 - Falar com Dono do Hotel");
        System.out.println("3 - Falar com Lata de Lixo Falante");
        System.out.println("4 - Falar com Mercador do Hotel");
        System.out.println("5 - Sair");

        int op;
        try {
            op = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido!");
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {

            case 1:
                player.curarTotal();
                player.mpTotal();

                TextControler.textInstant("Você descansou e recuperou tudo!");

                return ResultadoEvento.CONTINUAR;

            case 2:
                npcAtual = donoHotel;
                return ResultadoEvento.CONTINUAR;
            case 3:
                npcAtual = hotelNPC;
                return ResultadoEvento.CONTINUAR;
            case 4:
                npcAtual = mercador3;
                return ResultadoEvento.CONTINUAR;
            case 5:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }

    private ResultadoEvento eventoBar(Player player, Scanner sc) {

        if (npcAtual != null) {

            ResultadoEvento r = npcAtual.conversar(player, sc);
            if (r == ResultadoEvento.SAIR_MAPA) {
                npcAtual = null;
                return ResultadoEvento.CONTINUAR;
            }

            return r;
        }

        System.out.println("\n=== BAR ===");
        System.out.println("1 - Falar com Mercador");

        if (player.getBadKarma() >= 2) {
            System.out.println("2 - Pessoa de Casaco verde com listra amarela");
            System.out.println("3 - Sair");

        } else {
            System.out.println("2 - Sair");
        }

        int op;
        try {
            op = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido!");
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

        if (player.getBadKarma() < 2) {
            switch (op) {
                case 1:
                    npcAtual = mercador;
                    return ResultadoEvento.CONTINUAR;

                case 2:
                    return ResultadoEvento.SAIR_MAPA;

                default:
                    System.out.println("Opção inválida!");
                    return ResultadoEvento.CONTINUAR;
            }
        }

        switch (op) {

            case 1:
                npcAtual = mercador;
                return ResultadoEvento.CONTINUAR;

            case 2:
                npcAtual = secret;
                return ResultadoEvento.CONTINUAR;

            case 3:
                return ResultadoEvento.SAIR_MAPA;

            default:
                System.out.println("Opção inválida!");
                return ResultadoEvento.CONTINUAR;
        }
    }

    private ResultadoEvento eventoCasa(Player player, Scanner sc) {
        System.out.println("\n=== CASA ===");
        System.out.println("1 - Descançar");
        System.out.println("2 - Sair");

        int op;
        try {
            op = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido!");
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {

            case 1:
                player.curarTotal();
                player.mpTotal();
                TextControler.textInstant("Você descansou e recuperou toda a vida!");
                return ResultadoEvento.CONTINUAR;

            case 2:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }
}
