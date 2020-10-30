package aplicacioIG;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Dades.*;




public class MisReservas extends JFrame {
	private LlistaReserva reserves;
	private String dni;
	private data dataActual;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel frase = new JLabel("Mis Reservas:");
	
	public MisReservas(String titol,LlistaReserva p,String dni, data dataActual) {
		
		super("Mis Reservas");
		this.dni=dni;
		this.dataActual=dataActual;
		reserves = p;
		
		JButton tornar = new JButton("Tornar");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		contentPane.add(frase, BorderLayout.NORTH);
		contentPane.add(tornar, BorderLayout.SOUTH);
		
		//funcions del boton tornar
		tornar.addActionListener( new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	        	   setVisible(false);
	               new MenuPrincipal("MenuPrincipal",dni,dataActual);
	           }
	        });
		
		DefaultListModel<String> m = new DefaultListModel<String>();
		JList<String> list = new JList<String>(m);
		scrollPane.setViewportView(list);
		
		Reserves reservesEscriure[]=new Reserves[reserves.getNumReserves()];
		reservesEscriure=reserves.BuscadorDni(dni);
		for (int i=0; i < reserves.getNumReserves() ; i++)
			if(reservesEscriure[i]!=null)
			{
				m.addElement(reservesEscriure[i].toString());
			}
		
		
		// Necessari per alliberar la mem�ria quan tanquem la finestra.
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Forcem les mides de l'objecte contenidor, es a dir, la finestra.
			setSize(800,500);
		// Fem la finestra visible.
			setVisible(true);

		
	}
	

}