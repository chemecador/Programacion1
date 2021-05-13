package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("¿Cuántas notas vas a rellenar?");
		int cantidadNotas = in.nextInt();

		while (cantidadNotas <= 0) {
			System.out.println("El número de notas a rellenar debe ser al menos 1.");
			System.out.println("¿Cuántas notas vas a rellenar?");
			cantidadNotas = in.nextInt();
		}
		int[] notas = new int[cantidadNotas];
		OperacionesVector.rellenarNotas(notas);
		int opcion=1;
		do {
	
			System.out.println("MENÚ");
			System.out.println("1. Ver las notas.");
			System.out.println("2. Media de la clase");
			System.out.println("3. Buscar un valor en el vector");
			System.out.println("4. Salir");
			System.out.println("Elegir opción (1-4)");
			
			opcion = in.nextInt();
			while(opcion < 1 || opcion > 4) {
				System.out.println("Opción incorrecta. Vuelve a intentarlo:\n");
				System.out.println("1. Ver las notas.");
				System.out.println("2. Media de la clase");
				System.out.println("3. Buscar un valor en el vector");
				System.out.println("4. Salir");
				System.out.println("Elegir opción (1-4)");
				opcion = in.nextInt();
			}
			//ver las notas
			if (opcion == 1) { 
				OperacionesVector.visualizarNotas(notas);
			}
			//media de la clase
			if (opcion == 2) {
				System.out.println("La media es " + OperacionesVector.calcularMedia(notas));			
			}
			//buscar una nota
			if (opcion == 3) {
				System.out.println("¿Qué nota deseas buscar?");
				int notaBuscar=in.nextInt();
				while(notaBuscar < 0 || notaBuscar > 10) {
					System.out.println("La nota debe estar entre 0 y 10.");
					notaBuscar=in.nextInt();
				}
					if (OperacionesVector.buscarNota(notas, notaBuscar) == -1)
						System.out.println("La nota " + notaBuscar + " no aparece.");
					else
						System.out.println("La nota " + notaBuscar + " la ha sacado "
							+ "por primera vez el alumno " + (OperacionesVector.buscarNota(notas, notaBuscar)+1) 
							+ " (se encuentra en la posición " + OperacionesVector.buscarNota(notas, notaBuscar)
							+ " del vector). ");
				
			}
		}while(opcion!=4);
		System.out.println("¡Adiós!");

	}
}