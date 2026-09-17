package model.service;
import java.util.ArrayList;

public class Chapter{
	private ArrayList<Scene> scenes = new ArrayList<>();
	private String title;
	private int currentScene = 0;
	private int totalOfScenes = 0;

	// Construtor
	public Chapter(String titleText){
		this.title = titleText;
	}
	// ---------------

	// Adding functions
	public void newScene(){
		Scene generic = new Scene()
		scenes.add(generic);
	}

	public void addNewDialogue(int id, String textOfDialogue, String npcName){
		scenes.get(id).addNewDialogue(textOfDialogue, npcName);
	}

	public void addNewChoice(int id, String text, String nextSceneId, int affinity, int love, int angry, int sadness){
		scenes.get(id).addNewChoice(text, nextSceneId, affinity, love, angry, sadness);
	}
	// -----------------------------------

	public boolean isScenesFinished(){
		return currentScene == totalOfScenes;
	}

	// Scenes functions
	public String getChoicesText(){
		return scenes.get(currentScene).getChoicesText();
	}

	public String nextDialogue(){
		return scenes.get(currentScene).nextDialogue();
	}

	public String getNpcThatSaidIt(){
		return scenes.get(currentScene).getNpcThatSaidIt();
	}

	public String getCurrentDialogueText(){
		return scenes.get(currentScene).getCurrentDialogueText();
	}

	public boolean isFinishedAllDialogues(){
		return scenes.get(currentScene).isFinishedAllDialogues();
	}

	// Choices functions
	public String getChoicesText(){
		return scenes.get(currentScene).getChoicesText();
	}

	public int getText(int id){
		return scenes.get(currentScene).getText(id);
	}

	public int getNextSceneIdChoice(int id){
		return scenes.get(currentScene).getNextSceneIdChoice(id);
	}

	public int getAffinityChange(int id){
		return scenes.get(currentScene).getAffinityChange(id);
	}

	public int getChoiceLoveChange(int id){
		return scenes.get(currentScene).getChoiceLoveChange(id);
	}

	public int getChoiceAngryChange(int id){
		return scenes.get(currentScene).getChoiceAngryChange(id);
	}

	public int getChoideSadnessChange(int id){
		return scenes.get(currentScene).getChoideSadnessChange(id);
	}


}