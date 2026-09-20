package scr.controller;

import scr.model.repository.StoryBuilder;
import scr.model.service.Chapter;
import scr.model.service.GameState;
import scr.model.service.Scene;
import scr.view.GameInterface;

public class Game {
    private GameState state;
    public Game() {
        this.state = new GameState(
            StoryBuilder.getOrfeu(),
            StoryBuilder.GetNpcs(),
            StoryBuilder.getChapters());
	    }

    public void gameRunning() {
        while (state.isRunning()) {
            Chapter currentChapter = state.getCurrentChapter();
            GameInterface.showChapterTitle(currentChapter.getTitle());

            while (!state.isCurrentScenesFinished()) {
            
                Scene currentScene = currentChapter.getCurrentScene();

                while (!currentScene.isFinishedAllDialogues()) {
                    GameInterface.showDialogue(currentScene.nextDialogue());
                    littleStop(1000);
                }
            
                GameInterface.showTextLn("");

                if (currentScene.isEnding()) {
                    state.setRunning(false);
                    break;
                }

                if (currentScene.choicesSize() != 0) {
                    GameInterface.showTextLn(currentScene.getChoicesText());
                    GameInterface.showPlayerStats(state.getOrfeu().toString());
                    GameInterface.showPromptChoice();
                
                    int choiceId = getNumberInput(currentScene.choicesSize());
                    String currentSceneId = ApplyConsequences.applyConsequences(
                        state.getOrfeu(), 
                        state.getNpcs(), 
                        currentScene.getChoice(choiceId)
                    );
                    currentChapter.changeCurrentScene(currentSceneId);
                    GameInterface.clearConsole();
                } else {
                    if (currentScene.getCondition() != null) {
                        String currentSceneId = StatVerify.selectScene(state.getOrfeu(), state.getNpcs(), currentScene);
                        if (currentSceneId != null) {
                            currentChapter.changeCurrentScene(currentSceneId);
                        } else if (currentScene.getNextSceneId() != null) {
                            currentChapter.changeCurrentScene(currentScene.getNextSceneId());
                        } else {
                            currentChapter.nextScene();
                        }
                    } else if (currentScene.getNextSceneId() != null) {
                        currentChapter.changeCurrentScene(currentScene.getNextSceneId());
                    } else {
                        currentChapter.nextScene();
                    }
                }
            }
            if (state.isRunning()) {
                GameInterface.waitForEnter("\n[Fim do Capítulo. Pressione ENTER para avançar...]");
                GameInterface.clearConsole();
                state.advanceChapter();
            }
        }
        GameInterface.clearConsole();
        GameInterface.showGameFinished();
        GameInterface.waitForEnter("\nPressione ENTER para voltar ao Menu Principal...");
        GameInterface.clearConsole();
    }

    private int getNumberInput(int maxChoices) {
        int choice;
        while (true) {
            try {
                String userInput = GameInterface.getTextInput();
                choice = Integer.parseInt(userInput.trim());
                
                if (choice > 0 && choice <= maxChoices) {
                    return choice - 1;
                } else {
                    GameInterface.showGameInvalidOption();
                }
            } catch (NumberFormatException e) {
                GameInterface.showGameInvalidInput();
            }
        }
    }

    private void littleStop(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}