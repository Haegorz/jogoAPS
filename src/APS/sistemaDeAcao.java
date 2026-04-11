package APS;

class sistemaDeAcao {

    static void atacar(Personagens atk, Personagens def) {
        int dano = atk.atk - def.def;
        if (dano < 1) dano = 1;

        def.hp -= dano;

        System.out.println(atk.nome + " causou " + dano + " de dano!");
    }

    static void defender(Personagens p) {
        System.out.println(p.nome + " está defendendo!");
        p.def += 3;
    }
}
