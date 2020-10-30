package Dades;

/**
 * Classe que conté tota la informació d'una activitat que es pot fer dins dels
 * circuits, la classe circuits conte una llista d'activitats la qual es poden
 * afegir activitats
 * 
 * @author Oriol Villanova Llorens
 *
 */
public class Activitat {

	/**
	 * Definim els atributs de la classe.
	 */
	private String nom;
	private String descripcio;
	private String lloc;

	/**
	 * COnstructor per defecte de la classe
	 */
	public Activitat() {
		nom = "";
		descripcio = "";
		lloc = "";
	}

	/**
	 * Constructor omplint les dades de la classe
	 * 
	 * @param nom        - nom de l'activitat
	 * @param descripcio - descripcio de la ruta que farà l'activitat
	 * @param lloc       - lloc on es realitzara la activitat.
	 */
	public Activitat(String nom, String descripcio, String lloc) {
		this.nom = nom;
		this.descripcio = descripcio;
		this.lloc = lloc;
	}

	/**
	 * Metode que retorna una copia de l'activitat en questió.
	 * 
	 * @return
	 */
	public Activitat copia() {
		Activitat duplicat = new Activitat(nom, descripcio, lloc);
		return duplicat;
	}

	/**
	 * Getters i setters de la classe
	 * 
	 */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getLloc() {
		return lloc;
	}

	public void setLloc(String lloc) {
		this.lloc = lloc;
	}

	/**
	 * toString de la classe.
	 */
	@Override
	public String toString() {
		return "Activitat: \n Nom = " + nom + "\n Descripcio= " + descripcio + "\n Lloc = " + lloc +"\n\n";
	}

}
