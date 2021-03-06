package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDeDatos {
	Connection conexion;
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
			f = new FileInputStream("conf/datos.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://"
					+ p.getProperty("servidor.nombre")+":"
					+ p.getProperty("servidor.puerto")+"/"
					+ p.getProperty("servidor.basedatos"),
					p.getProperty("servidor.usuario"),
					p.getProperty("servidor.password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void crearTabla() {
		String sentenciaSql = "CREATE TABLE IF NOT EXISTS trileria2 (nombreTrilero VARCHAR(10), edadTrilero INT);";
		try {
			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.executeUpdate();
			System.out.println("Tabla creada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertarDato() {
		String sentenciaSql = "INSERT INTO trileria2 VALUES (?,?);";;
		try {
			String nombreTrilero = "David";
			int edadTrilero = 21;

			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.setString(1, nombreTrilero);
			sentencia.setInt(2, edadTrilero);
			sentencia.executeUpdate();
			System.out.println("Dato insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ver() {
		String sentenciaSql = "SELECT * FROM trileria2";
		try {
			sentencia = conexion.prepareStatement(sentenciaSql);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				System.out.println("Nombre del Trilero " + resultado.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void borrarDato() {
		String sentenciaSql = "DELETE FROM trileria2 WHERE nombreTrilero = ?";
		String nombreBorrar = "David";
		try {
			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.setString(1, nombreBorrar);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
