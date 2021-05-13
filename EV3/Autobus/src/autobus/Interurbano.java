package autobus;

import java.util.Scanner;

public class Interurbano extends Autobus {
	private int numKilometros;

	Interurbano() {
		Scanner in = new Scanner(System.in);
		System.out.println("¿Cuál es el número de kilómetros?");
		this.numKilometros = in.nextInt();
		in.nextLine();
	}

	public float calcularPrecio() {

		return super.getPrecioBase() * this.numKilometros;
	}
}
