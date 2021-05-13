package extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Torneo: Un torneo tiene 4 atributos: nombre, sede, lista de los últimos
 * 5 ganadores y puntos que se lleva el ganador.
 * 
 * Por defecto hay 4 torneos, los 4 Grand Slam (Australian Open, Roland Garros,
 * Wimbledon y US Open), que son leídos a partir de sus respectivos ficheros y
 * se ha creado un ArrayList de Torneos al ejecutar el programa. El usuario
 * puede añadir, modificar y ordenar los torneos que desee.
 * 
 * @author Alejandro Gata
 * @since 1.8
 */

public class Torneo {
	private String nombre;
	private String sede;
	private ArrayList<String> ganadores;
	private int puntos;

	/**
	 * Constructor de la clase Torneo
	 */
	public Torneo() {
		this.nombre = "";
		this.sede = "";
		this.ganadores = new ArrayList<String>();
		this.puntos = 0;
	}

	/**
	 * Sobrecarga de constructor de la clase torneo
	 * 
	 * @param nombre : nombre del torneo.
	 * @param sede   : sede del torneo.
	 * @param puntos : puntos que se lleva el ganador.
	 */
	public Torneo(String nombre, String sede, int puntos) {
		this.nombre = "";
		this.sede = "";
		this.ganadores = new ArrayList<String>();
		this.puntos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public ArrayList<String> getGanadores() {
		return ganadores;
	}

	public void setGanadores(ArrayList<String> ganadores) {
		this.ganadores = ganadores;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/**
	 * Método que lee los ganadores del torneo
	 */
	public void leerGanadores() {
		boolean error = true;
		do {
			try {
				BufferedReader f1 = new BufferedReader(new FileReader(this.nombre + ".txt"));
				String lineaTenista = f1.readLine();
				while (lineaTenista != null) {
					String[] ganadoresTorneo = lineaTenista.split(", ");
					for (int i = 0; i < ganadoresTorneo.length; i++) {
						ganadores.add(ganadoresTorneo[i]);
					}
				}
				error = false;
				f1.close();
			} catch (IOException e) {
				error = true;
				System.out.println("Torneo no encontrado. Prueba con otro nombre: ");
				Scanner in = new Scanner(System.in);
				this.nombre = in.nextLine();
			}
		} while (error);
	}

	/**
	 * Método que visualiza la información del torneo
	 */
	public void visualizarTorneo() {
		System.out.println("El nombre del torneo es: " + this.nombre);
		System.out.println("Se ubica en: " + this.sede);
		System.out.println("Puntos para el ganador: " + this.puntos);
		System.out.print("La lista de los últimos cinco ganadores es: ");

		for (int i = 0; i < ganadores.size(); i++) {
			System.out.print(ganadores.get(i));
			if (i < ganadores.size() - 2) {
				System.out.print(", ");
			} else if (i == ganadores.size() - 2) {
				System.out.print(" y ");
			}
		}
		System.out.println("\n");
	}
}
