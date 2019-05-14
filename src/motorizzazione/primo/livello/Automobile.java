package motorizzazione.primo.livello;

import java.util.List;

public abstract class Automobile extends Veicolo{
	
	private int nRuote = 4;
	
	public int getNumRuote() {
		return nRuote;
	}
	
	public void viaggia() {
		System.out.println("Veicolo in movimento...");
	}
		
	public double getCilindrata() {
		return cilindrata;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getModelBrand() {
		return "Marchio: " + brand +"\n"+"Modello"+ ": " + model;
	}
	
	public static Automobile getAutoMaxCilindrata(List<Automobile> auto) {
		
		Automobile max = auto.get(0);
		
		for (Automobile a : auto) {
			if(max.getCilindrata()<a.getCilindrata())
				max = a;
		}
		
		return max;
	}
	
}
