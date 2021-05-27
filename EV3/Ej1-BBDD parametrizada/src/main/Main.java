package main;


public class Main {
	public static void main (String[] args) {

		BaseDeDatos miBBDD = new BaseDeDatos();
		//1. Cargar controlador
		miBBDD.cargarControlador();
		System.out.println("cargado");
		//2. Conectar con la BBDD
		miBBDD.conectarBBDD();
		miBBDD.crearTabla();
		//miBBDD.insertarDato();
		//miBBDD.borrarDato();
		miBBDD.ver();
		//3. Cerrar
		miBBDD.cerrarConexion();
	}
}
