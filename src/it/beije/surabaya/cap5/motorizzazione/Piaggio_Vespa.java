package it.beije.surabaya.cap5.motorizzazione;

public class Piaggio_Vespa extends Scooter{

	@Override
	public void indossaCasco() {

		System.out.println("Indosso il casco");
		
	}

	@Override
	public void impenna() {

		System.out.println("Impenno a fatica");
	}

	@Override
	public double getCilindrata() {
		return 98;
	}

	@Override
	public double getPeso() {
		return 114;
	}

}
