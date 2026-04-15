package APS;

public class Main {

    public static void main(String[] args) {

        Personagens player = new Personagens("Hero", 60, 12, 5);
        Personagens enemy = new Personagens("Goblin", 50, 10, 4);

        sistemaDeCombate.iniciarCombate(player, enemy);
    }
}