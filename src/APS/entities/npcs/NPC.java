package APS.entities.npcs;

import APS.entities.personagens.Player;
import APS.events.ResultadoEvento;
import java.util.Scanner;


public class NPC {

    // (Encapsulamento) - O modificador 'protected' protege o atributo, permitindo acesso direto apenas à própria classe e às suas subclasses
    protected String nome;

    // (Método Construtor) - Construtor padrão da classe utilizado para inicializar o estado do objeto NPC com um nome específico
    public NPC(String nome) {
        this.nome = nome;
    }

    // (Polimorfismo de Classe) - O método aceita um parâmetro do tipo 'Player', permitindo interagir com qualquer uma de suas subclasses
    public ResultadoEvento conversar(Player player, Scanner sc) {
        System.out.println(nome + ": Olá.");
        return ResultadoEvento.CONTINUAR;
    }
}