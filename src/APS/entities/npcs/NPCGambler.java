package APS.entities.npcs;

import APS.combat.SistemaDeCombate;
import APS.combat.Skill;
import APS.entities.personagens.Mobs;
import APS.entities.personagens.Player;
import APS.events.Ending;
import APS.events.ResultadoEvento;
import APS.ui.TextControler;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// (Herança) - NPCGambler herda atributos e métodos da superclasse NPC
public class NPCGambler extends NPC {
    
    // (Encapsulamento) - Atributo privado restringindo o acesso direto de outras classes
    private boolean isVivo = true;

    // (Método Construtor) - Inicializa o objeto definindo o nome via chamada ao construtor pai
    public NPCGambler() {
        super("Cara Suspeito");
    }

    // (Sobrescrita) - Redefine o método 'conversar' herdado da classe mãe NPC
    public ResultadoEvento conversar(Player player, Scanner sc) {
        if (!isVivo) {
            TextControler.textInstant("O cara suspeito não tem mais nada pra te oferecer...");
            return ResultadoEvento.SAIR_MAPA;
        } else {
            System.out.println("\n=== CARA SUSPEITO ===");
            System.out.println("1 - Oi");
            System.out.println("2 - Jogar");
            System.out.println("3 - Sair");

            int op;

            // (Tratamento de Exceções) - Captura erros de tipo de dado inválido inserido no Scanner
            try {
                op = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
                return ResultadoEvento.CONTINUAR;
            }

            switch (op) {

                case 1:
                    System.out.print("Suspeito:");
                    TextControler.textInstant("...\n");
                    return ResultadoEvento.CONTINUAR;

                case 2:
                    TextControler.textInstant("O cara suspeito sorri e propõe um jogo de dados...\n");
                    TextControler.textInstant("Aposte o quanto quiser! até mesmo o que não tem...\n");
                    TextControler.textInstant("Se você ganhar, recebe 1.5x o valor apostado, mas se perder, perde tudo!\n");
                    System.out.println("Quanto vc quer apostar? (Digite um número inteiro)");

                    // (Tratamento de Exceções) - Segundo bloco try-catch para lidar com erros na entrada do valor da aposta
                    try {
                        int aposta = sc.nextInt();
                        sc.nextLine();

                        return jogarDado(aposta, player, sc);

                    } catch (InputMismatchException e) {
                        System.out.println("Digite um número válido!");
                        sc.nextLine();
                        return ResultadoEvento.CONTINUAR;
                    }

                case 3:
                    return ResultadoEvento.SAIR_MAPA;

                default:
                    System.out.println("Opção inválida!");
                    return ResultadoEvento.CONTINUAR;
            }
        }
    }

    public ResultadoEvento jogarDado(int aposta, Player player, Scanner sc) {

        int dado = (int) (Math.random() * 6) + 1;

        if (dado < 4) {

            // (Encapsulamento) - Acesso ao estado financeiro do player através de getter público
            if (player.getMoedas() - aposta < 0) {
                TextControler.textInstant("Vai pagar com sua vida então...");

                // (Polimorfismo de Classe) - Instanciação de 'Mobs', que compartilha a árvore hierárquica de Personagens
                Mobs secretboos = new Mobs("Igor", 300, player.getHp() * 2, player.getAtk() - 15, 100, 1, 0);
                secretboos.setTipo("INTELIGENTE");

                player.setKillCount(player.getKillCount() + 9);
                
                // (Polimorfismo de Classe) - O método aceita subclasses válidas de Player e Mobs de forma genérica
                SistemaDeCombate.iniciarCombate(player, secretboos, sc);

                if (!player.vivo()) {
                    Ending.finalRuimalmavendida();
                    return ResultadoEvento.MORREU;

                } else {
                    isVivo = false;
                    player.setBadKarma(1);
                    TextControler.textFast("Você sente uma estranha sensação de poder ao derrotar o cara suspeito...\n");
                    
                    // (Instanciação de Objeto) - Criação  de uma nova Skill para passar como parâmetro do método
                    player.aprenderSkill(new Skill("Apostar", (int)(new Random().nextInt(100)), (int)(new Random().nextInt(100))));
                    return ResultadoEvento.SAIR_MAPA;
                }

            } else {

                TextControler.textInstant("Você perdeu a aposta de " + aposta + " moedas!\n");

                int resultado = aposta * -1;
                // (Encapsulamento) - Modificação controlada do estado do player através do método setter
                player.setMoedas(resultado);

                return ResultadoEvento.CONTINUAR;
            }

        } else {

            int resultado = (int) (aposta * 1.5);

            TextControler.textInstant("Você ganhou " + resultado + " moedas!\n");

            player.setMoedas(resultado);

            return ResultadoEvento.CONTINUAR;
        }
    }

}