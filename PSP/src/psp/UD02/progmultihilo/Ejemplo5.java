/**
 * 
 */
package psp.UD02.progmultihilo;

import psp.UD02.progmultihilo.utilidades.Consumidor;
import psp.UD02.progmultihilo.utilidades.Informacion;
import psp.UD02.progmultihilo.utilidades.Productor;

/**
 * @author JESUS
 *
 */
public class Ejemplo5 {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Informacion info = new Informacion();
		
		Productor p = new Productor(info);
		Thread tProductor = new Thread(p);
		
		Consumidor c = new Consumidor(info);
		Thread tConsumidor = new Thread(c);
		
		tProductor.start();
		tConsumidor.start();
	}
}
