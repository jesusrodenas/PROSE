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
public class KillJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pid = args[0];
		
		ArrayList<String> cmdKill = new ArrayList<String>();
		cmdKill.add("taskkill");
		cmdKill.add("/F");
		cmdKill.add("/PID");
		cmdKill.add(pid);
		
		ProcessBuilder pb = new ProcessBuilder(cmdKill);
		
		pb.inheritIO();
		
		try {
			pb.start().waitFor();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
