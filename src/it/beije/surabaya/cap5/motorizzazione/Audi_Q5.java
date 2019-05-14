package it.beije.surabaya.cap5.motorizzazione;

public class Audi_Q5 extends Suv{
	public double getCilindrata() {
		return 2967.0;
		}
	public int getNumPosti() { 
		return 5;
		}
	public  double getPeso() {
		return 1900;
	}
	public void viaggia() {
		System.out.println("anche in salita");
	}
	public String brand() {
		return "Audi";
		}
}
