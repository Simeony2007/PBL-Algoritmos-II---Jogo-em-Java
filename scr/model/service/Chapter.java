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
	public void newScene(Scene scene){
		scenes.add(scene);
	}

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

	public Choice getChoice(int id){
		return scenes.get(currentScene).getChoice(id);
	}

	public Scene getScene(){
		return scenes.get(currentScene);
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
        return scenes.get(currentScene).getReqSceneId();
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

}