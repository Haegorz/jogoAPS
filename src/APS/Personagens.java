package APS;

public class Personagens {

    protected String nome;
    protected int hp;
    protected int maxHp;
    protected int mp;
    protected int atk;
    protected int def;
    protected int defTemp = 0;
    protected int maxMp;
    
    

    public Personagens(String nome, int hp, int atk, int def, int mp) {
        this.nome = nome;
        this.hp = this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
        this.atk = atk;
        this.def = def;
        
    }


    public String getNome() { return nome; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAtk() { return atk; }
    public int getDefTotal() { return def + defTemp; }
    public int getMp(){return mp;}
    public int getMaxMp(){return maxMp;}
    public void toHp(int valor){hp = valor;}
    public void setMp(int valor){mp = valor;}
    

    public void setHp(int hp) {
        if (hp < 0) this.hp = 0;
        else if (hp > maxHp) this.hp = maxHp;
        else this.hp = hp;
    }

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
    public void aumentarMaxHp(int valor) {
        this.maxHp += valor;
    }

    public void aumentarAtk(int valor) {
        this.atk += valor;
    }
    public void aumentarMaxMp(int valor){
        this.maxMp += valor;
    }

    public void aumentarDef(int valor) {
        this.def += valor;
    }

    public void curarTotal() {
        this.hp = this.maxHp;
    }
    public void mpTotal(){
        this.mp = maxMp;

    }
    
    public boolean esquivou() {
        double chance;

        if (nome.equals("Espadachim")) chance = 0.25;
        else if (nome.equals("Mago")) chance = 0.15;
        else chance = 0.10;

        return Math.random() < chance;
    }
    public void curarHp(int valor) {
    setHp(Math.min(getHp() + valor, getMaxHp()));
    }

    public void curarMp(int valor) {
        setMp(Math.min(getMp() + valor, getMaxMp()));
    }
}