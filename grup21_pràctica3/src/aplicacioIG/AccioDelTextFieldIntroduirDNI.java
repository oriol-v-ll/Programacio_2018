package aplicacioIG;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dades.*;
public class AccioDelTextFieldIntroduirDNI implements ActionListener{

	private Clients[] clients;
	private Finestra1 finestra;
	
	public AccioDelTextFieldIntroduirDNI(Finestra1 finestra) {
		this.finestra=finestra;
	}
	
	public void actionPerformed(ActionEvent evt) {
		clients=finestra.getLlistaClientsAgencia();
		data dataActual=new data();
		dataActual=finestra.getDataActual();
		int i=0;
		boolean trobat=false;
		JTextField tf = (JTextField) evt.getSource();
		String dni = tf.getText();
		while(i<clients.length && !trobat)
		{
			if(clients[i]!=null)
			{
				if(clients[i].esAquestDni(dni))
				{
					trobat=true;
				}
			}
			i++;
		}
		if(trobat)
		{
			JOptionPane.showMessageDialog(null, "Hola "+dni+"!", "Benvinguda", JOptionPane.INFORMATION_MESSAGE);
			new MenuPrincipal("Menu Principal",dni,dataActual);
			finestra.setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(null, "No hi esteu registrat! !", "ATENCIÓ!", JOptionPane.WARNING_MESSAGE);
			new FinestraRegistrarse("Registrarse",dni,dataActual);
			finestra.setVisible(false);
		}
	}

}
