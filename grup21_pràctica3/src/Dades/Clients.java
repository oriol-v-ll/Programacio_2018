package Dades;

import java.io.Serializable;

/**
 * Clase Clients que tená como atributos:
 * el DNI, el nombre y la dirección de correo electrónico.
 * El DNi debe ser único.
 * @author Bernat Sort
 *
 */
public class Clients implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Atributos de la clase
	 */
	private String dni;
	private String nom;
	private String correu;
	
	
	/**
	 * Constructor por defecto
	 */
	
	public Clients() {
		dni="";
		nom="";
		correu="";
	}
	
	/**
	 * Constructor que recibe datos de los clientes e inicializa campos.
	 * @param dni: dni del cliente.
	 * @param nom: nombre del cliente.
	 * @param adreça: dirección del cliente.
	 * @param correu: correo del  cliente.
	 */
	public Clients(String dni, String nom, String correu) {
		
		this.dni=dni;
		this.nom=nom;
		this.correu=correu;
		}

	/**
	 * Setters y Getters 
	 * Para que otras clases puedan acceder y usar los atributos de esta clase.
	 */
	  
	/** 
     * getter   
     * @return devuelve el dni del cliente
     */  
	public String getDni() {
		return dni;
	}
	
	/** 
     * Setter Modifica el dni
     * @param dni es el dni que se le asignará al cliente 
     */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/** 
     * getter   
     * @return devuelve el nombre del cliente
     */  
	public String getNom() {
		return nom;
	}
	/** 
     * Setter Modifica el nombre del cliente
     * @param nom es el nombre que se le asignará al cliente 
     */
	public void setNom(String nom) {
		this.nom = nom;
	}
	  
	/** 
     * getter   
     * @return devuelve el correo del cliente
     */  
	public String getCorreu() {
		return correu;
	}
	
	/** 
     * Setter Modifica el correo
     * @param correu es el correo que se le asignará al cliente 
     */
	public void setCorreu(String correu) {
		this.correu = correu;
	}
	
	
    /**
     * Método que crea un duplicado de la instancia Clients.
     * @return clientes exactos a los nuestros. 
     */
    public Clients copia() {
  	  return(new Clients (dni, nom, correu)); 
    }
	
	
	/**
     * Método toString: convierte el contenido de la clase a un String.
     * @return el contenido del objeto como una cadena y separada por espacios.
     */
     public String toString() 
     { 
  	   return ("Client:\n Dni:"+ dni + "\n Nom: " +nom+ "\n Correu: " +correu + "\n" );
     }
	
     
    /**
	 * Método que comprueba si el dni es igual al que recibe por parámetro. 
	 * @param dni: DNI que se compara
	 * @return true: si el DNI es el mismo. False: si el DNI no es el mismo.
	 */
	public boolean esAquestDni(String dni){
		return(this.dni.equals(dni));
		}	
}
