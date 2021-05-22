package main;

import java.util.ArrayList;

import entidades.Persona;
import entidades.Torneo;

public class Main {
	/**
	 * Programa para trabajar con datos relacionados con el mundo del tenis
	 * 
	 * @param args Argumentos
	 * @author Alejandro Gata
	 * @since 1.8
	 */
	public static void main(String[] args) {

		ArrayList<Persona> personas = new ArrayList<Persona>();
		ArrayList<Torneo> torneos = new ArrayList<Torneo>();
		BBDD tenistasBBDD = new BBDD();

		Operaciones.operacionesPrevias(tenistasBBDD, personas);

		Menu.menuCompleto(personas, torneos, tenistasBBDD);

		tenistasBBDD.cerrarConexion();
	}

}
