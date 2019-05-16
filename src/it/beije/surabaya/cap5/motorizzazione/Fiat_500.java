package it.beije.surabaya.cap5.motorizzazione;

public class Fiat_500 extends Veicolo implements Utilitaria  {

	@Override
	public double getCilindrata() {
		return 1368;
	}

	@Override
	public double getPeso() {
		return 970;
	}

//	@Override
//	public int getNumRuote() {
//		return 5;
//	}
	@Override
	public void viaggia() {

		System.out.println("Viaggio in fiaaat");
		
	}

	

}
