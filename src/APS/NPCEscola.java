package APS;

import java.util.Scanner;

public class NPCEscola extends NPC {

    public NPCEscola() {
        super("Ito");
    }

    
    public ResultadoEvento conversar(Player player, Scanner sc) {

        System.out.println("1 - Oi");
        System.out.println("2 - ...");
        System.out.println("3 - Sair");

        int op;

        try {
            op = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido!");
            sc.nextLine();
            return ResultadoEvento.CONTINUAR;
        }

        switch (op) {
            case 1:
                System.out.print("Ito: ");
                TextControler.textInstant("Deviam ter reciclado...\n");
                return ResultadoEvento.CONTINUAR;

            case 2:
                System.out.print("Ito: Não poupe seu inimigo!");
                TextControler.textInstant("Não poupe seu inimigo!\n");
                return ResultadoEvento.CONTINUAR;

            case 3:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }
}