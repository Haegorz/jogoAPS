package APS;

public class Mobs extends Personagens {

    private int xpDrop;
    private String tipo;
    private boolean stun = false;

    public Mobs(String nome, int hp, int atk, int def, int xpDrop, int mp) {
        super(nome, hp, atk, def, mp);
        this.xpDrop = xpDrop;
    }

    public int getXpDrop() { return xpDrop; }

    // ===== TIPO DO BOSS =====
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    // ===== STUN =====
    public boolean isStun() { return stun; }
    public void setStun(boolean stun) {
        if (!this.stun) { // só aplica se não estiver já stunado
            this.stun = stun;
        }
    }
}