package APS;

public class sistemaDeCombate {

    public static void iniciarCombate(Personagens player, Personagens enemy) {

        System.out.println("Combate iniciado!");

        while (player.vivo() && enemy.vivo()) {

            sistemaMenu.status(player, enemy);

            Action playerAction = sistemaMenu.turnoJogador(player);
            Action enemyAction = enemyAI.decidir(enemy, player);

            // DEFESAS
            if (playerAction == Action.DEFEND) player.defender(5);
            if (enemyAction == Action.DEFEND) enemy.defender(5);
            if (enemyAction == Action.CAUTIOUS) enemy.defender(2);

            // ATAQUES
            if (playerAction == Action.ATTACK) {
                sistemaDeAcao.atacar(player, enemy);
            }

            if (enemy.vivo() && enemyAction == Action.ATTACK) {
                sistemaDeAcao.atacar(enemy, player);
            }
            
            //MAGIA??
            
            
            // RESET DOS TURNOS
            player.resetTurno();
            enemy.resetTurno();
        }

        sistemaMenu.status(player, enemy);

        System.out.println("\n===== RESULTADO =====");

        if (player.vivo()) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Você perdeu...");
        }
    }
}