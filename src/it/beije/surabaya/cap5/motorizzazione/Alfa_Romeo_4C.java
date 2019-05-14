package it.beije.surabaya.cap5.motorizzazione;

public class Alfa_Romeo_4C extends Sportiva {

	
	public double getCilindrata() {
		
		return 1.750;
	}

	public int getNumPosti()  {
		return 2;
	}
	public double getPeso() {
		
		return 1060;
	}

	public boolean pagaSuperBollo() {
		
		return false;				//OVERRIDE, UNA DELLE POCHE SPORTIVE CHE NON LO PAGA
	}
	
}
