package it.beije.surabaya.cap5.motorizzazione;

public abstract class Berlina extends Automobile{
	public void what() {
		System.out.println("Sono una berlina");
	}
	public void tetto() {
		System.out.println("alto");
	}
	public boolean cool() {
		return false;
	}
}
