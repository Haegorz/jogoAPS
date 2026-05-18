package APS;

import java.util.Scanner;

public class sistemaDeCombate {

    public static void iniciarCombate(Player player, Mobs enemy, Scanner sc) {

        System.out.println("\nCombate iniciado!");

        while (player.vivo() && enemy.vivo()) {

            sistemaMenu.status(player, enemy);

            Action playerAction = sistemaMenu.turnoJogador(player, sc);

            // MAGIAS
            if (playerAction == Action.MAGIA) {

                player.mostrarSkills();

                while (true) {
                    System.out.println("Digite a magia:");
                    String skillEscolhida = sc.nextLine();

                    boolean usou = player.usarMagia(skillEscolhida, enemy);

                    if (usou) {
                        break;
                    }
                }
            }

            // INVENTARIO
            if (playerAction == Action.INV) {

                boolean voltarMenu = false;

                while (!voltarMenu) {

                    player.getInventario();

                    System.out.println("Digite o Item a ser usado");
                    System.out.println("Ou digite 'sair' para voltar");

                    String itemToUse = sc.nextLine();


                    if (itemToUse.equalsIgnoreCase("sair")) {

                        voltarMenu = true;
                        sistemaMenu.status(player, enemy);
                        playerAction = sistemaMenu.turnoJogador(player, sc);

                        // se escolheu outra ação, sai do loop
                        if (playerAction != Action.INV) {
                            break;
                        }

                        continue;
                    }

                    boolean usou = player.usarItem(itemToUse, enemy, player);

                    if (usou) {
                        break;
                    }
                }
            }

            // IA INIMIGA
            Action enemyAction = enemyAI.decidir(enemy, player);

        
            if (enemy.getHp() < enemy.getMaxHp() * 0.3) {
                System.out.println(enemy.getNome() + " parece fraco...");
            }

            // DEFESA PLAYER
            if (playerAction == Action.DEFEND) {

                int defesa = 3 + (int) (Math.random() * 5);

                player.defender(defesa);

                System.out.println(player.getNome() + " se preparou! DEF +" + defesa);
            }

            // DEFESA INIMIGO
            if (enemyAction == Action.DEFEND) {

                enemy.defender(5);

                System.out.println(enemy.getNome() + " levantou a guarda!");
            }

            if (enemyAction == Action.CAUTIOUS) {

                enemy.defender(2);

                System.out.println(enemy.getNome() + " está cauteloso.");
            }

            // HABILIDADE AGRESSIVA
            if (enemy.getTipo() != null &&
                    enemy.getTipo().equals("AGRESSIVO")) {

                if (Math.random() < 0.4) {

                    System.out.println("O boss ataca duas vezes!");

                    sistemaDeAcao.atacar(enemy, player);
                }
            }

            // QUEBRA DEFESA
            if (playerAction == Action.DEFEND && Math.random() < 0.3) {

                System.out.println(enemy.getNome() + " quebra sua defesa!");

                player.receberDano(5);
            }

            // ATAQUE PLAYER
            if (playerAction == Action.ATTACK) {

                if (Math.random() < 0.25) {

                    System.out.println("Ataque especial!");

                    player.atacarEspecial(enemy);

                } else {

                    sistemaDeAcao.atacar(player, enemy);
                }
            }

            // TURNO INIMIGO

            if (enemy.isStun()) {

                System.out.println(enemy.getNome() + " está atordoado e perdeu o turno!");

                enemy.setStun(false);

            } else if (enemy.vivo() &&
                    enemyAction == Action.ATTACK) {

                // counter defesa
                if (playerAction == Action.DEFEND) {

                    System.out.println("Defesa perfeita! Dano reduzido!");

                    player.defender(
                            player.getDefTotal() + 5);
                }

                // HABBILIDADES ESPECIAIS
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

            // RESET TURNO
            player.resetTurno();
            enemy.resetTurno();
        }

        // RESULTADO FINAL
        sistemaMenu.status(player, enemy);

        System.out.println("\n===== RESULTADO =====");

        if (player.vivo()) {

            System.out.println("Você venceu!");

            System.out.println("EXP ganho: " + enemy.getXpDrop() + "\nDinheiro ganho: " + enemy.getMoedasDrop());

            player.ganharXP(enemy.getXpDrop(), sc);
            player.ganharMoedas(enemy.getMoedasDrop());
            player.setKillCount(player.getKillCount() + 1);
            player.statUper();

        } else {

            System.out.println("Você perdeu...");
        }
    }
}