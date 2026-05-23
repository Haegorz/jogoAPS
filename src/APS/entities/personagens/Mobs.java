package APS.entities.personagens;

// (Herança) - Mobs estende a classe base Personagens, herdando suas características fundamentais
public class Mobs extends Personagens {

    // (Encapsulamento) - Atributos privados controlam e protegem o acesso direto aos dados do Mob
    private int xpDrop;
    private int moedasDrop;
    private String tipo;
    private boolean stun = false;
    private int atkBase;
    private int defBase;
    private int hpBase;

    // (Método Construtor) - Construtor que inicializa a superclasse via 'super' e define as propriedades específicas do mob
    public Mobs(String nome, int hp, int atk, int def, int xpDrop, int mp, int moedasDrop) {
        super(nome, hp, atk, def, mp);
        this.moedasDrop = moedasDrop;
        this.xpDrop = xpDrop;
        this.hpBase = maxHp;
        this.atkBase = atk;
        this.defBase = def;
    }

    // (Encapsulamento) - Método get público para leitura segura do atributo xpDrop
    public int getXpDrop() {
        return xpDrop;
    }

    // (Encapsulamento) - Método get público para leitura segura do atributo moedasDrop
    public int getMoedasDrop() {
        return moedasDrop;
    }

    // ===== TIPO DO BOSS =====
    // (Encapsulamento) - Método get público para leitura segura do atributo tipo
    public String getTipo() {
        return tipo;
    }

    // (Encapsulamento) - Método set público para modificação controlada do atributo tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // ===== STUN =====
    // (Encapsulamento) - Método get público para leitura segura de uma propriedade booleana
    public boolean isStun() {
        return stun;
    }

    // (Encapsulamento) - Método set público que aplica uma regra de validação interna antes de alterar o estado de stun
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