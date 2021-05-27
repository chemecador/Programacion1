package academia;

import java.util.Scanner;

public abstract class Persona implements CosasPersona, Comparable<Persona> {
	static Scanner in = new Scanner(System.in);

	private String dni;
	private String nombre;

	Persona() {
		this.dni = "";
		this.nombre = "";
	}

	Persona(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}

	public void rellenar() {
		System.out.println("Nombre de la persona: ");
		this.nombre = in.nextLine();
		System.out.println("DNI: ");
		this.dni = in.nextLine();
	}

	public void visualizar() {
		System.out.println("Nombre de la persona: " + this.nombre);
		System.out.println("DNI: " + this.dni);
	}
	public int compareTo(Persona otraPersona) {
		return (this.dni.compareTo(otraPersona.getDni()));
	}
}
