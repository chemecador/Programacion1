package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		int horas = 0, categoria = 0, extras = 0, horasMayor = 0,
			horasMenor = 0, categoriaMayor = 0, categoriaMenor = 0;
		double sueldoBruto = 0, sueldoNeto = 0;
		boolean parar = false;
		
		//inicializamos los datos
		
		System.out.println("Introduzca su nombre (* = fin): ");
		String nombre = in.nextLine();
		String nombreMayor = nombre, nombreMenor = nombre;
		System.out.println("Introduzca las horas trabajadas: ");
		horas = in.nextInt();
		if (horas < 0) {
			System.exit(0);
		}
		System.out.println("Introduzca la categoría: ");
		categoria = in.nextInt();
		
		System.out.println("Introduzca las horas extras: ");
		extras = in.nextInt();
		if (extras < 0) {
			System.exit(0);
		}
		if (categoria == 1) {
			sueldoBruto = 30*horas + 35*extras;
			sueldoNeto = 0.86*sueldoBruto;
		}
		else if (categoria == 2) {
			sueldoBruto = 20*horas + 25*extras;
			sueldoNeto = 0.84*sueldoBruto;
		}
		else if (categoria == 3) {
			sueldoBruto = 10*horas + 15*extras;
			sueldoNeto = 0.88*sueldoBruto;
		}
		else {
			System.out.println("Error al introducir la categoría.");
			System.exit(0);
		}

		in.nextLine();
		horasMayor = horas+extras;
		horasMenor = horas+extras;
		categoriaMayor = categoria;
		categoriaMenor = categoria;
		
		System.out.println("Sueldo Bruto: " + sueldoBruto);
		System.out.println("Sueldo Neto: " + sueldoNeto);
		
		System.out.println("Introduzca su nombre: ");
		nombre = in.nextLine();
		if (nombre.equals("*"))
			parar = true;
		
		while (!parar) {
			System.out.println("Introduzca las horas trabajadas: ");
			horas = in.nextInt();
			if (horas < 0) {
				System.exit(0);
			}
			System.out.println("Introduzca la categoría: ");
			categoria = in.nextInt();
			System.out.println("Introduzca las horas extras: ");
			extras = in.nextInt();
			if (extras < 0) {
				System.exit(0);
			}
			if (categoria == 1) {
				sueldoBruto = 30*horas + 35*extras;
				sueldoNeto = 0.86*sueldoBruto;
			}
			else if (categoria == 2) {
				sueldoBruto = 20*horas + 25*extras;
				sueldoNeto = 0.84*sueldoBruto;
			}
			else if (categoria == 3) {
				sueldoBruto = 10*horas + 15*extras;
				sueldoNeto = 0.88*sueldoBruto;
			}
			else {
				System.out.println("Error al introducir la categoría. El programa se cerrará.");
				System.exit(0);
			}

			in.nextLine();
						
			if (horas+extras > horasMayor) {
				horasMayor = horas+extras;
				nombreMayor = nombre;
				categoriaMayor = categoria;
			}
			else if (horas+extras < horasMenor) {
				horasMenor = horas+extras;
				nombreMenor = nombre;
				categoriaMenor = categoria;
			}		
			
			System.out.println("Sueldo Bruto: " + sueldoBruto);
			System.out.println("Sueldo Neto: " + sueldoNeto);
			
			System.out.println("Introduzca su nombre: ");
			nombre = in.nextLine();
			if (nombre.equals("*"))
				parar = true;
		}

		
		System.out.println("TRABAJADOR CON MÁS HORAS: ");
		System.out.println("Nombre: " + nombreMayor);
		System.out.println("Categoría: " + categoriaMayor);
		System.out.println("Número de horas (totales): " + horasMayor);
		
		System.out.println("\nTRABAJADOR CON MENOS HORAS: ");
		System.out.println("Nombre: " + nombreMenor);
		System.out.println("Categoría: " + categoriaMenor);
		System.out.println("Número de horas (totales): " + horasMenor);
		
	
	}

}