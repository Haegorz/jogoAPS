package APS;

public class Player extends Personagens {
    private String[] inv;
    private EquipItem armadura;
    private EquipItem arma;

    public Player(String nome, int hp, int mp, int atk, int def){
        super(nome, hp, mp, atk, def);
        this.arma = null;
        this.armadura = null;
    }

}
