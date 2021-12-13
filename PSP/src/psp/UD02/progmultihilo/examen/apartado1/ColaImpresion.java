/**
 * 
 */
package psp.UD02.progmultihilo.examen.apartado1;

/**
 * @author JESUS
 *
 */
public class ColaImpresion {
	String mensaje;
	boolean disponible = true;
	int tamano;
	
	public ColaImpresion(int tamano) {
		this.tamano = tamano;
	}
	
	synchronized public void enviar(String s) {
		while(!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		disponible = false;
		this.mensaje = s;
		notify();
	}
	
	synchronized public String recibir() {
		while (disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String s = this.mensaje;
		disponible = true;
		notify();
		return s;
	}
}
