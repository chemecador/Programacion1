package autobus;

public class Main {

	public static void main(String[] args) {

		Urbano busUrbano = new Urbano();
		Interurbano busInterurbano = new Interurbano();
		busUrbano.rellenar();
		busInterurbano.rellenar();
		busUrbano.visualizar();
		busInterurbano.visualizar();
		System.out.println("El precio del bus urbano es: " + busUrbano.calcularPrecio());
		System.out.println("El precio del bus interurbano es : " + busInterurbano.calcularPrecio());

	}

}
