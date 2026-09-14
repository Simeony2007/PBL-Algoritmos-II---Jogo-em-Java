package model.service;
import java.util.ArrayList;

public class Dialogue{

	// Texto da fala
	private String text;
	private ArrayList<Option> option;

	public Dialogue(String text){
		this.option = new ArrayList<>();
		this.text = text;
	}

	// Retorna o text guardado no atributo
	public String getTexto(){
		return this.text;
	}

	// Adiciona um novo texto
	public void	setTexto(String newText){
		text = newText;
	}

	// Retorna o objeto escolha
	public ArrayList<Option> getOption(){
		return this.option;
	}

	// Retorna se existe escolha
	public boolean optionExists(){
		return this.option.size() > 0;
	}

	// Pegar o texto de todas as escolhas
	public String getOptionText(){
		String text;
		for (int i = 0; i < option.size() ; i++) {
			text = option.get(i) + "\n";
		}
		return text;
	}

	// Texto de uma escolha específica
	public String getOptionText(int id){
		return option.get(id).getTexto();
	}


	// Funções de Escolhas
	public int getOptionLoveChange(int id){
		return option.get(id).getLoveChange();
	}
	public int getOptionAngryChange(int id){
		return option.get(id).getAngryChange();
	}
	public int getOptionSadnessChange(int id){
		return option.get(id).getSadnessChange();
	}
	public int getOptionRouteChange(int id){
		return option.get(id).getRouteChange();
	}
}