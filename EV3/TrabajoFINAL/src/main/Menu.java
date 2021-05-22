package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import entidades.Persona;
import entidades.Tenista;
import entidades.Torneo;

/**
 * Clase Menu En esta clase se encuentran diferentes métodos para mostrar los
 * diferentes menús, recogiendo las elecciones del usuario
 * 
 * @author Alejandro Gata
 * @since 1.8
 *
 */
public class Menu {
	/**
	 * Método que muestra los diferentes menús.
	 * 
	 * @return char
	 */
	static Scanner in = new Scanner(System.in);
	/**
	 * Método con todo el menú completo
	 * 
	 * @param personas     ArrayList de personas
	 * @param torneos      ArrayList de torneos
	 * @param tenistasBBDD Base de datos de tenistas
	 */
	public static void menuCompleto(ArrayList<Persona> personas, ArrayList<Torneo> torneos, BBDD tenistasBBDD) {
		int opcionInicial = mostrarMenuInicial() - '0';
		while (opcionInicial != 5) {
			char opcionSeccion;
			int opcionSeccionInt;
			if (opcionInicial == 1) {
				opcionSeccion = mostrarMenuTenista();
				opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 6) {
					System.out.println("Opción no disponible");
					opcionSeccion = Menu.mostrarMenuTenista();
					opcionSeccionInt = opcionSeccion - '0';
				}
				menuTenista(opcionSeccion, personas);
			} else if (opcionInicial == 2) {

				opcionSeccion = mostrarMenuTorneos();
				opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 5) {
					System.out.println("Opción no disponible");
					opcionSeccion = mostrarMenuTorneos();
					opcionSeccionInt = opcionSeccion - '0';
				}
				menuTorneos(opcionSeccion, torneos);
			} else if (opcionInicial == 3) {
				opcionSeccion = mostrarMenuArbitros();
				opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 6) {
					System.out.println("Opción no disponible");
					opcionSeccion = mostrarMenuArbitros();
					opcionSeccionInt = opcionSeccion - '0';
				}
				menuArbitros(opcionSeccion, personas);
			} else if (opcionInicial == 4) {
				opcionSeccion = mostrarMenuBBDD();
				opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 5) {
					System.out.println("Opción no disponible");
					opcionSeccion = mostrarMenuBBDD();
					opcionSeccionInt = opcionSeccion - '0';
				}
				menuBBDD(opcionSeccion, tenistasBBDD);
			} else {
				System.out.println("Opción no válida");
			}
			opcionInicial = mostrarMenuInicial() - '0';
		}
	}
	public static char mostrarMenuInicial() {
		System.out.println("\n*** BIENVENIDO A LA ENCICLOPEDIA DEL TENIS ***");
		System.out.println("\n¿Con qué quieres trabajar?");
		System.out.println("Si quieres trabajar con TENISTAS, pulsa 1");
		System.out.println("Si quieres trabajar con TORNEOS, pulsa 2");
		System.out.println("Si quieres trabajar con ÁRBITROS, pulsa 3");
		System.out.println("Si quieres trabajar con BASES DE DATOS, pulsa 4");
		System.out.println("Si quieres salir, pulsa 5");
		char c = '5';

		try {
			c = in.nextLine().charAt(0);
		} catch (Exception e) {
			System.out.println("Error de teclado, el programa se cerrará");
		}
		if (c == '5') {
			System.out.println("¡Vuelve pronto!");
			System.exit(0);
		}
		return c;
	}

	// TENISTAS

	/**
	 * Método que muestra el menú del tenista y recoge la elección del usuario
	 * 
	 * @return char
	 */
	public static char mostrarMenuTenista() {
		System.out.println("***** TENISTAS *****");
		System.out.println("Si quieres VISUALIZAR los tenistas que tenemos en nuestra base de datos, pulsa 1");
		System.out.println("Si quieres MODIFICAR un tenista, pulsa 2");
		System.out.println("Si quieres BUSCAR la información de un tenista en concreto, pulsa 3");
		System.out.println(
				"Si quieres consultar quién va en la PRIMERA y en la ÚLTIMA posición de nuestro ranking, pulsa 4");
		System.out.println("Si quieres AÑADIR un nuevo tenista, pulsa 5");
		System.out.println("Si quieres ORDENAR a los tenistas por su nombre, pulsa 6");
		System.out.println("Si quieres volver al menú anterior, pulsa 7");
		char c = '7';
		try {
			c = in.nextLine().charAt(0);
		} catch (Exception e) {
			System.out.println("Error de teclado, el programa se cerrará");
		}
		return c;
	}

	/**
	 * Método que, a partir de la elección del usuario introducida como parámetro,
	 * invoca a los diferentes métodos para realizar las acciones que solicita el
	 * usuario respecto a los tenistas.
	 * 
	 * @param c        : char con la elección del usuario.
	 * @param personas : ArrayList de tenistas.
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

			System.out.println("¿Qué tenista deseas modificar?");
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
			System.out.println("¿Qué tenista deseas buscar?");
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
			Collections.sort(personas);
			System.out.println("Tenistas ordenados correctamente");
		} else if (c == '7') {
			Menu.mostrarMenuInicial();
		}
	}

	// TORNEOS
	/**
	 * Método que muestra el menú de torneos y recoge la elección del usuario
	 * 
	 * @return char
	 */
	public static char mostrarMenuTorneos() {
		System.out.println("***** TORNEOS *****");
		System.out.println("Si quieres visualizar los torneos que tenemos en nuestra base de datos, pulsa 1");
		System.out.println("Si quieres añadir un torneo, pulsa 2");
		System.out.println("Si quieres ordenar los torneos por puntos, pulsa 3");
		System.out.println("Si quieres ordenar los torneos por nombre, pulsa 4");
		System.out.println("Si quieres volver al menú anterior, pulsa 5");
		char c = in.nextLine().charAt(0);
		return c;
	}

	/**
	 * Método que, a partir de la elección del usuario introducida como parámetro,
	 * invoca a los diferentes métodos para realizar las acciones que solicita el
	 * usuario respecto a los torneos.
	 * 
	 * @param c       : char con la elección del usuario.
	 * @param torneos : ArrayList de torneos.
	 */
	public static void menuTorneos(char c, ArrayList<Torneo> torneos) {
		if (c == '1') {
			System.out.println("--------------------------------------");
			if (torneos.size() == 0) {
				System.out.println("Todavía no has añadido ningún torneo.");
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
				System.out.println("Todavía no has añadido ningún torneo.");
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
				System.out.println("Todavía no has añadido ningún torneo.");
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
	 * Método que muestra el menú de árbitros y recoge la elección del usuario
	 * 
	 * @return char
	 */
	public static char mostrarMenuArbitros() {
		System.out.println("***** ARBITROS *****");
		System.out.println("Si quieres visualizar los árbitros que tenemos en nuestra base de datos, pulsa 1");
		System.out.println("Si quieres añadir un árbitro, pulsa 2");
		System.out.println("Si quieres modificar los datos de un árbitro, pulsa 3");
		System.out.println("Si quieres ordenar los árbitros por nombre, pulsa 4");
		System.out.println("Si quieres volver al menú anterior, pulsa 5");
		char c = in.nextLine().charAt(0);
		return c;
	}

	/**
	 * Método que, a partir de la elección del usuario introducida como parámetro,
	 * invoca a los diferentes métodos para realizar las acciones que solicita el
	 * usuario respecto a los árbitros.
	 * 
	 * @param c        : char con la elección del usuario.
	 * @param personas : ArrayList de árbitros.
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

			System.out.println("¿Qué árbitro deseas modificar?");
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
				if (arbitro.getClass().getSimpleName().equals("Arbitro"))
					arbitro.visualizar();
			}
			System.out.println("--------------------------------------");
		} else if (c == '5') {
			Menu.mostrarMenuInicial();
		}
	}
	/**
	 * Método que muestra el menú de la base de datos
	 * @return Char
	 */
	public static char mostrarMenuBBDD() {
		System.out.println("***** BASES DE DATOS *****");
		System.out.println("Si quieres CREAR un estadio, pulsa 1");
		System.out.println("Si quieres INSERTAR DATOS en una tabla, pulsa 2");
		System.out.println("Si quieres VISUALIZAR una tabla, pulsa 3");
		System.out.println("Si quieres ELIMINAR un dato de una tabla, pulsa 4");
		System.out.println("Si quieres volver al menú anterior, pulsa 5");
		char c = in.nextLine().charAt(0);
		return c;
	}

	/**
	 * Método para trabajar con la base de datos
	 * 
	 * @param c      : char con la elección del usuario.
	 * @param miBBDD : base de datos
	 */
	public static void menuBBDD(char c, BBDD miBBDD) {
		if (c == '1') {
			miBBDD.crearTabla();
		} else if (c == '2') {
			System.out.println("¿Qué base de datos quieres crear? (estadio/tenista)");
			String opcion = in.nextLine();
			if (opcion.equalsIgnoreCase("estadio") || opcion.equalsIgnoreCase("tenista")) {
				miBBDD.rellenarTabla(opcion);
			} else {
				System.out.println("No existe la base de datos " + opcion);
			}
		} else if (c == '3') {
			System.out.println("¿Qué base de datos quieres visualizar? (estadio/tenista)");
			String opcion = in.nextLine();
			if (opcion.equalsIgnoreCase("estadio")) {
				miBBDD.consultarEstadio();
			} else if (opcion.equalsIgnoreCase("tenista")) {
				miBBDD.consultarTenista();
			} else {
				System.out.println("No existe la base de datos " + opcion);
			}
		} else if (c == '4') {
			System.out.println("¿De qué base de datos quieres eliminar un dato? (estadio/tenista)");
			String opcion = in.nextLine();
			if (opcion.equalsIgnoreCase("estadio")) {
				miBBDD.borrarEstadio();
			} else if (opcion.equalsIgnoreCase("tenista")) {
				miBBDD.borrarTenista();
			} else {
				System.out.println("No existe la base de datos " + opcion);
			}
		} else if (c == '5') {
			Menu.mostrarMenuInicial();
		}
	}
}
