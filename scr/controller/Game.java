package scr.controller;

import java.util.ArrayList;
import scr.model.repository.*;
import scr.model.service.*;
import scr.view.GameInterface;

public class Game{
	private Orfeu orfeu;
	private ArrayList<Npc> npcs = new ArrayList<>();
	private Chapter chapter;
	private int currentChapter = 1;
	private String currentSceneId;
	private GameInterface gameInterface = new GameInterface();

	public Game(){
		npcs = StoryBuilder.GetNpcs(npcs);
		orfeu = StoryBuilder.GetOrfeu(orfeu);
		chapter = StoryBuilder.getChapter(currentChapter);
	}

	public void gameRunning(){
		String newScene = "s1_introduction";
		getChapter();
		while (true) {
			String chapterTitle = chapter.getTitle();
			gameInterface.showTextLn(chapterTitle);
			ArrayList<String> sceneScript = new ArrayList<>();
			String genericString = "";

			for (int i = 0; i < chapter.getScene(newScene).getDialogues().length(); i++) {
				
				char k = chapter.getScene(newScene).getDialogues().charAt(i);
				
				if (k != '\n') {
					genericString += k;
				}
				else{
					genericString += k;
					sceneScript.add(genericString);
					genericString = "";
				}
			}

			for (int j = 0; j < sceneScript.size(); j++) {
				gameInterface.showTextLn(sceneScript.get(j));	
			}

			gameInterface.showTextLn(chapter.getScene(newScene).getOptionsText());
			int input = gameInterface.getNumberInput();
			if(input == 1){
				gameInterface.showTextLn("escolha1");
			}else if(input == 2){
				gameInterface.showTextLn("escolha2");
			}else if(input == 3){
				gameInterface.showTextLn("escolha2");
			}
			nextScene();
			newScene = currentSceneId;
		}
	}

	public void getChapter(){
		chapter = StoryBuilder.getChapter(currentChapter);
	}

	public String getDialogues() {
		return chapter.getScene(chapter.getScene(currentSceneId).getId()).getDialogues();
	}

	public String getOptions() {
		return chapter.getScene(chapter.getScene(currentSceneId).getId()).getOptionsText();
	}

	public void applyOptionEffects(int optionIndex) {
		Scene currentScene = chapter.getScene(currentSceneId);
		Option selectedOption = currentScene.getOption(optionIndex - 1);

		if (selectedOption != null) {
			orfeu.modifyObol(selectedOption.getObol());
			orfeu.modifyLove(selectedOption.getLove());
			orfeu.modifyAnger(selectedOption.getAnger());
			orfeu.modifySadness(selectedOption.getSadness());

			// Apply effects to Npc if present
			Npc currentNpc = currentScene.getNpc();
			if (currentNpc != null) {
				currentNpc.modifyAffinity(selectedOption.getAffinity());
			}

			// Move to the next scene
			Scene nextScene = selectedOption.getNextScene();
			if (nextScene != null) {
				currentSceneId = nextScene.getId();
			}
		}
	}
	
	public void nextScene(){
		Scene currentScene = chapter.getScene(currentSceneId);
		if (currentScene.getOption(0) == null) {
			if (currentScene.nextScene() != null) {
				currentSceneId = currentScene.nextScene().getId();
			}
			else {
				currentChapter++;
				getChapter();
				currentSceneId = chapter.getScene(0);
				if (currentSceneId == null) {
					// Fim do jogo;
				}
			}
		}
	}
}