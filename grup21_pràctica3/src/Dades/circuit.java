package Dades;

/**
 * Classe circuit. aquesta es una classe filla de la classe Productes que
 * especifica quin tipus de producte hi ha en aquesta classe, en aquest cas son
 * circuits que sempre es fan amb bus i poden tenir activitats programades
 * 
 * @author Oriol Villanova Llorens
 *
 */
public class circuit extends Productes {
	private static final long serialVersionUID = 1L;
	private String pais;
	private int dies;
	private data dataOferiment;
	private data dataOferimentAcab;
	private int[] llistaActivitats;
	// Es el num d'activitats:
	private int numElements;

	/**
	 * Constructor per defecte de la classe que volem utilitzar
	 */
	public circuit() {
		super();

		// Els circuits es fan sempre amb bus.
		tipusTransport = "Bus";
		pais = "";
		dies = 0;
		dataOferiment = new data();
		dataOferimentAcab = new data();
		llistaActivitats = new int[0];
		numElements = 0;

	}

	/**
	 * Constructor amb paràmetres.
	 * 
	 * @param mida -mida de les activitats que vlem tindre.
	 */
	public circuit(int mida) {
		super();

		// Els circuits es fan sempre amb bus.
		tipusTransport = "Bus";
		pais = "";
		dies = 0;
		dataOferiment = new data();
		dataOferimentAcab = new data();
		llistaActivitats = new int[mida];
		numElements = 0;

	}

	/**
	 * Getters i Setters de tots els atributs de la classe.
	 * 
	 * 
	 */
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getDies() {
		return dies;
	}

	public void setDies(int dies) {
		this.dies = dies;
	}

	public data getDataOferiment() {
		return dataOferiment;
	}

	public void setDataOferiment(data dataOferiment) {
		this.dataOferiment = dataOferiment;
	}

	public data getDataOferimentAcab() {
		return dataOferimentAcab;
	}

	public void setDataOferimentAcab(data dataOferimentAcab) {
		this.dataOferimentAcab = dataOferimentAcab;
	}

	public int getNumElements() {
		return numElements;
	}

	public int[] getLlistaActivitats() {
		return llistaActivitats;
	}

	/**
	 * Constructor amb els paràmetres que volem afegir al nostre circuit.
	 * 
	 * @param nom. El nom que li volem donar al circuit
	 * @param tipusTransport. El tipus de transport que utilitzarem en el circuit
	 * @param preu. El preu que costa en euros
	 * @param numero_places. Les places que hi han
	 * @param pais. Pais en el que s'efectura el nostre circuit.
	 * @param dies. Dies que dura l'activitat
	 * @param dataOferiment. Quan es comença a oferir el circuit.
	 * @param dataOferimentAcab. Quan s'acaba d'oferir el circuit.
	 * @param mida. La mida que farem servir per a la taula d'activitats.
	 */
	public circuit(String nom, String tipusTransport, double preu, int numero_places,int numeroPlacesDisponibles, String pais, int dies,
			data dataOferiment, data dataOferimentAcab, int mida) {

		super(nom, tipusTransport, preu, numero_places,numeroPlacesDisponibles);
		this.pais = pais;
		this.dies = dies;
		this.dataOferiment = dataOferiment;
		this.dataOferimentAcab = dataOferimentAcab;
		llistaActivitats = new int[mida];

	}

	/**
	 * S'afegeix una activitat al circuit, en aquest cas nomes guardem la posicó en
	 * que es troba la activitat dins de la taula d'activitats principal de
	 * llistaActivitats, per poderla consultar quan ens vagi be
	 * 
	 * @param posicio - index en que es troba l'activitat dins de la seva activitat.
	 */
	public void afegirActivitat(int posicio) {

		if (numElements >= llistaActivitats.length) {
			int[] aux = new int[llistaActivitats.length * 2];
			int i = 0;

			while (i < numElements) {
				aux[i] = llistaActivitats[i];
				i++;
			}
			llistaActivitats = aux;
		} else {
			llistaActivitats[numElements] = posicio;
			numElements++;
		}
	}

	/**
	 * Metode per a poder fer una copia del circuit en el que estem treballant.
	 * 
	 * @return Retorna la copia del circuit.
	 */
	public circuit copia() {
		circuit duplicat = new circuit(nom, tipusTransport, preu, numeroPlaces,numeroPlacesDisponibles, pais, dies, dataOferiment,
				dataOferimentAcab, llistaActivitats.length);
		return duplicat;
	}

	/**
	 * toString de la classe circuit
	 */
	@Override
	public String toString() {
		
		return "Circuit\n" + "\n Nom = " + nom + "\n Preu = " + (int)preu + " \n Nombre de places totals = " + numeroPlaces + "\n Nombre de places disponibles = " + numeroPlacesDisponibles + "\n Tipus de transport = " + tipusTransport + "\n Dest� = " + pais + "\n Dies = " + dies
				+ "\n Data Oferiment = " + dataOferiment.getDia() + "/" + dataOferiment.getMes() + "/"
				+ dataOferiment.getAny() + "\n Data Acabament = " + dataOferimentAcab.getDia() + "/"
				+ dataOferimentAcab.getMes() + "/" + dataOferimentAcab.getAny() + "\n\n";
	}

}
