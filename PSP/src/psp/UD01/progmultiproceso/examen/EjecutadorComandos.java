/**
 * 
 */
package psp.UD01.progmultiproceso.examen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JESUS
 *
 */
public class EjecutadorComandos {	
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		ejecutaComando("ping", "www.iescristobaldemonroy.es");
		ejecutaComando("pong", "direccion.inventada");
		ejecutaComando("echo", "%PATH%");
		ejecutaComando("taskkill", "123");
	}
	
	/**
	 * Método que recibirá el comando a lanzar en el CMD y su argumento (parámetro).
	 * @param comando
	 * @param argumento
	 */
	public static void ejecutaComando(String comando, String argumento) {
		List<String> cmd = new ArrayList<String>();
		cmd.add("CMD");
		cmd.add("/C");
		cmd.add(comando);
		cmd.add(argumento);
		
		String fSalida = comando + ".log";
		String fError  = comando + ".err";
		String fFinal;
		
		ProcessBuilder pb = new ProcessBuilder(cmd);		
		
		// Antes de lanzar el proceso, es necesario definir las correspondientes salidas.
		pb.redirectOutput(new File(fSalida));
		pb.redirectError (new File(fError));
		
		Process p = null;
		try {
			System.out.println("Comenzando la ejecuci�n del comando: " + comando + " " + argumento );
			System.out.println("Por favor, espere.");
			
			p = pb.start();
			int status = p.waitFor();
			if(status == 0) {
				System.out.print("La ejecución ha resultado satisfactoria. ");
				fFinal = fSalida;
			}else {
				System.out.print("La ejecución ha resultado errónea. ");
				fFinal = fError;
			}
			
			System.out.println("Puede consultar el resultado de la ejecuci�n del comando " + comando + " en el archivo " + fFinal + ".");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}