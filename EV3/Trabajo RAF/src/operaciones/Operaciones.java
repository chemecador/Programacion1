package operaciones;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Clase que contiene las distintas operaciones para operar con ficheros de tipo RAF
 * @author Alex
 * @since 1.8
 */
public class Operaciones {
	/**
	 * Método que convierte una cadena de cualquier longitud en longitud "lon", 
	 * añadiendo con espacios al final si es necesario.
	 * @param nombre cadena a modificar
	 * @param lon longitud final de la cadena
	 * @return String
	 */
	private static String formatearCadena(String nombre, int lon) {
		if (nombre.length() > lon) {
			return nombre.substring(0, lon); 
		}
		else {
			for (int i=nombre.length(); i<lon; i++) {
				nombre=nombre + " ";
			}
			return nombre;
		}
	}
	/**
	 * Método que crea un nuevo alumno en el archivo "nombreArchivo". Si existe, lo añade al final.
	 * Si no existe, crea un archivo con ese nombre.
	 * @param nombreArchivo nombre del archivo donde se crea un nuevo alumno
	 */
	public static void crearAlumno(String nombreArchivo) {
		try {
			RandomAccessFile f = new RandomAccessFile(nombreArchivo, "rw");
			f.seek(f.length()); //pone el puntero al final para añadir nuevo alumno
			Scanner in = new Scanner (System.in);
			String nombreAlumno = "";
			String ciclo = "";
			int cantidadModulos = 0;
			byte curso = 0;
			String nombreModulo = "";
			float nota = 0;
			String continuar = "";
			while(!continuar.equalsIgnoreCase("no")) {
				System.out.println("Nombre del alumno: ");
				nombreAlumno = in.nextLine();
				System.out.println("Ciclo: ");
				ciclo = in.nextLine();
				boolean error;
				do {
					try {
						System.out.println("Curso: ");
						curso = in.nextByte();
						error = false;
					} catch (Exception e) {
						System.out.println("Error de teclado");
						in.nextLine();
						error = true;
					}
				} while (error);
				do {
					try {
						System.out.println("Cantidad de módulos: ");
						cantidadModulos = in.nextInt();
						error = false;
					} catch (Exception e) {
						System.out.println("Error de teclado");
						in.nextLine();
						error = true;
					}
				} while (error);
				
				in.nextLine();
				nombreAlumno = formatearCadena(nombreAlumno,20);
				ciclo = formatearCadena(ciclo,15);
				
				f.writeUTF(nombreAlumno);
				f.writeUTF(ciclo);
				f.writeByte(curso);
				f.writeInt(cantidadModulos);
				for (int i = 1; i <= cantidadModulos ; i++) {
					System.out.println("Nombre del módulo " + i + ": ");
					nombreModulo = in.nextLine();
					nombreModulo = formatearCadena(nombreModulo,10);
					
					System.out.println("Nota del modulo : " + i + ": ");
					nota = in.nextFloat();
					in.nextLine();
					f.writeUTF(nombreModulo);
					f.writeFloat(nota);
				}
				do {
					System.out.println("¿Deseas continuar?");
					continuar = in.nextLine();
				}while (!continuar.equalsIgnoreCase("no") && !continuar.equalsIgnoreCase("si"));
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Error de archivo");
		}
		
	}
	
	/**
	 * Método que visualiza todos los alumnos de un archivo.
	 * @param nombreArchivo nombre del archivo donde se encuentran los alummnos
	 */
	public static void visualizar(String nombreArchivo){
		try {
			RandomAccessFile f = new RandomAccessFile(nombreArchivo,"rw");	
			String nombreAlumno = "";
			String ciclo = "";
			byte curso = 0;
			int cantidadModulos = 0;
			String nombreModulo = "";
			float nota = 0;
			boolean finFichero = false;
			do {
				try {
					nombreAlumno = f.readUTF();
					System.out.println("Nombre del alumno: " + nombreAlumno);
					ciclo = f.readUTF();
					System.out.println("Ciclo: " + ciclo);
					curso = f.readByte();
					System.out.println("Curso: " + curso);
					cantidadModulos = f.readInt();
					System.out.println("Cantidad de módulos: " + cantidadModulos);
					for (int i = 1; i <= cantidadModulos; i++) {
						nombreModulo = f.readUTF();
						System.out.println("Nombre del módulo " + i + ": " + nombreModulo);
						nota = f.readFloat();					
						System.out.println("Nota del modulo " + i + ": " + nota);
					}
					System.out.println();
				} catch(EOFException e) {
					finFichero=true;
				}
			} while (!finFichero);
			
			f.close();
		} catch (IOException e) {
			System.out.println("Error");
		}

	}
	
	
	/**
	 * Método que modifica un alumno que elija el usuario una vez se invoca, del archivo "nombreArchivo"
	 * @param nombreArchivo nombre del archivo donde se modificará el alumno
	 */
	public static void modificar(String nombreArchivo) {
		// Pedir el nombre del alumno a buscar
				Scanner in = new Scanner (System.in);
				System.out.println("Nombre del alumno a buscar = ");
				String nombreABuscar = in.nextLine();
				try {
					RandomAccessFile f = new RandomAccessFile(nombreArchivo,"rw");	
					String nombreAlumno;
					String nombreModulo;
					int cantidadModulos;
					float nota;
					boolean finFichero = false;
					boolean encontrado = false;
					do {
						try {
							nombreAlumno = f.readUTF();
							if (nombreAlumno.trim().equalsIgnoreCase(nombreABuscar)) {
								f.readUTF();
								f.readByte();
								cantidadModulos = f.readInt();
								f.seek(f.getFilePointer());
								System.out.println("El alumno " + nombreABuscar + " tiene: ");
								for (int i = 1; i <= cantidadModulos; i++) {
									nombreModulo = f.readUTF();
									nota = f.readFloat();
									System.out.println("Modulo: " + nombreModulo);
									System.out.println("Nota: " + nota);
								}
								f.seek(f.getFilePointer()-(cantidadModulos*16));
								for (int i = 1; i <= cantidadModulos; i++) {
									System.out.println("Nombre nuevo módulo = ");
									String nombreNew=in.nextLine();
									System.out.println("Nota nuevo = ");
									float notaNew=in.nextFloat();
									in.nextLine();
									nombreNew = formatearCadena(nombreNew, 10);
									f.writeUTF(nombreNew);
									f.writeFloat(notaNew);
								}
								encontrado=true;
							}
							else {
								//lo leo pero no es el alumno que estamos buscando
								f.readUTF();
								f.readByte();								cantidadModulos = f.readInt();
								for (int i = 1; i <= cantidadModulos; i++) {
									nombreModulo = f.readUTF();
									nota = f.readFloat();	
								}
							}
						}catch(EOFException e) {
							finFichero=true;
						}
					}while(!finFichero);
					if (!encontrado) {
						System.out.println("No existe el alumno");
					}
					f.close();
				}catch(IOException e) {
					System.out.println("Error al modificar");
				}
	}
	/**
	 * Método que calcula el promedio de nota de todos los alumnos, y muestra por pantalla el más alto.
	 * @param nombreArchivo nombre del archivo donde se mostrará la nota más alta
	 */
	public static void mostrarNotaMasAlta(String nombreArchivo) {
		float notaMasAlta = 0.0f;
		String alumnoMasNota = "";
		try {
			RandomAccessFile f = new RandomAccessFile(nombreArchivo,"rw");	
			String nombreAlumno = "";
			int cantidadModulos = 0;
			float nota = 0.0f;
			boolean finFichero = false;
			do {
				try {
					float promedio = 0.0f;
					nombreAlumno = f.readUTF();
					f.readUTF();
					f.readByte();
					cantidadModulos = f.readInt();
					for (int i = 1; i <= cantidadModulos; i++) {
						f.readUTF();
						nota = f.readFloat();
						promedio = promedio + nota;
					}
					promedio = promedio / cantidadModulos;
					if (promedio > notaMasAlta) {
						notaMasAlta = promedio;
						alumnoMasNota = nombreAlumno;
					}
				}catch(EOFException e) {
					finFichero=true;
				}
			} while (!finFichero);
			
			f.close();
		} catch (IOException e) {
			System.out.println("Error");
		}
		if (notaMasAlta < 0){
			System.out.println("No hemos encontrado ninguna asignatura");
		}
		else {
			System.out.println("El alumno " + alumnoMasNota.trim() + " ha promediado un " + notaMasAlta);
		}
	}
}
