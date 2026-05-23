package APS.events;

import APS.ui.TextControler;

public class Ending {

    // (Atributo Estático) - Métodos estáticos que encerram a execução exibindo as strings do desfecho 
    public static void finalBom() {
        System.out.println("\n==================================");
        System.out.print("           ");
        TextControler.textDramatic("FINAL BOM");
        System.out.print("             \n");
        System.out.println("==================================\n");

        TextControler.textFast("O Rei dos Lixões foi derrotado.\n");
        TextControler.textFast("A paz retorna ao reino.\n");
        TextControler.textFast("O ambiente começa a se recuperar.\n");
        TextControler.textFast("Seu nome será lembrado como herói.\n");

        TextControler.textDramatic("Obrigado por jogar.\n");
        System.out.println("==================================");
    }

    
    public static void finalRuim() {

        System.out.println("\n==================================");
        System.out.print("           ");
        TextControler.textDramatic("FINAL RUIM");
        System.out.print("             \n");
        System.out.println("==================================\n");

        TextControler.textFast("Você confiou no rei...\n");
        TextControler.textFast("E pagou o preço.\n");
        TextControler.textFast("As sombras dominam tudo.\n");

        TextControler.textDramatic("Seu nome será esquecido...\n");
        System.out.println("==================================");

    }


    public static void finalSecreto() {
        System.out.println("\n==================================");
        System.out.print("           ");
        TextControler.textDramatic("FINAL SECRETO");
        System.out.print("             \n");
        System.out.println("==================================\n");

        TextControler.textFast("Mesmo traído, você venceu.\n");
        TextControler.textFast("Você não é apenas um herói...\n");
        TextControler.textFast("Você é uma lenda.\n");

        TextControler.textDramatic("Poucos chegam até aqui.\n");
        System.out.println("==================================");
    }

    // (Atributo Estático) - Comportamento estático compartilhado de forma fixa no sistema
    public static void finalRuimalmavendida() {
        System.out.println("\n==================================");
        System.out.print("           ");
        TextControler.textDramatic("FINAL SECRETO??? (Não seja ganancioso!)");
        System.out.print("             \n");
        System.out.println("==================================\n");

        TextControler.textFast("Você perdeu a aposta...\n");
        TextControler.textFast("E pagou o preço.\n");
        TextControler.textFast("Sua alma agora pertence ao diabo...\n");
        TextControler.textFast("Seu nome será esquecido.\n");
        System.out.println("==================================");
    }

    // (Atributo Estático) - Função de classe fixa e imutável de acesso direto no encerramento
    public static void finalRuimlixo() {
        System.out.println("\n==================================");
        System.out.print("           ");
        TextControler.textDramatic("FINAL RUIM ???(Seja educado!)            \n");
        System.out.print("             \n");
        System.out.println("==================================\n");

        TextControler.textFast("Você não deveria ficar xingando as pessoas...\n");
        TextControler.textFast("(COMO VOCÊ PERDEU PRA ISSO?)\n");
        TextControler.textFast("Seu nome será esquecido.\n");
        System.out.println("==================================");
    }

    // (Atributo Estático) - Operação global estática que centraliza uma das resoluções narrativas do jogo
    public static void finalSecretoKarma() {
        System.out.println("\n==================================");
        System.out.print("           ");
        TextControler.textDramatic("FINAL SECRETO??? (Mas a que custo?)");
        System.out.print("             \n");
        System.out.println("==================================\n");

        TextControler.textFast("Você derrubou o rei...\n");
        TextControler.textFast("mas a que custo?\n");
        TextControler.textFast("As sombras dominaram você...\n");

        TextControler.textDramatic("Seu nome será esquecido...\n");
        System.out.println("==================================");
    }

    // (Atributo Estático) - Método estático que encerra a execução exibindo as strings do desfecho maligno
    public static void finalRuimMaligno() {
        System.out.println("\n==================================");
        System.out.print("           ");
        TextControler.textDramatic("FINAL RUIM??? (O mal triunfa?)            \n");
        System.out.print("             \n");
        System.out.println("==================================\n");

        TextControler.textFast("Você se uniu ao mal...\n");
        TextControler.textFast("Você aquele que era dito ser o bien.\n");
        TextControler.textFast("O mundo é dominado pelo rei e pela sua mão direita\n");
        TextControler.textDramatic("Não existe mais lugar para a humanidade...\n");
        TextControler.textDramatic("Você se arrepende de suas escolhas?\n");
        TextControler.textFast("Seu nome será esquecido.\n");
        System.out.println("==================================");
    }
}