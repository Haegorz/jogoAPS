package APS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal();
        Player player = menu.criarMenu(sc);
        Mapa mapaInicial = criaMapa.criarMundo();
        GameLoop.iniciar(player, mapaInicial, sc);
        
    }
}