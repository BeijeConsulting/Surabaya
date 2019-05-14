package it.beije.surabaya.cap5.motorizzazione;

public class Alfa_Romeo_Giulia extends Berlina {

	@Override
	public double getCilindrata() {
		
		return 2.0;
	}

	@Override
	public double getPeso() {
		
		return 0;
	}


	public String tipoTrazione() {
		
		return "FWD";
	}

}
