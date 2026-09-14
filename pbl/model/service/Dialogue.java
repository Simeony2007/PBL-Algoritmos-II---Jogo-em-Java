package model.service;
import java.util.ArrayList;

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


	/** Returns all texts of all options in one string block
	 *  @return String with all texts of all options separated by \n
	 */
	// public String getOptionText(){
	// 	String text;
	// 	for (int i = 0; i < option.size() ; i++) {
	// 		text = option.get(i) + "\n";
	// 	}
	// 	return text;
	// }
	
}