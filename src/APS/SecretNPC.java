package APS;

import java.util.Scanner;

public class SecretNPC extends NPC {
    public boolean itemDado;
    
    public SecretNPC() {
        super("Chara");
        this.itemDado = false;
    }

    public ResultadoEvento conversar(Player player, Scanner sc) {
        if (!itemDado) {
            TextControler.textFast("Chara: Você parece ser uma pessoa boa, aqui, leve isso.");
            TextControler.textFast("Chara te deu um item raro!");
            player.adicionarItem("Faca de Cozinha",new EquipItem("Faca de Cozinha",TipoItem.ATK,30),1);
            itemDado = true;
            
        } else {
            TextControler.textInstant("Chara: Já te dei um presente, não tenho mais nada para te dar.");
            
        }
        return ResultadoEvento.SAIR_MAPA;
    }

}
