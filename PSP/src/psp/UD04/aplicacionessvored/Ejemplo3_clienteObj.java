/**
 * 
 */
package psp.UD04.aplicacionessvored;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import psp.utilidades.Usuario;

/**
 * @author JESUS
 *
 */
public class Ejemplo3_clienteObj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String Host = "localhost";
		int Puerto = 9999;//puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		
		Socket cliente;
		try {
			cliente = new Socket(Host, Puerto);
			//Flujo de entrada para objetos
			ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
			
			//Se recibe un objeto
			Usuario dato = (Usuario) perEnt.readObject();//recibo objeto
			System.out.println("Recibo: "+dato.getUsuario()+"*"+dato.getPassword());
			
			//Modifico el objeto
			dato.setUsuario("prose"); 
			dato.setPassword("aprobado");
			
			//FLUJO DE salida para objetos
			ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream ());
			
			// Se envia el objeto
			perSal.writeObject(dato);
			System.out.println("Envio: "+dato.getUsuario()+"*"+dato.getPassword() ) ;
			// CERRAR STREAMS Y SOCKETS 
			perEnt.close(); 
			perSal.close(); 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
