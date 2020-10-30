package Excepcions;

public class ValorForaRang extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ValorForaRang() {
		super("El valor introduit no es troba dins dels paràmetres adecuats");
	}
}
