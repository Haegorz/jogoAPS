package APS;

class Personagens {
    String nome;
    int hp;
    int mp;
    int maxHp;
    int atk;
    int def;

    public Personagens(String nome, int hp, int mp, int atk, int def) {
        this.nome = nome;
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
    
    }


    boolean vivo() {
        return hp > 0;
    }
}