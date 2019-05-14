package motorizzazione.primo.livello;

public abstract class Ciclomotore extends Veicolo {
	
	//Metodi comuni a tutti i ciclo motori
	
	//considerazioni di default
	private int nRuote = 2;	
	private int nPosti = 2;	
	
	public int getNumRuote() {	
		return nRuote;
	}
	
	public int getNumPosti() {
		return nPosti;
	}
	
	public void viaggia() {
		System.out.println("Ciclomotore in movimento...");
	}
	
	public abstract void impenna();
	
	
}
