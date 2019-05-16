package it.beije.surabaya.cap5.motorizzazione.automodel;

import it.beije.surabaya.cap5.motorizzazione.Automobile;
import it.beije.surabaya.cap5.motorizzazione.Benzina;
import it.beije.surabaya.cap5.motorizzazione.Veicolo;
import it.beije.surabaya.cap5.motorizzazione.autotype.Utilitaria;

public class Fiat_500 extends Veicolo implements Utilitaria, Benzina {
	private final String brand = "Fiat";
	private final String model = "500";
	private final double cilindrata = 100;
	private final double peso = 1000;
	private final int num_ruote = 4;
	
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
