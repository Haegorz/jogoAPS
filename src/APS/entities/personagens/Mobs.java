package APS.entities.personagens;

public class Mobs extends Personagens {

    private int xpDrop;
    private int moedasDrop;
    private String tipo;
    private boolean stun = false;
    private int atkBase;
    private int defBase;
    private int hpBase;

    public Mobs(String nome, int hp, int atk, int def, int xpDrop, int mp, int moedasDrop) {
        super(nome, hp, atk, def, mp);
        this.moedasDrop = moedasDrop;
        this.xpDrop = xpDrop;
        this.hpBase = maxHp;
        this.atkBase = atk;
        this.defBase = def;
    }

    public int getXpDrop() {
        return xpDrop;
    }

    public int getMoedasDrop() {
        return moedasDrop;
    }

    // ===== TIPO DO BOSS =====
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // ===== STUN =====
    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        if (!this.stun) {
            this.stun = stun;
        }
    }

    public void escalarComPlayer(int levelPlayer) {
        double multiplicador = 1 + (levelPlayer * 0.06);
        maxHp = (int) (hpBase * multiplicador);
        hp = maxHp;
        atk = (int) (atkBase * multiplicador);
        def = (int) (defBase * multiplicador);
    }

    public void bossEscale(int levelPlayer) {
    double multiplicador = 1 + (levelPlayer * 0.04);
    maxHp = (int) (hpBase * multiplicador);
    hp = maxHp;
    atk = (int) (atkBase * multiplicador);
    def = (int) (defBase * multiplicador);
}

}