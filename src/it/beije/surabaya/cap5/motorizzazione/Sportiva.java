package it.beije.surabaya.cap5.motorizzazione;

public abstract class Sportiva extends Automobile{
	public void what() {
		System.out.println("Sono un'auto sportiva");
	}
	public void tetto() {
		System.out.println("basso");
	}
	public boolean cool() {
		return true;
	}
}
