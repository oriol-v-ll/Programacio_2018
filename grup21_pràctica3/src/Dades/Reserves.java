package Dades;

import java.io.Serializable;

/**
 * Classe Reserva, que tiene como atributos:
 * ReservaProducte = Atributo donde se guarda el producto
 * ReservaClient = Atributo donde se guarda el cliente.
 * Reservadata tiene que ser posterior a la data actual.
 * numReserva = La cantidad de plazas para reservar.
 * @author Sergi
 *
 */
public class Reserves implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Atributos de la clase
	 */
	
	private Productes ReservaProducte;
	private Clients ReservaClient;
	private data Reservadata;
	private int numReserva;
	public static Productes MesReserva = new Productes("","",0,0,5);
	
	

	/**
	 * Constructor por defecto
	 */
	
	 public Reserves() {
		 ReservaProducte=null;
		 ReservaClient=null;
		 Reservadata= null;
		 numReserva=0;
		}
	 
	 /**
		 * Constructor que recibe datos de las reserva.
		 * @param ReservaProducte: Producto que reservamos.
		 * @param ReservaClient: Datos clientes.
		 * @param Reservadata: Data de la reserva.
		 * @param numReserva: Numero de Reserva.
		 */
	 public Reserves(Productes ReservaProducte,Clients ReservaClient,data Reservadata, int numReserva){
			this.ReservaProducte=ReservaProducte;
			this.ReservaClient=ReservaClient;
			this.Reservadata=Reservadata;
			this.numReserva=numReserva;
			actualitzarMesreservat(ReservaProducte);
		}
	 
	 /**
	  * Setter Actualizar el valor de los atributos.
	  * Getter
	  * @return Retornan el valor de cada objeto.
	  */
	 
	public Productes getReservaProducte() {
		return ReservaProducte;
	}
	public void setReservaProducte(Productes reservaProducte) {
		ReservaProducte = reservaProducte;
		actualitzarMesreservat(ReservaProducte);

	}
	public Clients getReservaClient() {
		return ReservaClient;
	}
	public void setReservaClient(Clients reservaClient) {
		ReservaClient = reservaClient;
	}
	public data getReservadata() {
		return Reservadata;
	}
	public void setReservadata(data reservadata) {
		Reservadata = reservadata;
	}
	public int getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(int numReservas) {
		this.numReserva = numReservas;
	}

	
	public static Productes getMesReserva() {
		return MesReserva;
	}

	public static void setMesReserva(Productes mesReserva) {
		MesReserva = mesReserva;
	}


	/**
     * M�todo que crea un duplicado de la instancia Reserves.
     * @return Reservas exactos a los nuestros. 
     */
	public Reserves copia() {
		  return(new Reserves(ReservaProducte,ReservaClient,Reservadata,numReserva));
	 }

	/**
     * M�todo toString: convierte el contenido de la clase a un String.
     * @return el contenido del objeto como una cadena y separada por espacios.
     */
	public String toString() {
		return ("Reserva:\n\n" + ReservaProducte + "\n\n"+ReservaClient + "\nData de reserva = " + Reservadata.getDia()+"/"+Reservadata.getMes()+"/"+Reservadata.getAny()+ "\n\nPlaces Reservades=" + numReserva+"\n\n");
	}
	/**
     * M�todo que indica el producto m�s popular.
     */
	
	public void actualitzarMesreservat(Productes p){
		int numeroPlacesReservades = (p.getNumeroPlaces() - p.getNumeroPlacesDisponibles());
		int numeroPlacesMesReservat= (Reserves.MesReserva.getNumeroPlaces() - Reserves.MesReserva.getNumeroPlacesDisponibles());
		if(numeroPlacesReservades > numeroPlacesMesReservat) {
			MesReserva=p.copia();
		}
			
	}	
}
