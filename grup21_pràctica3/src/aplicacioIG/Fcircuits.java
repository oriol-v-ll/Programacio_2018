package aplicacioIG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Dades.*;

public class Fcircuits extends JFrame {
	private LlistaProductes producte;
	private String dni;
	private data dataActual;
	private static final long serialVersionUID = 1L;
	private JLabel Desti, DataArribada;

	private JTextField DestiF, DataArribadadiaF, DataArribadamesF, DataArribadaanyF;
	private JPanel panellBotons = new JPanel();
	private JTextArea area = new JTextArea();
	JScrollPane scrollPane = new JScrollPane();

	// private JLabel origen = new JLabel();

	public Fcircuits(String titol, LlistaProductes p,String dni, data dataActual) {
		super("Circuits"); // Crida el constructor de la classe mare JFrame.
		producte = p;
		this.dni=dni;
		this.dataActual=dataActual;
		// Inicialment l'usuari no ha entrat dades.

		// Creem els components que es veuran
		Desti = new JLabel("Desti:");
		DataArribada = new JLabel("Data de Arribada:");
		DestiF = new JTextField(10);
		DataArribadadiaF = new JTextField(10);
		DataArribadamesF = new JTextField(10);
		DataArribadaanyF = new JTextField(10);

		// Creem el contenidor per als controls
		panellBotons.setLayout(new FlowLayout());
		panellBotons.add(DataArribadadiaF);
		panellBotons.add(DataArribadamesF);
		panellBotons.add(DataArribadaanyF);
		JPanel controls = new JPanel(new GridLayout(3, 2));
		controls.add(Desti);
		controls.add(DestiF);
		controls.add(DataArribada);
		controls.add(panellBotons);
		// Creem els botons Cercar/Tornar
		JButton Cercar = new JButton("Cercar");
		JButton Tornar = new JButton("Tornar");

		// Creem un contenidor on posarem els botons Cercar/Tornar.
		JPanel botons = new JPanel(new FlowLayout());
		botons.add(Cercar);
		botons.add(Tornar);

		// Agafem el contenidor Principal:
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
				String Desti = DestiF.getText();
				;
				String DataOfDia = DataArribadadiaF.getText();
				int DataOferimentDia = Integer.parseInt(DataOfDia);
				String DataOfMes = DataArribadamesF.getText();
				int DataOferimentMes = Integer.parseInt(DataOfMes);
				String DataOfAny = DataArribadaanyF.getText();
				int DataOferimentAny = Integer.parseInt(DataOfAny);
				for (int i = 0; i < producte.getNumElements(); i++) {
					if (producte.getLlista()[i] instanceof circuit) {
						int places = producte.getLlista()[i].getNumeroPlacesDisponibles();
						String pais = (((circuit) producte.getLlista()[i]).getPais());
						int dia = (((circuit) producte.getLlista()[i]).getDataOferiment().getDia());
						int mes = (((circuit) producte.getLlista()[i]).getDataOferiment().getMes());
						int any = (((circuit) producte.getLlista()[i]).getDataOferiment().getAny());
						if (places > 0 && pais.equalsIgnoreCase(Desti) && dia == DataOferimentDia
								&& mes == DataOferimentMes && any == DataOferimentAny) {
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
		return DataArribadadiaF;
	}

	public JTextField getDataArribadamesF() {
		return DataArribadamesF;
	}

	public JTextField getDataArribadaanyF() {
		return DataArribadaanyF;
	}

	public void afegirTextArea(String s) {
		this.area.append(s + "\n");
	}

}
