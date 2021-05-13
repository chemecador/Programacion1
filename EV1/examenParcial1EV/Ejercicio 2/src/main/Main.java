package main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		/*
		 * Programa con un pequeño menú al que le introduces
		 * el curso que quieres realizar y te da permiso o no
		 * para cursarlo dependiendo de si eres alumno de Montessori
		 * y de tu nota media
		 * */
		Scanner in = new Scanner (System.in);
		
		//Primero, realizaremos un pequeño menú con las 3 opciones
		
		int opcion, nota;
		int alumnoInt;
		boolean alumno = false; //por defecto es falso
		
		System.out.println("Hola, bienvenido al colegio Montessori. "
				+ "\nAquí podrá realizar 3 cursos: PROGRAMACIÓN, MYSQL Y SISTEMAS."
				+ "\nPor favor, indique el número que corresponda en cada caso:"
				+ "\n\tSi quiere cursar PROGRAMACIÓN, pulse 1."
				+ "\n\tSi quiere cursar MYSQL, pulse 2."
				+ "\n\tSi quiere cursar SISTEMAS, pulse 3.");
		
		opcion = in.nextInt();
		
		if (opcion < 1 || opcion > 3) {
			System.out.println("Opción no válida. Le recordamos las opciones:"
					+ "\n\tSi quiere cursar PROGRAMACIÓN, pulse 1."
					+ "\n\tSi quiere cursar MYSQL, pulse 2."
					+ "\n\tSi quiere cursar SISTEMAS, pulse 3."				
					+ "\n\n El programa se cerrará. Vuelva a ejecutar"
					+ " el programa para intentarlo de nuevo.");
			System.exit(0);
		}
		
		System.out.println("Ha escogido la opción "+ opcion
				+". ¿Es usted alumno de colegio Montessori?"
				+ "\n\tSi ya es alumno, pulse 1."
				+ "\n\tSi NO es alumno, pulse 0.");
		
		alumnoInt = in.nextInt();
		
		if (alumnoInt != 0 && alumnoInt != 1) {
			System.out.println("Opción no válida. Le recordamos las opciones:"
					+ "\n\tSi ya es alumno, pulse 1."
					+ "\n\tSi NO es alumno, pulse 0."
					+ "\n\n El programa se cerrará. Vuelva a ejecutar"
					+ " el programa para intentarlo de nuevo.");
			System.exit(0);
		}
		
		System.out.println("Perfecto. Ahora, introduzca por favor su nota media: ");
		
		nota = in.nextInt();
		
		if (nota < 0 || nota > 10) {
			System.out.println("Error, la nota debe estar entre 0 y 10."
					+ "\n\nEl programa se cerrará. Vuelva a ejecutar"
					+ " el programa para intentarlo de nuevo.");
			System.exit(0);
		}
		
		//Todos los datos han sido introducidos y son correctos
		
		if (alumnoInt == 1) //por defecto es falso, solo lo cambiamos cuando
			alumno = true; //haya introducido '1'
		
		if (opcion == 1) {
			if (nota >= 5 && alumno)
				System.out.println("Puede matricularse en programación");
			
			else 
				System.out.println("No puede realizar el curso de programación por no"
						+ " haber aprobado o no ser Montessori");
		}
		
		else if (opcion == 2) {
			if (nota > 7 && alumno) 
				System.out.println("Puede hacer el curso de MySQL y le regalamos"
						+ "la matrícula");
			
			else if (nota < 7 && nota >= 5 && alumno) 
				System.out.println("Puede hacer el curso de MySQL y tiene descuento"
						+ " en la matrícula");
			
			else if (nota < 7 && nota >= 5 && !alumno) 
				System.out.println("Puede hacer el curso de MySQL");
				
			else //nota = 7 y alumno || no es alumno y nota > 7 || nota < 5
				System.out.println("No puede hacer el cuso de MySQL");
		}
		
		else { //solo queda la opcion 3
			if (alumno)
				System.out.println("Puede hacer el curso de Sistemas "
						+ "independientemente de la nota");
			
			else if (!alumno && nota>=5) 
				System.out.println("Puede hacer el curso de sistemas aunque no sea Montessori");
			
			else //no es alumno y ha suspendido
				System.out.println("No puede hacer el curso de sistemas");
		}
	}
}
