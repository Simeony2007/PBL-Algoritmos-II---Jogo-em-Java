public class Fala{

	// Texto da fala
	private String texto;
	private Escolha escolhas[];

	public void Fala(int totalDeEscolhas){
		escolhas = new Escolha[totalDeEscolhas];
		texto = "";
	}

	public void Fala(int totalDeEscolhas, String textoDaFala){
		escolhas = new Escolha[totalDeEscolhas];
		texto = textoDaFala;
	}

	// Retorna o texto guardado no atributo
	public String getTexto(){
		return this.texto;
	}

	// Adiciona um novo texto
	public void	setTexto(String textoNovo){
		texto = textoNovo;
	}

	// Retorna o objeto escolha
	public Escolha getEscolhas(){
		return this.escolhas;
	}

	// Retorna se existe escolha
	public boolean existeEscolha(){
		return this.escolhas.length() > 0;
	}

	// Pegar o texto de todas as escolhas
	public String getTextoEscolha(){
		String texto;
		for (int i = 0; i < escolhas.length() ; i++) {
			texto = escolhas[i].getTexto() + "\n";
		}
		return texto;
	}

	// Texto de uma escolha específica
	public String getTextoEscolha(int id){
		return escolhas[id].getTexto();
	}


	// Funções de Escolhas
	public int getEscolhaMudancaDeAmor(int id){
		return escolhas[id].getEscolhaMudancaDeAmor();
	}
	public int getEscolhaMudancaDeRaiva(int id){
		return escolhas[id].getEscolhaMudancaDeRaiva();
	}
	public int getEscolhaMudancaDeTristeza(int id){
		return escolhas[id].getEscolhaMudancaDeTristeza();
	}
	public int getEscolhaMudancaDeRota(int id){
		return escolhas[id].getEscolhaMudancaDeRota();
	}
}