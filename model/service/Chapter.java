package model.service;
import java.util.ArrayList;

public class Chapter {
	// Atributos
	private String title;
	private ArrayList<Scene> scenes = new ArrayList<>();
	private currentScene = 0;

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

	public void addScene(){
		Scene newScene = new Scene();
		
		scenes.add(newScene);
	}

	public Scene getCurrentScene(){
		return scenes.get(currentScene);
	}
	
	public Scene getScene(int id){
		return scenes.get(id);
	}


	// ------------- Funções de Scene ----------------
	public String nextDialogueText(int id){
		return scenes.get(id).getText();
	}
	public ArrayList<Dialogue> getDialogue(){
		return scenes.get(id).getDialogue();
	}

	// --------------- Funções de Dialogue ------------------

	public String getText(int sceneId, int dialogueId){
		return scenes.get(sceneId).getText(dialogueId);
	}

	public boolean optionExists(int sceneId, int dialogId){
		return scenes.get(sceneId).optionExists(dialogId);
	}

	public String getOptionText(int sceneId, int dialogId){
		return scenes.get(sceneId).getOptionText(dialogId);
	}

	
}