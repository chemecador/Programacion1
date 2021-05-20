package entidades;

import java.util.InputMismatchException;

/**
 * Clase Tenista: La clase Tenista tiene 3 atributos: nombre, país y puesto que
 * ocupa en el ranking. Por defecto, se ha leído la información del Top 10 (los
 * 10 mejores tenistas del mundo) a partir del fichero tenista.txt y se ha
 * creado un ArrayList de Tenistas al ejecutar el programa. El usuario puede
 * modificar y buscar los tenistas, así como mostrar el mejor y el peor del
 * ranking.
 * 
 * @author Alejandro Gata
 * @since 1.8
 */

public class Tenista extends Persona {
	private int puestoRanking;

	/**
	 * Construtor de la clase
	 */
	public Tenista() {
		super();
		this.puestoRanking = 0;
	}

	/**
	 * Sobrecarga de constructor.
	 * 
	 * @param nombre : nombre del tenista.
	 * @param pais   : país de nacimiento del tenista.
	 * @param puesto : puesto que ocupa el tenista en el ranking.
	 */
	public Tenista(String nombre, String pais, int puesto) {
		super(nombre, pais);
		this.puestoRanking = puesto;
	}

	public int getPuestoRanking() {
		return puestoRanking;
	}

	public void setPuestoRanking(int puestoRanking) {
		this.puestoRanking = puestoRanking;
	}

	/**
	 * Método que visualiza la información del tenista.
	 */
	public void visualizar() {
		super.visualizar();
		System.out.println("Su posición en el ranking es: " + this.puestoRanking);
	}
	

	public void rellenar() {
		super.rellenar();
		System.out.println("¿Cuál es su puesto en el ranking?");
		int p = in.nextInt();
		boolean errorLectura = true;
		do {
			try {
				while (p < 1) {
					System.out.println("El puesto no puede ser menor que 0 ");
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
	}

	@Override
	public int compareTo(Persona otraPersona) {
		
		return super.getNombre().compareTo(otraPersona.getNombre());
	}
}
