package APS.items;

// (Herança) - EquipItem estende a classe base Item, herdando suas propriedades e comportamentos
public class EquipItem extends Item {
    private TipoItem type;
    public int status;

    // (Método Construtor) - Inicializa o objeto chamando o construtor da superclasse via 'super' e definindo os atributos específicos
    public EquipItem(String nome, TipoItem type, int status) {
        super(nome);
        this.type = type;
        this.status = status;
    }

    public TipoItem getType() {
        return type;
    }
}