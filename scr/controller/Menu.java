package scr.controller;
import scr.controller.Game;
import scr.view.GameInterface;

public class Menu {
    private String menuOptions = "1 - Iniciar jogo\n2 - Instruções\n3 - Créditos\n4 - Fechar jogo\n";
    private GameInterface gameInterface = new GameInterface();
    private Game game;

    public String getOptions() {
        return menuOptions;
    }

    // Método orquestrador: Mantém o menu ativo até escolher sair
    public void iniciar() {
        int opcao = 0;
        while (opcao != 4) {
			//showTextLn(getOptions());
            opcao = inputOptions();
            optionScanner(opcao);
        }
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

    public int inputOptions() {
        while (true) {
            try {
                showTextLn(getOptions());
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
        clearConsole();
        switch (optionNumber) {
            case 1:
                game = new Game(0, 0, 0, 0);
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
        clearConsole();
    }
    public void clearConsole(){
		gameInterface.clearConsole();
	}
}