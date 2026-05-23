package APS.core;
// (Encapsulamento) - Uso de estrutura enum para limitar, agrupar e proteger os estados válidos do fluxo do jogo
public enum GameState {
	
	//estados do loop 
	
    EXPLORANDO,   // andando entre mapas
    EM_EVENTO,    // executando evento do mapa atual
    GAME_OVER
    
}