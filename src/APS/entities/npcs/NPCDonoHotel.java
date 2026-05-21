package APS.entities.npcs;

import APS.entities.personagens.Player;
import APS.events.ResultadoEvento;
import APS.ui.TextControler;
import java.util.Scanner;

public class NPCDonoHotel extends NPC {

    public NPCDonoHotel() {
        super("Dono");
    }

    
    public ResultadoEvento conversar(Player player, Scanner sc) {
        if (NPCHotel.getIsVivo()) {
           
        System.out.println("\n=== DONO DO HOTEL ===");
        System.out.println("1 - Oi");
        System.out.println("2 - Lata de lixo falante");
        System.out.println("3 - Quadra");
        System.out.println("4 - Sair");

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
                System.out.print("Dono: ");
                TextControler.textFast("Ei, Sinta-se a vontade pra descançar!\n");
                TextControler.textFast("Se precisar de algo, é só me chamar!\n");
                TextControler.textFast("O mercador está aberto! veja se tem algo que precisa. \n");
                return ResultadoEvento.CONTINUAR;

            case 2:
                System.out.print("Dono: ");
                TextControler.textFast("Ela é meio estranha, mas é gente fina.\n");
                TextControler.textFast("Embora n cheire bem... não fale isso pra ela.\n");
                return ResultadoEvento.CONTINUAR;

            case 3:
                System.out.print("Dono: ");
                TextControler.textFast("De onde tiraram a ideia de botar um parque do lado de uma usina nuclear?\n");
                TextControler.textFast("Depois da explosão ninguem saiu daqui, mas todos estão com medo do parque...");
                return ResultadoEvento.CONTINUAR;
            case 4:
                return ResultadoEvento.SAIR_MAPA;
        }
    }else{
        System.out.println("Dono: ");
        TextControler.textDramatic("...");
        TextControler.textDramatic("Você realmente é o heroi?\n");
        return ResultadoEvento.SAIR_MAPA;

    }

        return ResultadoEvento.CONTINUAR;
    }
}