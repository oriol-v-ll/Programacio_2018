package Dades;
import Excepcions.DniRepetido;

/**
 * Classe LlistaClients ha de contenir:
 * llista amb tots els clients
 * comprovar que no es dupliqui cap client
 * fer totes les funcions principals d’una llista.
 * Donar d’alta un client (aquí cal controlar que no hi pugui haver repetits).
 * Donar de baixa un client, cosa que implica esborrar tota la seva informació 
 * i les reserves de viatge que hagi fet.
 * @author Bernat Sort
 */
public class LlistaClients {
	
	/**
	 * Atributos de la clase
	 * private: indica que a través de una instancia no es accesible el atributo. Al heredar el atributo se convierte en inaccesible. 
	 * No se puede modificar el valor de estas propiedades desde fuera de la clase LlistaPoblacions.
	 */
	private int nClients;
	private Clients[] llista;
	
	
	
	/** Constructor
	 * @param nClients es el número de clientes
	 * @param llista es la lista donde guardamos los clientes
	 */
	public LlistaClients (int mida)
	{
	nClients=0;
	llista=new Clients[mida];
	}

	/**
	 * getter
	 * @return el número de clientes
	 */
	public int getNumClients() {
		return nClients;
	}
	/**
	 * getter
	 * @return la lista de clientes
	 */
	public Clients[] getLlistaClients() {
		return llista;
	}
	/**
	 * Método toString: convierte el contenido de la clase a un String.
	 * @return el contenido del objeto como una cadena.
	 */
	
	public String toString() { 
		String cadena=""; 
		for (int i=0; i<nClients; i++) 
		{
			cadena= cadena + llista[i].toString();
		}
	return(cadena);	
	}
	
	
	/**
	 * Añadir un nuevo dato de un cliente a la lista.
	 * @param p, cliente que se quiere añadir a la lista.
	 */
	
	//Dar de alta a un cliente
	public void afegirDadaClientALlista (Clients p) throws DniRepetido { //declaramos excepcion throws
	
	    //si no tenemos espacio suficiente ampliamos la lista
		//al hacer llista=aux, la llista anterior (que no era lo bastante grande) desaparece i se pasa a tener lo de la llista aux.
		if (nClients>=llista.length)
		{
			Clients[] aux =new Clients [llista.length * 2];
			
			int i=0;
			while (i<nClients) {
				aux[i]=llista[i];
				i++;
			}
			llista=aux;
		}
		//Si tenemos suficiente espacio en la llista:
		int j=0;
		while (j<nClients) {
			//si el cliente que queremos añadir ya está dado de alta
			//porque el dni coincide con alguno de la lista
			//lanzamos un error
			if (llista[j].getDni().equals(p.getDni())) { 	
				throw new DniRepetido(p.getDni()); //activamos la excepcion 
			}
			j++;
		}
	
		 //si el cliente no está repetido, lo agregamos en la posición libre
			llista[nClients]=p.copia(); 
			nClients++;	
	}
	
	
	/**
	 * Borrar la información de un cliente
	 * @param dni, cliente que se quiere borrar
	 */
	//Dar de baja a un cliente
	public void esborrarInfoClient (String dni)
	{
		int i=0;
		while (i<nClients) 
		{
			if ( (llista[i].getDni().equals(dni)))   
			{
				int j=i;
				while (j<nClients-1)
				{
					llista[j]=llista[j+1];
					j++;		
				}
				nClients--; 	
			} 
			else   
			{
				i++;
			}
		}
	}



}
