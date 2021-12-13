/**
 * 
 */
package psp.UD02.progmultihilo.examen.apartado1;

/**
 * @author JESUS
 *
 */
public class ProcesoImpresion implements Runnable {
	ColaImpresion cola;
	String[] mensaje;
	
	/**
	 * 
	 */
	public ProcesoImpresion(String[] mensaje, ColaImpresion cola) {
		this.cola = cola;
		this.mensaje = mensaje;
	}

	@Override
	public void run() {
		for (int i=0; i<mensaje.length; i++) {
			cola.enviar(mensaje[i]);
		}		
	}
}
