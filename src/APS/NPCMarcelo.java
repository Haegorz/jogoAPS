package APS;

import java.util.Scanner;

public class NPCMarcelo extends NPC {

    public NPCMarcelo() {
        super("Marcelo");
    }

    @Override
    public ResultadoEvento conversar(Player player, Scanner sc) {

        System.out.println("1 - Oi");
        System.out.println("2 - Cidade?");
        System.out.println("3 - Sair");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                System.out.println("Marcola: oi ;3.");
                return ResultadoEvento.CONTINUAR;

            case 2:
                System.out.println("Marcelinho: Cidade de <placeholder>.");
                return ResultadoEvento.CONTINUAR;

            case 3:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }
}