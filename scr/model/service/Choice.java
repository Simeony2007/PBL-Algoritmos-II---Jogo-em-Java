package scr.model.service;

public class Choice{
	private String text;
	private String nextSceneId;
	private String npc;
	private int obol;
	private int affinity;
	private int love;
	private int angry;
	private int sadness;

	public Choice(String text, String nextSceneId, String npcName, int obol, int affinity, int love, int angry, int sadness){
		this.text = text;
		this.nextSceneId = nextSceneId;
		this.npc = npcName;
		this.obol = obol;
		this.affinity = affinity;
		this.love = love;
		this.angry = angry;
		this.sadness = sadness;
	}

	public Choice(String text, String nextSceneId, int obol, int affinity, int love, int angry, int sadness){
		this.text = text;
		this.nextSceneId = nextSceneId;
		this.obol = obol;
		this.affinity = affinity;
		this.love = love;
		this.angry = angry;
		this.sadness = sadness;
	}

	public String getText(){
		return this.text;
	}

	public String getNextSceneIdChoice(){
		return nextSceneId;
	}

	public String getNpcInChoice(){
		return npc;
	}

	public int getObol(){
		return obol;
	}

	public int getAffinity(){
		return affinity;
	}

	public int getLove(){
		return love;
	}

	public int getSadness(){
		return sadness;
	}

	public int getAngry(){
		return angry;
	}
}