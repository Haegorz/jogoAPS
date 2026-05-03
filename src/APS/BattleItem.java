package APS;

public class BattleItem extends Item{
    private final TipoItem type;

    

    public BattleItem(String nome, TipoItem type){
        super(nome);
        this.type = type;


    }

   public void usar(Player player) {
        switch (type) {
            case HP:
                if((player.getHp() + player.usarHp(20)) > player.getMaxHp()){
                player.setHp(player.getMaxHp());
            }else{
                player.usarHp(20);
            }
            case MP:
                if((player.getMp() + player.usarMp(20)) > player.getMaxHp()){
                player.setMp(player.getMaxMp());
            }else{
                player.usarMp(20);
            }
        }
    }
    }

    
        
    
    

