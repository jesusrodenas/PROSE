/**
 * 
 */
package psp.UD01.progmultiproceso.examen;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author JESUS
 *
 */
public class LanzaContador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> cmd = new ArrayList<String>();
		cmd.add("java");
		cmd.add(Contador.class.getCanonicalName());
		
		ProcessBuilder pb = new ProcessBuilder(cmd);		
		pb.environment().put("CLASSPATH", LanzaContador.class.getClassLoader().getResource("").getPath());
		
		pb.inheritIO();
		
		try {
			Process p = pb.start();
			System.out.println("El PID del proceso lanzado es: " + p.pid());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}