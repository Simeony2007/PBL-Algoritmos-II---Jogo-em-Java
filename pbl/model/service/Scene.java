package pbl.model.service;
import java.util.ArrayList;

public class Scene{
	private ArrayList<Dialogue> dialogue = new ArrayList<>();
	private ArrayList<Option> option = new ArrayList<>();
	private Npc npc;
	private String nextScene;

	public Scene(){
		this.nextScene = null;
		this.npc = null;
	}

	public void addDialogue(String text){
		dialogue.add(new Dialogue(text));
	}

	public void addOption(String text, String nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
		option.add(new Option(text, nextScene, nObol, nLove, nAnger, nSadness, nAffinity));
	}

	public void currentNpc(Npc npc){
		this.npc = npc;
	}

	public void setNextScene(String nextScene){
		this.nextScene = nextScene;
	}

}