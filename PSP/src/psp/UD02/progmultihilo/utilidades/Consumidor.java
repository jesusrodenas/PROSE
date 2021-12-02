/**
 * 
 */
package psp.UD02.progmultihilo.utilidades;

import psp.UD02.progmultihilo.Ejemplo5;

/**
 * @author JESUS
 *
 */
public class Consumidor implements Runnable {
	public Informacion info;
	
	public Consumidor(Informacion info){
		this.info = info;
	}
	
	

	public String infoConsumida;
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			String infoConsumida = info.getInfo();
			System.out.println(i + " He consumido " + infoConsumida);
		}		
	}
}
