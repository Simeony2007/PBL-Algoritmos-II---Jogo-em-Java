package model.service;

public class Orfeu{
	private int obol;
	private int love;
	private int anger;
	private int sadness;

	// Construtor
	public Orfeu(int obol, int love, int anger, int sadness){
		this.obol = obol;
		this.love = love;
		this.anger = anger;
		this.sadness = sadness;
	}
	// -----------------

	public void changeObol(int value){
		obol += value;
	}
	public void changeLove(int value){
		love += value;
	}
	public void changeAnger(int value){
		anger += value;
	}
	public void changeSadness(int value){
		sadness += value;
	}

	public int getObol(){
		return obol;
	}
	public int getLove(){
		return love;
	}
	public int getAnger(){
		return anger;
	}
	public int getSadness(){
		return sadness;
	}
}