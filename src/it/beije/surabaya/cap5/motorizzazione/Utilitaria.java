package it.beije.surabaya.cap5.motorizzazione;

public abstract class Utilitaria extends Automobile{
	public void what(){
		System.out.println("sono un'utilitaria");
	}
	public void tetto() {
		System.out.println("basso");
	}
	public boolean cool() {
		return false;
	}
}
