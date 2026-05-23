package APS.core;

import APS.entities.personagens.Player;
import APS.events.ResultadoEvento;
import APS.map.Direction;
import APS.map.Mapa;
import APS.ui.inputTradutor;
import java.util.Scanner;

public class GameLoop {

    // (Polimorfismo de Classe) - O método trabalha com as classes Player e Mapa de forma genérica, aceitando qualquer subclasse delas
    public static void iniciar(Player player, Mapa mapaInicial, Scanner sc) {

        GameState estado = GameState.EXPLORANDO;
        Mapa mapaAtual = mapaInicial;

        inputTradutor tradutor = new inputTradutor();

        while (estado != GameState.GAME_OVER) {

            if (estado == GameState.EXPLORANDO) {

                // (Encapsulamento) - O mapa executa seu comportamento interno de renderização sem expor a estrutura do minimapa
                mapaAtual.mostrarMiniMapa(); 

                System.out.print("\nDigite a direção: ");

                String input = tradutor.inputHandler(sc);

                // (Tratamento de Exceções) - Início do bloco 'try' para tentar executar um código que pode gerar um erro em tempo de execução
                try {
                    // (Tratamento de Exceções) - O método valueOf pode lançar uma exceção caso a String não bata com nenhuma constante do enum
                    Direction direcao = Direction.valueOf(input);
                    Mapa proximo = mapaAtual.proximoMapa(direcao);

                    if (proximo != null) {
                        mapaAtual = proximo;
                        estado = GameState.EM_EVENTO;
                    } else {
                        System.out.println("Não dá pra ir pra esse lado.");
                    }

                // (Tratamento de Exceções) - Bloco 'catch' que captura e trata especificamente o erro de argumento inválido, impedindo que o jogo trave
                } catch (IllegalArgumentException e) {
                    System.out.println("Direção inválida.");
                }
            }

            else if (estado == GameState.EM_EVENTO) {

                // (Polimorfismo de Classe) - O método aoEntrar pode se comportar de formas completamente diferentes dependendo do tipo específico de Mapa 
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