package it.beije.surabaya.cap5.motorizzazione;

public class Mercedes_AMG_G63 extends Suv {
	public double getCilindrata() {
		
		return 5500;
	}

	public double getPeso() {
		
		return 3856;
	}
	public int getNumRuote ()  {   //Una delle pochissime, quindi sensato override
		return 6;
	}

	
	public boolean pagaSuperBollo() {
		
		return true;
	}
	
}
