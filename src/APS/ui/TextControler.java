package APS.ui;

public class TextControler {

    // (Atributo Estático) - Método utilitário de classe que pode ser acessado globalmente sem instanciar um objeto TextControler
    public static void textFast(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            // (Tratamento de Exceções) - Captura o erro disparado caso a execução da Thread seja interrompida de forma abrupta
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // (Atributo Estático) - Função estática de controle global para impressão acelerada de caracteres no console
    public static void textInstant(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            // (Tratamento de Exceções) - Bloco try-catch obrigatório para monitorar a pausa controlada do fluxo do programa
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // (Atributo Estático) - Método fixo da classe projetado para gerar efeitos dramáticos de pausa na saída de texto
    public static void textDramatic(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            // (Tratamento de Exceções) - Tratamento local de falha em tempo de execução na linha de processamento de threads
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}