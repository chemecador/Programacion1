package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("¿Cuántos pedidos vas a realizar? ");
		int totalPedidos = in.nextInt();
		while(totalPedidos <= 0 ) {
			System.out.println("Debes realizar al menos 1 pedido");
			System.out.println("¿Cuántos pedidos vas a realizar? ");
			totalPedidos = in.nextInt();
		}
		String pedidos[] = new String[totalPedidos];

		OperacionesVector.rellenarVector(pedidos);
		System.out.println("\nLos pedidos son:");
		
		OperacionesVector.visualizarPedidos(pedidos);
		System.out.println("\n¿Qué posición deseas buscar?");
		int posicion = in.nextInt();
		while (posicion < 1 || posicion>totalPedidos) {
			System.out.println("Error. No existe la posición " + posicion);
			System.out.println("¿Qué posición deseas buscar?");
			posicion = in.nextInt();
		}
		System.out.println("La posición "+ posicion + 
				" ha pedido para beber " + "\"" + OperacionesVector.mostrarExtra(pedidos[posicion-1] + "\""));
		
	}

}
