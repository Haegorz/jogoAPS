package APS.combat;

import APS.entities.personagens.*;

public class SistemaDeAcao {

	// (Polimorfismo de Classe) - O método aceita qualquer objeto que seja uma subclasse de Personagens
    public static void atacar(Personagens atk, Personagens def) {
    	
    	if (def.esquivou()) {
    	    System.out.println(def.getNome() + " esquivou do ataque!");
    	    return;
    	}
    	// (Encapsulamento) - Acesso controlado aos atributos via métodos assessores 
    	int danoBase = atk.getAtk() - def.getDefTotal();
    	if (danoBase < 1) danoBase = 1;

    	boolean critico = Math.random() < 0.2;
    	int dano = critico ? danoBase * 2 : danoBase;
		// (Encapsulamento) - O objeto modifica seu próprio estado interno através de um método público
    	def.receberDano(dano);

    	if (critico) {
    	    System.out.println("CRÍTICO!");
    	}

    	System.out.println(atk.getNome() + " causou " + dano + " de dano em " + def.getNome() + "!");
    }
}