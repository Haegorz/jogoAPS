package APS;

class Personagens {
    String nome;
    int hp;
    int maxHp;
    int atk;
    int def;

    Personagens(String nome, int hp, int atk, int def) {
        this.nome = nome;
        this.hp = this.maxHp = hp;
        this.atk = atk;
        this.def = def;
    }

    boolean vivo() {
        return hp > 0;
    }
}