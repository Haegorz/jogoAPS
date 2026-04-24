package APS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Mapa mapaAtual = criaMapa.criarMundo();
        MenuPrincipal menu = new MenuPrincipal();
        Personagens player = menu.criarMenu(sc);
        inputTradutor tradutor = new inputTradutor();
        
        while (true) {

            mapaAtual.aoEntrar(player, sc);
            mapaAtual.mostrarMiniMapa();
            while(true) {
            	System.out.print("\nDigite a direção: ");
            	
            	String input = tradutor.inputHandler(sc);

            	try {
            		Direction direcao = Direction.valueOf(input);
            		Mapa proximo = mapaAtual.proximoMapa(direcao);

            		if (proximo == null) {
            			System.out.println("Não dá pra ir pra esse lado.");
            			System.out.println("Escolha uma dessas direçoes:");
            			mapaAtual.mostrarMiniMapa();
            			
            		} else {
            			mapaAtual = proximo;
            			break;
            		}

            	} catch (IllegalArgumentException e) {
            		System.out.println("Direção inválida.");
            		System.out.println("Escolha uma dessas direçoes:");
            		mapaAtual.mostrarMiniMapa();
            	}
            }
        }
    }
}