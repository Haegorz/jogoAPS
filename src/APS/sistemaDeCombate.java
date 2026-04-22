package APS;

import java.util.Scanner;

public class SistemaDeCombate {

    public static void iniciarCombate(Player player, Personagens enemy) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Combate iniciado!");

        while (player.vivo() && enemy.vivo()) {

            sistemaMenu.status(player, enemy);

            Action playerAction;

                
            while (true) {
                playerAction = sistemaMenu.turnoJogador(player);

                if (playerAction == Action.INV) {
                    player.getInventario();

                    while (true) {
                        System.out.println("Digite o Item a ser usado");
                        String itemToUse = scan.nextLine();

                        if (player.usarItem(itemToUse)) {
                            break; 
                        }

                        
                    }

                    break; 
                }

                break; 
            }
            Action enemyAction = EnemyAI.decidir(enemy, player);

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

        scan.close(); 
    }
}