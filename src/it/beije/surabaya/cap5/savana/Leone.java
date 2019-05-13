package it.beije.surabaya.cap5.savana;

public class Leone implements Predatore, Carnivoro {

	public void mangioCarne() {
		System.out.println("mangio una bistecca...");
	}
	
	public void caccia() {
		System.out.println("ogni mattina etc etc...");
	}
	
	public String toString() {
		return "Leone";
	}
	
	public static void main(String[] args) {
		
		Leone leo = new Leone();
		
		leo.mangio((Preda) new Gazzella());
		leo.mangio((Erbivoro) new Gazzella());
		leo.mangio((Preda) new Opossum());
		leo.mangio((Carnivoro) new Opossum());
		leo.mangio((Erbivoro) new Opossum());
		leo.mangio(new Leone());
		
	}

}
