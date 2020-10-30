package aplicacioIG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Dades.*;
import Excepcions.DniRepetido;
import aplicacioConsola.ProgramaPrincipal;


public class FinestraRegistrarse extends JFrame {
	  private static final long serialVersionUID = 1L;
	  private LlistaClients llistaClientsAgencia = new LlistaClients(50);
	  private JLabel Dni, nom, correu;
	  private JTextField nomF, DniF, correuF;
	  private boolean ok;
	  private String dni;
	  private data dataActual;
	  
	  public FinestraRegistrarse(String titol,String dni,data dataActual) {
		  super("Crear un compte"); // Crida el constructor de la classe mare JFrame.
		  this.dni=dni;
		  this.dataActual=dataActual;
		  // Inicialment l'usuari no ha entrat dades.
		    ok = false;
			 inicialitzarDades();
		    // Creem els components que es veuran
		    Dni = new JLabel("Dni:");
		    nom = new JLabel("Nom:");
		    correu = new JLabel("Correu:");
		    DniF = new JTextField(10);
		    nomF = new JTextField(10);
		    correuF = new JTextField(10);
		    // Creem el contenidor per als controls
		    JPanel controls = new JPanel(new GridLayout(3,2));
		    controls.add(Dni);
		    controls.add(DniF);
		    controls.add(nom);
		    controls.add(nomF);
		    controls.add(correu);
		    controls.add(correuF);
		 // Creem els botons Registrarse/Tornar
		    JButton Registrarse = new JButton("Registrarse");
		    JButton Tornar = new JButton("Tornar");
		    
		    //Funcions dels botons.
		    Registrarse.addActionListener( new ActionListener() {
		           public void actionPerformed(ActionEvent e) {
		               ok = true;
		               String dniUsuari=DniF.getText();
		               String nomUsuari=nomF.getText();
		               String correuUsuari=correuF.getText();
		               Clients aux=new Clients(dniUsuari,nomUsuari,correuUsuari);
		               try {
			               llistaClientsAgencia.afegirDadaClientALlista(aux);
		               } catch(DniRepetido h) {}
		               
		               setVisible(false);
		               JOptionPane.showMessageDialog(null,dniUsuari + "\n Registre Completat!", "Registre Completat!",JOptionPane.INFORMATION_MESSAGE);
		               new MenuPrincipal("Menu Principal",dni,dataActual);
		               guardaDades();
		           }
		        });
		    Tornar.addActionListener( new ActionListener() {
		           public void actionPerformed(ActionEvent e) {
		               ok = false;
		               setVisible(false);
		               new Finestra1("Finestra1",dataActual);
		           }
		        });
		    
		 // Creem un contenidor on posarem els botons Acceptar/Cancelar.
		    JPanel botons = new JPanel(new FlowLayout());
		    botons.add(Registrarse);
		    botons.add(Tornar);
		    
		    //Agafem el contenidor Principal:
		    Container c = getContentPane();
		    c.add(controls, BorderLayout.CENTER);
		    c.add(botons, BorderLayout.SOUTH);

		    pack();
		    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		    setVisible(true);
		  }
		  
		public JTextField getNomF() {
			return nomF;
		}
		public void setNomF(JTextField nomF) {
			this.nomF = nomF;
		}
		public JTextField getDniF() {
			return DniF;
		}
		public void setDniF(JTextField dniF) {
			DniF = dniF;
		}
		public JTextField getCorreuF() {
			return correuF;
		}
		public void setCorreuF(JTextField correuF) {
			this.correuF = correuF;
		}
		public boolean isOk() {
			return ok;
		}
		public void setOk(boolean ok) {
			this.ok = ok;
		}
		private void inicialitzarDades() {
			ProgramaPrincipal.llegirFitxerClients(llistaClientsAgencia);
		}
		private void guardaDades() {
			ProgramaPrincipal.guardaClients(llistaClientsAgencia);
		}

}
