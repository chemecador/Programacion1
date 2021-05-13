package extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	 * @param nombre : nombre del árbitro.
	 * @param pais   : país de nacimiento del árbitro.s
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
	 * Método que visualiza la información del árbitro.
	 */
	public void visualizarArbitro() {
		System.out.println("Su nombre es: " + this.nombre);
		System.out.println("Su país de nacimiento es: " + this.pais);
	}

	/**
	 * Método que permite modificar el árbitro.
	 */
	public void modificarArbitro() {
		String nombreModificar = this.nombre;
		System.out.println("Estás modificando a " + nombreModificar);
		Scanner in = new Scanner(System.in);
		System.out.println("¿Qué nombre le quieres dar?");
		this.nombre = in.nextLine();
		System.out.println("¿Cuál es su país de nacimiento?");
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
			System.out.println("El árbitro " + nombreModificar + " ha sido modificado con éxito."
					+ "\nPor favor, comprueba el archivo árbitroModificar.txt");
			fuente.close();
			destino.close();
		} catch (IOException e) {
			System.out.println("Error al modificar arbitros.txt");
		}
	}
}
