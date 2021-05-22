package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import entidades.Persona;
import entidades.Tenista;

/**
 * Clase BBDD: En esta clase se recoge todo lo necesario para trabajar con una
 * base de datos
 * 
 * @author Alejandro Gata
 * @since 1.8
 *
 */
public class BBDD {

	static Scanner in = new Scanner(System.in);

	// Atributos
	private Connection conexion;
	PreparedStatement sentencia = null;

	/**
	 * Método que carga el controlador com.mysql.jdbd.Driver
	 */
	public void cargarControlador() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No he podido conectar con el controlador");
			e.printStackTrace();
		}

	}

	/**
	 * Método para conectar con la base de datos
	 */
	public void conectarBBDD() {

		// 2.1 Declarar el archivo
		FileInputStream f = null;
		try {
			f = new FileInputStream("conf/datos.properties");
		} catch (FileNotFoundException e1) {
			System.out.println("Error con el fichero properties");
			e1.printStackTrace();
		}
		// 2.2 Crear objeto de la clase Properties para usar el archivo
		Properties p = new Properties();
		try {
			p.load(f);
		} catch (IOException e1) {
			System.out.println("Error con los properties");
			e1.printStackTrace();
		}

		this.conexion = null;
		try {
			conexion = DriverManager.getConnection(
					"jdbc:mysql://" + p.getProperty("servidor.nombre") + ":" + p.getProperty("servidor.puerto") + "/"
							+ p.getProperty("servidor.basedatos"),
					p.getProperty("servidor.usuario"), p.getProperty("servidor.contraseña"));
		} catch (SQLException e) {
			System.out.println("Error al conectar con el servidor");
			e.printStackTrace();
		}
	}

	/**
	 * Lee los tenistas de la base de datos y los añade al ArrayList personas
	 * 
	 * @param personas ArrayList que contendrá a los tenistas
	 */
	public void leerTenistas(ArrayList<Persona> personas) {
		String sentenciaSql = "SELECT * FROM tenista";
		try {
			sentencia = conexion.prepareStatement(sentenciaSql);

			ResultSet resultado = sentencia.executeQuery();
			// mostramos los datos
			while (resultado.next()) {
				Tenista nuevoTenista = new Tenista();
				nuevoTenista.setNombre(resultado.getString(1));
				nuevoTenista.setPais(resultado.getString(2));
				nuevoTenista.setPuestoRanking(Integer.parseInt(resultado.getString(3)));
				personas.add(nuevoTenista);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Cerrar la conexión
	/**
	 * Método que cierra la conexión con la base de datos
	 */
	public void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que crea la tabla estadio. Si ya está creada, pregunta al usuario si
	 * la quiere eliminar
	 */
	public void crearTabla() {
		String consulta = "CREATE TABLE estadio(nombre varchar(30), aforo INT);";

		try {
			PreparedStatement sentencia;
			sentencia = conexion.prepareStatement(consulta);
			sentencia.execute();
			System.out.println("Estadio creado correctamente.");
		} catch (SQLException e) {
			System.out.println("Ya existe esa tabla. ¿Quieres eliminarla?");
			char opcion = Character.toUpperCase(in.nextLine().charAt(0));
			do {
				if (opcion == 'S') {
					eliminarTablaEstadio();
				} else {
					System.out.println("Opción incorrecta. Prueba de nuevo");
					opcion = Character.toUpperCase(in.nextLine().charAt(0));
				}
			} while (opcion != 'S' && opcion != 'N');
		}

	}

	/**
	 * Método que rellena la tabla introducida como parámetro
	 * 
	 * @param tablaRellenar String con la tabla a rellenar
	 */
	public void rellenarTabla(String tablaRellenar) {
		if (tablaRellenar.equalsIgnoreCase("estadio")) {
			rellenarEstadio();

		} else if (tablaRellenar.equalsIgnoreCase("tenista")) {
			System.out.println("Introduce el nombre del tenista");
			String nombre = in.nextLine();
			System.out.println("Introduce el país del tenista");
			String pais = in.nextLine();
			System.out.println("Introduce su puesto en el ranking");
			int puestoRanking = in.nextInt();
			Tenista tenista = new Tenista();
			tenista.setNombre(nombre);
			tenista.setPais(pais);
			tenista.setPuestoRanking(puestoRanking);
			rellenarTenista(tenista);

		} else {
			System.out.println("No existe la base de datos " + tablaRellenar);
		}

	}

	/**
	 * Método que rellena un estadio
	 */
	private void rellenarEstadio() {
		System.out.println("Introduce el nombre del estadio");
		String nombre = in.nextLine();
		System.out.println("Introduce su aforo");
		int aforo = in.nextInt();
		try {
			String sentenciaSql = "INSERT INTO estadio(nombre, aforo) VALUES (?,?) ";
			PreparedStatement sentencia;

			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.setString(1, nombre);
			sentencia.setInt(2, aforo);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que rellena un tenista
	 * 
	 * @param tenista tenista a rellenar
	 */
	private void rellenarTenista(Tenista tenista) {

		try {
			String sentenciaSql = "INSERT INTO tenista(nombre, pais, puestoRanking) VALUES (?,?,?) ";
			PreparedStatement sentencia;

			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.setString(1, tenista.getNombre());
			sentencia.setString(2, tenista.getPais());
			sentencia.setInt(3, tenista.getPuestoRanking());
			sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que consulta un estadio
	 */
	public void consultarEstadio() {

		String sentenciaSql = "SELECT * FROM estadio";

		try {
			sentencia = conexion.prepareStatement(sentenciaSql);
			ResultSet resultado = sentencia.executeQuery();
			// mostramos los datos
			while (resultado.next()) {
				System.out.println("Nombre del estadio: " + resultado.getString(1));
				System.out.println("Aforo: " + resultado.getInt(2));
			}
		} catch (SQLException e) {
			System.out.println("No he podido leer los datos de la tabla estadio");
			// e.printStackTrace();
		}
	}

	/**
	 * Método que elimina la tabla estadio
	 */
	public void eliminarTablaEstadio() {
		String consulta = "DROP TABLE estadio";
		try {
			sentencia = conexion.prepareStatement(consulta);
			sentencia.execute();
			System.out.println("Tabla eliminada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que consulta la información de un tenista
	 */
	public void consultarTenista() {
		String sentenciaSql = "SELECT * FROM tenista";
		try {
			sentencia = conexion.prepareStatement(sentenciaSql);

			ResultSet resultado = sentencia.executeQuery();
			// mostramos los datos
			System.out.println("La lista de tenistas es: ");
			while (resultado.next()) {
				System.out.println("Nombre del tenista: " + resultado.getString(1));
				System.out.println("País del tenista: " + resultado.getString(2));
				System.out.println("Puesto del ranking del tenista: " + resultado.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Método que elimina un estadio
	 */
	public void borrarEstadio() {
		System.out.println("¿Qué estadio deseas eliminar?");
		String nombre = in.nextLine();
		try {
			String sentenciaSql = "DELETE FROM estadio WHERE nombre=?";
			PreparedStatement sentencia;

			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.setString(1, nombre);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("El estadio " + nombre + " no se encuentra en la base de datos");
		}
	}

	/**
	 * Método que borra un tenista
	 */
	public void borrarTenista() {
		System.out.println("¿Qué tenista deseas eliminar?");
		String nombre = in.nextLine();
		try {
			String sentenciaSql = "DELETE FROM tenista WHERE nombre=?";
			PreparedStatement sentencia;

			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.setString(1, nombre);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("El tenista " + nombre + " no se encuentra en la base de datos");
		}
	}
}
