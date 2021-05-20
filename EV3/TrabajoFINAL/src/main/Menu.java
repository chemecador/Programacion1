package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import entidades.Persona;
import entidades.Tenista;
import entidades.Torneo;

/**
 * Clase Menu En esta clase se encuentran diferentes m�todos para mostrar los
 * diferentes men�s, recogiendo las elecciones del usuario.
 * 
 * @author Alejandro Gata
 * @since 1.8
 *
 */
public class Menu {
	/**
	 * M�todo que muestra el men� inicial.
	 * 
	 * @return char
	 */
	static Scanner in = new Scanner(System.in);

	public static char mostrarMenuInicial() {
		in = new Scanner(System.in);
		System.out.println("\n*** BIENVENIDO A LA ENCICLOPEDIA DEL TENIS ***");
		System.out.println("\n�Con qu� quieres trabajar?");
		System.out.println("Si quieres trabajar con TENISTAS, pulsa 1");
		System.out.println("Si quieres trabajar con TORNEOS, pulsa 2");
		System.out.println("Si quieres trabajar con �RBITROS, pulsa 3");
		System.out.println("Si quieres trabajar con BASES DE DATOS, pulsa 4");
		System.out.println("Si quieres salir, pulsa 5");
		char c = in.nextLine().charAt(0);
		if (c == '5') {
			System.out.println("�Vuelve pronto!");
			System.exit(0);
		}
		return c;
	}

	// TENISTAS

	/**
	 * M�todo que muestra el men� del tenista y recoge la elecci�n del usuario
	 * 
	 * @return char
	 */
	public static char mostrarMenuTenista() {
		System.out.println("***** TENISTAS *****");
		System.out.println("Si quieres VISUALIZAR los tenistas que tenemos en nuestra base de datos, pulsa 1");
		System.out.println("Si quieres MODIFICAR un tenista, pulsa 2");
		System.out.println("Si quieres BUSCAR la informaci�n de un tenista en concreto, pulsa 3");
		System.out.println(
				"Si quieres consultar qui�n va en la PRIMERA y en la �LTIMA posici�n de nuestro ranking, pulsa 4");
		System.out.println("Si quieres A�ADIR un nuevo tenista, pulsa 5");
		System.out.println("Si quieres volver al men� anterior, pulsa 6");
		char c = in.nextLine().charAt(0);
		return c;
	}

	/**
	 * M�todo que, a partir de la elecci�n del usuario introducida como par�metro,
	 * invoca a los diferentes m�todos para realizar las acciones que solicita el
	 * usuario respecto a los tenistas.
	 * 
	 * @param c        : char con la elecci�n del usuario.
	 * @param tenistas : ArrayList de tenistas.
	 */
	public static void menuTenista(char c, ArrayList<Persona> personas) {
		if (c == '1') {
			System.out.println("--------------------------------------");

			for (Persona persona : personas) {
				if (persona.getClass().getSimpleName().equalsIgnoreCase("Tenista")) {
					persona.visualizar();
				}
			}

			System.out.println("--------------------------------------");
		} else if (c == '2') {

			System.out.println("--------------------------------------");

			System.out.println("�Qu� tenista deseas modificar?");
			String nombreModificar = in.nextLine();
			boolean encontrado = false;
			while (!encontrado) {
				for (Persona persona : personas) {
					if (persona.getClass().getSimpleName().equalsIgnoreCase("Tenista")) {
						if (persona.getNombre().equalsIgnoreCase(nombreModificar)) {
							persona.rellenar();
							encontrado = true;
							break;
						}
					}
				}
				if (!encontrado) {
					System.out.println("Lo siento, no he podido encontrar a " + nombreModificar);
					System.out.println("Recuerda escribir su nombre completo y su primer apellido");
					if (!Operaciones.continuar()) {
						encontrado = true;
					}
				}
			}

			System.out.println("--------------------------------------");
		} else if (c == '3') {
			System.out.println("--------------------------------------");
			System.out.println("�Qu� tenista deseas buscar?");
			String nombreBuscar = in.nextLine();
			Operaciones.buscar(personas, nombreBuscar);

			System.out.println("--------------------------------------");
		} else if (c == '4') {
			System.out.println("--------------------------------------");
			Operaciones.mostrarLider(personas);
			System.out.println("--------------------------------------");
		} else if (c == '5') {
			Tenista nuevoTenista = new Tenista();
			nuevoTenista.rellenar();
			personas.add(nuevoTenista);
		} else if (c == '6') {
			Menu.mostrarMenuInicial();
		}
	}

	// TORNEOS
	/**
	 * M�todo que muestra el men� de torneos y recoge la elecci�n del usuario
	 * 
	 * @return char
	 */
	public static char mostrarMenuTorneos() {
		System.out.println("***** TORNEOS *****");
		System.out.println("Si quieres visualizar los torneos que tenemos en nuestra base de datos, pulsa 1");
		System.out.println("Si quieres a�adir un torneo, pulsa 2");
		System.out.println("Si quieres ordenar los torneos por puntos, pulsa 3");
		System.out.println("Si quieres ordenar los torneos por nombre, pulsa 4");
		System.out.println("Si quieres volver al men� anterior, pulsa 5");
		char c = in.nextLine().charAt(0);
		return c;
	}

