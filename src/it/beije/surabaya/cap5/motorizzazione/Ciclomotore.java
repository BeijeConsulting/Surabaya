package it.beije.surabaya.cap5.motorizzazione;

public abstract class Ciclomotore extends Veicolo{
	
	public abstract void impenna();
	
	@Override
	public int getNumRuote() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public int getNumPosti() {
		return 2;	
	}
	
	@Override
	public void viaggia(){
		System.out.println("Viaggio su " + getNumRuote() + " ruote..");
	}
	
}
