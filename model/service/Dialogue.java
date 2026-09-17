package model.service;
import java.util.ArrayList;

public class Dialogue{

	// Texto da fala
	private String text;
	private String dialogueId;
	private String npcThatSaidIt;

	public Dialogue(String text, String npcName){
		this.text = text;
		this.npcThatSaidIt = npcName;
	}

	public String getDialogueId(){
		return this.dialogueId;
	}

	// Retorna o text guardado no atributo
	public String getTexto(){
		return this.text;
	}

	public String getNpcThatSaidIt(){
		return npcThatSaidIt;
	}
}