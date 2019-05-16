package it.beije.surabaya.cap5.motorizzazione;

	public interface Sportiva extends Automobile {

		public default int getNumPosti() {
			return 2;
		}
}
