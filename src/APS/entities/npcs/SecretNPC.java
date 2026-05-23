package APS.entities.npcs;

import APS.entities.personagens.Player;
import APS.events.ResultadoEvento;
import APS.items.EquipItem;
import APS.items.TipoItem;
import APS.ui.TextControler;
import java.util.Scanner;

// (Herança) - SecretNPC estende a classe mãe NPC, herdando sua base teórica
public class SecretNPC extends NPC {
    public boolean itemDado;
    
    // (Método Construtor) - Inicializa o estado dos atributos e aciona o construtor pai pelo 'super'
    public SecretNPC() {
        super("Chara");
        this.itemDado = false;
    }

    // (Sobrescrita) - Modifica localmente a execução do método 'conversar' herdado de NPC
    public ResultadoEvento conversar(Player player, Scanner sc) {
        if (!itemDado) {
            TextControler.textFast("Chara: Você parece ser uma pessoa boa, aqui, leve isso.");
            TextControler.textFast("Chara te deu um item raro!");
            
            // (Instanciação de Objeto) - Cria dinamicamente uma instância de EquipItem na chamada do método
            player.adicionarItem("Faca de Cozinha",new EquipItem("Faca de Cozinha",TipoItem.ATK,30),1);
            itemDado = true;
            
        } else {
            TextControler.textInstant("Chara: Já te dei um presente, não tenho mais nada para te dar.");
            
        }
        return ResultadoEvento.SAIR_MAPA;
    }

}