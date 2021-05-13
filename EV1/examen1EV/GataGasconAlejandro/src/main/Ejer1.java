package main;

import java.util.Scanner;

public class Ejer1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		
		System.out.println("MENU");
		System.out.println("A. Tablas de multiplicar de pares descendiente.");
		System.out.println("B. Factoriales de impares en orden ascendente.");
		System.out.println("C. Salir.");
		System.out.print("Elegir Opción: ");
		char opcion = in.next().charAt(0);
		do {
			if (opcion == 'A' || opcion == 'a') {		//Tabla del 2: 110, tabla del 4: 220
				System.out.println("Indique el primer número (entre 1 y 10): ");
				int a = in.nextInt();
				System.out.println("Indique el segundo número (entre 1 y 10): ");
				int b = in.nextInt();
				if (a < 1 || b < 1 || a > 10 || b > 10) {
					System.out.println("Error al introducir los datos. El programa se cerrará.");
					System.exit(0);
				}
				int mayor,menor;
				int producto, suma;
				if (b<a) {
					mayor = a;
					menor = b;
				}
				else {
					mayor = b; 
					menor = a;
				}
				for (int i=mayor; i>=menor; i--) {
					suma = 0;
					if (i % 2 == 0) {
						for (int j=1; j<=10; j++) {
							producto = i*j;
							System.out.println(i + " x " + j + " = " + producto );
							suma = suma + producto;							
						}
						System.out.println("El total de la suma es " + suma + ".\n");
					}
				}
				
			}
			
			
			else if (opcion == 'B' || opcion == 'b') {
				System.out.println("Indique el primer número (entre 1 y 10): ");
				int a = in.nextInt();
				System.out.println("Indique el segundo número (entre 1 y 10): ");
				int b = in.nextInt();
				if (a < 1 || b < 1 || a > 10 || b > 10) {
					System.out.println("Error al introducir los datos. El programa se cerrará.");
					System.exit(0);
				}
				int mayor,menor;
				int f, suma = 0;
				if (b<a) {
					mayor = a;
					menor = b;
				}
				else {
					mayor = b; 
					menor = a;
				}
				for (int i = menor; i<= mayor; i++) {
					f = 1;
					if (i % 2 != 0) {
						for (int j = 1; j<=i; j++) {
							f = f*j;
						}
						System.out.println("El factorial de " + i + " es : " + f);
						suma = suma+f;
					}					
				}
				System.out.println("La suma de los factoriales es: " + suma + ".");
				
			}
			else {
				System.out.println("Opción no válida.");
			}
			System.out.println("MENU");
			System.out.println("A. Tablas de multiplicar de pares descendiente.");
			System.out.println("B. Factoriales de impares en orden ascendente.");
			System.out.println("C. Salir.");
			System.out.print("Elegir Opción: ");
			opcion = in.next().charAt(0);
		} while (opcion != 'C' && opcion != 'c');
		System.out.println("¡Hasta luego!");
	}

}
