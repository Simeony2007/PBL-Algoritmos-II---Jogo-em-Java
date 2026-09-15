package pbl.controller;
import pbl.controller.Game;
import pbl.view.GameInterface;

public class Menu {
    private String menuOptions = "1 - Iniciar jogo\n2 - Instruções\n3 - Créditos\n4 - Fechar jogo\n";
    private GameInterface gameInterface = new GameInterface();
    private Game game;

    @Override 
    public String toString() {
        return menuOptions;
    }

    // Método orquestrador: Mantém o menu ativo até escolher sair
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
                gameInterface.showTextLn(this.toString());
                int number = Integer.parseInt(gameInterface.getTextInput());
                if (number > 0 && number < 5) {
                    return number;
                } else {
                    gameInterface.showTextLn("Opção inválida! Digite um número de 1 a 4.");
                }
            } catch (Exception e) {
                gameInterface.showTextLn("Entrada inválida! Digite apenas números.");
            }
        }
    }

    public void optionScanner(int optionNumber) {
        switch (optionNumber) {
            case 1:
                game = new Game(/* Parametros iniciais */);
                //game.executar(); // Dispara o loop da história do Game
                break;
            case 2:
                gameInterface.showTextLn("Instruções do jogo...");
                break;
            case 3:
                gameInterface.showTextLn("Créditos...");
                break;
            case 4:
                gameInterface.showTextLn("Saindo do jogo...");
                break;
            default:
                gameInterface.showTextLn("Erro inesperado...");               
                break;
        }
    }
}