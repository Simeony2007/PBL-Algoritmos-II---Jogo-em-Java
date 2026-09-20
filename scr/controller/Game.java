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
	private int currentChapter = 0;
	private boolean boolGameRunning = true;

	public void gameRunning(){
		String currentTitle;
		String currentSceneId = null;
		
		orfeu = StoryBuilder.getOrfeu();
		npcs = StoryBuilder.GetNpcs();
		chapters = StoryBuilder.getChapters();
		
		while(isGameRunning()){
			littleStop(1000);
			currentTitle = chapters.get(currentChapter).getTitle();
			showTextLn(currentTitle);

			while(!isScenesFinished()){
				while(!chapters.get(currentChapter).isFinishedAllDialogues()){
					showTextLn(chapters.get(currentChapter).nextDialogue());
					littleStop(1000);
					showTextLn("");
				}
				if (choicesSize() != 0) {
					showTextLn(chapters.get(currentChapter).getChoicesText());
					showTextLn(orfeu.toString());
					showTextLn("\nEscolha uma opção: ");
					int choiceId = getNumberInput();
					currentSceneId = ApplyConsequences.applyConsequences(orfeu, npcs, chapters.get(currentChapter).getChoice(choiceId));
					GameInterface.clearConsole();
				}else{
					if(chapters.get(currentChapter).nextSceneByAttributes() != null){
						currentSceneId = StatVerify.selectScene(orfeu, npcs, chapters.get(currentChapter).getScene());
						}
					}

				if(currentSceneId != null){
					chapters.get(currentChapter).changeCurrentScene(currentSceneId);
				}
				else{
					if(chapters.get(currentChapter).getNextSceneId() != null){
						chapters.get(currentChapter).changeCurrentScene(chapters.get(currentChapter).getNextSceneId());
					}else{
						chapters.get(currentChapter).nextScene();
					}
				}
				if (currentSceneId == "s8_ending4" || currentSceneId == "s2bb_ending3"){
					boolGameRunning = false;
				}
				else{
				currentSceneId = null;				
				}
			}
				
			currentChapter++;
			littleStop(5000);
			GameInterface.clearConsole();
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

	private boolean isGameRunning(){
		if (!boolGameRunning){
			return false;
		}
		else {
		return currentChapter != chapters.size();
		}
	}

	private void showTextLn(String text){
		GameInterface.showTextLn(text);
	}

	private int getNumberInput(){
		int choice;
		while(true){
			try{
				String userInput = GameInterface.getTextInput();
				choice = Integer.parseInt(userInput);
				if(choice-1 < choicesSize() && choice > 0){
					return choice-1;
				}
				else{
					showTextLn("\nDigite um número válido!\n");
				}
			}catch(Exception e){
				showTextLn("Digite um número válido!\n");
			}
		}
	}

	private int choicesSize(){
		return chapters.get(currentChapter).choicesSize();
	}

	private boolean isScenesFinished(){
		if (!boolGameRunning){
			return true;
		}
		else {
		return chapters.get(currentChapter).isScenesFinished();
		}
	}

}