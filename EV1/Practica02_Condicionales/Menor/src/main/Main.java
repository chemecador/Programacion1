package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Introduzca el primer numero: ");
		int n1,n2,n3,menor;
		n1=in.nextInt();
		menor=n1;
		//System.out.println("\nSu numero es: " + n1);
		System.out.println("\nIntroduzca el segundo numero: ");
		n2=in.nextInt();
		if (n2<menor)
			menor=n2;
		System.out.println("\nIntroduzca el tercer numero: ");
		n3=in.nextInt();
		if (n3<menor)
			menor=n3;
		System.out.println("\nEl menor es: " + menor);
	}
}
