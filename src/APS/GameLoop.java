package APS;

import java.util.Scanner;

public class GameLoop {

    public static void iniciar(Player player, Mapa mapaInicial, Scanner sc) {

        GameState estado = GameState.EXPLORANDO;
        Mapa mapaAtual = mapaInicial;

        inputTradutor tradutor = new inputTradutor();

        while (estado != GameState.GAME_OVER) {

        	if (estado == GameState.EXPLORANDO) {

        	    mapaAtual.mostrarMiniMapa(); 

        	    System.out.print("\nDigite a direção: ");

        	    String input = tradutor.inputHandler(sc);

        	    try {
        	        Direction direcao = Direction.valueOf(input);
        	        Mapa proximo = mapaAtual.proximoMapa(direcao);

        	        if (proximo != null) {
        	            mapaAtual = proximo;
        	            estado = GameState.EM_EVENTO;
        	        } else {
        	            System.out.println("Não dá pra ir pra esse lado.");
        	        }

        	    } catch (IllegalArgumentException e) {
        	        System.out.println("Direção inválida.");
        	    }
        	}

            else if (estado == GameState.EM_EVENTO) {

                ResultadoEvento resultado = mapaAtual.aoEntrar(player, sc);

                if (resultado == ResultadoEvento.MORREU) {
                    estado = GameState.GAME_OVER;
                }

                else if (resultado == ResultadoEvento.SAIR_MAPA) {
                    estado = GameState.EXPLORANDO;
                }

                else {
                    // CONTINUAR faz fica no evento
                    estado = GameState.EM_EVENTO;
                }
            }
        }

        System.out.println("\n===== GAME OVER =====");
    }
}