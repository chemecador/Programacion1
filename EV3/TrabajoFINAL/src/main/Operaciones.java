package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entidades.Arbitro;
import entidades.Persona;
import entidades.Reputacion;
import entidades.Tenista;
import entidades.Torneo;

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

	static Scanner in = new Scanner(System.in);

	public static void anadirTenista(ArrayList<Persona> personas, BBDD tenistas) {
		Tenista nuevoTenista = new Tenista();
		nuevoTenista.rellenar();
		personas.add(nuevoTenista);
		tenistas.rellenarTabla("tenista");
	}

	public static void anadirArbitro(ArrayList<Persona> personas) {
		Arbitro nuevoArbitro = new Arbitro();
		nuevoArbitro.rellenar();
		personas.add(nuevoArbitro);
	}

	/**
	 * Método que busca un tenista introducido como parámetro en el ArrayList
	 * también introducido como parámetro.
	 * 
	 * @param personas : ArrayList de tenistas donde se buscará el tenista.
	 * @param nombre   : nombre del tenista que se buscará en el ArrayList.
	 */
	public static void buscar(ArrayList<Persona> personas, String nombre) {
		boolean encontrado = false;
		for (Persona persona : personas) {
			if (persona.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Aquí tienes la información de " + nombre + ": ");
				persona.visualizar();
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("No hemos podido encontrar a " + nombre);
			System.out.println("Aquí tienes la lista de tenistas disponible: ");
			Menu.menuTenista('1', personas);
			System.out.println("Aquí tienes la lista de árbitros disponible: ");
			Menu.menuArbitros('1', personas);
		}
	}

	/**
	 * Método que muestra el tenista con el puesto más alto y más bajo del ranking.
	 * 
	 * @param personas : ArrayList que almacena los tenistas.
	 */
	public static void mostrarLider(ArrayList<Persona> personas) {
		Tenista minimo = new Tenista();
		Tenista maximo = new Tenista();
		for (Persona persona : personas) {
			if (persona.getClass().getSimpleName().equalsIgnoreCase("Tenista")) {
				minimo = (Tenista) persona;
				maximo = (Tenista) persona;
			}
		}
		for (Persona persona : personas) {
			if (persona.getClass().getSimpleName().equals("Tenista")) {
				Tenista tenistaComparar = (Tenista) persona;
				if (tenistaComparar.getPuestoRanking() < minimo.getPuestoRanking()) {
					minimo = tenistaComparar;
				}
				if (tenistaComparar.getPuestoRanking() > maximo.getPuestoRanking()) {
					maximo = tenistaComparar;
				}
			}
		}
		System.out.println("El tenista con mejor posición en el ranking es: ");
		minimo.visualizar();
		System.out.println("El tenista con peor posición en el ranking es: ");
		maximo.visualizar();
	}

	// TORNEOS

	/**
	 * 
	 * /** Método que permite añadir un torneo al ArrayList y que creará
	 * posteriormente un fichero con los ganadores.
	 * 
	 * @param torneos : ArrayList de torneos disponibles.
	 */
	public static void anadirTorneo(ArrayList<Torneo> torneos) {
		Torneo nuevoTorneo = new Torneo();
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
	 * @param personas : ArrayList que contendrá los árbitros.
	 */
	public static void leerArbitros(ArrayList<Persona> personas) {
		try {
			BufferedReader f1 = new BufferedReader(new FileReader("arbitros.txt"));
			String lineaArbitro = f1.readLine();
			while (lineaArbitro != null) {
				String[] vectorArbitro = lineaArbitro.split(", ");
				Arbitro nuevoArbitro = new Arbitro();
				for (int i = 0; i < vectorArbitro.length; i++) {
					nuevoArbitro.setNombre(vectorArbitro[0]);
					nuevoArbitro.setPais(vectorArbitro[1]);
					nuevoArbitro.setRep(Reputacion.valueOf(vectorArbitro[2]));
				}
				personas.add(nuevoArbitro);
				lineaArbitro = f1.readLine();
			}
			f1.close();
		} catch (IOException e) {
			System.out.println("Error al leer arbitros.txt");
		}
	}

	// OTRO
	/**
	 * Método que pregunta al usuario si desea continuar: S: sí N: no
	 * 
	 * @return boolean
	 */
	public static boolean continuar() {
		System.out.println("¿Quieres continuar? (S/N)");
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
	 * Método con todas las operaciones previas
	 * 
	 * @param tenistasBBDD Base de datos de tenistas
	 * @param personas     ArrayList de personas
	 */
	public static void operacionesPrevias(BBDD tenistasBBDD, ArrayList<Persona> personas) {
		leerArbitros(personas);
		tenistasBBDD.cargarControlador();
		tenistasBBDD.conectarBBDD();
		tenistasBBDD.leerTenistas(personas);

	}
}
