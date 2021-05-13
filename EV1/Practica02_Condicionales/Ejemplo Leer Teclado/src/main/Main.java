package main;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		//1.Declarar el teclado
		Scanner in = new Scanner(System.in);
		//2.Crear una variable donde guardar lo que leo por teclado
		String nombre;
		//3. Almacenar en la variable la lectura de teclado
		System.out.println("Hola, ¿cómo te llamas?");
		nombre = in.nextLine();
		System.out.println("Bienvenido, " + nombre);

	}

}
