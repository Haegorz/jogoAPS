package APS.entities.npcs;

import APS.combat.SistemaDeCombate;
import APS.entities.personagens.Mobs;
import APS.entities.personagens.Player;
import APS.events.Ending;
import APS.events.ResultadoEvento;
import APS.items.EquipItem;
import APS.items.TipoItem;
import APS.ui.TextControler;
import java.util.Scanner;

// (Herança) - NPCHotel estende a superclasse NPC, herdando sua estrutura base
public class NPCHotel extends NPC {
    
    // (Atributo Estático) - Variável de classe compartilhada por todas as instâncias de NPCHotel
    private static boolean isVivo = true;
    
    // (Método Construtor) - Inicializa o nome do objeto chamando o construtor da superclasse
    public NPCHotel() {
        super("Lata de lixo falante");
    }
    
    // (Encapsulamento) - Método público de leitura para obter o estado do atributo estático privado
    public static boolean getIsVivo() {
        return isVivo;
    }

    // (Sobrescrita) - Redefine o comportamento do método 'conversar' original da classe NPC
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
                    
                    // (Polimorfismo de Classe) - Instancia um mob que se encaixa na hierarquia genérica de personagens do jogo
                    Mobs secretboss = new Mobs("Gi...", 1, 1, 1, 1, 1, 0);
                    secretboss.setTipo("INTELIGENTE");
                    player.setKillCount(player.getKillCount() - 10);
                    
                    // (Polimorfismo de Classe) - Invoca o fluxo de combate aceitando o mob e o jogador 
                    SistemaDeCombate.iniciarCombate(player, secretboss, sc);

                    if (!player.vivo()) {
                        Ending.finalRuimlixo();
                        return ResultadoEvento.MORREU;

                    } else {
                        isVivo = false;
                        player.setBadKarma(1);
                        TextControler.textFast("Você pega a tampa da lata de lixo como recompensa!\n");
                        
                        // (Instanciação de Objeto) - Criação  de um EquipItem passando-o como argumento do método
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