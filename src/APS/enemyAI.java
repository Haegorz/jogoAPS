package APS;

import java.util.Random;

public class EnemyAI {

    private static final Random rand = new Random();

    public static Action decidir(Personagens enemy, Personagens player) {

        System.out.println("\nTurno do inimigo...");

        if (enemy.getHp() < enemy.getMaxHp() * 0.3) {
            System.out.println(enemy.getNome() + " se prepara para bloquear!");
            return Action.DEFEND;
        }

        if (rand.nextBoolean()) {
            return Action.ATTACK;
        } else {
            System.out.println(enemy.getNome() + " está cauteloso!");
            return Action.CAUTIOUS;
        }
    }
}