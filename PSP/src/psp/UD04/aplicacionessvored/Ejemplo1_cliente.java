/**
 * 
 */
package psp.UD04.aplicacionessvored;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author JESUS
 *
 */
public class Ejemplo1_cliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String Host = "localhost";
		int Puerto = 9999;//puerto remoto
		// ABRIR SOCKET
		Socket cliente = null;
		try {
			
			cliente = new Socket(Host, Puerto);
			InetAddress i= cliente.getInetAddress();
			System.out.println ("Puerto local: "+ cliente.getLocalPort());
			System.out.println ("Puerto Remoto: "+ cliente.getPort());
			System.out.println ("Host Remoto: "+ i .getHostName() .toString());
			System.out.println ("IP Host Remoto: "+ i .getHostAddress().toString()); 
			cliente.close() ; // Cierra el socket
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//conecta 


	}

}
