package timesheet;

public class TSutils {

	public static String creaUtente() {
		
		String query = null;
		
		return query;
		
	}

	public static String modificaUtente(String idUtente) {
		
		String query = null;

		return query;
	}

	public static String eliminaUtente(String idUtente) {
		
		String query = null;
		query = "DELETE FROM user WHERE id = " + idUtente;
		
		return query;
	}
	

}
