package APS;

import java.util.Scanner;

public class NPCHotel extends NPC {
    private static boolean isVivo = true;

    public NPCHotel() {
        super("Lata de lixo falante");
    }

    public ResultadoEvento conversar(Player player, Scanner sc) {
        if (isVivo) {
            System.out.println("1 - Oi?");
            System.out.println("2 - Você fede");
            System.out.println("3 - Sair");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Lata de lixo: Oi, humano! Bem-vindo ao Hotel Lixo!");
                    return ResultadoEvento.CONTINUAR;
                case 2:
                    System.out.println("Lata de lixo: Ei, isso é ofensivo!");
                    Mobs secretboos = new Mobs("Gi...", 1, 1, 1, 1, 1, 0);
                    secretboos.setTipo("INTELIGENTE");

                    sistemaDeCombate.iniciarCombate(player, secretboos, sc);

                    if (!player.vivo()) {
                        Ending.finalRuimlixo();
                        return ResultadoEvento.MORREU;

                    } else {
                        isVivo = false;
                        return ResultadoEvento.SAIR_MAPA;
                    }
                case 3:
                    return ResultadoEvento.SAIR_MAPA;
                default:
                    System.out.println("Opção inválida.");
                    return ResultadoEvento.CONTINUAR;
            }
        } else {
            System.out.println("Não tem mais nada aqui...");
            return ResultadoEvento.SAIR_MAPA;

        }
    }
}
