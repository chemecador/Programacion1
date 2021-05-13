package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		/*Mostrar el promedio de grupos que están en un mismo año escolar; siendo que cada grupo puede
		tener n alumnos que cada alumno puede llevar m materias y que en todas las materias se
		promedian tres calificaciones para obtener el promedio de la materia. Lo que se desea desplegar es
		el promedio de los grupos, el promedio de cada grupo y el promedio de cada alumno*/
		
		Scanner in = new Scanner (System.in);
		System.out.println("Indique el número de grupos: ");
		int grupos = in.nextInt();
		System.out.println("Indique el número de alumnos: ");
		int alumnos = in.nextInt();
		int materias, nota, numNotas = 3;
		float mediaNota;
		
		for (int i=1; i<=grupos; i++) {
			for (int n=1; n<=alumnos; n++) {
				System.out.println("Indique el número de materias del alumno " + n + " :");
				materias = in.nextInt();
				if (materias < 1) {
					System.out.println("Error en los datos. El programa se cerrará.");
					System.exit(0);
				}
				for (int m=1; m<=materias; m++) {
					mediaNota = 0;
					for (int l = 1; l<=numNotas; l++) {	
						System.out.println("Introduzca la nota " + l + " de la materia " + m + " :");
						nota = in.nextInt();
						mediaNota = mediaNota + nota;
						if (nota < 0 || nota > 10) {
							System.out.println("Error en los datos. El programa se cerrará.");
							System.exit(0);
						}
					}
				mediaNota = mediaNota / numNotas;
				System.out.println("La nota media del alumno " + n + " en la materia "
						+ m + " es de " + mediaNota);
				}
			}
		}
		
	}

}
