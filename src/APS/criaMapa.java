package APS;

public class criaMapa {

    public static Mapa criarMundo() {

        Mapa vila = new Mapa("Vila");
        Mapa floresta = new Mapa("Floresta");
        Mapa montanha = new Mapa("Montanha");
        Mapa cidade = new Mapa("Cidade");

        vila.setNorte(floresta);

        floresta.setSul(vila);
        floresta.setNorte(montanha);
        floresta.setLeste(cidade);

        montanha.setSul(floresta);

        cidade.setOeste(floresta);

        return vila; // mapa inicial pq sim ;3
    }
}