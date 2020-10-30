package Dades;

import java.io.Serializable;

/**
 * Classe productes , es la classe pare dels productes que podem afegir a la
 * nosta aplicacio.
 * 
 * @author Oriol Villanova Llorens.
 *
 */
public class Productes implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String nom;
	protected double preu;
	protected int numeroPlaces;
	protected int numeroPlacesDisponibles;
	protected String tipusTransport; // Nomes pot ser tren avio o vaixell.

	/**
	 * Constructor buit de la classe.
	 */
	public Productes() {
		nom = "";
		tipusTransport = "";
		preu = 0;
		numeroPlaces = 0;
		numeroPlacesDisponibles = 0;
		id = 0;

	}

	/**
	 * Constructor enviant els paràmetres necessaris per a poder omplir dades.
	 * 
	 * @param nom            del producte de viatge
	 * @param tipusTransport en que es pot fer el viatge
	 * @param preu           que costa el viatge
	 * @param numero_places  la cantitat de persones que caben per a fer el viatge.
	 */
	public Productes(String nom, String tipusTransport, double preu, int numero_places, int numeroPlacesDisponibles) {
		this.nom = nom;
		this.tipusTransport = tipusTransport;
		this.preu = preu;
		this.numeroPlaces = numero_places;
		this.numeroPlacesDisponibles = numeroPlacesDisponibles;
		id = (int) preu + numero_places + nom.length();
		// En aquest cas el id es únic per a cada producte, hi ha molt poques
		// probabilitats que dos productes tinguin la mateixa id

	}

	/**
	 * Getters i setters dels diferents atributs de la classe.
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public int getNumeroPlaces() {
		return numeroPlaces;
	}

	public void setNumeroPlaces(int numero_places) {
		this.numeroPlaces = numero_places;
	}

	public String getTipusTransport() {
		return tipusTransport;
	}

	public void setTipusTransport(String tipusTransport) {
		this.tipusTransport = tipusTransport;
	}

	public int getNumeroPlacesDisponibles() {
		return numeroPlacesDisponibles;
	}

	public void setNumeroPlacesDisponibles(int numeroPlacesDisponibles) {
		this.numeroPlacesDisponibles = numeroPlacesDisponibles;
	}
	
	public Productes copia() {
		Productes duplicat=new Productes(nom,tipusTransport,preu,numeroPlaces,numeroPlacesDisponibles);
		return duplicat;
	}

	/**
	 * Mètode per veure les places que queden disponibles del producte en questió.
	 * 
	 * @return true si quedem places disponibles, false si no li queden places.
	 */
	public boolean teplacesDisponibles() {
		boolean te = false;

		if (numeroPlacesDisponibles != 0)
			te = true;

		return te;

	}

	/**
	 * toString de la classe.
	 */
	@Override
	public String toString() {
		return "Producte: \n Nom = " + nom + "\n Preu = " + preu + "\n Nombre de places totals = " + numeroPlaces
				+ "\n Nombre de places disponibles = " + numeroPlacesDisponibles + "\n Tipus de Producte = " + tipusTransport ;
	}

}
