package it.beije.surabaya.cap5.fattoria;

public class Balena extends Mammifero {
	
	public Balena(){
		super(0);
	}
	
	public void movimento() {
		System.out.println("vivo nei mari...");
	}
	
	public void nutrirsi() {
		System.out.println("mangio i pesci...");
	}
}
