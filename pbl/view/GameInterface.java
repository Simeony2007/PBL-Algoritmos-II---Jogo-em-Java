package pbl.view;
import java.util.Scanner;

public class GameInterface{
	private Scanner scanner = new Scanner(System.in);

	public int getNumberInput(){
		return scanner.nextInt();
	}

	public String getTextInput(){
		return scanner.nextLine();
	}
	
	public void showTextLn(String text){
		System.out.println(text);
	}

	public void showText(String text){
		System.out.print(text);
	}
}