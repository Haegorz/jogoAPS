package APS;

import java.util.HashSet;
import java.util.Set;

public class Personagens {

    private String nome;
    private int hp;
    private int maxHp;
    private int atk;
    private int def;

    private int level = 1;
    private int exp = 0;
    private int proximoLevel = 50;
    private int xpDrop;

    private int defTemp = 0;

    public Personagens(String nome, int hp, int atk, int def, int xpDrop) {
        this.nome = nome;
        this.hp = this.maxHp = hp;
        this.atk = atk;
        this.def = def;
        this.xpDrop = xpDrop;
    }

    public String getNome() { return nome; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAtk() { return atk; }
    public int getDefTotal() { return def + defTemp; }
    public int getXpDrop() { return xpDrop; }

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

    public void ganharXP(int quantidade) {
        exp += quantidade;

        while (exp >= proximoLevel && proximoLevel > 0) {
            subirNivel();
        }
    }

    private void subirNivel() {
        level++;

        exp -= proximoLevel;

        proximoLevel = (int)(proximoLevel * 1.5);
        if (proximoLevel <= 0) proximoLevel = 1;

        maxHp += 10;
        atk += 2;
        def += 1;

        hp = maxHp;

        System.out.println(nome + " subiu para o nível " + level + "!");
    }
    
    public void addFlag(String flag) {
        flags.add(flag);
    }

    public boolean temFlag(String flag) {
        return flags.contains(flag);
    }

    public void removeFlag(String flag) {
        flags.remove(flag);
    }
    
    private Set<String> flags = new HashSet<>();
}