	/**
	 * M�todo que, a partir de la elecci�n del usuario introducida como par�metro,
	 * invoca a los diferentes m�todos para realizar las acciones que solicita el
	 * usuario respecto a los torneos.
	 * 
	 * @param c       : char con la elecci�n del usuario.
	 * @param torneos : ArrayList de torneos.
	 */
	public static void menuTorneos(char c, ArrayList<Torneo> torneos) {
		if (c == '1') {
			System.out.println("--------------------------------------");
			if (torneos.size() == 0) {
				System.out.println("Todav�a no has a�adido ning�n torneo.");
			} else {
				for (Torneo torneo : torneos) {
					torneo.visualizarTorneo();
				}
			}
			System.out.println("--------------------------------------");
		} else if (c == '2') {

			System.out.println("--------------------------------------");

			Operaciones.anadirTorneo(torneos);
			System.out.println("--------------------------------------");
		} else if (c == '3') {
			System.out.println("--------------------------------------");

			if (torneos.size() == 0) {
				System.out.println("Todav�a no has a�adido ning�n torneo.");
			} else {
				Operaciones.ordenarTorneoPorPuntos(torneos);
				System.out.println("Torneos ordenados correctamente.");

				for (Torneo torneo : torneos) {
					torneo.visualizarTorneo();
				}
			}
			System.out.println("--------------------------------------");
		} else if (c == '4') {
			System.out.println("--------------------------------------");
			if (torneos.size() == 0) {
				System.out.println("Todav�a no has a�adido ning�n torneo.");
			} else {
				Operaciones.ordenarTorneoPorNombre(torneos);
				System.out.println("Torneos ordenados correctamente.");
				for (Torneo torneo : torneos) {
					torneo.visualizarTorneo();
				}
			}

			System.out.println("--------------------------------------");
		} else if (c == '5') {
			Menu.mostrarMenuInicial();
		}
	}

	// ARBITROS

	/**
	 * M�todo que muestra el men� de �rbitros y recoge la elecci�n del usuario
	 * 
	 * @return char
	 */
	public static char mostrarMenuArbitros() {
		System.out.println("***** ARBITROS *****");
		System.out.println("Si quieres visualizar los �rbitros que tenemos en nuestra base de datos, pulsa 1");
		System.out.println("Si quieres a�adir un �rbitro, pulsa 2");
		System.out.println("Si quieres modificar los datos de un �rbitro, pulsa 3");
		System.out.println("Si quieres ordenar los �rbitros por nombre, pulsa 4");
		System.out.println("Si quieres volver al men� anterior, pulsa 5");
		char c = in.nextLine().charAt(0);
		return c;
	}

	/**
	 * M�todo que, a partir de la elecci�n del usuario introducida como par�metro,
	 * invoca a los diferentes m�todos para realizar las acciones que solicita el
	 * usuario respecto a los �rbitros.
	 * 
	 * @param c        : char con la elecci�n del usuario.
	 * @param tenistas : ArrayList de �rbitros.
	 */
	public static void menuArbitros(char c, ArrayList<Persona> personas) {
		if (c == '1') {
			System.out.println("--------------------------------------");

			for (Persona persona : personas) {
				if (persona.getClass().getSimpleName().equalsIgnoreCase("Arbitro")) {
					persona.visualizar();
				}
			}

			System.out.println("--------------------------------------");
		} else if (c == '2') {

			System.out.println("--------------------------------------");

			Operaciones.anadirArbitro(personas);

			System.out.println("--------------------------------------");
		} else if (c == '3') {
			System.out.println("--------------------------------------");

			System.out.println("�Qu� �rbitro deseas modificar?");
			String nombreModificar = in.nextLine();
			boolean encontrado = false;
			while (!encontrado) {
				for (Persona persona : personas) {
					if (persona.getClass().getSimpleName().equalsIgnoreCase("Arbitro")) {
						if (persona.getNombre().equalsIgnoreCase(nombreModificar)) {
							persona.rellenar();
							encontrado = true;
							break;
						}
					}
				}
				if (!encontrado) {
					System.out.println("Lo siento, no he podido encontrar a " + nombreModificar);
					System.out.println("Recuerda escribir su nombre completo y su primer apellido");
					if (!Operaciones.continuar()) {
						encontrado = true;
					}
				}
			}

			System.out.println("--------------------------------------");
		} else if (c == '4') {
			System.out.println("--------------------------------------");
			Collections.sort(personas);
			for (Persona arbitro : personas) {
				arbitro.visualizar();
			}
			System.out.println("--------------------------------------");
		} else if (c == '5') {
			Menu.mostrarMenuInicial();
		}
	}

	public static char mostrarMenuBBDD() {
		System.out.println("***** BASES DE DATOS *****");
		System.out.println("Si quieres CREAR un estadio, pulsa 1");
		System.out.println("Si quieres RELLENAR una tabla, pulsa 2");
		System.out.println("Si quieres VISUALIZAR una tabla, pulsa 3");
		System.out.println("Si quieres volver al men� anterior, pulsa 4");
		char c = in.nextLine().charAt(0);
		return c;
	}

	public static void menuBBDD(char c, BBDD miBBDD) {
		if (c == '1') {
			miBBDD.crearTabla();
		} else if (c == '2') {
			miBBDD.rellenarTabla();
		} else if (c == '3') {
			miBBDD.consultarTabla();
		} else if (c == '4') {
			Menu.mostrarMenuInicial();
		}
	}
}
