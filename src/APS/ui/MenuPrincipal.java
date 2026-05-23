package APS.ui;

import APS.combat.Skill;
import APS.entities.personagens.Player;
import java.util.Scanner;

public class MenuPrincipal {

    // (Polimorfismo de Classe) - O método aceita receber qualquer subclasse válida de Scanner como parâmetro de entrada
    public Player criarMenu(Scanner sc) {

        while (true) {

            System.out.println("//######################################\\\\");
            System.out.println("//              JAVA QUEST              \\\\");
            System.out.println("//                                      \\\\");
            System.out.println("//  1 - COMEÇA O JOGO COMO CAVALEIRO    \\\\");
            System.out.println("//  2 - COMEÇA O JOGO COMO MAGO         \\\\");
            System.out.println("//  3 - COMEÇA O JOGO COMO ESPADACHIM   \\\\");
            System.out.println("//######################################\\\\");

            int oji = sc.nextInt();
            sc.nextLine();

            switch (oji) {
                case 1:
                    // (Instanciação de Objeto) - Aloca espaço em memória para criar uma instância específica da classe Player
                    Player player = new Player("Cavaleiro", 60, 9, 14, 15);
                    // (Instanciação de Objeto) - Cria um objeto da classe Skill e o repassa diretamente como argumento de método
                    player.aprenderSkill(new Skill("Grito de Guerra", 15, 5));
                    return player;

                case 2:
                    // (Instanciação de Objeto) - Criação de uma instância isolada para o personagem da classe Mago
                    Player player2 = new Player("Mago", 40, 6, 3, 40);
                    player2.aprenderSkill(new Skill("Fireball", 30, 10));
                    player2.aprenderSkill(new Skill("Thunder", 45, 20));
                    return player2;

                case 3:
                    // (Instanciação de Objeto) - Alocação e configuração inicial do objeto pertencente à classe Espadachim
                    Player player3 = new Player("Espadachim", 45, 15, 5, 25);
                    player3.aprenderSkill(new Skill("Fireball", 30, 10));
                    return player3;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}