package scr.model.service;
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
	public Dialogue(String text){
		this.text = text;
		this.npcThatSaidIt = null;
	}

	public String getDialogueId(){
		return this.dialogueId;
	}

	// Retorna o text guardado no atributo
	public String getTexto(){
		
		if(npcThatSaidIt == null){
			return this.text;
		}else{
			return npcThatSaidIt + ": " + this.text;
		}
		
		
	}

	public String getNpcThatSaidIt(){
		return npcThatSaidIt;
	}
}