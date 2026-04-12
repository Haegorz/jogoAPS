package APS;

public class Main {

    public static void main(String[] args) {

        Personagens player = new Personagens("Hero", 50, 20, 10, 10);
        Personagens enemy = new Personagens("Goblin", 40,20, 8, 3);

        sistemaDeCombate.iniciarCombate(player, enemy);
    }
}