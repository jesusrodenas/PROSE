/**
 * 
 */
package psp.UD02.progmultihilo;

import psp.UD02.progmultihilo.utilidades.Ejemplo2Runnable;

/**
 * @author JESUS
 *
 */
public class Ejemplo2 implements Runnable {

	@Override
	public void run() {
		Ejemplo2Runnable ej2r = new Ejemplo2Runnable(10);
		Thread hRunnable = new Thread(ej2r);
		hRunnable.start();
	}
}