package APS;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Hero", 60 , 12, 5, 20);

        Personagens enemy = new Personagens("Goblin", 50, 10, 4, 20);
        player.adicionarItem("pocao_hp", new BattleItem("Poção HP", TipoItem.HP), 1);
        player.adicionarItem("pocao_mp", new BattleItem("Poção MP", TipoItem.MP), 1);


        SistemaDeCombate.iniciarCombate(player, enemy);
    }
}