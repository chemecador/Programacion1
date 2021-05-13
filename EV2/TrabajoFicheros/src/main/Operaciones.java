package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import extra.Arbitro;
import extra.Tenista;
import extra.Torneo;

/**
 * Clase Operaciones En esta clase se encuentran diferentes métodos para operar
 * con Torneos, Tenistas y Arbitros.
 * 
 * @author Alejandro Gata
 * @version 1.8
 * 
 *
 */

public class Operaciones {

	// TENISTAS

	/**
	 * Método que lee los tenistas almacenados en el fichero tenistas.txt
	 * 
	 * @param tenistas : ArrayList donde se almacenarán dichos tenistas.
	 */
	public static void leerTenistas(ArrayList<Tenista> tenistas) {
		try {
			BufferedReader f1 = new BufferedReader(new FileReader("tenistas.txt"));
			String lineaTenista = f1.readLine();
			while (lineaTenista != null) {
				String[] vectorTenista = lineaTenista.split(", ");
				Tenista nuevoTenista = new Tenista();
				for (int i = 0; i < vectorTenista.length; i++) {
					nuevoTenista.setNombre(vectorTenista[0]);
					nuevoTenista.setPais(vectorTenista[1]);
					nuevoTenista.setPuestoRanking(Integer.parseInt(vectorTenista[2]));
				}
				tenistas.add(nuevoTenista);
				lineaTenista = f1.readLine();
			}
			f1.close();
		} catch (IOException e) {
			System.out.println("Error al leer tenistas.txt");
		}
		System.out.println("Tenistas leídos correctamente.");
	}

	/**
	 * Método que visualiza los tenistas que se encuentran en el ArrayList tenistas.
	 * 
	 * @param tenistas : ArrayList que almacena los tenistas.
	 */
	public static void visualizarTenistas(ArrayList<Tenista> tenistas) {
		for (Tenista tenista : tenistas) {
			tenista.visualizarTenista();
			System.out.println();
		}
	}

