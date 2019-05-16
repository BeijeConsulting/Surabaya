package it.beije.surabaya.cap5.motorizzazione.automodel;

import it.beije.surabaya.cap5.motorizzazione.Benzina;
import it.beije.surabaya.cap5.motorizzazione.Elettrico;
import it.beije.surabaya.cap5.motorizzazione.Veicolo;
import it.beije.surabaya.cap5.motorizzazione.autotype.Sportiva;

public class Toyota_Yaris extends Veicolo implements Sportiva, Benzina, Elettrico {
	private final String brand = "Toyota";
	private final String model = "Yaris";
	private final double cilindrata = 100;
	private final double peso = 1000;
	private final int num_ruote = 4;
	private final String motor_type = "Hybrid";

	public double getCilindrata() {
		return this.cilindrata;
		
	}

	public double getPeso() {
		return this.peso;
	}

	public String getBrand() {
		return this.brand;
	}

	public String getModel() {
		return this.model;
	}

	public String getMarcaModello() {
		return this.brand + " " + this.model;
	}
	
	public int getNumRuote() {
		return this.num_ruote;
	}

	public int getNumPosti() {
		return num_posti;
	}
	
	public String getMotorType( ) {
		return motor_type;
	}

}
