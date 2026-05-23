package APS.combat;

public class Skill {

    private String nome;
    private int dano;
    private int custoMp;

    // (Método Construtor) - Método executado na criação do objeto para inicializar seus atributos com os valores fornecidos
    public Skill(String nome, int dano, int custoMp) {
        this.nome = nome;
        this.dano = dano;
        this.custoMp = custoMp;
    }
    // (Encapsulamento) - Método get público que fornece acesso seguro e somente leitura para o atributo privado 'nome'
    public String getNome() {
        return nome;
    }
    // (Encapsulamento) - Método get público que fornece acesso seguro e somente leitura para o atributo privado 'dano'
    public int getDano() {
        return dano;
    }
    // (Encapsulamento) - Método get público que fornece acesso seguro e somente leitura para o atributo privado 'custoMp'
    public int getCustoMp() {
        return custoMp;
    }
}