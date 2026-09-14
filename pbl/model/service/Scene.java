package model.service;
import java.util.ArrayList;

public class Scene{
	// Atributos
	private ArrayList<Dialogue> dialogue = new ArrayList<>();
	private ArrayList<Option> option = new ArrayList<>();
	//private ArrayList<Npc> character = new ArrayList<>();
	private int currentDialogue = 0;

	// public void newNpc(String name, int affinity){
	//     Npc genericNpc = new Npc(name, affinity);
	//     character.add(genericNpc);
	//}

	public String nextDialogueText(){
		return dialogue.get(currentDialogue++).getText();
	}

	// Adicionar novo Diálogo
	public void addDialogue(String text){
		Dialogue newDialogue = new Dialogue(text);
		dialogue.add(text);
		lastDialogueAdded++;
		return lastDialogueAdded;
	}

	public boolean optionExists(){
		return option.size() > 0;
	}

	public void addOption(String textOfOption, String nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
		Option newOption = new Option(textOfOption, nextScene, nObol, nLove, nAnger, nSadness, nAffinity);
		option.add(newOption);
	}


	// --------------- Funções de Dialogue ------------------
	
	public String getText(int id){
		return dialogue.get(id).toString();
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