package scr.model.service;

public class Choice{
	private String text;
	private String nextSceneId;
	private int obolChange;
	private int affinityChange;
	private int loveChange;
	private int angryChange;
	private int sadnessChange;

	public Choice(String text, String nextSceneId,int obol, int affinity, int love, int angry, int sadness){
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