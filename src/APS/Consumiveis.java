package APS;

public abstract class Consumiveis {
    protected String nome;
    protected String descricao;

    public Consumiveis(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public abstract void usar(Personagens alvo);
}