	/**
	 * Método que busca un tenista introducido como parámetro en el ArrayList
	 * también introducido como parámetro.
	 * 
	 * @param tenistas : ArrayList de tenistas donde se buscará el tenista.
	 * @param nombre   : nombre del tenista que se buscará en el ArrayList.
	 */
	public static void buscarTenista(ArrayList<Tenista> tenistas, String nombre) {
		boolean encontrado = false;
		for (Tenista tenista : tenistas) {
			if (tenista.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Aquí tienes la información de " + nombre + ": ");
				tenista.visualizarTenista();
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("No hemos podido encontrar a " + nombre);
			System.out.println("Aquí tienes la lista de tenistas disponible: ");
			for (Tenista tenista : tenistas) {
				System.out.println(tenista.getNombre());

			}
		}
	}

	/**
	 * Método que muestra el tenista con el puesto más alto y más bajo del ranking.
	 * 
	 * @param tenistas : ArrayList que almacena los tenistas.
	 */
	public static void mostrarLider(ArrayList<Tenista> tenistas) {
		Tenista maximo = tenistas.get(0);
		Tenista minimo = tenistas.get(0);
		for (Tenista tenista : tenistas) {
			if (tenista.getPuestoRanking() < maximo.getPuestoRanking()) {
				maximo = tenista;
			} else if (tenista.getPuestoRanking() > minimo.getPuestoRanking()) {
				minimo = tenista;
			}
		}
		System.out.println("El tenista con mejor posición en el ranking es: ");
		maximo.visualizarTenista();
		System.out.println("El tenista con peor posición en el ranking es: ");
		minimo.visualizarTenista();
	}

	// TORNEOS

	/**
	 * Método que lee los ganadores de los diferentes Grand Slam, almacenado en los
	 * diferentes ficheros de texto.
	 * 
	 * @param torneos : ArrayList que almacena los diferentes torneos disponibles.
	 */
	public static void leerGanadoresGrandSlam(ArrayList<Torneo> torneos) {
		Torneo australianOpen = new Torneo();
		Torneo rolandGarros = new Torneo();
		Torneo wimbledon = new Torneo();
		Torneo usOpen = new Torneo();

		australianOpen.setNombre("Australian Open");
		australianOpen.setSede("Australia");
		australianOpen.setPuntos(2000);

		rolandGarros.setNombre("Roland Garros");
		rolandGarros.setSede("Francia");
		rolandGarros.setPuntos(2000);

		wimbledon.setNombre("Wimbledon");
		wimbledon.setSede("Reino Unido");
		wimbledon.setPuntos(2000);

		usOpen.setNombre("US Open");
		usOpen.setSede("EEUU");
		usOpen.setPuntos(2000);

		try {
			BufferedReader f1 = new BufferedReader(new FileReader("AustralianOpen.txt"));
			String lineaTenista = f1.readLine();
			String[] ganadoresAustralianOpen = lineaTenista.split(", ");

			for (String string : ganadoresAustralianOpen) {
				australianOpen.getGanadores().add(string);
			}
			f1.close();
		} catch (IOException e) {
			System.out.println("No he podido cargar los ganadores de US Open");
		}

		try {
			BufferedReader f1 = new BufferedReader(new FileReader("RolandGarros.txt"));
			String lineaTenista = f1.readLine();
			String[] ganadoresRolandGarros = lineaTenista.split(", ");

			for (String string : ganadoresRolandGarros) {
				rolandGarros.getGanadores().add(string);
			}
			f1.close();
		} catch (IOException e) {
			System.out.println("No he podido cargar los ganadores de Roland Garros");
		}

		try {
			BufferedReader f1 = new BufferedReader(new FileReader("Wimbledon.txt"));
			String lineaTenista = f1.readLine();
			String[] ganadoresWimbledon = lineaTenista.split(", ");

			for (String string : ganadoresWimbledon) {
				wimbledon.getGanadores().add(string);
			}
			f1.close();
		} catch (IOException e) {
			System.out.println("No he podido cargar los ganadores de Wimbledon");
		}
		try {
			BufferedReader f1 = new BufferedReader(new FileReader("UsOpen.txt"));
			String lineaTenista = f1.readLine();
			String[] ganadoresUsOpen = lineaTenista.split(", ");

			for (String string : ganadoresUsOpen) {
				usOpen.getGanadores().add(string);
			}
			f1.close();
		} catch (IOException e) {
			System.out.println("No he podido cargar los ganadores de US Open");
		}

		torneos.add(australianOpen);
		torneos.add(rolandGarros);
		torneos.add(wimbledon);
		torneos.add(usOpen);
		System.out.println("Torneos leídos correctamente.");
	}

	/**
	 * Método que permite añadir un torneo al ArrayList y que creará posteriormente
	 * un fichero con los ganadores.
	 * 
	 * @param torneos : ArrayList de torneos disponibles.
	 */
	public static void anadirTorneo(ArrayList<Torneo> torneos) {
		Torneo nuevoTorneo = new Torneo();
		Scanner in = new Scanner(System.in);
		System.out.println("¿Cómo se llama el torneo?");
		String nombre = in.nextLine();
		nuevoTorneo.setNombre(nombre);
		System.out.println("¿Dónde está su sede?");
		String sede = in.nextLine();
		nuevoTorneo.setSede(sede);
		System.out.println("¿Cuántos puntos se lleva el ganador?");
		int puntos = in.nextInt();
		in.nextLine();
		nuevoTorneo.setPuntos(puntos);
		System.out.println("Por favor, indique los últimos 5 ganadores (separados por una coma y un espacio). Ejemplo:"
				+ "\nNadal, Federer, Nadal, Djokovic, Nadal");
		String lineaGanadores = in.nextLine();
		String[] ganadoresTorneo = lineaGanadores.split(", ");
		for (int i = 0; i < ganadoresTorneo.length; i++) {
			nuevoTorneo.getGanadores().add(ganadoresTorneo[i]);
		}
		try {
			PrintWriter destino = new PrintWriter(new FileWriter(nombre + ".txt", false));
			destino.println(lineaGanadores);
			destino.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + nombre + ".txt");
		}
		System.out.println("Ganadores registrados correctamente en " + nombre + ".txt");
		torneos.add(nuevoTorneo);
	}

	/**
	 * Método que ordena a los torneos por puntos.
	 * 
	 * @param torneos : ArrayList de torneos.
	 */
	public static void ordenarTorneoPorPuntos(ArrayList<Torneo> torneos) {
		for (int i = 1; i < torneos.size(); i++) {
			for (int j = torneos.size() - 1; j >= i; j--) {
				if (torneos.get(j).getPuntos() > torneos.get(j - 1).getPuntos()) {
					Torneo aux = new Torneo();
					aux = torneos.get(j);
					torneos.set(j, torneos.get(j - 1));
					torneos.set(j - 1, aux);
				}
			}
		}
	}

	/**
	 * Método que ordena a los torneos por nombre.
	 * 
	 * @param torneos : ArrayList de torneos.
	 */
	public static void ordenarTorneoPorNombre(ArrayList<Torneo> torneos) {
		for (int i = 1; i < torneos.size(); i++) {
			for (int j = torneos.size() - 1; j >= i; j--) {
				if (torneos.get(j).getNombre().compareTo(torneos.get(j - 1).getNombre()) < 0) {
					Torneo aux = new Torneo();
					aux = torneos.get(j);
					torneos.set(j, torneos.get(j - 1));
					torneos.set(j - 1, aux);
				}
			}
		}
	}

