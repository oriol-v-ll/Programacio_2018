package Dades;
import Excepcions.ProducteCaducatException;

public class LlistaReserva {
	private int numReserves;
	private Reserves[] llista;

	public LlistaReserva(int n) {
		llista = new Reserves[n];
		numReserves = 0;
	}

	public int getNumReserves() {
		return numReserves;
	}

	public void setNumReserves(int numReserves) {
		this.numReserves = numReserves;
	}

	public Reserves[] getLlista() {
		return llista;
	}

	public void setLlista(Reserves[] llista) {
		this.llista = llista;
	}

	/**
	 * Método para añadir una reserva en la lista.
	 * @param r Reserva que hemos realizado.
	 * @throws ProducteCaducatException Error que se lanza si el producto ha caducado.
	 */
	public void afegirReserva(Reserves r) throws ProducteCaducatException {

		if (r.getReservaProducte() instanceof circuit) { //Comprobar si la data es correcta dependiendo si es circuito o transporte.
			if (r.getReservadata().esPosterior(((circuit) r.getReservaProducte()).getDataOferiment())) {
				throw new ProducteCaducatException(r.getReservaProducte());

			}
		}
		if (r.getReservaProducte() instanceof transport) {
			if (r.getReservadata().esPosterior(((transport) r.getReservaProducte()).getData_entrada())) {
				throw new ProducteCaducatException(r.getReservaProducte());

			}
		}

		int i = 0;

		if (numReserves >= llista.length) {
			Reserves[] aux = new Reserves[llista.length * 2];

			while (i < numReserves) {
				aux[i] = llista[i];
				i++;
			}
			llista = aux;
		}

		if (numReserves < llista.length) {
			llista[numReserves] = r.copia();
			int placesdisp = r.getReservaProducte().getNumeroPlacesDisponibles() - r.getNumReserva();
			r.getReservaProducte().setNumeroPlacesDisponibles(placesdisp);
			numReserves++;
		}

	}
	
	/**
	 * Metodo que borra todos los datos del cliente en la lista reserva.
	 * @param dni Del cliente que tenemos que borrar.
	 */

	public void esborrarReserva(String dni) {
		int i = 0;
		while (i < numReserves) {
			if ((llista[i].getReservaClient().getDni().equals(dni))) {
				int placesdisp = llista[i].getReservaProducte().getNumeroPlacesDisponibles()
						+ llista[i].getNumReserva();
				llista[i].getReservaProducte().setNumeroPlacesDisponibles(placesdisp);
				int j = i;

				while (j < numReserves - 1) {
					llista[j] = llista[j + 1];
					j++;
				}
				numReserves--;

			} else {
				i++;
			}
		}
	}
	/**
	 * @param dni El Dni del Cliente.
	 * @return Una lista con todas las reservas asignadas a su DNI.
	 */

	public Reserves[] BuscadorDni(String dni) {

		Reserves[] aux = new Reserves[llista.length];
		int i = 0;
		for (i = 0; i < numReserves; i++) {
			if ((llista[i].getReservaClient().getDni().equals(dni))) {
				int j = 0;
				aux[j] = llista[i];
				j++;
			}

		}
		return aux;

	}
	
	/**
	 *  Metodo que imprime los productos que tienen  reservas junto con los datos del cliente que han reservado.
	 * @param p Lista de Productos.
	 * @param numProducte Numero de Productos.
	 * 
	 */

	public String[] ProductesReservats() {
		String[] retornar= new String[numReserves];
		for(int i=0;i<numReserves;i++)
		{
			retornar[i]=llista[i].getReservaProducte().toString() +"\n\nReservat per:\n\n"+ llista[i].getReservaClient().toString();
		}
		return retornar; 
	}
	
	/**public void BuscadordeReserva(Productes[] p, int numProducte) {
		Clients[] aux = new Clients[llista.length];
		int i = 0;
		Productes aux2=new Productes();
		int h = 0;
		for (i = 0; i < numProducte; i++) {
			if (p[i].getNumeroPlacesDisponibles() != p[i].getNumeroPlaces()) {
				for (int j = 0; j < numReserves; j++) {
					aux2=llista[j].getReservaProducte();
					if (aux2 == p[i]) {
						aux[h] = llista[j].getReservaClient();
						h++;
					}
				}
			}
			p[i].toString();
			aux.toString();
			h = 0;
		}
		i++;
	}
	*/
	//metodo toString 

	public String toString() {
		String cadena = "";

		for (int i = 0; i < numReserves; i++)
			cadena = cadena + "" + llista[i].toString();

		return cadena;

	}

}
