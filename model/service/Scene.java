package model.service;

import java.util.ArrayList;

public class Scene{
	// Atributos
	private ArrayList<Dialogue> dialogue = new ArrayList<>();
	private int currentDialogue = 0;

	public String nextDialogue(){
		return dialogue.get(currentDialogue++).getText();
	}
	public ArrayList<Dialogue> getDialogue(){
		return dialogue;
	}
	public void addDialogue(String text){
		Dialogue newDialogue = new Dialogue(text);
		dialogue.add(text);
	}

	public void addDialogueWOption(String text, String textOfOption, String nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
		Dialogue newDialogue = new Dialogue(text);
		newDialogue.addOption(textOfOption, nextScene, nObol, nLove, nAnger, nSadness, nAffinity);
		dialogue.add(text);
	}

	// --------------- Funções de Dialogue ------------------
	public void addOption(int id, String textOfOption, String nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
		dialogue.get(id).addOption(textOfOption, nextScene, nObol, nLove, nAnger, nSadness, nAffinity)
	}
	public String getText(int id){
		return dialogue.get(id).getText();
	}

	// Adiciona um novo texto
	public void	setText(int id, String newText){
		dialogue.get(id).setText(newText);
	}

	public ArrayList<Option> getOption(int id){
		return dialogue.get(id).getOption();
	}

	public boolean optionExists(){
		return dialogue.get(id).optionExists();
	}

	public String getOptionText(){
		return dialogue.get(id).getOptionText();
	}

	public String getOptionText(int dialogueId, int optionID){
		return dialogue.get(id).getOptionText(optionID);
	}

	// --------- Funções de Options ----------
	public String getOptionText(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getText(optionID);
	}
	public String getOptionNextScene(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getNextScene(optionID);
	}
	public int getOptionLove(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getOptionLove(optionID);
	}
	public int getOptionAngry(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getOptionAngry(optionID);
	}
	public int getOptionSadness(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getOptionSadness(optionID);
	}
	public int getOptionAffinity(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getOptionAffinity(optionID);
	}
	public int getOptionObol(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getOptionObol(optionID);
	}
}