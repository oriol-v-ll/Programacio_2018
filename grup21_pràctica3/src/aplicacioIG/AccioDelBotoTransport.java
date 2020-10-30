package aplicacioIG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dades.data;


public class AccioDelBotoTransport implements ActionListener {
	private String dni;
	private data dataActual;
	private MenuPrincipal finestra;
	
	public AccioDelBotoTransport(MenuPrincipal finestra,String dni, data dataActual) {
		this.finestra = finestra;
		this.dni=dni;
		this.dataActual=dataActual;
	}
	
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		new Transport("Transport",finestra.getLlistaProductesAgencia(),dni,dataActual);
		finestra.setVisible(false);
		
	}

}


