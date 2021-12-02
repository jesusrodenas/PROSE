/**
 * 
 */
package psp.UD02.progmultihilo;

import psp.UD02.progmultihilo.utilidades.Contador;
import psp.UD02.progmultihilo.utilidades.HiloDecrementador;
import psp.UD02.progmultihilo.utilidades.HiloIncrementador;

/**
 * @author JESUS
 *
 */
public class Ejemplo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloIncrementador a = new HiloIncrementador("HiloA", cont);
		HiloDecrementador b = new HiloDecrementador("HiloB", cont);
		a.start();
		b.start();

	}

}
