package autobus;

import java.util.Scanner;

public class Urbano extends Autobus {
	private char ruta;

	Urbano() {
		Scanner in = new Scanner(System.in);
		System.out.println("¿Cuál es la ruta?");
		this.ruta = in.nextLine().charAt(0);
	}

	public float calcularPrecio() {

		if (this.ruta == 'A') {
			return (super.getPrecioBase() * 1.1f);
		} else {
			return (super.getPrecioBase() * 1.2f);
		}
	}
}
