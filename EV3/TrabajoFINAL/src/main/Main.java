package main;

import java.util.ArrayList;

import entidades.Persona;
import entidades.Torneo;

public class Main {

	public static void main(String[] args) {

		ArrayList<Persona> personas = new ArrayList<Persona>();
		ArrayList<Torneo> torneos = new ArrayList<Torneo>();
		Operaciones.leerArbitros(personas);
		
		BBDD tenistasBBDD = new BBDD();
		tenistasBBDD.cargarControlador();
		tenistasBBDD.conectarBBDD();
		tenistasBBDD.leerTenistas(personas);

		int opcionInicial = Menu.mostrarMenuInicial() - '0';
		while (opcionInicial != 5) {
			char opcionSeccion;
			int opcionSeccionInt;
			if (opcionInicial == 1) {
				opcionSeccion = Menu.mostrarMenuTenista();
				opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 5) {
					System.out.println("Opción no disponible");
					opcionSeccion = Menu.mostrarMenuTenista();
					opcionSeccionInt = opcionSeccion - '0';
				}
				Menu.menuTenista(opcionSeccion, personas);
			} else if (opcionInicial == 2) {

				opcionSeccion = Menu.mostrarMenuTorneos();
				opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 5) {
					System.out.println("Opción no disponible");
					opcionSeccion = Menu.mostrarMenuTorneos();
					opcionSeccionInt = opcionSeccion - '0';
				}
				Menu.menuTorneos(opcionSeccion, torneos);
			} else if (opcionInicial == 3) {
				opcionSeccion = Menu.mostrarMenuArbitros();
				opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 6) {
					System.out.println("Opción no disponible");
					opcionSeccion = Menu.mostrarMenuArbitros();
					opcionSeccionInt = opcionSeccion - '0';
				}
				Menu.menuArbitros(opcionSeccion, personas);
			} else if (opcionInicial == 4) {
				opcionSeccion = Menu.mostrarMenuBBDD();
				opcionSeccionInt = opcionSeccion - '0';
				while (opcionSeccionInt < 1 || opcionSeccionInt > 5) {
					System.out.println("Opción no disponible");
					opcionSeccion = Menu.mostrarMenuBBDD();
					opcionSeccionInt = opcionSeccion - '0';
				}
				Menu.menuBBDD(opcionSeccion, tenistasBBDD);
			} else {
				System.out.println("Opción no válida");
			}
			opcionInicial = Menu.mostrarMenuInicial() - '0';
		}
		
		tenistasBBDD.cerrarConexion();
	}

}
