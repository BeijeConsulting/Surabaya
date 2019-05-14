package it.beije.surabaya.cap5.motorizzazione;

public abstract class Furgone extends Automobile{
	public void what() {
		System.out.println("Sono un furgone");
	}
	public void tetto() {
		System.out.println("alto");
	}
	public boolean cool() {
		return true;
	}
}
