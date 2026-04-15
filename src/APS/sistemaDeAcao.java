package APS;

public class sistemaDeAcao {

    public static void atacar(Personagens atk, Personagens def) {

        int dano = atk.getAtk() - def.getDefTotal();
        if (dano < 1) dano = 1;

        def.receberDano(dano);

        System.out.println(atk.getNome() + " causou " + dano + " de dano em " + def.getNome() + "!");
    }
}