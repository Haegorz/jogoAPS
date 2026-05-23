package APS.events;

// (Encapsulamento) - Uso de estrutura enum para delimitar e proteger as opções de retorno válidas para os eventos
public enum ResultadoEvento {
    
    CONTINUAR,     // continua no mesmo mapa (loop chama de novo depois)
    SAIR_MAPA,     // sair do evento e permitir movimento
    MORREU         // player morreu
    
}