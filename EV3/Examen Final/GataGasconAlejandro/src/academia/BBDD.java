package academia;

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

public class BBDD {
	private Connection conexion = null;
	PreparedStatement sentencia;
	
	public void cargarControlador() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void conectarBBDD() {
		FileInputStream f = null;
		try {
			f = new FileInputStream ("conf/datos.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://"
						+ p.getProperty("servidor.nombre") + ":"
						+ p.getProperty("servidor.puerto") + "/"
						+ p.getProperty("servidor.bbdd"),
						p.getProperty("servidor.user"),
						p.getProperty("servidor.password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void cerrarConexion() {
		try {
			conexion.close();
			System.out.println("Conexion cerrada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void crearTabla() {
		String sentenciaSql = "CREATE TABLE IF NOT EXISTS personal "
				+ "(nombre VARCHAR(30), dni VARCHAR(9), tipo VARCHAR(15))";
		try {
			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


	public void insertarDatos(ArrayList<Persona> listadoPersonal) {
		
		String sentenciaSql = "INSERT INTO personal VALUES (?,?,?)";
		String nombre = "";
		String dni = "";
		String tipo = "";
		try {
			for (Persona persona : listadoPersonal) {
				nombre = persona.getNombre();
				dni = persona.getDni();
				tipo = persona.getClass().getSimpleName();
				sentencia = conexion.prepareStatement(sentenciaSql);
				sentencia.setString(1, nombre);
				sentencia.setString(2, dni);
				sentencia.setString(3, tipo);
				sentencia.executeUpdate();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	public void visualizarDatos() {
		String sentenciaSql = "SELECT * FROM personal";
		try {
			sentencia = conexion.prepareStatement(sentenciaSql);
			ResultSet resultado = sentencia.executeQuery();
			if (!resultado.next()) {
				System.out.println("No hay datos");
			}
			while (resultado.next()) {
				System.out.println("Nombre: " + resultado.getString(1));
				System.out.println("DNI: " + resultado.getString(2));
				System.out.println("Tipo: " + resultado.getString(3));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void vaciarBBDD() {
		String sentenciaSql = "DELETE FROM personal";
		try {
			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
