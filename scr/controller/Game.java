package scr.controller;
import java.util.ArrayList;

import scr.model.service.Chapter;
import scr.model.service.Npc;
import scr.model.service.Orfeu;
import scr.model.repository.StoryBuilder;
import scr.view.GameInterface;

public class Game{
	private Orfeu orfeu;
	private ArrayList<Npc> npcs = new ArrayList<>();
	private static ArrayList<Chapter> chapters = new ArrayList<>();
	private GameInterface gameInterface = new GameInterface();
	private int currentChapter = 0;
	private boolean isGameRunning = true;

	public void gameRunning(){
		String currentTitle;
		String currentSceneId = null;
		
		orfeu = StoryBuilder.getOrfeu();
		npcs = StoryBuilder.GetNpcs();
		chapters = StoryBuilder.getChapters();
		
		while(isGameRunning()){
			currentTitle = getTitle();
			showTextLn(currentTitle);

			while(!isScenesFinished()){
				while(!isFinishedAllDialogues()){
					showTextLn(nextDialogue());
					showTextLn(orfeu.toString());
					littleStop(10);
					showTextLn("");
				}
				if (choicesSize() != 0) {
					showTextLn(getChoicesText());
					showTextLn("\nEscolha uma opção: ");
					int choiceId = getNumberInput();
					currentSceneId = ApplyConsequences.applyConsequences(orfeu, npcs, chapters.get(currentChapter).getChoice(choiceId));
					clearConsole();
				}else{
					if(chapters.get(currentChapter).nextSceneByAttributes() != null){
						System.out.println("\n\nteste\n\n");
						currentSceneId = StatVerify.selectScene(orfeu, npcs, chapters.get(currentChapter).getScene());
						}
					}

				if(currentSceneId != null){
					changeCurrentScene(currentSceneId);
				}
				else{
					if(getNextSceneId() != null){
						changeCurrentScene(getNextSceneId());
					}else{
						nextScene();
					}
				}
				if (currentSceneId == "s8_ending4" || currentSceneId == "s2bb_ending3"){
					isGameRunning = false;
				}
				else{
				currentSceneId = null;				
				}
			}
				
			nextChapter();
			
		}

		showTextLn("Game Finished!");
		littleStop(10000);
	}

	// Pequena pausa - Feito por AI
	private void littleStop(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void clearConsole(){
		gameInterface.clearConsole();
	}

	public boolean isGameRunning(){
		if (!isGameRunning){
			return false;
		}
		else {
		return currentChapter != chapters.size();
		}
	}

	public String getNextSceneId(){
		return chapters.get(currentChapter).getNextSceneId();
	}

	public void showTextLn(String text){
		gameInterface.showTextLn(text);
	}

	public String getTextInput(){
		return gameInterface.getTextInput();
	}

	public boolean isInTheOptionLimit(int userInput){
		return userInput-1 < choicesSize() && userInput > 0;
	}

	public int getNumberInput(){
		int generic;
		
		while(true){
			try{
				String genericString = getTextInput();
				generic = Integer.parseInt(genericString);
				if(isInTheOptionLimit(generic)){
					return generic-1;
				}
				else{
					showTextLn("\nDigite um número válido!\n");
				}
			}catch(Exception e){
				showTextLn("Digite um número válido!\n");
			}
		}
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


	public String nextSceneByAttributes(){
        return chapters.get(currentChapter).nextSceneByAttributes();
    }

	public String getSceneId(){
		return chapters.get(currentChapter).getSceneId();
	}

	public void changeCurrentScene(String sceneId){
		chapters.get(currentChapter).changeCurrentScene(sceneId);
	}

	public String getTitle(){
		return chapters.get(currentChapter).getTitle();
	}

	public int choicesSize(){
		return chapters.get(currentChapter).choicesSize();
	}

	// Scene functions
	public void nextScene(){
		chapters.get(currentChapter).nextScene();
	}
	
	public boolean isScenesFinished(){
		if (!isGameRunning){
			return true;
		}
		else {
		return chapters.get(currentChapter).isScenesFinished();
		}
	}

	public String nextDialogue(){
		return chapters.get(currentChapter).nextDialogue();
	}

	public String getNpcThatSaidIt(){
		return chapters.get(currentChapter).getNpcThatSaidIt();
	}

	public String getCurrentDialogueText(){
		return chapters.get(currentChapter).getCurrentDialogueText();
	}

	public boolean isFinishedAllDialogues(){
		return chapters.get(currentChapter).isFinishedAllDialogues();
	}

	// Choices functions
	public String getChoicesText(){
		return chapters.get(currentChapter).getChoicesText();
	}

	public String getText(int id){
		return chapters.get(currentChapter).getText(id);
	}

	public String getNextSceneIdChoice(int id){
		return chapters.get(currentChapter).getNextSceneIdChoice(id);
	}

}