package it.beije.surabaya.cap5.motorizzazione;

public abstract class Automobile extends Veicolo{
	
	@Override
	public int getNumRuote() {
		// TODO Auto-generated method stub
		return 4;
	}
	
	@Override
	public int getNumPosti() {
		return 4;
		
	}
	
	@Override
	public void viaggia(){
		System.out.println("Viaggio su " + getNumRuote() + " ruote..");
	}

}
