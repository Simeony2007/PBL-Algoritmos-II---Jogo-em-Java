package model.service;

public class Choice{
	private String text;
	private int loveChange;
	private int angryChange;
	private int sadnessChange;
	private int routeChange;

	public String getText(){
		return this.text;
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
	
	public int getRouteChange(){
		return routeChange;
	}
}