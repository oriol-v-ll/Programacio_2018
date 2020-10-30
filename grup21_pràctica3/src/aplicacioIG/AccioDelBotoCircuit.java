package aplicacioIG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dades.*;


public class AccioDelBotoCircuit implements ActionListener {
	private String dni;
	private data dataActual;
	private MenuPrincipal finestra;
	
	public AccioDelBotoCircuit(MenuPrincipal finestra,String dni, data dataActual) {
		this.finestra = finestra;
		this.dni=dni;
		this.dataActual=dataActual;
	}
	
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		new Fcircuits("Mis Circuits", finestra.getLlistaProductesAgencia(),dni,dataActual);
		finestra.setVisible(false);
		
	}

}
