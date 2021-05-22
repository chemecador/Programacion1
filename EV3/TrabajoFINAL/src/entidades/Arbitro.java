package entidades;

/**
 * Clase Arbitro: La clase Arbitro tiene 3 atributos: el nombre, el país de
 * nacimiento y su reputación. Por defecto, se han leído los árbitros más
 * reconocidos a nivel mundial a través del fichero arbitros.txt y se ha
 * almacenado en un ArrayList de arbitros al ejecutar el programa
 * 
 * @author Alejandro Gata
 * @since 1.8
 */

public class Arbitro extends Persona {
	private Reputacion rep;

	/**
	 * Constructor
	 */
	public Arbitro() {
		super();
		this.rep = null;
	}

	/**
	 * Sobrecarga de constructor
	 * 
	 * @param rep Reputación
	 */
	public Arbitro(Reputacion rep) {
		super();
		this.rep = rep;
	}

	public Reputacion getRep() {
		return rep;
	}

	public void setRep(Reputacion rep) {
		this.rep = rep;
	}

	/**
	 * Método que visualiza un árbitro
	 */
	public void visualizar() {
		super.visualizar();
		System.out.println("Su reputación es " + this.rep);
	}

	/**
	 * Método que rellena un árbitro
	 */
	public void rellenar() {
		super.rellenar();
		System.out.println("Introduzca su reputación (BUENA, NORMAL, MALA)");
		boolean error = false;
		do {
			try {
				this.rep = Reputacion.valueOf(in.nextLine());
				error = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Error, no ha escrito correctamente la reputación.");
				error = true;
			}
		} while (error);
	}

	@Override
	public int compareTo(Persona otraPersona) {

		return super.getNombre().compareTo(otraPersona.getNombre());
	}
}
