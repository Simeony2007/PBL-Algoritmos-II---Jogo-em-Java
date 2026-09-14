package model.service;

import java.util.ArrayList;

public class Scene{
	private ArrayList<Dialogue> dialogue = new ArrayList<>();
	private int currentDialogue = 0;

	public String nextDialogue(){
		return dialogue.get(currentDialogue++).getText();
	}
	public ArrayList<Dialogue> getDialogue(){
		return dialogue;
	}
}