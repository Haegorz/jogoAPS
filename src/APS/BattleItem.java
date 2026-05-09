package APS;

public class BattleItem extends Item {

    private final TipoItem type;

    public BattleItem(String nome, TipoItem type) {
        super(nome);
        this.type = type;
    }

    public void usar(Personagens alvo) {

        switch (type) {

            case HP:
                alvo.curarHp(20);
                System.out.println(
                    alvo.getNome()
                    + " recuperou HP!"
                );

                break;

            case MP:
                alvo.curarMp(20);
                System.out.println(
                    alvo.getNome()
                    + " recuperou MP!"
                );

                break;
        }
    }
}