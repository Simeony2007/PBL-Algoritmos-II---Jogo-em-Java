package model.service;
import java.util.ArrayList;

public class Scene{
	private ArrayList<Dialogue> dialogues = new ArrayList<>();
	private ArrayList<Choice> choices = new ArrayList<>();
	private String sceneId;
	private int currentDialogueID = 0;

	public Scene(String sceneIdText){
		this.sceneId = sceneIdText;
	}

	// Adding functions
	public void addNewDialogue(String textOfDialogue, String npcName){
		Dialogue generic = new Dialogue(textOfDialogue, npcName);
		dialogues.add(generic);
	}
	public void addNewDialogue(String textOfDialogue){
		Dialogue generic = new Dialogue(textOfDialogue);
		dialogues.add(generic);
	}

	public void addNewChoice(String text, String nextSceneId, int affinity, int love, int angry, int sadness){
		Choice generic = new Choice(text, nextSceneId, affinity, love, angry, sadness);
		choices.add(generic);
	}

	public String getSceneId() {
		return sceneId;
	}

	// ---------------------------
	public boolean isFinishedAllDialogues(){
		return currentDialogueID == dialogues.size();
	}

	public int choicesSize(){
		return choices.size();
	}

	public String getCurrentDialogueText(){
		return dialogues.get(currentDialogueID);
	}

	public String getNpcThatSaidIt(){
		return dialogues.get(currentDialogueID).getNpcThatSaidIt();
	}

	/**
	 * Pega o dialogo atual e avança para o próximo.
	 * A verificação de existencia de outros diálogos não é feita aqui.
	 * @return String: O texto do diálogo.
	 */
	public String nextDialogue(){
		return dialogues.get(currentDialogueID++);
	}

	public String getChoicesText() {
		String generic = "";
		for (int i = 0; i < choices.size(); i++) {
			generic += ("%d", i) + choices.get(i).getText() + "\n";
		}

		return generic;
	}

	// Funções de Escolhas
	public int getText(int id){
		return choices.get(id).getText();
	}
	public int getNextSceneIdChoice(int id){
		return choices.get(id).getNextSceneIdChoice();
	}
	public int getAffinityChange(int id){
		return choices.get(id).getAffinityChange();
	}
	public int getChoiceLoveChange(int id){
		return choices.get(id).getLoveChange();
	}
	public int getChoiceAngryChange(int id){
		return choices.get(id).getAngryChange();
	}
	public int getChoiceSadnessChange(int id){
		return choices.get(id).getSadnessChange();
	}
}