package model.service;
import java.util.ArrayList;

public class Dialogue{

	// Texto da fala
	private String text;
	private ArrayList<Choice> choices;

	public Dialogue(String text){
		this.choices = new ArrayList<>();
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
	public ArrayList<Choice> getChoices(){
		return this.choices;
	}

	// Retorna se existe escolha
	public boolean choiceExists(){
		return this.choices.size() > 0;
	}

	// Pegar o texto de todas as escolhas
	public String getChoiceText(){
		String text;
		for (int i = 0; i < choices.size() ; i++) {
			text = choices.get(i) + "\n";
		}
		return text;
	}

	// Texto de uma escolha específica
	public String getChoiceText(int id){
		return choices.get(id).getTexto();
	}


	// Funções de Escolhas
	public int getChoiceLoveChange(int id){
		return choices.get(id).getLoveChange();
	}
	public int getChoiceAngryChange(int id){
		return choices.get(id).getAngryChange();
	}
	public int getChoideSadnessChange(int id){
		return choices.get(id).getSadnessChange();
	}
	public int getChoiceRouteChange(int id){
		return choices.get(id).getRouteChange();
	}
}