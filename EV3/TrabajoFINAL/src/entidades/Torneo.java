package entidades;


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
	private int puntos;

	/**
	 * Constructor de la clase Torneo
	 */
	public Torneo() {
		this.nombre = "";
		this.sede = "";
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

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/**
	 * Método que visualiza la información del torneo
	 */
	public void visualizarTorneo() {
		System.out.println("El nombre del torneo es: " + this.nombre);
		System.out.println("Se ubica en: " + this.sede);
		System.out.println("Puntos para el ganador: " + this.puntos);
		System.out.println("\n");
	}
}
