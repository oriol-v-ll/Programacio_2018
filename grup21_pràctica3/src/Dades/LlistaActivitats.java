package Dades;
/**
 * Metode que fa totes les funcions bàsiques de la llista, guarda Activitats
 * dins de la llista
 * 
 * @author Oriol Villanova Llorens
 *
 */
public class LlistaActivitats {
	/**
	 * Fiquem els atributs de la classe
	 */
	private int numElements;
	private Activitat[] llistaActivitats;

	/**
	 * constructor per defecte de la classe.
	 */
	public LlistaActivitats() {
		numElements = 0;
		llistaActivitats = new Activitat[0];
	}

	/**
	 * Constructor passant la mida de la taula d'activitats que volem tindre
	 * 
	 * @param mida - la mida de la taula que volguem que tingui les activitats
	 */
	public LlistaActivitats(int mida) {
		numElements = 0;
		llistaActivitats = new Activitat[mida];
	}

	/**
	 * Getters i setters de tots els atributs de la classe.
	 * 
	 * @return
	 */

	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	public Activitat[] getLlistaActivitats() {
		return llistaActivitats;
	}

	public void setLlistaActivitats(Activitat[] llistaActivitats) {
		this.llistaActivitats = llistaActivitats;
	}

	/**
	 * Metode que ve de la classe Activitat per afegir una activitat a dins del
	 * circuit.
	 */
	public void afegirActivitat(Activitat afegirActivitat) {
		if (numElements >= llistaActivitats.length) {
			Activitat[] aux = new Activitat[llistaActivitats.length * 2];
			int i = 0;

			while (i < numElements) {
				aux[i] = llistaActivitats[i];
				i++;
			}
			llistaActivitats = aux;
		} else {

			llistaActivitats[getNumElements()] = afegirActivitat.copia();
			numElements++;
		}

	}

	/**
	 * Metode per borrar un elements de la llista d'activitats amb el nom de
	 * l'activitat
	 * 
	 * @param nom -nom de l'activitat que volem eliminiar.
	 */
	public void esborrarActivitat(String nom) {
		int i = 0;
		boolean trobat = false;

		while ((i < numElements) && (!trobat)) {

			if (llistaActivitats[i].getNom().equals(nom)) {
				int j = i;
				trobat = true;

				while (j < numElements - 1) {
					llistaActivitats[j] = llistaActivitats[j + 1];
					j++;
				}
				numElements--;
			} else {
				i++;
			}

		}
	}

	/**
	 * Metode per buscar una activitat sabent el seu nom.
	 * 
	 * @param nom nom de l'activitat
	 * @return l'activitat que té el mateix nom.
	 */
	public Activitat buscarActivitat(String nom) {

		boolean trobat = false;
		int i = 0;
		Activitat activitattrobada = new Activitat();

		while (!(trobat) && (i < numElements)) {

			if (llistaActivitats[i].getNom().equals(nom))
				trobat = true;

			i++;
		}

		if (trobat)
			activitattrobada = (llistaActivitats[i - 1]).copia();

		return activitattrobada;

	}

	/**
	 * toString de la classe, imprimeix per pantalla tot el contingut de la llista.
	 */
	public String toString() {
		String cadena="";

		for (int i = 0; i < numElements; i++)
			cadena= cadena + "" + llistaActivitats[i].toString();
		
		return cadena;

	}
}
