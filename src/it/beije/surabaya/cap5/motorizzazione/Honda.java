package it.beije.surabaya.cap5.motorizzazione;

public class Honda extends MotoGP {

	public Honda() {
		super.cilindrata = 1000;
		super.peso = 150;
	}
	
	public void viaggia() {
		System.out.println("Start: Honda in pista...");
	}

}