	// ARBITROS

	/**
	 * 
	 * Método que lee los árbitros que se encuentran en el fichero arbitros.txt
	 * 
	 * @param arbitros : ArrayList que contiene los árbitros.
	 */
	public static void leerArbitros(ArrayList<Arbitro> arbitros) {
		try {
			BufferedReader f1 = new BufferedReader(new FileReader("arbitros.txt"));
			PrintWriter f2 = new PrintWriter(new FileWriter("arbitrosModificar.txt", false));

			String lineaArbitro = f1.readLine();
			while (lineaArbitro != null) {
				String[] vectorArbitro = lineaArbitro.split(", ");
				Arbitro nuevoArbitro = new Arbitro();
				for (int i = 0; i < vectorArbitro.length; i++) {
					nuevoArbitro.setNombre(vectorArbitro[0]);
					nuevoArbitro.setPais(vectorArbitro[1]);
				}
				arbitros.add(nuevoArbitro);
				f2.println(lineaArbitro);
				lineaArbitro = f1.readLine();
			}
			f1.close();
			f2.close();
			System.out.println("Árbitros leídos correctamente.");
		} catch (IOException e) {
			System.out.println("Error al leer arbitros.txt");
		}
	}

	/**
	 * Método que permite añadir un nuevo árbitro al ArrayList, así como crear un
	 * fichero de text arbitrosModificar.txt donde añadirá el nuevo árbitro.
	 * 
	 * @param arbitros : ArrayList de árbitros.
	 */
	public static void anadirArbitro(ArrayList<Arbitro> arbitros) {
		Arbitro nuevoArbitro = new Arbitro();
		Scanner in = new Scanner(System.in);
		System.out.println("¿Cuál es su nombre?");
		String nombre = in.nextLine();
		nuevoArbitro.setNombre(nombre);
		System.out.println("¿Cuál es su país de nacimiento?");
		String pais = in.nextLine();
		nuevoArbitro.setPais(pais);
		arbitros.add(nuevoArbitro);
		try {
			PrintWriter destino = new PrintWriter(new FileWriter("arbitrosModificar.txt", true));
			destino.println(nombre + ", " + pais);
			destino.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en arbitrosModificar.txt");
		}
		System.out.println("Árbitro añadido correctamente en arbitrosModificar.txt");
	}

	// OTRO
	/**
	 * Método que pregunta al usuario si desea continuar: S: sí N: no
	 * 
	 * @return boolean
	 */
	public static boolean continuar() {
		System.out.println("¿Quieres continuar? (S/N)");
		Scanner in = new Scanner(System.in);
		char opcion = Character.toUpperCase(in.nextLine().charAt(0));
		while (true) {
			if (opcion == 'S') {
				return true;
			} else if (opcion == 'N') {
				return false;
			}
			System.out.println("Opción incorrecta. Prueba de nuevo");
			opcion = Character.toUpperCase(in.nextLine().charAt(0));
		}
	}

	/**
	 * Método que ordena a los árbitros por nombre.
	 * 
	 * @param arbitros : ArrayList de árbitros.
	 */
	public static void ordenarArbitroPorNombre(ArrayList<Arbitro> arbitros) {
		for (int i = 1; i < arbitros.size(); i++) {
			for (int j = arbitros.size() - 1; j >= i; j--) {
				if (arbitros.get(j).getNombre().compareTo(arbitros.get(j - 1).getNombre()) < 0) {
					Arbitro aux = new Arbitro();
					aux = arbitros.get(j);
					arbitros.set(j, arbitros.get(j - 1));
					arbitros.set(j - 1, aux);
				}
			}
		}
	}

	/**
	 * Método que ordena a los árbitros por país.
	 * 
	 * @param arbitros : ArrayList de árbitros.
	 */
	public static void ordenarArbitroPorPais(ArrayList<Arbitro> arbitros) {
		for (int i = 1; i < arbitros.size(); i++) {
			for (int j = arbitros.size() - 1; j >= i; j--) {
				if (arbitros.get(j).getPais().compareTo(arbitros.get(j - 1).getPais()) < 0) {
					Arbitro aux = new Arbitro();
					aux = arbitros.get(j);
					arbitros.set(j, arbitros.get(j - 1));
					arbitros.set(j - 1, aux);
				}
			}
		}
	}
}
