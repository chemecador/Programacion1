package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		int tarifa, horas;
		float sueldoBruto, sueldoNeto;
		String nombre;
		System.out.println("Introduzca el número de horas que ha trabajado: ");
		horas = in.nextInt();
		in.nextLine();
		System.out.println("Introduzca su nombre: ");
		nombre = in.nextLine();
		System.out.println("Vale, ahora introduzca la tarifa: ");
		tarifa = in.nextInt();
		
		if (horas<35)
			sueldoBruto = tarifa*horas;			
		else
			sueldoBruto = 35*tarifa + (horas-35)*tarifa*1.5f;
		
		if (sueldoBruto<=2000)
			sueldoNeto = sueldoBruto;
		
		else {
			if (sueldoBruto<=3500)
				sueldoNeto = sueldoBruto*0.8f;
			else
				//sueldoNeto = sueldoBruto - (sueldoBruto-1500)*0.2f - (sueldoBruto-3500)*0.3f;
				sueldoNeto = sueldoBruto*0.7f;
		}
		
		System.out.println(" Su nombre es " + nombre + ", su salario bruto es de " + 
		sueldoBruto + "€ y le corresponden " + sueldoNeto + " €. ");
	}

}
