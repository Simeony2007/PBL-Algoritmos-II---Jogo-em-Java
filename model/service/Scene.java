package model.service;

import java.util.ArrayList;

public class Scene{
	// Atributos
	private ArrayList<Dialogue> dialogue = new ArrayList<>();
	private ArrayList<Option> option = new ArrayList<>();
	private int currentDialogue = 0;
	private int lastDialogueAdded = -1;

	public String nextDialogueText(){
		return dialogue.get(currentDialogue++).getText();
	}
	public ArrayList<Dialogue> getDialogue(){
		return dialogue;
	}

	// Adicionar novo Diálogo
	public void addDialogue(String text){
		Dialogue newDialogue = new Dialogue(text);
		dialogue.add(text);
		lastDialogueAdded++;
		return lastDialogueAdded;
	}

	// Diálogo com escolhas
	// public void addDialogueWOption(String text, String textOfOption, String nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
	// 	Dialogue newDialogue = new Dialogue(text);
	// 	newDialogue.addOption(textOfOption, nextScene, nObol, nLove, nAnger, nSadness, nAffinity);
	// 	dialogue.add(text);
	// } Repetido, podemos simplesmente usar addDialogue e depois addOption(id da nova dialogue)

	// --------------- Funções de Dialogue ------------------
	public void addOption(int id, String textOfOption, String nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
		dialogue.get(id).addOption(textOfOption, nextScene, nObol, nLove, nAnger, nSadness, nAffinity)
	}
	public String getText(int id){
		return dialogue.get(id).getText();
	}

	// Adiciona um novo texto
	// public void	setText(int id, String newText){
	// 	dialogue.get(id).setText(newText);
	// } Já vai criar com o texto!

	public boolean optionExists(){
		return dialogue.get(id).optionExists();
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