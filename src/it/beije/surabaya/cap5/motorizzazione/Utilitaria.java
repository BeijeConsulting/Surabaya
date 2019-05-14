package it.beije.surabaya.cap5.motorizzazione;

public abstract class Utilitaria extends Automobile {
	
	public int getNumPosti()  {
		return 4;
	}
	
	public String tipoTrazione() {
		
		return "FWD";			//TRAZIONE ANTERIORE SU QUASI TUTTI I MODELLI
	}
	
	public boolean pagaSuperBollo() {  //PRATICAMENTE NESSUNA LO PAGA
		
		return false;
	}
}
