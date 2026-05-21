package APS.items;

public class Item {
    private int id;
    private static int idCounter = 0;
    protected String nome;

    public Item(String nome) {
        this.nome = nome;
        id = ++idCounter;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}