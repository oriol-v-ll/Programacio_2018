package aplicacioConsola;

/**
 * 
 * @author Alejandro Teodoro
 *
 */
import java.io.*;
import java.util.*;

import Dades.*;
import Excepcions.*;
import aplicacioIG.*;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		Scanner teclat = new Scanner(System.in);
		int opcio = 0, dia, mes, any;
		data dataActual = null;
		while (dataActual == null) {
			
			
			try {
				System.out.println("Introdueix el dia d'avui");
				dia = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix el mes");
				mes = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix l'any");
				any = Integer.parseInt(teclat.nextLine());
				if (dia < 1 || dia > 31 || mes < 1 || mes > 12)
					throw new DataNoValida();
				dataActual = new data(dia, mes, any);
			} catch (NumberFormatException e) {
				System.out.println("ERROR Has d'introduir un valor num�ric\n\n");
			} catch (DataNoValida e) {
				System.out.println(e.getMessage());
			}
		}
		LlistaProductes llistaProductesAgencia = new LlistaProductes(50);
		LlistaActivitats llistaActivitatsAgencia = new LlistaActivitats(50);
		LlistaClients llistaClientsAgencia = new LlistaClients(50);
		LlistaReserva llistaReservesAgencia = new LlistaReserva(50);
		llegirFitxerCircuits(llistaProductesAgencia);
		llegirFitxerTransport(llistaProductesAgencia);
		llegirFitxerActivitats(llistaActivitatsAgencia);
		llegirFitxerClients(llistaClientsAgencia);
		LlegirFitxerReserves(llistaReservesAgencia);
		System.out.println("Quina aplicaci� vols obrir?\n");
		System.out.println("\t1. Aplicaci� per a l'ag�ncia de viatges\n");
		System.out.println("\t2. Aplicaci� per als clients\n");
		System.out.println("\t3. Tancar el programa\n");
		while (opcio != 3) {
			try {
				opcio = Integer.parseInt(teclat.nextLine());
				if (opcio < 1 || opcio > 3) {
					throw new ValorForaRang();
				}
				switch (opcio) {
				case 1:
					menuAgencia(llistaProductesAgencia, llistaActivitatsAgencia, llistaClientsAgencia,
							llistaReservesAgencia, dataActual, teclat);
					break;
				case 2:
					new Finestra1("Iniciar sesion",dataActual);
					break;
				case 3:
					break;
				}
				System.out.println("Quina aplicaci� vols obrir?\n");
				System.out.println("\t1. Aplicaci� per a l'ag�ncia de viatges\n");
				System.out.println("\t2. Aplicaci� per als clients\n");
				System.out.println("\t3. Tancar el programa\n");
			} catch (ValorForaRang e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("ERROR Has d'introduir un valor num�ric");
			}

		}
		teclat.close();
	}

	// metode que inicia el menu de l'agencia
	public static void menuAgencia(LlistaProductes llistaProductesAgencia, LlistaActivitats llistaActivitatsAgencia,
			LlistaClients llistaClientsAgencia, LlistaReserva llistaReservesAgencia, data DataActual, Scanner teclat) {
		int opcio = 0;
		mostraMenuAgencia();
		while (opcio != 14) {
			try {
				opcio = Integer.parseInt(teclat.nextLine());
				if (opcio < 1 || opcio > 14) {
					throw new ValorForaRang();
				}
				while (opcio != 14) {
					switch (opcio) {
					case 1:
						afegirTransport(llistaProductesAgencia, teclat);
						break;
					case 2:
						afegirCircuit(llistaProductesAgencia, teclat);
						break;
					case 3:
						afegirActivitat(llistaActivitatsAgencia, teclat);
						break;
					case 4:
						altaClient(llistaClientsAgencia, teclat);
						break;
					case 5:
						baixaClient(llistaClientsAgencia, llistaReservesAgencia, teclat);
						break;
					case 6:
						productesReservats(llistaReservesAgencia);
						break;
					case 7:
						productesDisponibles(llistaProductesAgencia);
						break;
					case 8:
						productesNoCaducats(llistaProductesAgencia, DataActual);
						break;
					case 9:
						producteMesReserves(llistaReservesAgencia);
						break;
					case 10:
						mostraProductes(llistaProductesAgencia);
						break;
					case 11:
						mostraActivitats(llistaActivitatsAgencia);
						break;
					case 12:
						mostraClients(llistaClientsAgencia);
						break;
					case 13:
						mostraReserves(llistaReservesAgencia);
						break;
					case 14:
						break;
					}
					mostraMenuAgencia();
					opcio = Integer.parseInt(teclat.nextLine());
					if (opcio < 1 || opcio > 14) {
						throw new ValorForaRang();
					}
				}
				System.out.println("Programa tancat");
				guardaActivitats(llistaActivitatsAgencia);
				guardaClients(llistaClientsAgencia);
				guardaProductes(llistaProductesAgencia);
				guardaReserves(llistaReservesAgencia);
			} catch (ValorForaRang e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("ERROR Has d'introduir un valor num�ric");
			}
		}
	}

	// metode que mostra el menu de l'agencia per pantalla
	public static void mostraMenuAgencia() {
		System.out.println("Opcions del men�: \n");
		System.out.println("\t1. Afegir un transport\n");
		System.out.println("\t2. Afegir un circuit\n");
		System.out.println("\t3. Afegir una activitat\n");
		System.out.println("\t4. Donar d'alta un client\n");
		System.out.println("\t5. Donar de baixa un client\n");
		System.out.println("\t6. Mostrar els productes de viatge amb alguna reserva\n");
		System.out.println("\t7. Mostrar els productes de viatge amb places disponibles\n");
		System.out.println("\t8. Mostrar els productes de viatge no caducats\n");
		System.out.println("\t9. Mostrar el producte de viatge amb m�s reserves\n");
		System.out.println("\t10. Mostrar la llista de productes\n");
		System.out.println("\t11. Mostrar la llista d'activitats\n");
		System.out.println("\t12. Mostrar la llista de clients\n");
		System.out.println("\t13. Mostrar la llista de reserves\n");
		System.out.println("\t14. Tancar programa\n");
		System.out.println("\tSelecciona una opci�: ");
	}

	// opcio 1 del menu que afegeix un transport a la llista de productes
	public static void afegirTransport(LlistaProductes aux, Scanner teclat) {
		String nomTransport = "", tipusTransport = "", ciutatOrigen = "", ciutatDesti = "";
		double preuTransport = 0;
		int numPlaces = 0, dia = 0, mes = 0, any = 0;
		data dataSortida = null, dataTornada = null;
		transport transportAfegir = null;
		while (transportAfegir == null) {
			try {
				System.out.println("Introdueix el nom del transport ");
				nomTransport = teclat.nextLine();
				System.out.println("Introdueix el tipus de transport");
				tipusTransport = teclat.nextLine();
				System.out.println("Introdueix el preu del transport");
				preuTransport = Double.parseDouble(teclat.nextLine());
				System.out.println("Introdueix el nombre de places");
				numPlaces = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix la ciutat d'origen");
				ciutatOrigen = teclat.nextLine();
				System.out.println("Introdueix la ciutat dest�");
				ciutatDesti = teclat.nextLine();
				System.out.println("Introdueix el dia de sortida");
				dia = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix el mes de sortida");
				mes = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix l'any de sortida");
				any = Integer.parseInt(teclat.nextLine());
				if (dia < 1 || dia > 31 || mes < 1 || mes > 12)
					throw new DataNoValida();
				dataSortida = new data(dia, mes, any);
				System.out.println("Introdueix el dia d'arribada");
				dia = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix el mes d'arribada");
				mes = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix l'any d'arribada");
				any = Integer.parseInt(teclat.nextLine());
				if (dia < 1 || dia > 31 || mes < 1 || mes > 12)
					throw new DataNoValida();
				dataTornada = new data(dia, mes, any);
				transportAfegir = new transport(nomTransport, tipusTransport, preuTransport, numPlaces, numPlaces,
						ciutatOrigen, ciutatDesti, dataSortida, dataTornada);
				aux.afegirTransport(transportAfegir);
			} catch (NumberFormatException e) {
				System.out.println("ERROR Has d'introduir un valor num�ric ");
			} catch (DataNoValida e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// opcio 2 del menu que afegeix un circuit a la llista de productes
	public static void afegirCircuit(LlistaProductes aux, Scanner teclat) {
		String nomCircuit = "", tipusCircuit = "", pais = "";
		double preuCircuit = 0;
		int numPlaces = 0, dies = 0, numActivitats = 0, codiActivitat = 0, dia = 0, mes = 0, any = 0;
		data dataInici = null, dataFinal = null;
		circuit circuitAfegir = null;
		while (circuitAfegir == null) {
			try {
				System.out.println("Introdueix el nom del circuit ");
				nomCircuit = teclat.nextLine();
				System.out.println("Introdueix el tipus de circuit");
				tipusCircuit = teclat.nextLine();
				System.out.println("Introdueix el preu del circuit");
				preuCircuit = Double.parseDouble(teclat.nextLine());
				System.out.println("Introdueix el nombre de places");
				numPlaces = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix el pa�s on es desenvolupar� el circuit");
				pais = teclat.nextLine();
				System.out.println("Introdueix la duraci� del circuit");
				dies = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix el dia d'inici");
				dia = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix el mes d'inici");
				mes = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix l'any d'inici");
				any = Integer.parseInt(teclat.nextLine());
				if (dia < 1 || dia > 31 || mes < 1 || mes > 12)
					throw new DataNoValida();
				dataInici = new data(dia, mes, any);
				System.out.println("Introdueix el dia d'acabament");
				dia = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix el mes d'acabament");
				mes = Integer.parseInt(teclat.nextLine());
				System.out.println("Introdueix l'any d'acabament");
				any = Integer.parseInt(teclat.nextLine());
				if (dia < 1 || dia > 31 || mes < 1 || mes > 12)
					throw new DataNoValida();
				dataFinal = new data(dia, mes, any);
				circuitAfegir = new circuit(nomCircuit, tipusCircuit, preuCircuit, numPlaces, numPlaces, pais, dies,
						dataInici, dataFinal, 50);
			} catch (NumberFormatException e) {
				System.out.println("ERROR Has d'introduir un valor num�ric ");
			} catch (DataNoValida e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Introdueix el nombre d'activitats del circuit");
		numActivitats = Integer.parseInt(teclat.nextLine());
		for (int i = 0; i < numActivitats; i++) {
			System.out.println("Introdueix el nombre de l'activitat que vols afegir al circuit");
			codiActivitat = Integer.parseInt(teclat.nextLine());
			circuitAfegir.afegirActivitat(codiActivitat);
		}
		aux.afegirCircuit(circuitAfegir);
	}

	// opcio 3 del menu que afegeix una activitat a la llista d'activitats
	public static void afegirActivitat(LlistaActivitats aux, Scanner teclat) {
		String nomActivitat, descripcioActivitat, llocActivitat;
		System.out.println("Introdueix el nom de l'activitat que vols afegir");
		nomActivitat = teclat.nextLine();
		System.out.println("Introdueix una descripcio de l'activitat");
		descripcioActivitat = teclat.nextLine();
		System.out.println("Introdueix el lloc on es desenvolupar� l'activitat");
		llocActivitat = teclat.nextLine();
		Activitat activitatAfegir = new Activitat(nomActivitat, descripcioActivitat, llocActivitat);
		aux.afegirActivitat(activitatAfegir);
	}

	// opcio 4 del menu que afegeix un client a la llista de clients
	public static void altaClient(LlistaClients aux, Scanner teclat) {
		String dni, nom, correu;
		System.out.println("Intrdueix el DNI del client nou");
		dni = teclat.nextLine();
		System.out.println("Intrdueix el nom del client nou");
		nom = teclat.nextLine();
		System.out.println("Intrdueix el correu del client nou");
		correu = teclat.nextLine();
		Clients clientAfegir = new Clients(dni, nom, correu);
		try {
			aux.afegirDadaClientALlista(clientAfegir);
		} catch (DniRepetido e) {
			System.out.println(e.getMessage());
		}
	}

	// opcio 5 del menu que borra un client i les seves reserves de la llista de
	// clients i reserves respectivament
	public static void baixaClient(LlistaClients aux, LlistaReserva aux2, Scanner teclat) {
		String dni;
		System.out.println("Introdueix el DNI del client que vols borrar");
		dni = teclat.nextLine();
		aux.esborrarInfoClient(dni);
		aux2.esborrarReserva(dni);
	}

	// Opcio numero 6 del menu que mostra tots els productes que tenen alguna
	// reserva i mostra les dades del client que l'ha fet
	public static void productesReservats(LlistaReserva aux) {
		String[] productesReservats= new String[aux.getNumReserves()];
		productesReservats=aux.ProductesReservats();
		for(int i=0;i<aux.getNumReserves();i++)
		{
			System.out.println(productesReservats[i]);
		}
	}

	// opcio numero 7 del menu que mostra una llista dels productes disponibles
	public static void productesDisponibles(LlistaProductes aux) {
		Productes[] productesDisponibles = new Productes[aux.getNumElements()];
		productesDisponibles = aux.tePlaces();
		for (int i = 0; i < aux.getNumElements(); i++) {
			if(productesDisponibles[i]!=null)
				System.out.println(productesDisponibles[i]);
		}
	}

	// opcio numero 8 del menu que mostra els productes no caducats
	public static void productesNoCaducats(LlistaProductes aux, data DataActual) {

		Productes[] productesNoCaducats = new Productes[aux.getNumElements()];
		productesNoCaducats = aux.llistaNoCaducats(DataActual);
		for (int i = 0; i < productesNoCaducats.length; i++) {
			if (productesNoCaducats[i] != null)
				System.out.println(productesNoCaducats[i]);
		}
	}

	// opcio 9 del menu que mostra el producte amb mes reserves
	public static void producteMesReserves(LlistaReserva aux) {
		System.out.println(Reserves.getMesReserva().toString());
	}

	// opcio 10 del menu que mostra el contingut de la llista de productes
	public static void mostraProductes(LlistaProductes aux) {
		System.out.println(aux.toString());
	}

	// opcio 11 del menu que mostra el contingut de la llista d'activitats
	public static void mostraActivitats(LlistaActivitats aux) {
		System.out.println(aux.toString());
	}

	// opcio 12 del menu que mostra el contingut de la llista de clients
	public static void mostraClients(LlistaClients aux) {
		System.out.println(aux.toString());
	}
	
	//opcio 13 del menu que mostra el contingut de la llista de reserves
	public static void mostraReserves(LlistaReserva aux) {
		System.out.println(aux.toString());
	}
	// metode que llegeix el fitxer de transport i guarda el contingut a la llista
	// de productes
	public static void llegirFitxerTransport(LlistaProductes llista) {
		String nomTransport, tipusTransport, ciutatOrigen, ciutatDesti;
		double preuTransport;
		int numPlaces, numeroPlacesDisponibles, diaSortida, mesSortida, anySortida, diaTornada, mesTornada, anyTornada;
		data dataSortida, dataTornada;
		try {
			Scanner lectura = new Scanner(new File("LlistaTransports.txt"));
			while (lectura.hasNext()) {
				String linia = lectura.nextLine();
				Scanner lin = new Scanner(linia);
				lin.useDelimiter(";");
				nomTransport = lin.next();
				tipusTransport = lin.next();
				preuTransport = lin.nextDouble();
				numPlaces = lin.nextInt();
				numeroPlacesDisponibles = lin.nextInt();
				ciutatOrigen = lin.next();
				ciutatDesti = lin.next();
				diaSortida = lin.nextInt();
				mesSortida = lin.nextInt();
				anySortida = lin.nextInt();
				dataSortida = new data(diaSortida, mesSortida, anySortida);
				diaTornada = lin.nextInt();
				mesTornada = lin.nextInt();
				anyTornada = lin.nextInt();
				dataTornada = new data(diaTornada, mesTornada, anyTornada);
				transport transportAfegir = new transport(nomTransport, tipusTransport, preuTransport, numPlaces,
						numeroPlacesDisponibles, ciutatOrigen, ciutatDesti, dataSortida, dataTornada);
				llista.afegirTransport(transportAfegir);
				lin.close();
			}
			lectura.close();
		} catch (IOException e) {
			System.out.println("El fitxer de transports no existeix ");
		} catch (NoSuchElementException e) {
			System.out.println("Error al obrir el fitxer de transports");
		}
	}

	// metode que llegeix el fitxer de circuits i guarda el seu contingut a la
	// llista de productes
	public static void llegirFitxerCircuits(LlistaProductes llista) {
		String nomCircuit, tipusCircuit, pais;
		double preuCircuit;
		int numPlaces, numeroPlacesDisponibles, dies, diaInici, mesInici, anyInici, diaFinal, mesFinal, anyFinal,
				numActivitats, activitatAfegir;
		data dataInici, dataFinal;
		try {
			Scanner lectura = new Scanner(new File("LlistaCircuits.txt"));
			while (lectura.hasNext()) {
				String linia = lectura.nextLine();
				Scanner lin = new Scanner(linia);
				lin.useDelimiter(";");
				nomCircuit = lin.next();
				tipusCircuit = lin.next();
				preuCircuit = lin.nextDouble();
				numPlaces = lin.nextInt();
				numeroPlacesDisponibles = lin.nextInt();
				pais = lin.next();
				dies = lin.nextInt();
				diaInici = lin.nextInt();
				mesInici = lin.nextInt();
				anyInici = lin.nextInt();
				dataInici = new data(diaInici, mesInici, anyInici);
				diaFinal = lin.nextInt();
				mesFinal = lin.nextInt();
				anyFinal = lin.nextInt();
				dataFinal = new data(diaFinal, mesFinal, anyFinal);
				numActivitats = lin.nextInt();
				circuit circuitAfegir = new circuit(nomCircuit, tipusCircuit, preuCircuit, numPlaces,
						numeroPlacesDisponibles, pais, dies, dataInici, dataFinal, numActivitats);
				for (int i = 0; i < numActivitats; i++) {
					activitatAfegir = lin.nextInt();
					circuitAfegir.afegirActivitat(activitatAfegir);
				}
				llista.afegirCircuit(circuitAfegir);
				lin.close();
			}
			lectura.close();
		} catch (IOException e) {
			System.out.println("El fitxer de circuits no existeix");
		} catch (NoSuchElementException e) {
			System.out.println("Error al obrir el fitxer de circuits");
		}
	}

	// metode que llegeix el fitxer d'activitats i guarda el seu contingut a la
	// llista d'activitats
	public static void llegirFitxerActivitats(LlistaActivitats aux) {
		String nomActivitat, llocActivitat, descripcioActivitat;
		try {
			Scanner lectura = new Scanner(new File("LlistaActivitats.txt"));
			while (lectura.hasNext()) {
				String linia = lectura.nextLine();
				Scanner lin = new Scanner(linia);
				lin.useDelimiter(";");
				nomActivitat = lin.next();
				descripcioActivitat = lin.next();
				llocActivitat = lin.next();
				Activitat activitatAfegir = new Activitat(nomActivitat, descripcioActivitat, llocActivitat);
				aux.afegirActivitat(activitatAfegir);
				lin.close();
			}
			lectura.close();
		} catch (IOException e) {
			System.out.println("El fitxer d'activitats no existeix ");
		} catch (NoSuchElementException e) {
			System.out.println("Error al obrir el fitxer d'activitats");
		}
	}

	// metode que llegeix el fitxer de clients i guarda el seu contingut a la llista
	// de clients
	public static void llegirFitxerClients(LlistaClients aux) {
		String nom, dni, correu;
		try {
			Scanner lectura = new Scanner(new File("LlistaClients.txt"));
			while (lectura.hasNext()) {
				String linia = lectura.nextLine();
				Scanner lin = new Scanner(linia);
				lin.useDelimiter(";");
				nom = lin.next();
				dni = lin.next();
				correu = lin.next();
				Clients clientAfegir = new Clients(dni, nom, correu);
				aux.afegirDadaClientALlista(clientAfegir);
				lin.close();
			}
			lectura.close();
		} catch (IOException e) {
			System.out.println("El fitxer de clients no existeix ");
		} catch (DniRepetido e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("Error al obrir el fitxer de clients");
		}
	}

	// metode que llegeix el fitxer serialitzat de reserves i ho guarda a la llista
	// de reserves
	public static void LlegirFitxerReserves(LlistaReserva aux) {
		Reserves reservaLlegir = new Reserves();
		ObjectInputStream fin;
		Productes productesAfegir = new Productes();
		Clients clientAfegir = new Clients();
		data dataAfegir = new data();
		int numReserva;
		boolean llegit = false;
		try {
			fin = new ObjectInputStream(new FileInputStream("LlistaReserves.ser"));
			while (!llegit) {
				reservaLlegir = (Reserves) fin.readObject();
				productesAfegir = reservaLlegir.getReservaProducte();
				clientAfegir = reservaLlegir.getReservaClient();
				dataAfegir = reservaLlegir.getReservadata();
				numReserva = reservaLlegir.getNumReserva();
				Reserves reservaAfegir = new Reserves(productesAfegir, clientAfegir, dataAfegir, numReserva);
				aux.afegirReserva(reservaAfegir);
			}
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fitxer d'entrada no existeix");
		} catch (ClassNotFoundException e) {
			System.out.println("Format arxiu no correcte");
		} catch (EOFException e) {
			llegit = true;
		} catch (IOException e) {
			System.out.println("Algun problema amb els fitxers");
		} catch (ProducteCaducatException e) {
			System.out.println(e.getMessage());
		}
	}

	// metode que guarda el contingut de la llista de productes en un fitxer de
	// circuits i un de transports
	public static void guardaProductes(LlistaProductes aux) {
		try {
			String nomTransport, tipusTransport, ciutatOrigen, ciutatDesti;
			String nomCircuit, tipusCircuit, paisCircuit;
			double preuTransport, preuCircuit;
			int numeroPlaces, numeroPlacesDisponibles, diaEntrada, diaSortida, mesEntrada, mesSortida, anyEntrada,
					anySortida, diesCircuit, numActivitats;
			BufferedWriter escripturaCircuits = new BufferedWriter(new FileWriter("LlistaCircuits.txt"));
			BufferedWriter escripturaTransports = new BufferedWriter(new FileWriter("LlistaTransports.txt"));
			Productes[] productesGuardar = new Productes[aux.getNumElements()];
			productesGuardar = aux.getLlista();
			for (int i = 0; i < aux.getNumElements(); i++) {
				if (productesGuardar[i] instanceof transport) {
					nomTransport = productesGuardar[i].getNom();
					tipusTransport = productesGuardar[i].getTipusTransport();
					preuTransport = productesGuardar[i].getPreu();
					numeroPlaces = productesGuardar[i].getNumeroPlaces();
					numeroPlacesDisponibles = productesGuardar[i].getNumeroPlacesDisponibles();
					ciutatOrigen = ((transport) productesGuardar[i]).getCiutatOrigen();
					ciutatDesti = ((transport) productesGuardar[i]).getCiutatDesti();
					diaEntrada = ((transport) productesGuardar[i]).getData_entrada().getDia();
					diaSortida = ((transport) productesGuardar[i]).getData_sortida().getDia();
					mesEntrada = ((transport) productesGuardar[i]).getData_entrada().getMes();
					mesSortida = ((transport) productesGuardar[i]).getData_sortida().getMes();
					anyEntrada = ((transport) productesGuardar[i]).getData_entrada().getAny();
					anySortida = ((transport) productesGuardar[i]).getData_sortida().getAny();
					escripturaTransports.write(nomTransport + ";" + tipusTransport + ";" + (int) preuTransport + ";"
							+ numeroPlaces + ";" + numeroPlacesDisponibles + ";" + ciutatOrigen + ";" + ciutatDesti
							+ ";" + diaEntrada + ";" + mesEntrada + ";" + anyEntrada + ";" + diaSortida + ";"
							+ mesSortida + ";" + anySortida + ";\n");
				} else {
					nomCircuit = productesGuardar[i].getNom();
					tipusCircuit = productesGuardar[i].getTipusTransport();
					preuCircuit = productesGuardar[i].getPreu();
					numeroPlaces = productesGuardar[i].getNumeroPlaces();
					numeroPlacesDisponibles = productesGuardar[i].getNumeroPlacesDisponibles();
					paisCircuit = ((circuit) productesGuardar[i]).getPais();
					diesCircuit = ((circuit) productesGuardar[i]).getDies();
					diaEntrada = ((circuit) productesGuardar[i]).getDataOferiment().getDia();
					diaSortida = ((circuit) productesGuardar[i]).getDataOferimentAcab().getDia();
					mesEntrada = ((circuit) productesGuardar[i]).getDataOferiment().getMes();
					mesSortida = ((circuit) productesGuardar[i]).getDataOferimentAcab().getMes();
					anyEntrada = ((circuit) productesGuardar[i]).getDataOferiment().getAny();
					anySortida = ((circuit) productesGuardar[i]).getDataOferimentAcab().getAny();
					numActivitats = ((circuit) productesGuardar[i]).getNumElements();
					escripturaCircuits.write(nomCircuit + ";" + tipusCircuit + ";" + (int) preuCircuit + ";"
							+ numeroPlaces + ";" + numeroPlacesDisponibles + ";" + paisCircuit + ";" + diesCircuit + ";"
							+ diaEntrada + ";" + mesEntrada + ";" + anyEntrada + ";" + diaSortida + ";" + mesSortida
							+ ";" + anySortida + ";" + numActivitats + ";");
					int[] llistaActivitats = new int[numActivitats];
					llistaActivitats = ((circuit) productesGuardar[i]).getLlistaActivitats();
					for (int j = 0; j < numActivitats; j++) {
						int activitatAfegir = llistaActivitats[i];
						escripturaCircuits.write(activitatAfegir + ";");
					}
					escripturaCircuits.write("\n");
				}
			}
			escripturaCircuits.close();
			escripturaTransports.close();
		} catch (IOException e) {
			System.out.println("El fitxer no existeix ");
		}
	}

	// metode que guarda el contingut de la llista d'activitats en un fitxer
	// d'activitats
	public static void guardaActivitats(LlistaActivitats aux) {
		String nomActivitat, descripcioActivitat, llocActivitat;
		try {
			BufferedWriter escriptura = new BufferedWriter(new FileWriter("LlistaActivitats.txt"));
			Activitat[] activitatGuardar = new Activitat[aux.getNumElements()];
			activitatGuardar = aux.getLlistaActivitats();
			for (int i = 0; i < aux.getNumElements(); i++) {
				nomActivitat = activitatGuardar[i].getNom();
				descripcioActivitat = activitatGuardar[i].getDescripcio();
				llocActivitat = activitatGuardar[i].getLloc();
				escriptura.write(nomActivitat + ";" + descripcioActivitat + ";" + llocActivitat + ";\n");
			}
			escriptura.close();
		} catch (IOException e) {
			System.out.println("El fitxer no existeix ");
		}
	}

	// metode que guarda el contingut de la llista de clients en un fitxer de
	// clients
	public static void guardaClients(LlistaClients aux) {
		try {
			String nomClient, dniClient, correuClient;
			BufferedWriter escriptura = new BufferedWriter(new FileWriter("LlistaClients.txt"));
			Clients[] clientsGuardar = new Clients[aux.getNumClients()];
			clientsGuardar = aux.getLlistaClients();
			for (int i = 0; i < aux.getNumClients(); i++) {
				nomClient = clientsGuardar[i].getNom();
				dniClient = clientsGuardar[i].getDni();
				correuClient = clientsGuardar[i].getCorreu();
				escriptura.write(nomClient + ";" + dniClient + ";" + correuClient + ";\n");
			}
			escriptura.close();
		} catch (IOException e) {
			System.out.println("El fitxer no existeix ");
		}
	}

	// metode que guarda el contingut de la llista de reserves en un fitxer
	// serialitzat
	public static void guardaReserves(LlistaReserva aux) {
		ObjectOutputStream fout;
		try {
			fout = new ObjectOutputStream(new FileOutputStream("LlistaReserves.ser"));
			Reserves[] reservaGuardar = new Reserves[aux.getNumReserves()];
			reservaGuardar = aux.getLlista();
			for (int i = 0; i < aux.getNumReserves(); i++) {
				Reserves reservaAux=new Reserves(reservaGuardar[i].getReservaProducte(), reservaGuardar[i].getReservaClient(),
						reservaGuardar[i].getReservadata(), reservaGuardar[i].getNumReserva());
				fout.writeObject(reservaAux);						
			}
			fout.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fitxer d'entrada no existeix");
		} catch (IOException e) {
			System.out.println("Algun problema amb els fitxers");
		}
	}
}