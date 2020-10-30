package Excepcions;

/**
 * Definimos la excepción
 * @author Bernat Sort
 */
	
public class DniRepetido extends Exception {
	private static final long serialVersionUID=1L; //Para quitar el warning

	public DniRepetido(String dni){
		//Asignamos un mensaje a nuestra excepción
		super("El dni " + dni+  " ja està donat d'alta, client repetit \n");
		}	
	}
