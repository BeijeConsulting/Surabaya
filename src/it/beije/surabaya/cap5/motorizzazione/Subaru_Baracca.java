package it.beije.surabaya.cap5.motorizzazione;

public class Subaru_Baracca extends Berlina{
	public int getNumRuote() {
		return 3;
	}
	public double getCilindrata() {
		return 200.0;
		}
	public int getNumPosti() { 
		return 3;
		}
	public  double getPeso() {
		return 1100;
	}
	public void viaggia() {
		System.out.println("a fatica");
	}
	public String brand() {
		return "Subaru";
		}
	public boolean cool() {
		return true;
	}
	public boolean camporella() {
		return false;
	}
	public static void main(String[] args) {
		Subaru_Baracca s = new Subaru_Baracca();
		System.out.println(s.getNumRuote());
	}
}
