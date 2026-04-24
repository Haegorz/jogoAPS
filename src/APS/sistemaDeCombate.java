package APS;

import java.util.Scanner;

public class sistemaDeCombate {

    public static void iniciarCombate(Personagens player, Personagens enemy, Scanner sc) {

        System.out.println("Combate iniciado!");

        while (player.vivo() && enemy.vivo()) {

            sistemaMenu.status(player, enemy);

            Action playerAction = sistemaMenu.turnoJogador(player, sc);
            Action enemyAction = enemyAI.decidir(enemy, player);

            if (playerAction == Action.DEFEND) player.defender(5);
            if (enemyAction == Action.DEFEND) enemy.defender(5);
            if (enemyAction == Action.CAUTIOUS) enemy.defender(2);

            if (playerAction == Action.ATTACK) {
                sistemaDeAcao.atacar(player, enemy);
            }

            if (enemy.vivo() && enemyAction == Action.ATTACK) {
                sistemaDeAcao.atacar(enemy, player);
            }

            player.resetTurno();
            enemy.resetTurno();
        }

        sistemaMenu.status(player, enemy);

        System.out.println("\n===== RESULTADO =====");

        if (player.vivo()) {
            System.out.println("Você venceu!");
            System.out.println("EXP ganho: " + enemy.getXpDrop() );
            player.ganharXP(enemy.getXpDrop());
        } else {
            System.out.println("Você perdeu...");
        }
    }
}