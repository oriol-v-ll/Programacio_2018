package aplicacioIG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Dades.*;

public class Transport extends JFrame {
	private LlistaProductes producte;
	private String dni;
	private data dataActual;
	private static final long serialVersionUID = 1L;
	private JLabel Origen, Desti, DataSortida;
	private JTextField OrigenF, DestiF, DataSortidadiaF, DataSortidamesF, DataSortidaanyF;
	private JPanel panellBotons = new JPanel();
	private JTextArea area = new JTextArea();
	JScrollPane scrollPane = new JScrollPane();

	public Transport(String titol, LlistaProductes p, String dni, data dataActual) {
		super("Transports"); // Crida el constructor de la classe mare JFrame.
		producte = p;
		this.dni=dni;
		this.dataActual=dataActual;
		// Inicialment l'usuari no ha entrat dades.

		// Creem els components que es veuran
		Origen = new JLabel("Origen:");
		Desti = new JLabel("Destí:");
		DataSortida = new JLabel("Data de Sortida:");
		OrigenF = new JTextField(10);
		DestiF = new JTextField(10);
		DataSortidadiaF = new JTextField(10);
		DataSortidamesF = new JTextField(10);
		DataSortidaanyF = new JTextField(10);

		panellBotons.setLayout(new FlowLayout());
		panellBotons.add(DataSortidadiaF);
		panellBotons.add(DataSortidamesF);
		panellBotons.add(DataSortidaanyF);
		// Creem el contenidor per als controls
		JPanel controls = new JPanel(new GridLayout(3, 2));
		controls.add(Origen);
		controls.add(OrigenF);
		controls.add(Desti);
		controls.add(DestiF);
		controls.add(DataSortida);
		controls.add(panellBotons);
		// Creem els botons Registrarse/Tornar
		JButton Cercar = new JButton("Cercar");
		JButton Tornar = new JButton("Tornar");
		
		// Creem un contenidor on posarem els botons Acceptar/Cancelar.
		JPanel botons = new JPanel(new FlowLayout());
		botons.add(Cercar);
		botons.add(Tornar);
		
		// Agafem el contenidor Principal:
		// Agafem el contenidor principal
		Container c = getContentPane();
		c.add(controls, BorderLayout.NORTH);
		c.add(botons, BorderLayout.SOUTH);
		c.add(scrollPane, BorderLayout.CENTER);
		c.add(area, BorderLayout.EAST);

		DefaultListModel<String> m = new DefaultListModel<String>();
		JList<String> list = new JList<String>(m);
		list.addListSelectionListener(e -> {
			circuit cir = (circuit) producte.getLlista()[list.getSelectedIndex()];
			area.setText(cir.getNom());
		});
		scrollPane.setViewportView(list);
		// Funcions dels botons.
		Cercar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String origen = OrigenF.getText();
				String Desti = DestiF.getText();
				String DataOfDia = DataSortidadiaF.getText();
				int DiaSortida = Integer.parseInt(DataOfDia);
				String DataOfMes = DataSortidamesF.getText();
				int MesSortida = Integer.parseInt(DataOfMes);
				String DataOfAny = DataSortidaanyF.getText();
				int AnySortida = Integer.parseInt(DataOfAny);
				for (int i = 0; i < producte.getNumElements(); i++) {
					if (producte.getLlista()[i] instanceof transport) {
						int places = producte.getLlista()[i].getNumeroPlacesDisponibles();
						String origenLlista = (((transport) producte.getLlista()[i]).getCiutatOrigen());
						String destiLlista = (((transport) producte.getLlista()[i]).getCiutatDesti());
						int dia = (((transport) producte.getLlista()[i]).getData_entrada().getDia());
						int mes = (((transport) producte.getLlista()[i]).getData_entrada().getMes());
						int any = (((transport) producte.getLlista()[i]).getData_entrada().getAny());
						if (places > 0 && origenLlista.equalsIgnoreCase(origen) && destiLlista.equalsIgnoreCase(Desti)
								&& dia == DiaSortida && mes == MesSortida && any == AnySortida) {
							m.addElement(producte.getLlista()[i].toString());
						}
					}
				}
			}
		});
		Tornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MenuPrincipal("MenuPrincipal",dni,dataActual);
			}
		});
		pack();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
	}
	
	public JTextField getDestiF() {
		return DestiF;
	}

	public JTextField getDataArribadadiaF() {
		return DataSortidadiaF;
	}

	public JTextField getDataArribadamesF() {
		return DataSortidamesF;
	}

	public JTextField getDataArribadaanyF() {
		return DataSortidaanyF;
	}
}