package scr.model.service;

public class Dialogue{

	// Atributos
	private String text;
	
	// Construtor
	public Dialogue(String text){
		this.text = text;
	}
	
	@Override
	public String toString(){
		return text;
	}

}