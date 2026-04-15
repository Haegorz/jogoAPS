package APS;

public class Personagens {

    private String nome;
    private int hp;
    private int maxHp;
    private int atk;
    private int def;

    private int defTemp = 0;

    public Personagens(String nome, int hp, int atk, int def) {
        this.nome = nome;
        this.hp = this.maxHp = hp;
        this.atk = atk;
        this.def = def;
    }

    public String getNome() { return nome; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAtk() { return atk; }
    public int getDefTotal() { return def + defTemp; }

    public boolean vivo() {
        return hp > 0;
    }

    public void receberDano(int dano) {
        hp -= dano;
        if (hp < 0) hp = 0;
    }

    public void defender(int valor) {
        defTemp = valor;
    }

    public void resetTurno() {
        defTemp = 0;
    }
}