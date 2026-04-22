package APS;

public class Personagens {

    protected String nome;
    protected int hp;
    private  int maxHp;
    protected int mp;
    protected int atk;
    protected int def;
    private int maxMp;

    private int defTemp = 0;

    public Personagens(String nome, int hp,int atk, int def, int mp) {
        this.nome = nome;
        this.hp = this.maxHp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.maxMp = mp;

    }

    public String getNome() { return nome; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAtk() { return atk; }
    public int getDefTotal() { return def + defTemp; }
    public int getMp(){return mp;}
    public int getMaxMp(){return maxMp;}
    public void setHp(int valor){hp = valor;}
    public void setMp(int valor){mp = valor;}

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