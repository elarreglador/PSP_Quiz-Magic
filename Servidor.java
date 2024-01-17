
import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String args[]) throws IOException {

		ServerSocket servidor; // Crea serverSocket
		servidor = new ServerSocket(60000); //Puerto de conexion
		System.out.println("Inici Servidor en 60000");

		while (true) {
			Socket socketClient = new Socket();
			System.out.println("A la espera de nuevos clientes...");
			socketClient = servidor.accept(); // Espera un cliente
			HiloServidor fil = new HiloServidor(socketClient); // Crea hilo y le pasa el socket
			fil.start(); // Inicia el hilo con la logica del servidor
			System.out.println("[SERVIDOR]: Creado y lanzado hilo para atender al cliente.");
		}
	}
}
