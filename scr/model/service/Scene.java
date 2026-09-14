package scr.model.service;
import java.util.ArrayList;

public class Scene{
	private String id;
	private String dialogue;
	private ArrayList<Option> option = new ArrayList<>();
	private Npc npc;
	private Scene nextScene;

	public Scene(String id){
		this.id = id;
		this.nextScene = null;
		this.npc = null;
	}

	public String getId(){
		return id;
	}

	public void addDialogue(String text){
		StringBuilder sb = new StringBuilder();
		sb.append(text);
		sb.append("\n");
		this.dialogue = sb.toString();
	}

	public void addOption(String text, Scene nextScene, int nObol, int nLove, int nAnger, int nSadness, int nAffinity){
		option.add(new Option(text, nextScene, nObol, nLove, nAnger, nSadness, nAffinity));
	}

	public void currentNpc(Npc npc){
		this.npc = npc;
	}

	public void setNextScene(Scene nextScene){
		this.nextScene = nextScene;
	}

	public Npc getNpc(){
		return npc;
	}

	public Scene nextScene(){
		return nextScene;
	}

	public String getDialogues(){
		return dialogue;
	}

	public String getOptionsText(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < option.size(); i++){
			sb.append(String.format("%d. %s\n", i + 1, option.get(i).getText()));
		}
		return sb.toString();
	}

	public Option getOption(int index){
		if(index >= 0 && index < option.size()){
			return option.get(index);
		}
		return null;
	}
}