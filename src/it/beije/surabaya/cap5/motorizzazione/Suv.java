package it.beije.surabaya.cap5.motorizzazione;

public abstract class Suv extends Automobile {
	public void what() {
		System.out.println("Sono un suv");
	}
	public void tetto() {
		System.out.println("alto");
	}
	public boolean cool() {
		return false;
	}
}
