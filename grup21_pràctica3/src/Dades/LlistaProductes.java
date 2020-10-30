package Dades;

/**
 * LLista dels productes disponibles, es pot consultar un producte, tant circuit
 * com transport, eliminar i afegir.
 * 
 * @author Oriol Villanova Llorens
 *
 */
public class LlistaProductes {

	private int numElements;
	private Productes[] llista;

	/**
	 * Constructor per defecte
	 * 
	 * @param mida de la llista d'elements que volguem que tingui.
	 */
	public LlistaProductes(int mida) {
		llista = new Productes[mida];
		numElements = 0;
	}

	/**
	 * Getters i setters de la classe LListaProductes
	 * 
	 * 
	 */
	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	public Productes[] getLlista() {
		return llista;
	}

	public void setLlista(Productes[] llista) {
		this.llista = llista;
	}

	/**
	 * Fegir un transport a la llista de productes.
	 * 
	 * @param circuit_afegir el circuit que volem afegir a la nostra llista.
	 */
	public void afegirCircuit(circuit circuit_afegir) {

		if (numElements >= llista.length) {
			Productes[] aux = new circuit[llista.length * 2];
			int i = 0;

			while (i < numElements) {
				aux[i] = llista[i];
				i++;
			}
			llista = aux;
		} else {

			llista[getNumElements()] = circuit_afegir.copia();
			numElements++;
		}

	}

	/**
	 * Métode que al passarli un circuit o l'afegeix nou si en aquest cas no
	 * existeix, i si esta creat compara el nom, el pais en que es fa i la data
	 * d'oferiment i s'actualitza la informació dins de la llista
	 * 
	 * @param afegir - circuit que s'ha d'afegir per a actualitzar-lo o ficarlo un
	 *               altre cop dins de de la matriu
	 */
	public void actualitzarCircuit(circuit afegir) {
		boolean trobat = false;

		if (numElements >= llista.length) {
			Productes[] aux = new circuit[llista.length * 2];
			int i = 0;

			while (i < numElements) {
				aux[i] = llista[i];
				i++;
			}
			llista = aux;
		}
		int j = 0;
		while (j < numElements && !trobat) {
			if (llista[j].getNom().equals(afegir.getNom())) {
				if (((circuit) llista[j]).getDataOferiment() == afegir.getDataOferiment()) {
					if (((circuit) llista[j]).getPais() == afegir.getPais()) {
						llista[j] = afegir.copia();
						trobat = true;
					}
				}
			}
			j++;
		}

		if (!trobat) {

			llista[getNumElements()] = afegir.copia();
			numElements++;
		}
	}

	/**
	 * Es borra un circuit de la llista, deixant aquesta ordenada i fent-ho d'una
	 * manera eficient. Els circuits que tinguin el mateix nom i surtin del mateix
	 * pais s'eliminarà el primer que hi hagi a la llista
	 * 
	 * @param nom. Nom del circuit que volem borrar
	 * @param pais. Pais en que circula el circuit que volem borrar.
	 * 
	 */
	public void esborrarCircuit(String nom, String pais) {
		int i = 0;
		boolean trobat = false;

		while ((i < numElements) && (!trobat)) {
			// Es troba el circuit que coincideix pel nom i pel pais que es passa per
			// paràmetre
			if (llista[i] instanceof circuit)
				if ((llista[i].getNom().equals(nom)) && (((circuit) llista[i]).getPais().equals(pais))) {
					int j = i;
					trobat = true;

					while (j < numElements - 1) {
						llista[j] = llista[j + 1];
						j++;
					}
					numElements--;
				} else {
					i++;
				}

		}
	}

	/**
	 * Metode per buscar circuits dins de la llista de productes que estan
	 * disponibles
	 * 
	 * @param nom          - nom del circuit que volem buscar
	 * @param ciutatOrigen - la ciutat de la qual surt el circuit que volem buscar
	 * @param ciutatDesti  - la ciutat a la que arriba el circuit que volem buscar
	 * @param dataSortida  - la data en la que volem que el circuit surti
	 * @param DataArribada - la data en que arriba el circuit que volem fer.
	 * @return Retorna el circuit que compleix amb les condicions de cerca, si no el
	 *         troba retorna un circuit vuit
	 */
	public circuit buscarCircuit(String desti, data dataOferiment) {

		boolean trobat = false;
		int i = 0;
		circuit circuitTrobat = new circuit();

		while (!(trobat) && (i < numElements)) {

			if (llista[i] instanceof circuit)
				if (((circuit) llista[i]).getPais().equals(desti))
					if (((circuit) llista[i]).getDataOferiment().compararDates(dataOferiment))
						trobat = true;

			i++;
		}
		// Si es troba el transport es el que enviara

		if (trobat)
			circuitTrobat = ((circuit) llista[i - 1]).copia();

		return circuitTrobat;

	}

	/**
	 * Afegir un transport a la llista de productes
	 * 
	 * @param transport_afegir - El transport que volem afegir a la nostra llista.
	 */
	public void afegirTransport(transport transport_afegir) {

		if (numElements >= llista.length) {
			Productes[] aux = new transport[llista.length * 2];
			int i = 0;

			while (i < numElements) {
				aux[i] = llista[i];
				i++;
			}
			llista = aux;
		} else {

			llista[getNumElements()] = transport_afegir.copia();
			numElements++;
		}

	}

