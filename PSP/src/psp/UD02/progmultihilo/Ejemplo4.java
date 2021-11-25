/**
 * 
 */
package psp.UD02.progmultihilo;

import psp.UD02.progmultihilo.utilidades.CuentaBancaria;
import psp.UD02.progmultihilo.utilidades.UsuarioCuentaBancaria;

/**
 * @author JESUS
 *
 */
public class Ejemplo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CuentaBancaria cb = new CuentaBancaria(40);
		UsuarioCuentaBancaria hJesus = new UsuarioCuentaBancaria("Juan", cb);
		UsuarioCuentaBancaria hManuela = new UsuarioCuentaBancaria("Manuela", cb);
		
		hJesus.start();
		hManuela.start();		
	}
}