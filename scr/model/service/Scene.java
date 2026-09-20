package scr.model.service;
import java.util.ArrayList;

public class Scene{
	private ArrayList<Dialogue> dialogues = new ArrayList<>();
	private ArrayList<Choice> choices = new ArrayList<>();
	private String sceneId;
	private int currentDialogueID = 0;
	private String nextSceneId;

	// --- Rota por Atributos ---
	private String reqSceneId = null;
	private String reqNpcName = null;
	private int reqType;
	private int reqLove;
	private int reqSadness;
	private int reqAngry;
	private int reqAffinity;
	private int reqObol;

	public void setConditionByAttributes(String nextSceneId, String npcName, int obol, int reqType, int affinity, int love, int sadness, int angry) {
		this.reqSceneId = nextSceneId;
		this.reqNpcName = npcName;
		this.reqType = reqType;
		this.reqLove = love;
		this.reqSadness = sadness;
		this.reqAngry = angry;
		this.reqAffinity = affinity;
		this.reqObol = obol;
	}

	// --- Métodos Getters (Para o Game conseguir ler) ---
	public String getReqSceneId(){
		return reqSceneId;
	}
	public String getReqNpcName(){
		return reqNpcName;
	}
	public int getreqType(){
		return reqType;
	}
	public int getReqLove(){
		return reqLove;
	}
	public int getReqSadness(){
		return reqSadness;
	}
	public int getReqAngry(){
		return reqAngry;
	}
	public int getReqAffinity(){
		return reqAffinity;
	}
	public int getReqObol(){
		return reqObol;
	}

	public Scene(String sceneIdText){
		this.sceneId = sceneIdText;
		this.nextSceneId = null;
	}
	public Scene(String sceneIdText, String nextSceneIdName){
		this.sceneId = sceneIdText;
		this.nextSceneId = nextSceneIdName;
	}

	public String getNextSceneId(){
		return nextSceneId;
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

	public void addNewChoice(String text, String nextSceneId, int obol, int affinity, int love, int angry, int sadness){
		Choice generic = new Choice(text, nextSceneId, obol, affinity, love, angry, sadness);
		choices.add(generic);
	}

	public void addNewChoice(String text, String nextSceneId, String npcName, int obol, int affinity, int love, int angry, int sadness){
		Choice generic = new Choice(text, nextSceneId, npcName, obol, affinity, love, angry, sadness);
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
		return dialogues.get(currentDialogueID).getTexto();
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
		return dialogues.get(currentDialogueID++).getTexto();
	}

	public String getChoicesText() {
		String generic = "";
		for (int i = 0; i < choices.size(); i++) {
			generic += i+1 + " - " + choices.get(i).getText() + "\n";
		}

		return generic;
	}

	// Funções de Escolhas
	public String getText(int id){
		return choices.get(id).getText();
	}
	public String getNextSceneIdChoice(int id){
		return choices.get(id).getNextSceneIdChoice();
	}

	public Choice getChoice(int id){
		return choices.get(id);
	}

}