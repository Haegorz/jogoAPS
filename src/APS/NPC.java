package APS;

import java.util.Scanner;

public class NPC {

    protected String nome;

    public NPC(String nome) {
        this.nome = nome;
    }

    public ResultadoEvento conversar(Player player, Scanner sc) {
        System.out.println(nome + ": Olá.");
        return ResultadoEvento.CONTINUAR;
    }
}