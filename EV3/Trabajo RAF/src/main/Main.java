package main;

import java.util.Scanner;

import operaciones.Operaciones;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char opcion;
		System.out.println("¿Con qué archivo quieres trabajar?");
		String nombreArchivo = in.nextLine();
		do {
			System.out.println("**MENÚ**");
			System.out.println("1. Crear archivo");
			System.out.println("2. Visualizar archivo");
			System.out.println("3. Modificar");
			System.out.println("4. Mostrar el alumno con la nota más alta");
			System.out.println("5. Salir");
			opcion = in.nextLine().charAt(0);
			
			if (opcion == '1') {
				Operaciones.crearAlumno(nombreArchivo);
			}
			else if (opcion == '2') {
				Operaciones.visualizar(nombreArchivo);
			}
			else if (opcion == '3') {
				Operaciones.modificar(nombreArchivo);
			}
			else if (opcion == '4') {
				Operaciones.mostrarNotaMasAlta(nombreArchivo);
			}
			else if (opcion != '5'){
				System.out.println("\nOpción no disponible\n");
			}
		} while(opcion != 5);
		in.close();
	}

}
