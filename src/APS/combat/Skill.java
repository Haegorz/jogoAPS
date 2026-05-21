package APS.combat;

public class Skill {

    private String nome;
    private int dano;
    private int custoMp;

    public Skill(String nome, int dano, int custoMp) {
        this.nome = nome;
        this.dano = dano;
        this.custoMp = custoMp;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getCustoMp() {
        return custoMp;
    }
}