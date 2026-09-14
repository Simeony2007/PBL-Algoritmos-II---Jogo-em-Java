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

	// --------------- Funções de Dialogue ------------------

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
	public int getOptionLoveChange(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getLoveChange(optionID);
	}
	public int getOptionAngryChange(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getAngryChange(optionID);
	}
	public int getOptionSadnessChange(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getSadnessChange(optionID);
	}
	public int getOptionRouteChange(int dialogueId, int optionID){
		return dialogue.get(dialogueId).getRouteChange(optionID);
	}



}