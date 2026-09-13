import java.util.ArrayList;

public class Cena{

	private ArrayList<Fala> falas[];
	private int falaAtual;

	public void Fala(){
		this.falas[] = new ArrayList<Fala>();
	}

	public String proximaFala(){
		return falas[falaAtual++].getTexto();
	}
	public String[] getFalas(){
		return falas;
	}



}