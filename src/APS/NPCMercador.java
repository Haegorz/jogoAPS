package APS;

import java.util.Scanner;

public class NPCMercador extends NPC {

    public NPCMercador() {
        super("Mercador");
    }

    @Override
    public ResultadoEvento conversar(Player player, Scanner sc) {

        System.out.println("1 - Crompa poçao");
        System.out.println("2 - Sair");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
            	System.out.println("n funciona ainda kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
                System.out.println("ta aq me chefe!");
                return ResultadoEvento.CONTINUAR;

            case 2:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }
}