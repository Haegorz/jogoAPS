package APS;

public class Mobs extends Personagens {

    private int xpDrop;
    private int moedasDrop;
    private String tipo;
    private boolean stun = false;

    public Mobs(String nome, int hp, int atk, int def, int xpDrop, int mp, int moedasDrop) {
        super(nome, hp, atk, def, mp);
        this.moedasDrop = moedasDrop;
        this.xpDrop = xpDrop;
    }

    public int getXpDrop() { return xpDrop; }
    public int getMoedasDrop() { return moedasDrop; }

    // ===== TIPO DO BOSS =====
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    // ===== STUN =====
    public boolean isStun() { return stun; }
    public void setStun(boolean stun) {
        if (!this.stun) { 
            this.stun = stun;
        }
    }
}