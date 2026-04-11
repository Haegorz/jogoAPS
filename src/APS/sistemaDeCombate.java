package APS;

class sistemaDeCombate {

    static void iniciarCombate(Personagens player, Personagens enemy) {

        while (player.vivo() && enemy.vivo()) {

        	sistemaMenu.mostrarStatus(player, enemy);

        	sistemaMenu.turnoJogador(player, enemy);

            if (!enemy.vivo()) break;

            turnoInimigo(enemy, player);
        }

        if (player.vivo()) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Você perdeu...");
        }
    }

    static void turnoInimigo(Personagens enemy, Personagens player) {
        System.out.println("\nTurno do inimigo...");
        sistemaDeAcao.atacar(enemy, player);
    }
}