	/**
	 * Metode per actualitzar un transport, si es troba un transport amb el mateix
	 * nom, la mateixa ciutat d'origen i la mateixa data d'entrada s'actualitzarà
	 * la informació de la llista. El metode esta pensat per nomes actualitzar el
	 * contingut de la llista, pero si per algun motiu el usuari introdueix alguna
	 * cosa que no esta a la llista es ficaria a l'ultima posició disponible
	 * 
	 * @param afegir - el transport que volem afegir o actualitzar.
	 */
	public void actualitzarTransport(transport afegir) {
		boolean trobat = false;

		if (numElements >= llista.length) {
			Productes[] aux = new transport[llista.length * 2];
			int i = 0;

			while (i < numElements) {
				aux[i] = llista[i];
				i++;
			}
			llista = aux;
		}
		int j = 0;
		while (j < numElements && !trobat) {
			if (llista[j].getNom().equals(afegir.getNom())) {
				if (((transport) llista[j]).getCiutatOrigen() == afegir.getCiutatOrigen()) {
					if (((transport) llista[j]).getData_entrada() == afegir.getData_entrada()) {
						llista[j] = afegir.copia();
						trobat = true;
					}
				}
			}
			j++;
		}

		if (!trobat) {

			llista[getNumElements()] = afegir.copia();
			numElements++;
		}
	}

	/**
	 * Mètode per esborrar un Transport, la llista s'ordena i es troba queda
	 * ordenada com ja estava sense deixar espais en buit
	 * 
	 * @param nom          del transport que volem eliminar
	 * @param ciutatOrigen del transport que volem eliminar.
	 */
	public void esborrarTransport(String nom, String ciutatOrigen) {
		int i = 0;
		boolean trobat = false;

		while ((i < numElements) && (!trobat)) {
			// Es troba el transport que coincideix amb el nom indicat per parametre i la
			// ciutat origen.

			if (llista[i] instanceof transport)
				if ((llista[i].getNom().equals(nom))
						&& ((transport) llista[i]).getCiutatOrigen().equals(ciutatOrigen)) {
					int j = i;
					trobat = true;

					while (j < numElements - 1) {
						llista[j] = llista[j + 1];
						j++;
					}
					numElements--;
				} else {
					i++;
				}

		}
	}

	/**
	 * Es pot buscar un transport amb els seguents parametres
	 * 
	 * @param              nom, nom del transport que volem buscar
	 * @param              ciutatOrigen, la ciutat de la que srtirà el transport
	 * @param dataSortida
	 * @param DataArribada
	 * @return
	 */
	public transport buscarTransport(String ciutatOrigen, String ciutatDesti, data dataSortida) {

		boolean trobat = false;
		int i = 0;
		transport transportTrobat = new transport();

		while (!(trobat) && (i < numElements)) {

			if (llista[i] instanceof transport)
				if (((transport) llista[i]).getCiutatOrigen().equals(ciutatOrigen))
					if (((transport) llista[i]).getCiutatDesti().equals(ciutatDesti))
						if (((transport) llista[i]).getData_entrada().compararDates(dataSortida))
							trobat = true;
			i++;
		}
		// Si es troba el transport es el que enviara

		if (trobat)
			transportTrobat = ((transport) llista[i - 1]).copia();

		return transportTrobat;

	}

	/**
	 * Mètode que retorna una llista de productes amb els productes que encara
	 * tinguin places disponibles per a poder contractar-lo
	 * 
	 * @return llista de productes amb tot el contingut de els productes que estan
	 *         dins de la llista i que encara tenen places disponibles.
	 */
	public Productes[] tePlaces() {
		Productes[] aux = new Productes[numElements];
		int j = 0;
		for (int i = 0; i < numElements; i++) {
			if (llista[i].teplacesDisponibles()) {
				aux[j] = llista[i];
				j++;
			}
		}

		return aux;
	}

	/**
	 * Retorna una llista amb els productes que no estan caducats.
	 * 
	 * @param dataActual la data actual per poder compararla
	 * @return llista de productes que no estan caducats.
	 */
	public Productes[] llistaNoCaducats(data dataActual) {

		Productes[] aux = new Productes[llista.length];
		int j = 0;
		for (int i = 0; i < numElements; i++) {

			if (llista[i] instanceof circuit) {

				if (((circuit) llista[i]).getDataOferiment().esPosterior(dataActual)) {
					aux[j] = llista[i];
					j++;
				}
			}

			if (llista[i] instanceof transport) {

				if (((transport) llista[i]).getData_entrada().esPosterior(dataActual)) {
					aux[j] = llista[i];
					j++;
				}

			}

		}

		return aux;
	}

	/**
	 * toString de la llista, t'imprimeix per la pantalla el contingut de la llista.
	 */
	public String toString() {
		String cadena = "";

		for (int i = 0; i < numElements; i++)
			cadena = cadena + "" + llista[i].toString();

		return cadena;

	}

}
