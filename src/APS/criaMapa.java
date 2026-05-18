package APS;

public class criaMapa {

    public static Mapa criarMundo() {

    	Mapa inicio = new Mapa(TipoMapa.CASA_MUNCKS, "Sua Casa");
    	Mapa area1 = new Mapa(TipoMapa.A1, "Area 1 ");
    	Mapa parque = new Mapa(TipoMapa.PARQUE, "PARQUE");
    	Mapa mercado = new Mapa(TipoMapa.MERCADO, "mercado");
    	Mapa escola = new Mapa(TipoMapa.ESCOLA, "Escola");
    	Mapa biblioteca = new Mapa(TipoMapa.BIBLIOTECA, "Biblioteca");
    	Mapa area2 = new Mapa(TipoMapa.A2, "Area 2");
    	Mapa bar = new Mapa(TipoMapa.LOJA, "Mercador");
        Mapa hotel = new Mapa(TipoMapa.HOTEL, "Hotel");
    	Mapa area3 = new Mapa(TipoMapa.A3, "Area 3");
    	Mapa usina = new Mapa(TipoMapa.USINA, "Usina Nuclear");
        Mapa quadra = new Mapa(TipoMapa.QUADRA, "Quadra de Esportes");

        inicio.setOeste(area1);

    

        area1.setLeste(inicio);
        area1.setNorte(bar);
        area1.setSul(mercado);

        bar.setSul(area1);

        mercado.setNorte(area1);
        mercado.setSul(area2);

        area2.setNorte(mercado);
        area2.setLeste(escola);
        area2.setOeste(biblioteca);

        escola.setOeste(area2);
        escola.setNorte(quadra);

        quadra.setSul(escola);

        biblioteca.setLeste(area2);
        biblioteca.setOeste(area3);

        area3.setLeste(biblioteca); 
        area3.setSul(hotel);
        area3.setOeste(parque);
        
        hotel.setNorte(area3);

        parque.setLeste(area3);
        parque.setOeste(usina);

        usina.setLeste(parque);




        
        
        return inicio; // ponto de partida do jogador
    }
}