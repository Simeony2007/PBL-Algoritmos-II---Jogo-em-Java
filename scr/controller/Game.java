package scr.controller;
import java.util.ArrayList;

import scr.model.service.Chapter;
import scr.model.service.Npc;
import scr.model.service.Orfeu;
import scr.model.repository.StoryBuilder;
import scr.view.GameInterface;

public class Game{
	private Orfeu protagonista;
	private ArrayList<Npc> npcs = new ArrayList<>();
	private ArrayList<Chapter> capitulos = new ArrayList<>();
	private GameInterface gameInterface = new GameInterface();
	private int currentChapter = 0;

	public void gameRunning(){

		String currentTitle;
		String nextSceneId;
		String npcAlvo = null;

		addNewChapter(StoryBuilder.BuildChapter1());
		for (Npc j : StoryBuilder.GetNpcs()) {
			addNewNpc(j);
		}

		while(!isTheChaptersFinished()){
			currentTitle = getTitle();
			showTextLn(currentTitle);

			while(!isScenesFinished()){
				while(!isFinishedAllDialogues()){
					npcAlvo = getNpcThatSaidIt();
					showTextLn(nextDialogue());
				}
				if (choicesSize() != 0) {
					showTextLn(getChoicesText());
					showText("\nEscolha uma opção: ");
					int choiceId = getNumberInput();
					nextSceneId = applyEffects(choiceId, npcAlvo);
					nextSceneId = null;
				}
				else{
					nextSceneId = null;
				}
				if(nextSceneId != null){
					changeCurrentScene(nextSceneId);
				}
				else{
					nextScene();
				}
			}
			nextChapter();
		}

		showTextLn("Game Finished!");
	}

	public boolean isTheChaptersFinished(){
		return currentChapter == capitulos.size();
	}

	public void showTextLn(String text){
		gameInterface.showTextLn(text);
	}

	public void showText(String text){
		gameInterface.showText(text);
	}

	public String getTextInput(){
		return gameInterface.getTextInput();
	}

	public boolean isInTheOptionLimit(int userInput){
		return userInput < choicesSize() && userInput > 0;
	}

	public int getNumberInput(){
		int generic;
		
		while(true){
			try{
				String genericString = getTextInput();
				generic = Integer.parseInt(genericString);
				if(isInTheOptionLimit(generic)){
					return generic;
				}
				else{
					showTextLn("\nDigite um número válido!\n");
				}
			}catch(Exception e){
				showTextLn("Digite um número válido!\n");
			}
		}
	}

	public String applyEffects(int choiceId, String npcName){
		int affinity = getAffinityChange(choiceId);
		int love = getChoiceLoveChange(choiceId);
		int anger = getChoiceAngryChange(choiceId);
		int sadness = getChoiceSadnessChange(choiceId);
		String sceneNextId = getNextSceneIdChoice(choiceId);

		protagonista.changeAnger(anger);
		protagonista.changeLove(love);
		protagonista.changeSadness(sadness);

		Npc generic = getNpc(npcName);
		if(generic != null){
			generic.changeAffinity(affinity);
		}
		
		return sceneNextId;
	}

	public Npc getNpc(String nome){
		for (Npc i : npcs) {
			if(i.getName().equals(nome)){
				return i;
			}
		}
		return null;
	}

	public void nextChapter(){
		currentChapter++;
	}

	public Game(int obol, int love, int anger, int sadness){
		this.protagonista = new Orfeu(obol, love, anger, sadness);
	}

	public String getSceneId(){
		return capitulos.get(currentChapter).getSceneId();
	}
	
	public void addNewNpc(String name, int affinity){
		Npc generic = new Npc(name, affinity);
		npcs.add(generic);
	}

	public void addNewNpc(Npc generic){
		npcs.add(generic);
	}

	public void changeCurrentScene(String sceneId){
		capitulos.get(currentChapter).changeCurrentScene(sceneId);
	}

	public String getTitle(){
		return capitulos.get(currentChapter).getTitle();
	}

	public int choicesSize(){
		return capitulos.get(currentChapter).choicesSize();
	}

	// Adder functions
	public void addNewChapter(String title){
		Chapter generic = new Chapter(title);
		capitulos.add(generic);
	}

	public void addNewChapter(Chapter newChapter){
		capitulos.add(newChapter);
	}

	// Scene functions
	public void newScene(int chapterId){
		capitulos.get(chapterId).newScene();
	}

	public void addNewDialogue(int chapterId, int sceneId, String textOfDialogue, String npcName){
		capitulos.get(chapterId).addNewDialogue(sceneId, textOfDialogue, npcName);
	}

	public void addNewChoice(int chapterId, int sceneId, String text, String nextSceneId, int obol, int affinity, int love, int angry, int sadness){
		capitulos.get(chapterId).addNewChoice(sceneId, text, nextSceneId, obol, affinity, love, angry, sadness);
	}

	public void nextScene(){
		capitulos.get(currentChapter).nextScene();
	}
	
	public boolean isScenesFinished(){
		return capitulos.get(currentChapter).isScenesFinished();
	}

	public String nextDialogue(){
		return capitulos.get(currentChapter).nextDialogue();
	}

	public String getNpcThatSaidIt(){
		return capitulos.get(currentChapter).getNpcThatSaidIt();
	}

	public String getCurrentDialogueText(){
		return capitulos.get(currentChapter).getCurrentDialogueText();
	}

	public boolean isFinishedAllDialogues(){
		return capitulos.get(currentChapter).isFinishedAllDialogues();
	}

	// Choices functions
	public String getChoicesText(){
		return capitulos.get(currentChapter).getChoicesText();
	}

	public String getText(int id){
		return capitulos.get(currentChapter).getText(id);
	}

	public String getNextSceneIdChoice(int id){
		return capitulos.get(currentChapter).getNextSceneIdChoice(id);
	}

	public int getAffinityChange(int id){
		return capitulos.get(currentChapter).getAffinityChange(id);
	}

	public int getChoiceLoveChange(int id){
		return capitulos.get(currentChapter).getChoiceLoveChange(id);
	}

	public int getChoiceAngryChange(int id){
		return capitulos.get(currentChapter).getChoiceAngryChange(id);
	}

	public int getChoiceSadnessChange(int id){
		return capitulos.get(currentChapter).getChoiceSadnessChange(id);
	}

}