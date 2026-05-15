package APS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NPCGambler extends NPC {
    private boolean isVivo = true;

    public NPCGambler() {
        super("Cara Suspeito");
    }

    public ResultadoEvento conversar(Player player, Scanner sc) {
        if (!isVivo) {
            System.out.println("O cara suspeito não tem mais nada pra te oferecer...");
            return ResultadoEvento.SAIR_MAPA;
        } else {
            System.out.println("1 - Oi");
            System.out.println("2 - Jogar");
            System.out.println("3 - Sair");

            int op;

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
                    System.out.println("Suspeito:...");
                    return ResultadoEvento.CONTINUAR;

                case 2:
                    System.out.println("Quanto vc quer apostar? (Digite um número inteiro)");

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

            if (player.getMoedas() - aposta < 0) {

                System.out.println("Vai pagar com sua vida então...");

                Mobs secretboos = new Mobs("Igor", 200, player.getHp(), 10, 1, 1, 0);
                secretboos.setTipo("INTELIGENTE");

                sistemaDeCombate.iniciarCombate(player, secretboos, sc);

                if (!player.vivo()) {
                    Ending.finalRuimalmavendida();
                    return ResultadoEvento.MORREU;

                } else {
                    return ResultadoEvento.SAIR_MAPA;
                }

            } else {

                System.out.println("Você perdeu a aposta de " + aposta + " moedas!");

                int resultado = aposta * -1;
                player.setMoedas(resultado);

                return ResultadoEvento.CONTINUAR;
            }

        } else {

            int resultado = (int) (aposta * 1.5);

            System.out.println("Você ganhou " + resultado + " moedas!");

            player.setMoedas(resultado);

            return ResultadoEvento.CONTINUAR;
        }
    }

}