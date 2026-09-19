package scr.model.service;
import java.util.ArrayList;

public class Chapter{
	private ArrayList<Scene> scenes = new ArrayList<>();
	private String title;
	private int currentScene = 0;

	// Construtor
	public Chapter(String titleText){
		this.title = titleText;
	}
	// ---------------

	// Adding functions
	public void newScene(){
		Scene generic = new Scene(null);
		scenes.add(generic);
	}

	public void newScene(Scene scene){
		scenes.add(scene);
	}

	public void addNewDialogue(int id, String textOfDialogue, String npcName){
		scenes.get(id).addNewDialogue(textOfDialogue, npcName);
	}

	public void addNewChoice(int id, String text, String nextSceneId, int obol, int affinity, int love, int angry, int sadness){
		scenes.get(id).addNewChoice(text, nextSceneId, obol, affinity, love, angry, sadness);
	}

	public void addNewChoice(int id, String text, String nextSceneId, String npcName, int obol, int affinity, int love, int angry, int sadness){
		scenes.get(id).addNewChoice(text, nextSceneId, npcName, obol, affinity, love, angry, sadness);
	}
	// -----------------------------------

	public String getTitle(){
		return title;
	}

	public void changeCurrentScene(String sceneId){
		for (Scene i : scenes) {
			if (i.getSceneId().equals(sceneId)) {
				currentScene = scenes.indexOf(i);
			}
		}
	}

	public String getSceneId() {
		return scenes.get(currentScene).getSceneId();
	}


	public void nextScene(){
		currentScene++;
	}

	public boolean isScenesFinished(){
		return currentScene == scenes.size();
	}

	// Scenes functions

	public String nextSceneByAttributes(){
        return scenes.get(currentScene).nextSceneByAttributes();
    }

    public String getreqNpcName(){
        return scenes.get(currentScene).getreqNpcName();
    }

    public int[] getType(){
        return scenes.get(currentScene).getType();
    }

    public int getReqLove(){
        return scenes.get(currentScene).getReqLove();
    }

    public int getReqSadness(){
        return scenes.get(currentScene).getReqSadness();
    }

    public int getReqAngry(){
        return scenes.get(currentScene).getReqAngry();
    }

    public int getReqAffinity(){
        return scenes.get(currentScene).getReqAffinity();
    }

    public int getReqObol(){
        return scenes.get(currentScene).getReqObol();
    }

	public String getNextSceneId(){
		return scenes.get(currentScene).getNextSceneId();
	}

	public int choicesSize(){
		return scenes.get(currentScene).choicesSize();
	}

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
	public String getText(int id){
		return scenes.get(currentScene).getText(id);
	}

	public String getNextSceneIdChoice(int id){
		return scenes.get(currentScene).getNextSceneIdChoice(id);
	}

	public String getNpcInChoice(int id){
		return scenes.get(currentScene).getNpcInChoice(id);
	}

	public int getObolChange(int id){
		return scenes.get(currentScene).getObolChange(id);
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

	public int getChoiceSadnessChange(int id){
		return scenes.get(currentScene).getChoiceSadnessChange(id);
	}


}