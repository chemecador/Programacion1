package entidades;

import java.util.Scanner;

/**
 * Clase Arbitro: La clase Arbitro tiene 2 atributos: el nombre y el pa�s de
 * nacimiento. Por defecto, se han le�do los �rbitros m�s reconocidos a nivel
 * mundial a trav�s del fichero arbitros.txt y se ha almacenado en un ArrayList
 * de arbitros al ejecutar el programa. El usuario puede a�adir, modificar y
 * ordenar dichos �rbitros.
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
	 * @param nombre : nombre del �rbitro.
	 * @param pais   : pa�s de nacimiento del �rbitro.s
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
	 * M�todo que visualiza la informaci�n de la persona.
	 */
	public void visualizar() {
		System.out.println("Su nombre es: " + this.nombre);
		System.out.println("Su pa�s de nacimiento es: " + this.pais);
	}

	/**
	 * M�todo que permite modificar la persona.
	 */

	public void rellenar() {
		System.out.println("Introduce el nombre: ");
		this.nombre = in.nextLine();
		System.out.println("Introduce su pa�s de nacimiento: ");
		this.pais = in.nextLine();
	}

}
