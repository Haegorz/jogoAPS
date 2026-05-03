package APS;

public class EquipItem extends Item {
    private String type;
    public int status;

    public EquipItem(String nome, String type, int status){
        super(nome);
        this.type = type;
        this.status = status;
    }

    public void equip(EquipItem nome){
        
    }

    
}
