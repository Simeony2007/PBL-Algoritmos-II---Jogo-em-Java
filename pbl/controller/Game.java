package pbl.controller;

import java.util.ArrayList;
import pbl.model.repository.*;
import pbl.model.service.*;

public class Game{
	private Orfeu orfeu;
	private ArrayList<Npc> npcs = new ArrayList<>();
	private Chapter chapter;
	private int currentChapter = 1;
	private String currentSceneId;


	public Game(){
		npcs = StoryBuilder.GetNpcs(npcs);
		orfeu = StoryBuilder.GetOrfeu(orfeu);
		chapter = StoryBuilder.getChapter(currentChapter);
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
}