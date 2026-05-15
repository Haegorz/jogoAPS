package APS;

public class BattleItem extends Item {

    private final TipoItem type;
    private final int valor;

    public BattleItem(String nome, TipoItem type, int valor) {

        super(nome);

        this.type = type;
        this.valor = valor;
    }

    public TipoItem getType() {
        return type;
    }

    public void usar(Personagens alvo) {

        switch (type) {

            case HP:

                alvo.curarHp(valor);

                System.out.println(
                    alvo.getNome()
                    + " recuperou "
                    + valor
                    + " HP!"
                );

                break;

            case MP:

                alvo.curarMp(valor);

                System.out.println(
                    alvo.getNome()
                    + " recuperou "
                    + valor
                    + " MP!"
                );

                break;
        }
    }
}