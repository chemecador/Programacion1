package main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import extra.Arbitro;
import extra.Tenista;
import extra.Torneo;

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
	public static char mostrarMenuInicial() {
		Scanner in = new Scanner(System.in);
		System.out.println("\n*** BIENVENIDO A LA ENCICLOPEDIA DEL TENIS ***");
		System.out.println("\n�Con qu� quieres trabajar?");
		System.out.println("Si quieres trabajar con Tenistas, pulsa 1");
		System.out.println("Si quieres trabajar con Torneos, pulsa 2");
		System.out.println("Si quieres trabajar con �rbitros, pulsa 3");
		System.out.println("Si quieres salir, pulsa 4");
		char c = in.nextLine().charAt(0);
		if (c == '4') {
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
		System.out.println("Si quieres visualizar los tenistas que tenemos en nuestra base de datos, pulsa 1");
		System.out.println("Si quieres modificar un tenista, pulsa 2");
		System.out.println("Si quieres buscar la informaci�n de un tenista en concreto, pulsa 3");
		System.out.println(
				"Si quieres consultar qui�n va en la primera y en la �ltima posici�n de nuestro ranking, pulsa 4");
		System.out.println("Si quieres volver al men� anterior, pulsa 5");
		Scanner in = new Scanner(System.in);
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
	public static void menuTenista(char c, ArrayList<Tenista> tenistas) {
		Scanner in = new Scanner(System.in);

		if (c == '1') {
			System.out.println("--------------------------------------");
			for (Tenista tenista : tenistas) {
				tenista.visualizarTenista();
			}
			System.out.println("--------------------------------------");
		} else if (c == '2') {

			System.out.println("--------------------------------------");
			System.out.println("�Qu� tenista deseas modificar?");
			String nombreModificar = in.nextLine();
			boolean encontrado = false;
			while (!encontrado) {
				for (Tenista tenista : tenistas) {
					if (tenista.getNombre().equalsIgnoreCase(nombreModificar)) {
						tenista.modificarTenista();
						encontrado = true;
						break;
					}
				}
				if (!encontrado) {
					System.out.println("Lo siento, no he podido encontrar a " + nombreModificar);
					System.out.println("Recuerda escribir su nombre completo y su primer apellido");
					if (!Operaciones.continuar()) {
						encontrado = true;
					}
					nombreModificar = in.nextLine();
				}
			}

			System.out.println("--------------------------------------");
		} else if (c == '3') {
			System.out.println("--------------------------------------");
			System.out.println("�Qu� tenista deseas buscar?");
			String nombreBuscar = in.nextLine();
			Operaciones.buscarTenista(tenistas, nombreBuscar);

			System.out.println("--------------------------------------");
		} else if (c == '4') {
			System.out.println("--------------------------------------");
			Operaciones.mostrarLider(tenistas);
			System.out.println("--------------------------------------");
		} else if (c == '5') {
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
		Scanner in = new Scanner(System.in);
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

			for (Torneo torneo : torneos) {
				torneo.visualizarTorneo();
			}

			System.out.println("--------------------------------------");
		} else if (c == '2') {

			System.out.println("--------------------------------------");

			Operaciones.anadirTorneo(torneos);
			System.out.println("--------------------------------------");
		} else if (c == '3') {
			System.out.println("--------------------------------------");

			Operaciones.ordenarTorneoPorPuntos(torneos);
			System.out.println("Torneos ordenados correctamente.");

			if (torneos.size() == 4) {
				System.out.println("Recuerda: hasta ahora solo tengo en la base de datos "
						+ "los 4 Grand Slam. Todos tienen 2000 puntos. \nTe sugiero que "
						+ "a�adas otros torneos primero");
			}
			for (Torneo torneo : torneos) {
				torneo.visualizarTorneo();
			}

			System.out.println("--------------------------------------");
		} else if (c == '4') {
			System.out.println("--------------------------------------");

			Operaciones.ordenarTorneoPorNombre(torneos);
			System.out.println("Torneos ordenados correctamente.");
			for (Torneo torneo : torneos) {
				torneo.visualizarTorneo();
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
		Scanner in = new Scanner(System.in);
		System.out.println("***** ARBITROS *****");
		System.out.println("Si quieres visualizar los �rbitros que tenemos en nuestra base de datos, pulsa 1");
		System.out.println("Si quieres a�adir un �rbitro, pulsa 2");
		System.out.println("Si quieres modificar los datos de un �rbitro, pulsa 3");
		System.out.println("Si quieres ordenar los �rbitros por nombre, pulsa 4");
		System.out.println("Si quieres ordenar los �rbitros por pa�s, pulsa 5");
		System.out.println("Si quieres volver al men� anterior, pulsa 6");
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
	public static void menuArbitros(char c, ArrayList<Arbitro> arbitros) {
		Scanner in = new Scanner(System.in);
		if (c == '1') {
			System.out.println("--------------------------------------");

			for (Arbitro arbitro : arbitros) {
				arbitro.visualizarArbitro();
			}

			System.out.println("--------------------------------------");
		} else if (c == '2') {

			System.out.println("--------------------------------------");

			Operaciones.anadirArbitro(arbitros);

			System.out.println("--------------------------------------");
		} else if (c == '3') {
			System.out.println("--------------------------------------");

			System.out.println("�Qu� �rbitro deseas modificar?");
			String nombreModificar = in.nextLine();
			boolean encontrado = false;
			while (!encontrado) {
				for (Arbitro arbitro : arbitros) {
					if (arbitro.getNombre().equalsIgnoreCase(nombreModificar)) {
						arbitro.modificarArbitro();
						encontrado = true;
						break;
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
			Operaciones.ordenarArbitroPorNombre(arbitros);
			for (Arbitro arbitro : arbitros) {
				arbitro.visualizarArbitro();
			}
			System.out.println("--------------------------------------");
		} else if (c == '5') {
			System.out.println("--------------------------------------");
			Operaciones.ordenarArbitroPorPais(arbitros);
			for (Arbitro arbitro : arbitros) {
				arbitro.visualizarArbitro();
			}
			System.out.println("--------------------------------------");
		} else if (c == '6') {
			Menu.mostrarMenuInicial();
		}
	}
}
