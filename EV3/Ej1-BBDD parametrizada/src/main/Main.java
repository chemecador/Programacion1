package main;


public class Main {
	public static void main (String[] args) {

		BaseDeDatos miBBDD = new BaseDeDatos();
		//1. Cargar controlador
		miBBDD.cargarControlador();
		
		//2. Conectar con la BBDD
		miBBDD.conectarBBDD();
		Menu.mostrarMenu();
		//3. Cerrar
		miBBDD.cerrarConexion();
	}
}
