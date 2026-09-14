package model.service;
import java.util.ArrayList;

public class Dialogue{

	// Atributos
	private String text;
	private ArrayList<Option> option = new ArrayList<>();

	public Dialogue(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void	setText(String newText){
		text = newText;
	}

	public ArrayList<Option> getOption(){
		return option;
	}

	public boolean optionExists(){
		return option.size() > 0;
	}

	public String getOptionText(){
		String text;
		for (int i = 0; i < option.size() ; i++) {
			text = option.get(i) + "\n";
		}
		return text;
	}

	public String getOptionText(int id){
		return option.get(id).getTexto();
	}


	// --------- Funções de Options ----------
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