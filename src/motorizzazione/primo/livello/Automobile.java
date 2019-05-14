package motorizzazione.primo.livello;

public abstract class Automobile extends Veicolo{
	
	private int nRuote = 4;
	
	public int getNumRuote() {
		return nRuote;
	}
	
	public void viaggia() {
		System.out.println("Veicolo in movimento...");
	}
		
	public double getCilindrata() {
		return cilindrata;
	}
	
	public double getPeso() {
		return peso;
	}
}
