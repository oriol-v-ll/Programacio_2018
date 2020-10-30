package Excepcions;
import Dades.Productes;

public class ProducteCaducatException extends Exception {
	private static final long serialVersionUID=1L; //Para quitar el warning

	public ProducteCaducatException(Productes p){
		//Asignamos un mensaje a nuestra excepci�n
		super("ERROR El producte:" + p.getNom()+  "esta caducat.");
		}	
}
