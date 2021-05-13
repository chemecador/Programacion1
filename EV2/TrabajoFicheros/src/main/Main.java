package main;

import java.util.ArrayList;

import extra.Arbitro;
import extra.Torneo;
import extra.Tenista;

public class Main {

	public static void main(String[] args) {

		ArrayList<Tenista> tenistas = new ArrayList<Tenista>();
		ArrayList<Arbitro> arbitros = new ArrayList<Arbitro>();
		ArrayList<Torneo> torneos = new ArrayList<Torneo>();

		// Primero, leemos los tenistas que tenemos disponibles en el fichero
		// tenistas.txt
		Operaciones.leerTenistas(tenistas);

		// Despu�s, leemos la informaci�n que tenemos disponible acerca de los Grand
		// Slam en los diferentes ficheros
		Operaciones.leerGanadoresGrandSlam(torneos);

		// Por �ltimo, hacemos lo propio con los �rbitros. Adem�s, creamos un fichero
		// arbitrosModificar.txt para no corromper
		// el archivo original, en caso de querer a�adir nuevos �rbitros o modificarlos.
		Operaciones.leerArbitros(arbitros);

		int opcionInicial = Menu.mostrarMenuInicial() - '0';
		while (opcionInicial != 4) {
			if (opcionInicial == 1) {
				char opcionSeccion = Menu.mostrarMenuTenista();
				int opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 5) {
					System.out.println("Opci�n no disponible");
					opcionSeccion = Menu.mostrarMenuTenista();
					opcionSeccionInt = opcionSeccion - '0';
				}
				Menu.menuTenista(opcionSeccion, tenistas);
			} else if (opcionInicial == 2) {

				char opcionSeccion = Menu.mostrarMenuTorneos();
				int opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 5) {
					System.out.println("Opci�n no disponible");
					opcionSeccion = Menu.mostrarMenuTorneos();
					opcionSeccionInt = opcionSeccion - '0';
				}
				Menu.menuTorneos(opcionSeccion, torneos);
			} else if (opcionInicial == 3) {
				char opcionSeccion = Menu.mostrarMenuArbitros();
				int opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 6) {
					System.out.println("Opci�n no disponible");
					opcionSeccion = Menu.mostrarMenuArbitros();
					opcionSeccionInt = opcionSeccion - '0';
				}
				Menu.menuArbitros(opcionSeccion, arbitros);
			} else {
				System.out.println("Opci�n no v�lida");
			}
			opcionInicial = Menu.mostrarMenuInicial() - '0';
		}
	}

}
