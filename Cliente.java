import java.net.*;
import java.io.*;

public class Cliente {

	public static void main(String args[]) throws IOException {
		try {
			Socket socket = new Socket("localhost", 60000);

			// CREA FLUJOS DE ENTRADA I SALIDA
			PrintWriter fSalida = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader fEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// FLUJO PARA ENTRADA DE TECLADO
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			// TAREAS DEL CLIENTE
			// El client demanarà per teclat un nom.
			System.out.print("Introduce tu nombre: ");
			String nombre = in.readLine();

			// El client enviarà al servidor el nom
			fSalida.println(nombre);

			// servidor enviarà al client preguntes
			// el client la mostrarà per pantalla
			String pregunta = fEntrada.readLine();
			while (pregunta != null) {
				System.out.println(pregunta);

				// client agafarà la resposta enviant-la al servidor
				fSalida.println(in.readLine());

				pregunta = fEntrada.readLine();
			}

			// servidor enviarà al client la puntuació i el client la mostrarà.
			System.out.println(fEntrada.readLine());

			// CIERA FLUJOS Y SOCKET
			fSalida.close();
			fEntrada.close();
			in.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("Excepcion en main(): " + e);
		}

	}
}
