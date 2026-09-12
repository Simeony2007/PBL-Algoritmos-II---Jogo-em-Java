public class Capitulos{

	private Cena cenas[] = new Cena;

	public Cena getCena(int numeroDaCena){

		if (numeroDaCena <= cenas.length) {
			return cenas[numeroDaCena];	
		}
		else{
			System.out.printl("Valor fora dos limites!"):
		}
	}

}