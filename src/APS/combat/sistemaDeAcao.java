package APS.combat;

import APS.entities.personagens.*;

public class SistemaDeAcao {

    public static void atacar(Personagens atk, Personagens def) {
    	
    	if (def.esquivou()) {
    	    System.out.println(def.getNome() + " esquivou do ataque!");
    	    return;
    	}
    	
    	int danoBase = atk.getAtk() - def.getDefTotal();
    	if (danoBase < 1) danoBase = 1;

    	boolean critico = Math.random() < 0.2;
    	int dano = critico ? danoBase * 2 : danoBase;

    	def.receberDano(dano);

    	if (critico) {
    	    System.out.println("CRÍTICO!");
    	}

    	System.out.println(atk.getNome() + " causou " + dano + " de dano em " + def.getNome() + "!");
    }
}