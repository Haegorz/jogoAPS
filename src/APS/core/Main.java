package APS.core;

import APS.entities.personagens.Player;
import APS.map.Mapa;
import APS.map.criaMapa;
import APS.ui.MenuPrincipal;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        // (Instanciação de Objeto) - Uso do operador 'new' para alocar memória e criar novas instâncias das classes Scanner e MenuPrincipal
        Scanner sc = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal();
        // (Polimorfismo de Classe) - A referência 'player' recebe um objeto do tipo específico criado dentro do menu 
        Player player = menu.criarMenu(sc);
        // (Polimorfismo de Classe) - O método estático retorna uma instância de um mapa específico
        Mapa mapaInicial = criaMapa.criarMundo();
        // (Encapsulamento) - Inicializa o fluxo principal
        GameLoop.iniciar(player, mapaInicial, sc);
        
    }
}