package aplicacioIG;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

import Dades.*;
import aplicacioConsola.ProgramaPrincipal;


public class Finestra1 extends JFrame {
	private LlistaClients llistaClientsAgencia = new LlistaClients(50);
	private data dataActual=new data();
	private static final long serialVersionUID = 1L;

	private JTextField text = new JTextField(10);
	private JPanel panelltext = new JPanel();
	private JLabel frase;

	// Constructor de la finestra
	public Finestra1(String titol,data dataActual) {
		super("Iniciar Sessió"); // Crida el constructor de la classe mare JFrame.
		this.dataActual=dataActual;
		inicialitzardades();
		iniComponents();
	}

	private void iniComponents() {
		// Obtenim la referència a l'objecte "contenidor" de la finestra.
		Container container = getContentPane();

		// Forcem la disposició dels objectes que contindrà el contenidor al tipus
		// "BorderLayout"
		container.setLayout(new BorderLayout());

		// Ara ja podem afegir els objectes no contenidors en l'objecte contenidor.
		// La disposició dels objectes en el contenidor es farà en "BorderLayout".

		frase = new JLabel("Introdueix el teu DNI:");
		container.add(frase, BorderLayout.NORTH);

		panelltext.setLayout(new FlowLayout());
		panelltext.add(text);
		container.add(panelltext, BorderLayout.CENTER);

		// Classe de tractarà l'esdeveniment sobre el botó.
		AccioDelTextFieldIntroduirDNI accioTextField = new AccioDelTextFieldIntroduirDNI(this);
		text.addActionListener(accioTextField);

		// Necessari per alliberar la memòria quan tanquem la finestra.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Forcem les mides de l'objecte contenidor, es a dir, la finestra.
		setSize(300, 120);
		// Fem la finestra visible.
		setVisible(true);

	}

	private void inicialitzardades() {
		ProgramaPrincipal.llegirFitxerClients(llistaClientsAgencia);
	}
	
	public Clients[] getLlistaClientsAgencia() {
		return llistaClientsAgencia.getLlistaClients();
	}	
	
	public data getDataActual() {
		return dataActual;
	}
}
