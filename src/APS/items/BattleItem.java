package APS.items;

import APS.entities.personagens.Personagens;

// (Herança) - BattleItem estende a classe base Item, herdando suas propriedades e comportamentos
public class BattleItem extends Item {

    // (Atributo Final) - Modificador 'final' que torna o atributo imutável após sua inicialização
    private final TipoItem type;
    
    // (Atributo Final) - Atributo cujo valor constante não pode ser alterado após receber o valor no construtor
    private final int valor;

    // (Método Construtor) - Inicializa o objeto chamando o construtor da superclasse via 'super' e definindo os atributos finais
    public BattleItem(String nome, TipoItem type, int valor) {

        super(nome);

        this.type = type;
        this.valor = valor;
    }

    public TipoItem getType() {
        return type;
    }

    // (Polimorfismo de Classe) - O método recebe o tipo abstrato/geral 'Personagens', aceitando qualquer uma de suas subclasses (como Player ou Mobs)
    public void usar(Personagens alvo) {

        switch (type) {

            case HP:
                alvo.curarHp(valor);
                System.out.println( alvo.getNome() + " recuperou " + valor + " HP!" );

                break;

            case MP:
                alvo.curarMp(valor);
                System.out.println( alvo.getNome() + " recuperou " + valor + " MP!" );

                break;
        }
    }
}