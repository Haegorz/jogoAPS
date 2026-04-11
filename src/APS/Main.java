package APS;

public class Main {

    public static void main(String[] args) {

        Personagens player = new Personagens("Hero", 50, 10, 5);
        Personagens enemy = new Personagens("Goblin", 40, 8, 3);

        sistemaDeCombate.iniciarCombate(player, enemy);
    }
}