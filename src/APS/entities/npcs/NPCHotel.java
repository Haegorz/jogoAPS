package APS.entities.npcs;

import APS.combat.sistemaDeCombate;
import APS.entities.personagens.Mobs;
import APS.entities.personagens.Player;
import APS.events.Ending;
import APS.events.ResultadoEvento;
import APS.items.EquipItem;
import APS.items.TipoItem;
import APS.ui.TextControler;
import java.util.Scanner;

public class NPCHotel extends NPC {
    private static boolean isVivo = true;
    
    public NPCHotel() {
        super("Lata de lixo falante");
    }
    public static boolean getIsVivo() {
        return isVivo;
    }

    public ResultadoEvento conversar(Player player, Scanner sc) {
        if (isVivo) {
            System.out.println("\n=== LATA DE LIXO FALANTE ===");
            System.out.println("1 - Oi?");
            System.out.println("2 - Você fede");
            System.out.println("3 - Sair");

            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Lata de lixo: ");
                    TextControler.textFast("Ei, humano! Bem-vindo ao Hotel Lixo!\n");
                    return ResultadoEvento.CONTINUAR;
                case 2:
                    System.out.print("Lata de lixo: ");
                    TextControler.textFast("Você não tem vergonha?!\n");
                    Mobs secretboss = new Mobs("Gi...", 1, 1, 1, 1, 1, 0);
                    secretboss.setTipo("INTELIGENTE");
                    player.setKillCount(player.getKillCount() - 10);
                    sistemaDeCombate.iniciarCombate(player, secretboss, sc);

                    if (!player.vivo()) {
                        Ending.finalRuimlixo();
                        return ResultadoEvento.MORREU;

                    } else {
                        isVivo = false;
                        player.setBadKarma(1);
                        TextControler.textFast("Você pega a tampa da lata de lixo como recompensa!\n");
                        player.adicionarItem("Capacete de lata",new EquipItem("Capacete de lata",TipoItem.DEF,30),1);
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
