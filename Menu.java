public class Menu{
	private String opcoes = "1 - Start\n2 - Something\n3 - Other thing\n4 - Exit";

	public String getOpcoes(){
		return opcoes;
	}
	public Partida iniciarJogo(){
		Partida partida = new Partida;
		return partida;
	}
	public boolean sairDoJogo(){
		return false;
	}
}