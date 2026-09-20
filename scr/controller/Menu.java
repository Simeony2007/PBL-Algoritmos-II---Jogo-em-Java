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

	public void showText(String text){
		GameInterface.showTextLn(text);
	}

	public String getTextInput(){
		return GameInterface.getTextInput();
	}

    public int inputOptions() {
        while (true) {
            try {
                showTextLn("1 - Iniciar jogo\n2 - Instruções\n3 - Créditos\n4 - Fechar jogo\n");
                int number = Integer.parseInt(getTextInput());
                if (number > 0 && number < 5) {
                    return number;
                } else {
                    showTextLn("Opção inválida! Digite um número de 1 a 4.");
                }
            } catch (Exception e) {
                showTextLn("Entrada inválida! Digite apenas números.");
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
                showTextLn("Instruções do jogo...");
                break;
            case 3:
                showTextLn("Créditos...");
                break;
            case 4:
                showTextLn("Saindo do jogo...");
                break;
            default:
                showTextLn("Erro inesperado...");               
                break;
        }
        GameInterface.clearConsole();
    }

    public void showTextLn(String text){
	    GameInterface.showTextLn(text);
	}

}