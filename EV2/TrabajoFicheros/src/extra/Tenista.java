package extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Tenista: La clase Tenista tiene 3 atributos: nombre, pa�s y puesto que
 * ocupa en el ranking. Por defecto, se ha le�do la informaci�n del Top 10 (los
 * 10 mejores tenistas del mundo) a partir del fichero tenista.txt y se ha
 * creado un ArrayList de Tenistas al ejecutar el programa. El usuario puede
 * modificar y buscar los tenistas, as� como mostrar el mejor y el peor del
 * ranking.
 * 
 * @author Alejandro Gata
 * @since 1.8
 */

public class Tenista {
	private String nombre;
	private String pais;
	private int puestoRanking;

	/**
	 * Construtor de la clase
	 */
	public Tenista() {
		this.nombre = "";
		this.pais = "";
		this.puestoRanking = 0;
	}

	/**
	 * Sobrecarga de constructor.
	 * 
	 * @param nombre : nombre del tenista.
	 * @param pais   : pa�s de nacimiento del tenista.
	 * @param puesto : puesto que ocupa el tenista en el ranking.
	 */
	public Tenista(String nombre, String pais, int puesto) {
		this.nombre = nombre;
		this.pais = pais;
		this.puestoRanking = puesto;
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

	public int getPuestoRanking() {
		return puestoRanking;
	}

	public void setPuestoRanking(int puestoRanking) {
		this.puestoRanking = puestoRanking;
	}

	/**
	 * M�todo que visualiza la informaci�n del tenista.
	 */
	public void visualizarTenista() {
		System.out.println("Su nombre es: " + this.nombre);
		System.out.println("Su pa�s de nacimiento es: " + this.pais);
		System.out.println("Su posici�n en el ranking es: " + this.puestoRanking);
	}

	/**
	 * M�todo que permite modificar el tenista.
	 */
	public void modificarTenista() {
		String nombreModificar = this.nombre;
		System.out.println("Est�s modificando a " + nombreModificar);
		Scanner in = new Scanner(System.in);
		System.out.println("�Qu� nombre le quieres dar?");
		this.nombre = in.nextLine();
		System.out.println("�Cu�l es su pa�s de nacimiento?");
		this.pais = in.nextLine();
		System.out.println("�Cu�l es su puesto en el ranking?");
		int p = in.nextInt();
		boolean errorLectura = true;
		do {
			try {
				while (p < 10 && p != this.puestoRanking) {
					if (p < 1) {
						System.out.println("Ese puesto no existe...");
					} else {
						System.out.println("No puedes modificar el Top 10.");
					}
					System.out.println("Prueba de nuevo: ");
					p = in.nextInt();
				}
				errorLectura = false;
			} catch (InputMismatchException e) {
				System.out.println("Error de lectura");
				in.nextLine();
				errorLectura = true;
			} catch (Exception e) {
				System.out.println("Error de teclado");
				in.nextLine();
				errorLectura = true;
			}
		} while (errorLectura);

		this.puestoRanking = p;
		try {
			BufferedReader fuente = new BufferedReader(new FileReader("tenistas.txt"));
			PrintWriter destino = new PrintWriter(new FileWriter("tenistasModificar.txt", false));
			String lineaTenista = fuente.readLine();
			String[] vectorTenista = lineaTenista.split(", ");
			while (lineaTenista != null) {
				if (vectorTenista[0].equalsIgnoreCase(nombreModificar)) {
					destino.println(this.nombre + ", " + this.pais + ", " + this.puestoRanking);
				} else {
					destino.println(lineaTenista);
				}
				lineaTenista = fuente.readLine();
				if (lineaTenista != null) {
					vectorTenista = lineaTenista.split(", ");
				}
			}
			System.out.println("El tenista " + nombreModificar + " ha sido modificado con �xito."
					+ "\nPor favor, compruebe el archivo tenistaModificar.txt");
			fuente.close();
			destino.close();
		} catch (IOException e) {
			System.out.println("Error al modificar el tenista.");
		}
	}
}
