package main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		/* Ejercicio 1: Programa que calcula el descuento de
		 * una compra de manzanas y peras. Se le introduce el número
		 * de kg de compra de manzanas y peras y mostrará por pantalla
		 * el descuento final de la compra. */
		
		Scanner in = new Scanner (System.in);
		int manzanas, peras;
		
		//Pedimos por teclado los datos
		System.out.println("Hola, introduzca el número de kg de manzanas: ");
		manzanas = in.nextInt();
		System.out.println("\nAhora introduzca el número de kg de peras: ");
		peras = in.nextInt();
		System.out.println("Ha comprado: " + manzanas + " kg de manzanas y "
				+ peras + " kg de peras. ");
		//Evaluamos las condiciones
		if (manzanas < 0 || peras < 0) {
			//Si hay error en los datos, se finaliza el programa
			System.out.println("Error, no puede comprar un número de kg negativo.");
			System.exit(0);
		}
		if (manzanas <= 2) {
			if (peras == 0)
				System.out.println("No aplica descuento en este caso.");
			
			else if (peras <= 2)
				System.out.println("El descuento es del 5%");
			
			else 
				System.out.println("El descuento es del 10%");
		}
		
		else if (manzanas <= 5) { 
			//ya sabemos que es mayor que 2, porque ha saltado el primer if
			if (peras >= 2 && peras <=4)
				System.out.println("El descuento es del 10%");
			else if (peras > 4)
				System.out.println("El descuento es del 20%");
			else 
				System.out.println("El descuento es del 5%");
		}
		else if (manzanas <=10 ) {
			//por el mismo motivo, sabemos que es mayor que 5
			if (peras>0)
				System.out.println("El descuento es del 15%");
			else 
				System.out.println("El descuento es del 10%");
		}
		else
			//solo queda que sea mayor que 10
			System.out.println("El descuento es del 20%");
	}

}
