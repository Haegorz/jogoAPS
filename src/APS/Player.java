package APS;
import java.util.HashMap;

public class Player extends Personagens {
    private EquipItem armadura;
    private EquipItem arma;
    private HashMap<String, Integer> inventario;
    private HashMap<String, Item> secretinv;

    public Player(String nome, int hp, int atk, int def, int mp){
        super(nome, hp, atk, def, mp);
        this.inventario = new HashMap<>();
        this.secretinv = new HashMap<>();

        
    }

    public void getInventario(){
        for (String item: inventario.keySet()){
            System.out.println(item + "--------" + inventario.get(item));
        }
        
        
  
    }

    

    public int usarHp(int valor){
        hp += valor;
        return hp;
    }
    
    public int usarMp(int valor){
        mp += valor;
        return mp;
    }
    
    public void adicionarItem(String nome, Item item, int quantidade) {
        if(inventario.containsKey(nome)){
            int novaQuant = inventario.get(nome) + quantidade;
            inventario.replace(nome, novaQuant);

        }else{
            inventario.put(nome, quantidade);
        }
        secretinv.put(nome, item);
    }

    public void removerItem(String nome){
         if (inventario.get(nome) >= 1)  {
            int removItem;
            removItem = inventario.get(nome) - 1;
            inventario.replace(nome, removItem);
            } else if (inventario.get(nome) == 0){
                inventario.remove(nome);
            }
        }
  

    public boolean usarItem(String nome) {
    Item item = secretinv.get(nome);

    if (item != null) {
        this.removerItem(nome);
        ((BattleItem)item).usar(this);
        return true; 
    } else {
        System.out.println("Item não encontrado");
        return false; 
    }
}
}
