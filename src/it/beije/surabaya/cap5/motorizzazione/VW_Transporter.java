package it.beije.surabaya.cap5.motorizzazione;

public class VW_Transporter extends Furgone{
	public double getCilindrata() {
		return 1400.0;
		}
	public int getNumPosti() { 
		return 7;
		}
	public  double getPeso() {
		return 1755;
	}
	public void viaggia() {
		System.out.println("carico");
	}
	public String brand() {
		return "VolksWagen";
		}
}
