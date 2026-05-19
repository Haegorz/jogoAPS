package APS;

public class LataMonstre extends Consumiveis {
    public LataMonstre(String nome, String descricao) {
        super("Energetico Monstre", "Uma lata de energético em embalagem reutilizada que aumenta temporariamente força, agilidade e regeneração de AP do personagem. Mas cuidado, o uso excessivo pode causar efeitos colaterais como lentidão e perda de vida constante. Use apenas um ao dia!");
    }

    @Override
    public void usar(Personagens alvo) {
        System.out.println("\n" + alvo.getNome() + "Abriu uma Lata monstre"  + "!" );

        alvo.aumentarAtk(5);
        alvo.aumentarAp(20);
        alvo.regenerarAp(10);

        System.out.println("EFEITOS: +5 ATK, +20 AP MAX, +10 AP RECUPERADOS");
    }
}
