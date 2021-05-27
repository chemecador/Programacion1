package main;

import java.util.Scanner;

public class Menu {
	static Scanner in = new Scanner (System.in);
	
	public static int mostrarMenu() {
		System.out.println("MENÚ DE LA BASE DE DATOS");
		System.out.println("1. Crear tabla");
		System.out.println("2. Insertar valores");
		System.out.println("3. Visualizar");
		System.out.println("4. Modificar");
		System.out.println("5. Eliminar");
		return in.nextInt();
	}

	
}
