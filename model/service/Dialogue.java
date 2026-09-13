package model.service;
public class Dialogue{

	// Texto da fala
	private String texto;

	public Dialogue(String texto){
		this.texto = texto;
	}

	// Retorna o texto guardado no atributo
	public String getTexto(){
		return this.texto;
	}

	// Adiciona um novo texto
	public void	adicionarTexto(String textoNovo){
		texto = textoNovo;
	}


	// fazerEscolha seria um método como? Tipo, o que ele recebe e o que ele dá de saída?
	// public ? fazerEscolha(?);
}