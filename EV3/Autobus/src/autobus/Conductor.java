package autobus;

import java.util.Scanner;

public class Conductor {
	private String nombre;
	private int salario;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public void rellenar() {
		Scanner in = new Scanner(System.in);
		System.out.println("Dime el nombre del conductor: ");
		this.nombre = in.nextLine();
		System.out.println("Dime el salario del conductor: ");
		this.salario = in.nextInt();
		in.nextLine();
	}

	public void visualizar() {
		System.out.println("El nombre del conductor es: " + this.nombre);
		System.out.println("El salario del conductor es " + this.salario);
	}
}
