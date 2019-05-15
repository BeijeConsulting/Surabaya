package it.beije.surabaya.cap5.motorizzazione;

public class Kawasaki_Z900 extends Veicolo implements Moto {

	@Override
	public void impenna() {
		System.out.println("Meeeeem meeeeeeeem..");
	}

	@Override
	public double getCilindrata() {
		return 900;
	}

	@Override
	public double getPeso() {
		return 210;
	}

	@Override
	public void indossaCascoIntegrale() {

		System.out.println("Metto il casco integrale");
		
	}

}
