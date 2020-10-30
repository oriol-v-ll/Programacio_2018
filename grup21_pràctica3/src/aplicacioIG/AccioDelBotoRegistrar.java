package aplicacioIG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dades.*;
//import javax.swing.JTextField;

public class AccioDelBotoRegistrar implements ActionListener {
	private Finestra1 finestra;
	private String dni;
	private data dataActual;
	
	public AccioDelBotoRegistrar(Finestra1 finestra,String dni, data dataActual) {
		this.finestra = finestra;
		this.dni=dni;
		this.dataActual=dataActual;
	}
	
	public void actionPerformed(ActionEvent evt) {
		new FinestraRegistrarse("Registrarse",dni,dataActual);
		finestra.setVisible(false);
	}

}
