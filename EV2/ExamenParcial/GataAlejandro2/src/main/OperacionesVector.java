package main;

import java.util.Scanner;

public class OperacionesVector {
	
	static Scanner in = new Scanner (System.in);
	
	/*
	 * Rellena el vector de pedidos introducido como par�metro
	 */
	public static void rellenarVector(String pedidos[]) {
		String comida="", bebida="";
		for (int i=0;i<pedidos.length;i++) {
			System.out.println("Elegir pedido (Hamburguesa o Perrito)");
			comida=in.nextLine().toLowerCase();
			
			while (!comida.equalsIgnoreCase("hamburguesa") &&!comida.equalsIgnoreCase("perrito")) {
				System.out.println("La opci�n " + comida + " no aparece en la carta.");
				System.out.println("Elegir pedido (Hamburguesa o Perrito)");
				comida=in.nextLine().toLowerCase();
			}
			
			System.out.println("Elegir bebida (refresco, ca�a o agua)");
			bebida=in.nextLine().toLowerCase();
			while (!bebida.equalsIgnoreCase("refresco") && !bebida.equalsIgnoreCase("ca�a")
					&& !bebida.equalsIgnoreCase("agua")) {
				System.out.println("La opci�n " + bebida + " no aparece en la carta.");
				System.out.println("Elegir pedido (Hamburguesa o Perrito)");
				bebida=in.nextLine().toLowerCase();
			}
			
			pedidos[i] = comida + " con " + bebida;
			System.out.println("Pedido realizado: " + pedidos[i]);
		}
	}
	
	/*
	 * Visualiza los pedidos del vector introducido como par�metro
	 */
	public static void visualizarPedidos(String pedidos[]) {
		for (int i=0;i<pedidos.length;i++) {
			System.out.println("Pedido n�mero " + (i+1) + ": " + pedidos[i]);
		}
	}
	/*
	 * Devuelve el pedido extra del vector introducido como par�metro.
	 * 
	 * Planteamiento: la bebida se mostrar� siempre despu�s del segundo espacio,
	 * 		as� que buscaremos el segundo espacio y devolveremos el resto de la cadena hasta el final.
	 */
	public static String mostrarExtra(String pedido) {
		String extra ="";
		int contadorEspacios = 0, i=0;
		
		while (i<pedido.length()) {
			if (pedido.charAt(i) == ' ') {
				contadorEspacios++;
				i++;
			}
			if (contadorEspacios==2) {
				extra += pedido.charAt(i);
			}
			i++;
		}
		
		return extra;
	}
}
