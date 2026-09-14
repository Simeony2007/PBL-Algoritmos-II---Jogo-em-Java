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

	public void addOption(String textOfOption, String nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
		Option newOption = new Option(textOfOption, nextScene, nObol, nLove, nAnger, nSadness, nAffinity);
		option.add(newOption);
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

	/** Returns all texts of all options in one string block
	 *  @return String with all texts of all options separated by \n
	 */
	public String getOptionText(){
		String text;
		for (int i = 0; i < option.size() ; i++) {
			text = option.get(i) + "\n";
		}
		return text;
	}


	// --------- Funções de Options ----------

	public String getOptionText(int id){
		return option.get(id).getText();
	}
	public String getOptionNextScene(int id){
		return option.get(id).getNextScene();
	}
	public int getOptionLove(int id){
		return option.get(id).getLove();
	}
	public int getOptionAffinity(int id){
		return option.get(id).getAffinity();
	}
	public int getOptionObol(int id){
		return option.get(id).getObol();
	}
	public int getOptionSadness(int id){
		return option.get(id).getSadness();
	}
	public int getOptionAnger(int id){
		return option.get(id).getAnger();
	}
}