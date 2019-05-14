package it.beije.surabaya.cap5.motorizzazione;

public abstract class Sportiva extends Automobile{
	public boolean pagaSuperBollo ()  {
		return true;				//LA MAGGIOR PARTE PAGA IL SUPERBOLLO
	}
	
	public int getNumPosti()  {
		return 4;
	}

	public String tipoTrazione ()  {
		return "RWD";					//lA maggior parte hanno trazione posteriore
	}
}
