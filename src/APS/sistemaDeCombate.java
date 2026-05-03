package APS;

import java.util.Scanner;

public class sistemaDeCombate {



    
	public static void iniciarCombate(Player player, Mobs enemy, Scanner sc) {

        System.out.println("Combate iniciado!");

        while (player.vivo() && enemy.vivo()) {

            sistemaMenu.status(player, enemy);

            Action playerAction = sistemaMenu.turnoJogador(player, sc);

            while (true) {
                Scanner scan = new Scanner(System.in);

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
            Action enemyAction = enemyAI.decidir(enemy, player);
            // feedback
            if (enemy.getHp() < enemy.getMaxHp() * 0.3) {
                System.out.println(enemy.getNome() + " parece fraco...");
            }

            //DEFESA
            if (playerAction == Action.DEFEND) {
                int defesa = 3 + (int)(Math.random() * 5);
                player.defender(defesa);
                System.out.println(player.getNome() + " se preparou! DEF +" + defesa);
            }

            if (enemyAction == Action.DEFEND) {
                enemy.defender(5);
                System.out.println(enemy.getNome() + " levantou a guarda!");
            }

            if (enemyAction == Action.CAUTIOUS) {
                enemy.defender(2);
                System.out.println(enemy.getNome() + " está cauteloso.");
            }
            
            if (enemy.getTipo() != null && enemy.getTipo().equals("AGRESSIVO")) {
                if (Math.random() < 0.4) {
                    System.out.println("O boss ataca duas vezes!");
                    sistemaDeAcao.atacar(enemy, player);
                }
            }
            
            if (playerAction == Action.DEFEND && Math.random() < 0.3) {
                System.out.println(enemy.getNome() + " quebra sua defesa!");
                player.receberDano(5);
            }

            //ATAQUE DO PLAYER
            if (playerAction == Action.ATTACK) {
                player.atacarEspecial(enemy);
            }

            //TURNO DO INIMIGO
            if (enemy.isStun()) {
                System.out.println(enemy.getNome() + " está atordoado e perdeu o turno!");
                enemy.setStun(false);
            } 
            else if (enemy.vivo() && enemyAction == Action.ATTACK) {

                //COUNTER DEFESA
                if (playerAction == Action.DEFEND) {
                    System.out.println("Defesa perfeita! Dano reduzido!");
                    player.defender(player.getDefTotal() + 5);
                }

                //habilidades do boss
                if (enemy.getTipo() != null) {

                    if (enemy.getTipo().equals("AGRESSIVO") && Math.random() < 0.3) {
                        System.out.println("O boss entrou em fúria!");
                        sistemaDeAcao.atacar(enemy, player);
                    }

                    if (enemy.getTipo().equals("INTELIGENTE") && Math.random() < 0.2) {
                        System.out.println("O boss previu seu ataque!");
                        enemy.defender(10);
                    }
                }

                sistemaDeAcao.atacar(enemy, player);
            }

            //RESET
            player.resetTurno();
            enemy.resetTurno();
        }

        sistemaMenu.status(player, enemy);

        System.out.println("\n===== RESULTADO =====");

        if (player.vivo()) {
            System.out.println("Você venceu!");
            System.out.println("EXP ganho: " + enemy.getXpDrop());
            player.ganharXP(enemy.getXpDrop(), sc);;
        } else {
            System.out.println("Você perdeu...");
        }
    }
}