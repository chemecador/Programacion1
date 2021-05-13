package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int clave, intentos = 0, saldo = 0;
		System.out.println("CAJERO AUTOMÁTICO");
		System.out.println("-----------------");
		System.out.println("Introducir la clave de acceso: ");
		clave = in.nextInt();
		while (clave != 1234 && intentos < 3) {
			System.out.println("Clave incorrecta");
			intentos++;
			if (intentos == 3) {
				System.out.println("Ha introducido una clave incorrecta en 3 ocasiones."
						+ " El programa se cerrará.");
				System.exit(0);				
			}
			System.out.println("Introducir la clave de acceso: ");
			clave = in.nextInt();
		}
		System.out.println("CAJERO AUTOMÁTICO");
		System.out.println("-----------------");
		System.out.println("1. INGRESAR");
		System.out.println("2. RETIRAR");
		System.out.println("3. CONSULTAR SALDO");
		System.out.println("4. SALIR");
		int opcion = in.nextInt();
		while (opcion != 4) {
			if (opcion == 1) {
				System.out.println("¿Cuánto desea ingresar?");
				int ingreso = in.nextInt();
				saldo = saldo + ingreso;
			}
			else if (opcion == 2) {
				System.out.println("¿Cuánto desea retirar?");
				int retiro = in.nextInt();
				saldo = saldo - retiro;			
			}
			else if (opcion == 3) {
				System.out.println("Su saldo es " + saldo + ".");
			}
			else {
				System.out.println("Opción incorrecta.");
			}
			System.out.println("CAJERO AUTOMÁTICO");
			System.out.println("-----------------");
			System.out.println("1. INGRESAR");
			System.out.println("2. RETIRAR");
			System.out.println("3. CONSULTAR SALDO");
			System.out.println("4. SALIR");
			opcion = in.nextInt();
		}
		System.out.println("¡Adiós!");
	}

}
