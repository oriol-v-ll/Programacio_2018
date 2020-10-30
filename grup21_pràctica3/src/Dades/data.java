package Dades;

import java.io.Serializable;

/**
 * Classe que guardarà les dates del projecte per poder fer consultes i buscar
 * els productes que puguin ser triats per la data actual que s'escriurà pel
 * main
 * 
 * @author Oriol Villanova Llorens
 *
 */
public class data implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int dia;
	private int mes;
	private int any;

	/**
	 * Constructor per defecte de la classe.
	 */
	public data() {
		dia = 0;
		mes = 0;
		any = 0;
	}

	/**
	 * Constructor passant els pràmetres de la classe.
	 * 
	 * @param dia dia
	 * @param mes mes
	 * @param any any
	 */
	public data(int dia, int mes, int any) {
		this.dia = dia;
		this.mes = mes;
		this.any = any;

	}

	/**
	 * Metode per comprobar si dos date son iguals
	 * 
	 * @param aComprobar - la data que volem comprobar
	 * @return - true si son iguals, false si no.
	 */
	public boolean compararDates(data aComprobar) {
		boolean soniguals = false;

		if (aComprobar.getDia() == dia)
			if (aComprobar.getMes() == mes)
				if (aComprobar.getAny() == any)
					soniguals = true;

		return soniguals;
	}

	/**
	 * Metode per comprobar si una data enviada per paràmetre es superior a l'actual
	 * @param aComprobar la data que es vol comprobar.
	 * @return true si es superior, false si es inferior.
	 */
	public boolean esPosterior(data aComprobar) {
		
		boolean esPosterior = false;
		if (any>aComprobar.getAny())
			esPosterior=true;
		else if(any==aComprobar.getAny())
			if (mes>aComprobar.getMes())
				esPosterior=true;
			else if(mes==aComprobar.getMes())
				if (dia>=aComprobar.getDia())
					esPosterior = true;
		return esPosterior;
	}

	/**
	 * Getters i setters de tots els atributs de la classe data.
	 * 
	 * 
	 */
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}

}
