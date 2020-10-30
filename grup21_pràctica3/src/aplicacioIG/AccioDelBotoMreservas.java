package aplicacioIG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dades.*;


public class AccioDelBotoMreservas implements ActionListener {
	//private Finestra1 finestra;
	//private JTextField dni = finestra.getText();
	private MenuPrincipal finestra;
	private String dni;
	private data dataActual;
	
	public AccioDelBotoMreservas(MenuPrincipal finestra,String dni,data dataActual) {
		this.finestra = finestra;
		this.dni=dni;
		this.dataActual=dataActual;
	}
	
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		new MisReservas("Mis Reservas", finestra.getLlistareserves(),dni,dataActual);
		finestra.setVisible(false);
		
	}

}
