package Excepcions;

/**
 * Definimos la excepci�n
 * @author Bernat Sort
 */
	
public class DniRepetido extends Exception {
	private static final long serialVersionUID=1L; //Para quitar el warning

	public DniRepetido(String dni){
		//Asignamos un mensaje a nuestra excepci�n
		super("El dni " + dni+  " ja est� donat d'alta, client repetit \n");
		}	
	}
