package it.beije.surabaya.cap5.motorizzazione;

public abstract class Suv extends Automobile{
	public abstract boolean pagaSuperBollo  ();   //Sensato su alcuni suv
	
	public int getNumPosti()  {
		return 5;
	}
	
	
	public String tipoTrazione() {
		
		return "AWD";			//HA SENSO ER IL TIPO DI MACCHINA
	}
}
