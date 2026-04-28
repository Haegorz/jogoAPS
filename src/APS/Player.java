package APS;

import java.util.HashSet;
import java.util.Set;

public class Player extends Personagens{
	
    private int level = 1;
    private int exp = 0;
    private int proximoLevel = 50;
    
	public Player(String nome, int hp, int atk, int def) {
		super(nome, hp, atk, def);
	}
	
	public void ganharXP(int quantidade) {
	    exp += quantidade;

	    while (exp >= proximoLevel) {
	        subirNivel();
	    }
	}

	private void subirNivel() {
	    level++;
	    exp -= proximoLevel;
	    proximoLevel = (int)(proximoLevel * 1.5);
	    if (proximoLevel <= 0) proximoLevel = 1;

	    aumentarMaxHp(10);
	    aumentarAtk(2);
	    aumentarDef(1);
	    curarTotal();
	    
	    System.out.println(getNome() + " subiu para o nível " + level + "!");
	}

    public void addFlag(String flag) {
    	flags.add(flag);
    }

    public boolean temFlag(String flag) {
    	return flags.contains(flag);
    }

    public void removeFlag(String flag) {
    	flags.remove(flag);
    }

    private Set<String> flags = new HashSet<>();
}
