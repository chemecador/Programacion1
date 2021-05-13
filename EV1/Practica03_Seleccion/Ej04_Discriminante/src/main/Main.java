package main;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	
	Scanner in = new Scanner(System.in);
	int a,b,c;
	double x,d;
	
	System.out.println("Introduzca el valor de A: ");
	a = in.nextInt();
	System.out.println("Introduzca el valor de B: ");
	b = in.nextInt();
	System.out.println("Introduzca el valor de C: ");
	c = in.nextInt();	
	d = b*b-(4*a*c);
	
	if (d<0)
		System.out.println("No se puede resolver");
	else if (d==0) {
		x = -b/(2*a);
		System.out.println("X = " + x);
	}
	else {
		double x2;
		x = -b+Math.sqrt(d)/(2*a);
		x2 = -b-Math.sqrt(d)/(2*a);
		System.out.println("Tiene dos soluciones: X1 = " + x + " y X2 = " + x2);
		}
	
	}

}
