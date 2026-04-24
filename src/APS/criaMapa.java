package APS;

public class criaMapa {

    public static Mapa criarMundo() {

    	Mapa vila = new Mapa(TipoMapa.VILA, "Vila");
    	Mapa floresta = new Mapa(TipoMapa.FLORESTA, "Floresta");
    	Mapa montanha = new Mapa(TipoMapa.MONTANHA, "Montanha");
    	Mapa caverna = new Mapa(TipoMapa.CAVERNA, "Caverna");
    	Mapa cidade = new Mapa(TipoMapa.CIDADE, "Cidade");
    	Mapa planices = new Mapa(TipoMapa.PLANICES, "Planices");
    	Mapa fazenda = new Mapa(TipoMapa.FAZENDA, "Fazenda");
    	Mapa loja2 = new Mapa(TipoMapa.LOJA, "Mercador");
    	Mapa castelo = new Mapa(TipoMapa.CASTELO, "Portao do Castelo");
    	Mapa sala_rei = new Mapa(TipoMapa.SALA_REI, "Sala do Trono");

        vila.setNorte(floresta);

        floresta.setSul(vila);
        floresta.setNorte(montanha);
        floresta.setLeste(cidade);

        montanha.setSul(floresta);
        montanha.setNorte(caverna);

        cidade.setOeste(floresta);
        
        caverna.setSul(montanha);
        caverna.setNorte(planices);
       
        planices.setSul(caverna);
        planices.setNorte(castelo);
        planices.setLeste(fazenda);
        planices.setOeste(loja2);
       
        fazenda.setOeste(planices);
       
        loja2.setLeste(planices);
      
        castelo.setSul(planices);
        castelo.setNorte(sala_rei);
       
        sala_rei.setSul(castelo);
        
        return vila; // mapa inicial pq sim ;3
    }
}