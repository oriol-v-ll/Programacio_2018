package Excepcions;

public class DataNoValida extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DataNoValida() {
		super("ERROR La data introduida no és correcta");
	}
}
