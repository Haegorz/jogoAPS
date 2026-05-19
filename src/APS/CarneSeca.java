package APS;

public class CarneSeca extends Consumiveis{
    
    public CarneSeca() {
        super("Carne Seca", "Carne de sol que restaura 30 HP ao ser consumida e aumenta temporariamente a defesa do personagem.");
    }

    @Override
    public void usar(Personagens alvo) {
        System.out.println("\n" + alvo.getNome() + "Consumiu uma Carne Seca!" );
        alvo.regenerarHp(30);
        alvo.aumentarDef(5);
        System.out.println("EFEITOS: +30 HP, +5 DEF");
    }
}
