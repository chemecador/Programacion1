package main;

import java.util.Scanner;

public class OperacionesVector {

	static Scanner in = new Scanner(System.in);
	
	/*
	 * Rellena las notas del vector introducido como parámetro
	 */
	public static void rellenarNotas(int notas[]) {
		int notaAlumno;
		for (int i=0;i<notas.length;i++) {
			System.out.println("Introduzca la nota del alumno: " + (i+1) + ": " );
			notaAlumno= in.nextInt();
			while(notaAlumno < 0 || notaAlumno > 10) {
				System.out.println("La nota debe estar entre 0 y 10. ");
				System.out.println("Introduzca la nota del alumno: " + (i+1) + ": " );
				notaAlumno= in.nextInt();
			}
			notas[i] = notaAlumno;
		}
	}
	
	/*
	 * Visualiza las notas del vector introducido como parámetro
	 */
	public static void visualizarNotas(int notas[]) {
		for (int i=0;i<notas.length;i++) {
			System.out.println("La nota del alumno " + (i+1) + " es: " + notas[i]);
		}
	}
	
	/*
	 * Devuelve la media de las notas del vector introducido como parámetro
	 */
	public static int calcularMedia(int notas[]) {
		int total=0;
		for (int i=0;i<notas.length;i++) {
			total += notas[i];
		}
		return (total/notas.length);
	}
	
	/*
	 * Devuelve la nota a buscar del vector introducido como parámetro
	 */
	public static int buscarNota(int notas[], int notaBuscar) {
		for (int i=0;i<notas.length;i++) {
			if (notas[i] == notaBuscar) return i;
		}
		return -1;
	}
}
