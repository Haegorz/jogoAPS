package APS;

import java.util.Scanner;

public class NPCEscola extends NPC {

    public NPCEscola() {
        super("Ito");
    }

    
    public ResultadoEvento conversar(Player player, Scanner sc) {

        System.out.println("\n=== PROF. ITO ===");
        System.out.println("1 - Oi");
        System.out.println("2 - ...");
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
                System.out.print("Ito: ");
                TextControler.textFast("Os alunos tem estado muito agitados ultimamente.\n");
                TextControler.textFast("O medo da escola ser invadida é constante\n");
                TextControler.textFast("Me pergunto quando tudo sera resolvido...\n");
                return ResultadoEvento.CONTINUAR;

            case 2:
                System.out.print("Ito: ");
                TextControler.textFast("Perto daqui eu sinto uma presença assustadora...\n");
                TextControler.textFast("Parece vir da usina que foi explodiu.\n");
                return ResultadoEvento.CONTINUAR;

            case 3:
                System.out.print("Ito: ");
                TextControler.textFast("Por algum motivo os estudantes tem evitado a quadra ultimamente...\n");
                TextControler.textFast("Parece que tem algo errado por lá...\n");
                TextControler.textFast("Talvez eu deve investigar...\n");
                return ResultadoEvento.CONTINUAR;
            case 4:
                return ResultadoEvento.SAIR_MAPA;
        }

        return ResultadoEvento.CONTINUAR;
    }
}