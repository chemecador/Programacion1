package academia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Colegio {
	static Scanner in = new Scanner(System.in);

	private String nombreColegio;
	private ArrayList<Persona> listadoPersonal;

	public Colegio() {
		this.nombreColegio = "";
		this.listadoPersonal = new ArrayList<Persona>();
	}

	public Colegio(String nombreColegio, ArrayList<Persona> listadoPersonal) {
		this.nombreColegio = nombreColegio;
		this.listadoPersonal = listadoPersonal;
	}

	public String getNombreColegio() {
		return nombreColegio;
	}

	public void setNombreColegio(String nombreColegio) {
		this.nombreColegio = nombreColegio;
	}

	public ArrayList<Persona> getListadoPersonal() {
		return listadoPersonal;
	}

	public void setListadoPersonal(ArrayList<Persona> listadoPersonal) {
		this.listadoPersonal = listadoPersonal;
	}

	public void rellenarColegio() {
		String seguir = "si";
		while (seguir.equalsIgnoreCase("si")) {
			System.out.println("¿Qué quieres añadir? Alumno/Profesor");
			String opcion = in.nextLine();
			if (opcion.equalsIgnoreCase("alumno")) {
				Alumno nuevoAlumno = new Alumno();
				nuevoAlumno.rellenar();
				listadoPersonal.add(nuevoAlumno);

			} else if (opcion.equalsIgnoreCase("profesor")) {
				Profesor nuevoProfesor = new Profesor();
				nuevoProfesor.rellenar();
				listadoPersonal.add(nuevoProfesor);
			} else {
				System.out.println("Error. " + opcion + " no es ni alumno ni profesor.");
			}
			System.out.println("¿Quieres añadir otro dato?");
			seguir = in.nextLine();
			while (!seguir.equalsIgnoreCase("si") && !seguir.equalsIgnoreCase("no")) {
				System.out.println("No te entiendo. Solo responde \"SI\" o \"NO\" ");
				seguir = in.nextLine();
			}
		}
	}

	public void ordenarColegio() {
		Collections.sort(listadoPersonal);
	}

	public void visualizarColegio() {
		System.out.println("Hay un total de " + listadoPersonal.size() + " personas:\n");
		int numProfesores = 0;
		int numAlumnos = 0;
		for (Persona persona : listadoPersonal) {

			if (persona.getClass().getSimpleName().equals("Profesor")) {
				numProfesores++;
				System.out.println("Profesor número " + numProfesores);
			} else if (persona.getClass().getSimpleName().equals("Alumno")) {
				numAlumnos++;
				System.out.println("Alumno número " + numAlumnos);
			}
			persona.visualizar();
			System.out.println();
		}
	}

	public void metodosColegio() {
		rellenarColegio();
		ordenarColegio();
		visualizarColegio();		
	}

}
