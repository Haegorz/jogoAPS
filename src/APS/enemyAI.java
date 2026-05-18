package APS;

import java.util.Random;

public class enemyAI {

    private static Random rand = new Random();

    public static Action decidir(Mobs enemy, Player player) {

        System.out.println("\nTurno do inimigo...");

        String tipo = enemy.getTipo();

        if (tipo != null) {

            switch (tipo) {

                case "AGRESSIVO":
                    System.out.println(enemy.getNome() + " está furioso!");
                    return Action.ATTACK;

                case "TANK":
                    if (enemy.getHp() < enemy.getMaxHp() * 0.25) {
                        if(Math.random() < 0.5) {
                            System.out.println(enemy.getNome() + " levanta sua guarda!");
                            return Action.DEFEND;
                        } else {
                            System.out.println(enemy.getNome() + " se mantém firme!");
                            return Action.ATTACK;
                        }
                    }
                    return Action.ATTACK;

                case "RAPIDO":
                    if (rand.nextInt(100) < 70) {
                        return Action.ATTACK;
                    } else {
                        System.out.println(enemy.getNome() + " se move rapidamente!");
                        return Action.CAUTIOUS;
                    }

                case "INTELIGENTE":
                    if (player.getHp() < player.getMaxHp() * 0.4) {
                        System.out.println(enemy.getNome() + " vê uma chance de finalizar!");
                        return Action.ATTACK;
                    } else {
                        System.out.println(enemy.getNome() + " analisa o combate...");
                        return Action.DEFEND;
                    }
            }
        }
        
        if (enemy.getHp() < enemy.getMaxHp() * 0.3) {
            System.out.println(enemy.getNome() + " entrou em desespero!");
            return Action.ATTACK;
        }

        return rand.nextBoolean() ? Action.ATTACK : Action.CAUTIOUS;
    }
}