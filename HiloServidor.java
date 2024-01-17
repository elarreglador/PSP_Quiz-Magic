import java.io.*;
import java.net.*;

public class HiloServidor extends Thread {
	BufferedReader fEntrada;
	PrintWriter fSalida;
	Socket socket = null;

	// CONSTRUCTOR
	public HiloServidor(Socket socket) throws IOException {
		System.out.println("Cree fil servidor");
		this.socket = socket;
		// CREA FLUJOS DE ENTRADA Y SALIDA
		fSalida = new PrintWriter(socket.getOutputStream(), true);
		fEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	// LOGICA DEL SERVIDOR.
	String nombre;
	String pregunta;
	String respuesta;
	String respuestaCorrecta;
	int puntuacion = 0;
	String archivo = "./PreguntasRespuestas.txt";

	public void run() {
		try {
			// TAREAS DEL SERVIDOR
			// El client enviarà al servidor el nom
			nombre = fEntrada.readLine();

			for (int i = 1; i < LibArchivo.cuentaLineas(archivo); i = i + 2) {
				// servidor enviarà al client preguntes
				pregunta = LibArchivo.leeLinea(archivo, i);
				fSalida.println(pregunta);
				System.out.println("[SERVIDOR -> " + nombre + "]:" + i + ")" + pregunta);

				// client agafarà la resposta enviant-la al servidor
				respuesta = fEntrada.readLine();
				System.out.println("[CLIENTE " + nombre + "]:" + respuesta);

				// servidor el que avaluarà la resposta. Cada resposta correcta sumarà un punt a
				// l’usuari.
				respuestaCorrecta = LibArchivo.leeLinea(archivo, i + 1);
				if (respuestaCorrecta.equals(respuesta)) {
					puntuacion++;
					System.out.println("Respuesta correcta.");
				} else {
					System.out.println("Respuesta incorrecta, la respuesta es *" + respuestaCorrecta + "*");
				}
			}

			// servidor enviarà al client la puntuació i el client la mostrarà.
			fSalida.println("Puntuacion de " + nombre + ": " + puntuacion);
			System.out.println("Puntuacion de " + nombre + ": " + puntuacion);

			// servidor guardarà nom i puntuació en el fitxer «Puntuacions.txt».
			LibArchivo.escribeTexto("puntuaciones.txt", false, nombre + " : " + puntuacion);

			// CIERRA FLUJOS Y SOCKET
			System.out.println("Cerrando conexion...");
			fSalida.close();
			fEntrada.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("Excepcion en metodo run(): " + e);
		}
	}
}