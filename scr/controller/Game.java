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
	private ArrayList<Chapter> chapters = new ArrayList<>();
	private GameInterface gameInterface = new GameInterface();
	private int currentChapter = 0;
	private boolean isGameRunning = true;

	public void gameRunning(){
		String currentTitle;
		String nextSceneId = null;
		String npcAlvo = null;
		
		orfeu = StoryBuilder.getOrfeu();
		npcs = StoryBuilder.GetNpcs();
		chapters = StoryBuilder.getChapters();


		for (Npc j : StoryBuilder.GetNpcs()) {
			addNewNpc(j);
		}
		
		while(isGameRunning()){
			currentTitle = getTitle();
			showTextLn(currentTitle);

			while(!isScenesFinished()){
				while(!isFinishedAllDialogues()){
					showTextLn(nextDialogue());
					littleStop(10);
					showTextLn("");
				}
				if (choicesSize() != 0) {
					showTextLn(getChoicesText());
					showText("\nEscolha uma opção: ");
					int choiceId = getNumberInput();
					npcAlvo = getNpcInChoice(choiceId);
					nextSceneId = applyEffects(choiceId, npcAlvo);
					clearConsole();
				}else{
					if(nextSceneByAttributes() != null && getType() != null && getType().length > 0){
						String genericScene;
						if(getreqNpcName() != null){
							genericScene = changeSceneBasedInAffinity(nextSceneByAttributes(), getreqNpcName(), getReqAffinity(), getType()[0]);
						}else{
							genericScene = changeSceneBasedInAttributes(nextSceneByAttributes(), getReqLove(), getReqSadness(), getReqAngry(), getType());
						}
						if(genericScene != null){
							nextSceneId = genericScene;
						}
					}
				}
				if(nextSceneId != null){
					changeCurrentScene(nextSceneId);
				}
				else{
					if(getNextSceneId() != null){
						changeCurrentScene(getNextSceneId());
					}else{
						nextScene();
					}
				}
				if (nextSceneId == "s8_ending4" || nextSceneId == "s2bb_ending3"){
					isGameRunning = false;
				}
				else{
				nextSceneId = null;				
				}
			}
				
			nextChapter();
			
		}

		showTextLn("Game Finished!");
	}

	// Pequena pausa - Feito por AI
	public void littleStop(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void clearConsole(){
		gameInterface.clearConsole();
	}

	public String changeSceneBasedInAffinity(String nextSceneNameId, String npcName, int affinity, int type){
		Npc generic = getNpc(npcName);
		
		switch (type) {
			case 1:
				if (generic.getAffinity() > affinity) {
					return nextSceneNameId;
				}
				else{
					return null;
				}
		
			case 2:
				if (generic.getAffinity() == affinity) {
					return nextSceneNameId;
				}
				else{
					return null;
				}
			
			case 3:
				if (generic.getAffinity() < affinity) {
					return nextSceneNameId;
				}
				else{
					return null;
				}
			default:
				return null;
				
		}
	}

	/**
	 * O type escolhe o tipo de verificação, seguindo a tabela:
	 * <table border="1">
	 *   <tr>
	 *     <th>Type</th>
	 *     <th>Condição</th>
	 *   </tr>
	 *   <tr>
	 *     <td>1</td>
	 *     <td>{@code love > protagonista.love}</td>
	 *   </tr>
	 *   <tr>
	 *     <td>2</td>
	 *     <td>{@code sadness > protagonista.sadness}</td>
	 *   </tr>
	 *   <tr>
	 *     <td>3</td>
	 *     <td>{@code angry > protagonista.angry}</td>
	 *   </tr>
	 *   <tr>
	 *     <td>4</td>
	 *     <td>{@code love == protagonista.love}</td>
	 *   </tr>
	 *   <tr>
	 *     <td>5</td>
	 *     <td>{@code sadness == protagonista.sadness}</td>
	 *   </tr>
	 *   <tr>
	 *     <td>6</td>
	 *     <td>{@code angry == protagonista.angry}</td>
	 *   </tr>
	 *   <tr>
	 *     <td>7</td>
	 *     <td>{@code love < protagonista.love}</td>
	 *   </tr>
	 *   <tr>
	 *     <td>8</td>
	 *     <td>{@code sadness < protagonista.sadness}</td>
	 *   </tr>
	 *   <tr>
	 *     <td>9</td>
	 *     <td>{@code angry < protagonista.angry}</td>
	 *   </tr>
	 * </table>
	 * @param nextSceneNameId
	 * @param love
	 * @param sadness
	 * @param angry
	 * @param type, int list
	 * @return String com o id da próxima cena
	 */

	public String changeSceneBasedInAttributes(String nextSceneNameId, int love, int sadness, int angry, int[] type){		
		Boolean trueVerification = false;
		for (int i : type) {
			switch (i) {
				case 1: // love > protagonista.love
					if (love > orfeu.getLove()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 2: // sadness > protagonista.sadness
					if (sadness > orfeu.getSadness()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 3: // angry > protagonista.angry
					if (angry > orfeu.getAnger()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 4: // love == protagonista.love
					if (love == orfeu.getLove()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 5: // sadness == protagonista.sadness
					if (sadness == orfeu.getSadness()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 6: // angry == protagonista.angry
					if (angry == orfeu.getAnger()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 7: // love < protagonista.love
					if (love < orfeu.getLove()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 8: // sadness < protagonista.sadness
					if (sadness < orfeu.getSadness()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 9: // angry < protagonista.angry
					if (angry < orfeu.getAnger()) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				default:
					trueVerification = false;
					return null;
			}
		}
		if (trueVerification) {
			return nextSceneNameId;
		}else{
			return null;
		}
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

	public void showText(String text){
		gameInterface.showText(text);
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

	public String applyEffects(int choiceId, String npcName){
		int affinity = getAffinityChange(choiceId);
		int love = getChoiceLoveChange(choiceId);
		int anger = getChoiceAngryChange(choiceId);
		int sadness = getChoiceSadnessChange(choiceId);
		String sceneNextId = getNextSceneIdChoice(choiceId);

		orfeu.changeAnger(anger);
		orfeu.changeLove(love);
		orfeu.changeSadness(sadness);

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


	public String nextSceneByAttributes(){
        return chapters.get(currentChapter).nextSceneByAttributes();
    }

    public String getreqNpcName(){
        return chapters.get(currentChapter).getreqNpcName();
    }

    public int[] getType(){
        return chapters.get(currentChapter).getType();
    }

    public int getReqLove(){
        return chapters.get(currentChapter).getReqLove();
    }

    public int getReqSadness(){
        return chapters.get(currentChapter).getReqSadness();
    }

    public int getReqAngry(){
        return chapters.get(currentChapter).getReqAngry();
    }

    public int getReqAffinity(){
        return chapters.get(currentChapter).getReqAffinity();
    }

    public int getReqObol(){
        return chapters.get(currentChapter).getReqObol();
    }

	public String getSceneId(){
		return chapters.get(currentChapter).getSceneId();
	}
	
	public void addNewNpc(String name, int affinity){
		Npc generic = new Npc(name, affinity);
		npcs.add(generic);
	}

	public void addNewNpc(Npc generic){
		npcs.add(generic);
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

	// Adder functions
	public void addNewChapter(String title){
		Chapter generic = new Chapter(title);
		chapters.add(generic);
	}

	public void addNewChapter(Chapter newChapter){
		chapters.add(newChapter);
	}

	// Scene functions
	public void newScene(int chapterId){
		chapters.get(chapterId).newScene();
	}

	public void addNewDialogue(int chapterId, int sceneId, String textOfDialogue, String npcName){
		chapters.get(chapterId).addNewDialogue(sceneId, textOfDialogue, npcName);
	}

	public void addNewChoice(int chapterId, int sceneId, String text, String nextSceneId, int obol, int affinity, int love, int angry, int sadness){
		chapters.get(chapterId).addNewChoice(sceneId, text, nextSceneId, obol, affinity, love, angry, sadness);
	}

	public void addNewChoice(int chapterId, int sceneId, String text, String nextSceneId, String npcName, int obol, int affinity, int love, int angry, int sadness){
		chapters.get(chapterId).addNewChoice(sceneId, text, nextSceneId, npcName, obol, affinity, love, angry, sadness);
	}

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

	public String getNpcInChoice(int id){
		return chapters.get(currentChapter).getNpcInChoice(id);
	}

	public int getAffinityChange(int id){
		return chapters.get(currentChapter).getAffinityChange(id);
	}

	public int getChoiceLoveChange(int id){
		return chapters.get(currentChapter).getChoiceLoveChange(id);
	}

	public int getChoiceAngryChange(int id){
		return chapters.get(currentChapter).getChoiceAngryChange(id);
	}

	public int getChoiceSadnessChange(int id){
		return chapters.get(currentChapter).getChoiceSadnessChange(id);
	}

}