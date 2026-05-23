package APS.entities.npcs;

import APS.entities.personagens.Player;
import APS.events.ResultadoEvento;
import APS.ui.TextControler;
import java.util.Scanner;

// (Herança) - NPCEscola herda características e comportamentos da classe mãe NPC
public class NPCEscola extends NPC {

    // (Método Construtor) - Inicializa o objeto definindo o nome "Ito" através da superclasse
    public NPCEscola() {
        super("Ito");
    }

    // (Sobrescrita) - Altera o comportamento do método 'conversar' definido originalmente em NPC
    public ResultadoEvento conversar(Player player, Scanner sc) {

        System.out.println("\n=== PROF. ITO ===");
        System.out.println("1 - Oi");
        System.out.println("2 - ...");
        System.out.println("3 - Quadra");
        System.out.println("4 - Sair");

        int op;

        // (Tratamento de Exceções) - Captura erros de digitação caso o usuário não informe um número inteiro
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