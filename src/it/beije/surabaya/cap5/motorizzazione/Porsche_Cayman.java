package it.beije.surabaya.cap5.motorizzazione;

public class Porsche_Cayman extends Sportiva{
	
	public double getCilindrata() {
		return 1200.0;
		}
	public int getNumPosti() { 
		return 4;
		}
	public  double getPeso() {
		return 1355;
	}
	public void viaggia() {
		System.out.println("molto");
	}
	public String brand() {
		return "Porsche";
		}

}
