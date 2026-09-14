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

	public void addScene(){
		Scene newScene = new Scene();
		scenes.add(newScene);
	}

	// ------------- Funções de Scene ----------------
	public String nextDialogueText(int id){
		return scenes.get(id).nextDialogueText();
	}
	public void addDialogue(int id, String text){
		scenes.get(id).addDialogue(text);
	}

	public void addOption(int id, String textOfOption, String nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
		scenes.get(id).addOption(textOfOption, nextScene, nObol, nLove, nAnger, nSadness, nAffinity);
	}

	// public void newNpc(int id, String name, int affinity){
	//     scenes.get(id).newNpc(name, affinity);
	//}

	public boolean optionExists(int sceneId){
		return scenes.get(sceneId).optionExists();
	}
	// public void newNpc(int sceneId, String name, int affinity){
	//     scene.get(sceneId).newNpc(name, affinity);
	//}

	// --------- Funções de Options ----------

	public String getOptionText(int sceneId, int optionId){
		return scenes.get(sceneId).getText(optionId);
	}
	public String getOptionNextScene(int sceneId, int id){
		return scenes.get(sceneId).getNextScene(optionId);
	}
	public int getOptionLove(int sceneId, int id){
		return scenes.get(sceneId).getLove(optionId);
	}
	public int getOptionAffinity(int sceneId, int id){
		return scenes.get(sceneId).getAffinity(optionId);
	}
	public int getOptionObol(int sceneId, int id){
		return scenes.get(sceneId).getObol(optionId);
	}
	public int getOptionSadness(int sceneId, int id){
		return scenes.get(sceneId).getSadness(optionId);
	}
	public int getOptionAnger(int sceneId, int id){
		return scenes.get(sceneId).getAnger(optionId);
	}
	
}