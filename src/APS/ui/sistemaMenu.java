package APS.ui;

import APS.combat.Action;
import APS.entities.personagens.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SistemaMenu {

    // (Atributo Estático) - Método de classe que pode ser acessado diretamente sem necessitar de uma instância de SistemaMenu
    public static void status(Personagens p, Personagens e) {

        System.out.println("\n====================");
        // (Polimorfismo de Classe) - Os parâmetros aceitam referências genéricas de Personagens, englobando objetos de qualquer uma de suas subclasses
        System.out.println(p.getNome() + " HP: " + p.getHp() + "/" + p.getMaxHp() +
                " MP " + p.getMp() + "/" + p.getMaxMp()
                + " | ATK:" + p.getAtk() + " DEF:" + p.getDefTotal());
        System.out.println(e.getNome() + " HP: " + e.getHp() + "/" + e.getMaxHp()
                + " | ATK:" + e.getAtk() + " DEF:" + e.getDefTotal());
        System.out.println("====================");
    }

    // (Atributo Estático) - Operação global estática encarregada de capturar a ação escolhida pelo usuário durante o combate
    public static Action turnoJogador(Personagens p, Scanner sc) {

        while (true) {

            System.out.println("\n1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Magia");
            System.out.println("4 - Inventario");

            // (Tratamento de Exceções) - Bloco de captura estruturado para isolar e tratar erros de entrada de dados incorretos
            try {
                int escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 1)
                    return Action.ATTACK;
                if (escolha == 2)
                    return Action.DEFEND;
                if (escolha == 3)
                    return Action.MAGIA;
                if (escolha == 4)
                    return Action.INV;

                System.out.println("Opção inválida.");

            } catch (InputMismatchException ex) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
            }
        }
    }
}