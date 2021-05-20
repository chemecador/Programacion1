package entidades;

import java.util.Scanner;

/**
 * Clase Arbitro: La clase Arbitro tiene 2 atributos: el nombre y el país de
 * nacimiento. Por defecto, se han leído los árbitros más reconocidos a nivel
 * mundial a través del fichero arbitros.txt y se ha almacenado en un ArrayList
 * de arbitros al ejecutar el programa. El usuario puede añadir, modificar y
 * ordenar dichos árbitros.
 * 
 * @author Alejandro Gata
 *
 */

public abstract class Persona implements CosasPersona,Comparable<Persona> {
	
	static Scanner in = new Scanner (System.in);
	
	private String nombre;
	private String pais;

	/**
	 * Constructor de la clase Persona.
	 */
	public Persona() {
		this.nombre = "";
		this.pais = "";
	}

	/**
	 * Sobrecarga de constructor.
	 * 
	 * @param nombre : nombre del árbitro.
	 * @param pais   : país de nacimiento del árbitro.s
	 */
	public Persona(String nombre, String pais) {
		this.nombre = "";
		this.pais = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Método que visualiza la información de la persona.
	 */
	public void visualizar() {
		System.out.println("Su nombre es: " + this.nombre);
		System.out.println("Su país de nacimiento es: " + this.pais);
	}

	/**
	 * Método que permite modificar la persona.
	 */

	public void rellenar() {
		System.out.println("Introduce el nombre: ");
		this.nombre = in.nextLine();
		System.out.println("Introduce su país de nacimiento: ");
		this.pais = in.nextLine();
	}

}
