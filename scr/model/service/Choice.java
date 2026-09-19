package scr.model.service;

public class Choice{
	private String text;
	private String nextSceneId;
	private String npc;
	private int obolChange;
	private int affinityChange;
	private int loveChange;
	private int angryChange;
	private int sadnessChange;

	public Choice(String text, String nextSceneId, String npcName, int obol, int affinity, int love, int sadness, int angry){
		this.text = text;
		this.nextSceneId = nextSceneId;
		this.npc = npcName;
		this.obolChange = obol;
		this.affinityChange = affinity;
		this.loveChange = love;
		this.angryChange = angry;
		this.sadnessChange = sadness;
	}

	public Choice(String text, String nextSceneId, int obol, int affinity, int love, int sadness, int angry){
		this.text = text;
		this.nextSceneId = nextSceneId;
		this.obolChange = obol;
		this.affinityChange = affinity;
		this.loveChange = love;
		this.angryChange = angry;
		this.sadnessChange = sadness;
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

	public int getObolChange(){
		return obolChange;
	}

	public int getAffinityChange(){
		return affinityChange;
	}

	public int getLoveChange(){
		return loveChange;
	}

	public int getSadnessChange(){
		return sadnessChange;
	}

	public int getAngryChange(){
		return angryChange;
	}
}