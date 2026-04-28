package APS;

public class Mobs extends Personagens {
    private int xpDrop;
    
    public Mobs(String nome, int hp, int atk, int def, int xpDrop) {
		super(nome, hp, atk, def);
		this.xpDrop = xpDrop;
	}
    
    public int getXpDrop() { return xpDrop; }
}
