package APS;

public class sistemaDeCombate {

    public static void iniciarCombate(Personagens player, Personagens enemy) {

        System.out.println("Combate iniciado!");

        while (player.vivo() && enemy.vivo()) {

            sistemaMenu.status(player, enemy);

            Action playerAction = sistemaMenu.turnoJogador(player);
            Action enemyAction = enemyAI.decidir(enemy, player);

            // DEFESAS Heroi
            if (playerAction == Action.DEFEND) player.defender(5,5);
            if (playerAction == Action.DODGE) player.esquiva(3);


            //Inimigo
            if (enemyAction == Action.DEFEND) enemy.defender(5,3);
            if (enemyAction == Action.CAUTIOUS) enemy.defender(2,2);
            if (enemyAction == Action.DODGE) enemy.esquiva(8);
            // ATAQUES

            if (playerAction == Action.ATTACK) {
                if (player.gastarAp(6)) {
                    sistemaDeAcao.atacar(player, enemy);
                }else {
                    System.out.println("Agilidade insuficiente para atacar!");
                }
            }

            if (enemy.vivo() && enemyAction == Action.ATTACK) {
                 if (enemy.gastarAp(6)) {
                    sistemaDeAcao.atacar(enemy, player);
                }else {
                    System.out.println("Agilidade insuficiente para atacar!");
                }
            }

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