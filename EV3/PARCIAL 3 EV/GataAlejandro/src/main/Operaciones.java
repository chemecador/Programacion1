package main;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import montessori.Concierto;
import montessori.Montessori;
import montessori.Teatro;

public class Operaciones {
	static Scanner in = new Scanner (System.in);
	public static void rellenarMain(ArrayList<Montessori> v) {

		String opcion= "";
		String seguir = "";
		do {
			System.out.println("¿Qué quiere rellenar? (concierto/teatro)");
			opcion = in.nextLine();
			if(opcion.equalsIgnoreCase("concierto")) {
				Concierto unConcierto = new Concierto();
				unConcierto.rellenar();
				v.add(unConcierto);
			}
			else if (opcion.equalsIgnoreCase("teatro")) {
				Teatro unTeatro = new Teatro();
				unTeatro.rellenar();
				v.add(unTeatro);
			}
			else {
				System.out.println("Error. " + opcion + " no es ni concierto ni teatro");
			}
			do {
				System.out.println("¿Quiere continuar? (si/no)");
				seguir = in.nextLine();
			} while (!seguir.equalsIgnoreCase("si") && !seguir.equalsIgnoreCase("no"));
		}while (!seguir.equalsIgnoreCase("no"));
	}
	public static void visualizarMain(ArrayList<Montessori> v) {
		for (Montessori montessori : v) {
			if (montessori.getClass().getSimpleName().equalsIgnoreCase("Concierto")) {
				System.out.println("Está visualizando un concierto.");
			}
			else if (montessori.getClass().getSimpleName().equalsIgnoreCase("Teatro")) {
				System.out.println("Está visualizando un teatro. ");
			}
			montessori.visualizar();
		}
		
	}
	public static void visualizarRAF() {
		try {
			RandomAccessFile f = new RandomAccessFile("teatro","rw");
			f.seek(0);
			System.out.println(f.readUTF());
			
		} catch (IOException e) {
			System.out.println("No hay información acerca del teatro.");
		}
	}
}
