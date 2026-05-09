package APS;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal();
        Player player = menu.criarMenu(sc);
        player.adicionarItem("pocao_hp", new BattleItem("Poção HP", TipoItem.HP), 1);
        player.adicionarItem("pocao_mp", new BattleItem("Poção MP", TipoItem.MP), 1);
        player.aprenderSkill(new Skill("Fireball", 30, 10));
        player.aprenderSkill(new Skill("Thunder", 45, 20));
        player.adicionarItem("espada",new EquipItem("Espada de Ferro",TipoItem.ATK,5),1);
        Mapa mapaInicial = criaMapa.criarMundo();
        GameLoop.iniciar(player, mapaInicial, sc);
        
    }
}