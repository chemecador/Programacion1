package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
	public static void main (String[] args) {
		//1. Cargar controlador
		try {
			System.out.println("1. Cargar el controlador");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2. Conectar con la BBDD
		System.out.println("2.Conectar con la base");
		
		//2.1 Declarar el archivo
		FileInputStream f = null;
		try {
			f = new FileInputStream("conf/datos.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		//2.2 Crear objeto de la clase Properties para usar el archivo
		Properties p = new Properties();
		try {
			p.load(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//2.3 Sacar los datos del archivo
		System.out.println("Nombre del servidor = " + p.getProperty("servidor.nombre"));
		System.out.println("Puerto del servidor = " + p.getProperty("servidor.puerto"));
		System.out.println("Base de datos       = " + p.getProperty("servidor.basedatos"));
		System.out.println("Usuario             = " + p.getProperty("servidor.usuario"));
		System.out.println("Password            = " + p.getProperty("servidor.password"));
		
		
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection
					("jdbc:mysql://" + p.getProperty("servidor.nombre") + ":"
									 + p.getProperty("servidor.puerto") + "/" 
									 + p.getProperty("servidor.basedatos") ,
									   p.getProperty("servidor.usuario") ,
									   p.getProperty("servidor.contraseña"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3. Cerrar
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
