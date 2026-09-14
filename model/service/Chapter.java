package model.service;
import java.util.ArrayList;

public class Chapter {
	// Atributos
	private String title;
	private ArrayList<Scene> scenes = new ArrayList<>();

	public Chapter(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public ArrayList<Scene> getScene(){
		return scenes;
	}

	public void addScene(Scene scene){
		scenes.add(scene);
	}

	public Scene getScene(int id){
		return scenes.get(id);
	}


	// ------------- Funções de Scene ----------------
	public String nextDialogue(int id){
		return scenes.get(id).getText();
	}
	public ArrayList<Dialogue> getDialogue(){
		return scenes.get(id).getDialogue();
	}

	// --------------- Funções de Dialogue ------------------

	public String getText(int sceneId, int dialogueId){
		return scenes.get(sceneId).getText(dialogueId);
	}

	// Adiciona um novo texto
	public void	setText(int sceneId ,int dialogueId, String newText){
		scenes.get(sceneId).setText(dialogueId, newText);
	}

	public ArrayList<Option> getOption(int sceneId, int dialogId){
		return scenes.get(sceneId).getOption(dialogueId);
	}

	public boolean optionExists(int sceneId, int dialogId){
		return scenes.get(sceneId).optionExists(dialogId);
	}

	public String getOptionText(int sceneId, int dialogId){
		return scenes.get(sceneId).getOptionText(dialogId);
	}

	public String getOptionText(int sceneId, int dialogueId, int optionID){
		return scenes.get(sceneId).getOptionText(dialogueId, optionID);
	}

	// --------- Funções de Options ----------
	public int getOptionLoveChange(int sceneId, int dialogueId, int optionID){
		return scenes.get(sceneId).getLoveChange(dialogueId, optionID);
	}
	public int getOptionAngryChange(int sceneId, int dialogueId, int optionID){
		return scenes.get(sceneId).getAngryChange(dialogueId, optionID);
	}
	public int getOptionSadnessChange(int sceneId, int dialogueId, int optionID){
		return scenes.get(sceneId).getSadnessChange(dialogueId, optionID);
	}
	public int getOptionRouteChange(int sceneId, int dialogueId, int optionID){
		return scenes.get(sceneId).getRouteChange(dialogueId, optionID);
	}
}