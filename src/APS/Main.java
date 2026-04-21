package APS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Personagens player = new Personagens("Hero", 60, 12, 5);

        Mapa mapaAtual = criaMapa.criarMundo();

        while (true) {

            mapaAtual.aoEntrar(player);
            mapaAtual.mostrarDirecoes();

            System.out.print("\nDigite a direção: ");
            String input = sc.nextLine().toUpperCase();

            try {
                Direction direcao = Direction.valueOf(input);

                Mapa proximo = mapaAtual.proximoMapa(direcao);

                if (proximo == null) {
                    System.out.println("Não dá pra ir pra esse lado.");
                } else {
                    mapaAtual = proximo;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Direção inválida.");
            }
        }
    }
}