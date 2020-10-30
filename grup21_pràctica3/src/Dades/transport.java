package Dades;

/**
 * La classe transport implementa, la manera que els clients poden ser
 * transportats entre les diferents rutes que es desenvolupen al llarg dels
 * dies.
 * 
 * @author Oriol Villanova Llorens
 *
 */
public class transport extends Productes {
	private static final long serialVersionUID = 1L;
	/**
	 * Es creen tots els atributs de la classe.
	 */

	private String ciutatOrigen;
	private String ciutatDesti;
	private data data_entrada;
	private data data_sortida;

	/**
	 * Constructor per defecte de la classe.
	 */
	public transport() {
		super();

		ciutatOrigen = "";
		ciutatDesti = "";
		data_entrada = new data();
		data_sortida = new data();

	}

	/**
	 * 
	 * Constructor omplint tots els atributs de la classe
	 * 
	 * @param nom            del producte que s'ofereix
	 * @param tipusTransport per terra mar o aire
	 * @param preu           preu del producte
	 * @param numero_places  que pot albergar
	 * @param ciutatOrigen   la ciutat origen del transport
	 * @param ciutatDesti    del transport
	 * @param data_entrada   del transport
	 * @param data_sortida   del transport
	 */
	public transport(String nom, String tipusTransport, double preu, int numero_places,int numeroPlacesDisponibles, String ciutatOrigen,
			String ciutatDesti, data data_entrada, data data_sortida) {
		super(nom, tipusTransport, preu, numero_places,numeroPlacesDisponibles);
		this.ciutatOrigen = ciutatOrigen;
		this.ciutatDesti = ciutatDesti;
		this.data_entrada = data_entrada;
		this.data_sortida = data_sortida;

	}

	/**
	 * geters i setters de tots els atributs de la classe per a que altres calsses
	 * puguin utilitzar les dades d'aquesta
	 * 
	 */

	public String getCiutatOrigen() {
		return ciutatOrigen;
	}

	public void setCiutatOrigen(String ciutatOrigen) {
		this.ciutatOrigen = ciutatOrigen;
	}

	public String getCiutatDesti() {
		return ciutatDesti;
	}

	public void setCiutatDesti(String ciutatDesti) {
		this.ciutatDesti = ciutatDesti;
	}

	public data getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(data data_entrada) {
		this.data_entrada = data_entrada;
	}

	public data getData_sortida() {
		return data_sortida;
	}

	public void setData_sortida(data data_sortida) {
		this.data_sortida = data_sortida;
	}

	/**
	 * Metode per afegir una persona a les places disponibles del transport
	 * 
	 * @param plaça que hem d'ocupar
	 */
	public void afegirOcupant(int placa) {
		// Has de fer una exepcio d'errors. No està avabat de fer aquest mètode.
		numeroPlaces--;

	}

	/**
	 * Metode toString per poder veure el contingut de la classe.
	 */
	@Override
	public String toString() {
		return "Transport \n " + "\n Nom = " + nom + "\n Preu = " + preu + " \n Nombre de places = " + numeroPlaces
				+ "\n Nombre de places disponibles = " + numeroPlacesDisponibles +"\n Tipus de transport = " + tipusTransport + "\n Ciutat Origen = " + ciutatOrigen
				+ "\n Ciutat Desti = " + ciutatDesti + "\n Data de sortida = " + data_entrada.getDia() + "/"
				+ data_entrada.getMes() + "/" + data_entrada.getAny() + "\n Data d'arribada = " + data_sortida.getDia()
				+ "/" + data_sortida.getMes() + "/" + data_sortida.getAny() + "\n\n";
	}

	/**
	 * Mètode per a fer una copia del objecte que estiguem treballant.
	 * 
	 * @return
	 */
	public transport copia() {
		transport duplicat = new transport(nom, tipusTransport, preu, numeroPlaces,numeroPlacesDisponibles, ciutatOrigen, ciutatDesti,
				data_entrada, data_sortida);
		return duplicat;
	}
}
