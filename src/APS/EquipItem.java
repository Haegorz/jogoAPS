package APS;

public class EquipItem extends Item {
    private TipoItem type;
    public int status;

    public EquipItem(String nome, TipoItem type, int status) {
        super(nome);
        this.type = type;
        this.status = status;
    }

    public TipoItem getType() {
        return type;
    }
}