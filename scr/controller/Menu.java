package scr.controller;

import scr.view.GameInterface;

public class Menu {
    private Game game;

    public void iniciar() {
        int opcao = 0;
        while (opcao != 4) {
            opcao = inputOptions();
            optionScanner(opcao);
        }
    }

    public int inputOptions() {
        while (true) {
            try {
                GameInterface.showMainMenu();
                
                String userInput = GameInterface.getTextInput();
                int number = Integer.parseInt(userInput.trim());
                
                if (number > 0 && number <= 4) {
                    return number;
                } else {
                    GameInterface.showMenuInvalidOption();
                }
            } catch (NumberFormatException e) {
                GameInterface.showMenuInvalidInput();
            }
        }
    }

    public void optionScanner(int optionNumber) {
        GameInterface.clearConsole();
        
        switch (optionNumber) {
            case 1:
                game = new Game(); 
                game.gameRunning();
                break;
            case 2:
                GameInterface.showInstructions();
                GameInterface.getTextInput();
                break;
            case 3:
                GameInterface.showCredits();
                GameInterface.getTextInput();
                break;
            case 4:
                GameInterface.showExitMessage();
                break;
            default:
                GameInterface.showTextLn("Erro inesperado...");                              
                break;
        }
        
        GameInterface.clearConsole();
    }
}