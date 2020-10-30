package aplicacioIG;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Dades.*;
import aplicacioConsola.ProgramaPrincipal;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
	private LlistaReserva llistareserves= new LlistaReserva(50);
	private LlistaProductes llistaProductesAgencia = new LlistaProductes(50);
	private LlistaActivitats llistaActivitatsAgencia = new LlistaActivitats(50);
	private LlistaClients llistaClientsAgencia = new LlistaClients(50);
	private String dni;
	private data dataActual;
	
	private static final long serialVersionUID = 1L;

	private JPanel panellBotons = new JPanel();
	private JButton b1 = new JButton("Transports");
	private JButton b2 = new JButton("Circuits");
	private JButton b3 = new JButton("Mis Reservas");
	private JButton b4 = new JButton("Sortir");
	
	private JLabel frase = new JLabel("MENU PRINCIPAL: Agafa una opció");
	private JLabel frase2 = new JLabel("Benvingut!");
	

	
	
	// Constructor de la finestra, es a dir, la classe contenidora.
	public MenuPrincipal(String titol, String dni, data dataActual) {
		super("Menu Principal"); // Crida el constructor de la classe mare JFrame.
		this.dni=dni;
		this.dataActual=dataActual;
		inicialitzardades();
		iniComponents();
	}
	
	
	
	private void iniComponents() {
		// Obtenim la referï¿½ncia a l'objecte "contenidor" de la finestra.
		Container container = getContentPane();
		
		// Forcem la disposiciï¿½ dels objectes que contindrï¿½ el contenidor
		// de la finestra principal al tipus "BorderLayout"
		container.setLayout(new BorderLayout());
		// Afegim els dos control al contenidor principal.
		
		
		// Forcem la disposiciï¿½ dels objectes continguts en el panell.
		panellBotons.setLayout(new FlowLayout());
		// Afegim els botons al panell.
		panellBotons.add(b1);
		panellBotons.add(b2);
		panellBotons.add(b3);
		panellBotons.add(b4);

		
		// Afegim el panell a la finestra.
		container.add(panellBotons, BorderLayout.CENTER);
		container.add(frase, BorderLayout.SOUTH);
		container.add(frase2, BorderLayout.NORTH);

		// Classe de tractarï¿½ l'esdeveniment sobre el botï¿½.
		AccioDelBotoCircuit accioBotoCircuit = new AccioDelBotoCircuit(this,dni,dataActual);
		AccioDelBotoTransport accioBotoTransport = new AccioDelBotoTransport(this,dni,dataActual);
		AccioDelBotoMreservas accioBotoMisReservas = new AccioDelBotoMreservas(this,dni,dataActual);
		// Indiquem que cada botï¿½ utilitzi la classe anterior per tractar l'esdeveniment.
		// NOTA: Cada botï¿½ pot tenir una classe diferent per tractar el seu esdeveniment.
		b1.addActionListener(accioBotoTransport);
		b2.addActionListener(accioBotoCircuit);
		b3.addActionListener(accioBotoMisReservas);
		b4.addActionListener( new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	        	   setVisible(false);
	        	   new Finestra1("Finestra1",dataActual);
	               
	           }
	        });
		//texte.addActionListener(accioTextField);
		
		// Necessari per alliberar la memï¿½ria quan tanquem la finestra.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Forcem les mides de l'objecte contenidor, es a dir, la finestra.
		setSize(300,150);
		// Fem la finestra visible.
		setVisible(true);
	}
	private void inicialitzardades() {
		ProgramaPrincipal.llegirFitxerCircuits(llistaProductesAgencia);
		ProgramaPrincipal.llegirFitxerTransport(llistaProductesAgencia);
		ProgramaPrincipal.llegirFitxerActivitats(llistaActivitatsAgencia);
		ProgramaPrincipal.llegirFitxerClients(llistaClientsAgencia);
		ProgramaPrincipal.LlegirFitxerReserves(llistareserves);
	}
	
	public LlistaReserva getLlistareserves() {
		return llistareserves;
	}
	public LlistaProductes getLlistaProductesAgencia() {
		return llistaProductesAgencia;
	}
	public LlistaActivitats getLlistaActivitatsAgencia() {
		return llistaActivitatsAgencia;
	}
	public LlistaClients getLlistaClientsAgencia() {
		return llistaClientsAgencia;
	}	
}
