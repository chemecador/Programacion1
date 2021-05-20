package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import entidades.Persona;
import entidades.Tenista;

public class BBDD {
	
	static Scanner in = new Scanner (System.in);
	
	// Atributo
	private Connection conexion;
	PreparedStatement sentencia = null;

	// Métodos
	
	// Cargar el controlador
	public void cargarControlador() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No he podido conectar con el controlador");
			e.printStackTrace();
		}

	}

	// Conectar con la BBDD
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
	public void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
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
			do{
				if (opcion == 'S') {
					eliminarTablaEstadio();
				}
				else {
					System.out.println("Opción incorrecta. Prueba de nuevo");
					opcion = Character.toUpperCase(in.nextLine().charAt(0));
				}
			} while (opcion!='S' && opcion != 'N');
		} 
		
	}
	public void rellenarTabla() {
		System.out.println("¿Qué tabla quieres rellenar? (Estadio/Tenista)");
		String tablaRellenar = in.nextLine();
		
		if (tablaRellenar.equalsIgnoreCase("estadio")) {
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
		else if (tablaRellenar.equalsIgnoreCase("tenista")) {
			System.out.println("Introduce el nombre del tenista");
			String nombre = in.nextLine();
			System.out.println("Introduce el país del tenista");
			String pais = in.nextLine();
			System.out.println("Introuce su puesto en el ranking");
			int puestoRanking = in.nextInt();
			try {
				String sentenciaSql = "INSERT INTO tenista(nombre, pais, puestoRanking) VALUES (?,?,?) ";
				PreparedStatement sentencia;
		
				sentencia = conexion.prepareStatement(sentenciaSql);
				sentencia.setString(1, nombre);
				sentencia.setString(2, pais);
				sentencia.setInt(3, puestoRanking);
				sentencia.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	public void consultarTabla() {
		System.out.println("¿Qué tabla quieres consultar?");
		String nombreTabla = in.nextLine();
		String sentenciaSql = "SELECT * FROM ?";
		if (!nombreTabla.equalsIgnoreCase("tenista") && !nombreTabla.equalsIgnoreCase("estadio")) {
			System.out.println("No existe la tabla " + nombreTabla);
		}
		else {
			try {
				sentencia = conexion.prepareStatement(sentenciaSql);
				sentencia.setString(1, nombreTabla);
				ResultSet resultado = sentencia.executeQuery();
				// mostramos los datos
				if (nombreTabla.equalsIgnoreCase("estadio")) {
					while (resultado.next()) {
						System.out.println(resultado.getString(1) + ", " + resultado.getString(2));
					}
				}
				else if (nombreTabla.equalsIgnoreCase("tenista")) {
					while (resultado.next()) {
						System.out.println(resultado.getString(1) + ", " + resultado.getString(2)
						+ ", " + resultado.getInt(3));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void eliminarTablaEstadio() {
		String consulta = "DROP TABLE estadio";
		try {
			sentencia = conexion.prepareStatement(consulta);
			sentencia.execute();
			System.out.println("Tabla eliminada");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
