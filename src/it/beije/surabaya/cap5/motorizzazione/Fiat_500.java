package it.beije.surabaya.cap5.motorizzazione;

public class Fiat_500 extends Utilitaria {

	@Override
	public double getCilindrata() {
		return 1368;
	}

	@Override
	public double getPeso() {
		return 970;
	}

	@Override
	public void viaggia() {

		System.out.println("Viaggio in fiaaat");
		
	}

}
