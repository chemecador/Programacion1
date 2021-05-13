package extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class Arbitro {
	private String nombre;
	private String pais;

	/**
	 * Constructor de la clase Arbitro.
	 */
	public Arbitro() {
		this.nombre = "";
		this.pais = "";
	}

	/**
	 * Sobrecarga de constructor.
	 * 
	 * @param nombre : nombre del �rbitro.
	 * @param pais   : pa�s de nacimiento del �rbitro.s
	 */
	public Arbitro(String nombre, String pais) {
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
	 * M�todo que visualiza la informaci�n del �rbitro.
	 */
	public void visualizarArbitro() {
		System.out.println("Su nombre es: " + this.nombre);
		System.out.println("Su pa�s de nacimiento es: " + this.pais);
	}

	/**
	 * M�todo que permite modificar el �rbitro.
	 */
	public void modificarArbitro() {
		String nombreModificar = this.nombre;
		System.out.println("Est�s modificando a " + nombreModificar);
		Scanner in = new Scanner(System.in);
		System.out.println("�Qu� nombre le quieres dar?");
		this.nombre = in.nextLine();
		System.out.println("�Cu�l es su pa�s de nacimiento?");
		this.pais = in.nextLine();

		try {
			BufferedReader fuente = new BufferedReader(new FileReader("arbitros.txt"));
			PrintWriter destino = new PrintWriter(new FileWriter("arbitrosModificado.txt", false));
			String lineaArbitro = fuente.readLine();
			String[] vectorArbitro = lineaArbitro.split(", ");
			while (lineaArbitro != null) {
				if (vectorArbitro[0].equalsIgnoreCase(nombreModificar)) {
					destino.println(this.nombre + ", " + this.pais);
				} else {
					destino.println(lineaArbitro);
				}
				lineaArbitro = fuente.readLine();
				if (lineaArbitro != null) {
					vectorArbitro = lineaArbitro.split(", ");
				}
			}
			System.out.println("El �rbitro " + nombreModificar + " ha sido modificado con �xito."
					+ "\nPor favor, comprueba el archivo �rbitroModificar.txt");
			fuente.close();
			destino.close();
		} catch (IOException e) {
			System.out.println("Error al modificar arbitros.txt");
		}
	}
}
