package main;

import java.util.Scanner;

import academia.Alumno;
import academia.BBDD;
import academia.Colegio;
import academia.Profesor;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);
		Colegio colegio = new Colegio();
		colegio.metodosColegio();
		BBDD miBBDD = new BBDD();
		miBBDD.cargarControlador();
		miBBDD.conectarBBDD();
		miBBDD.crearTabla();
		System.out.println("¿Quieres vaciar la base de datos?");
		String opcion = in.nextLine();
		if (opcion.equalsIgnoreCase("si")) {
			miBBDD.vaciarBBDD();
		}
		miBBDD.insertarDatos(colegio.getListadoPersonal());
		miBBDD.visualizarDatos();
		miBBDD.cerrarConexion();
		in.close();
	}

}
