/**
 * 
 */
package psp.UD02.progmultihilo.examen.apartado1;

/**
 * @author JESUS
 *
 */
public class Impresora implements Runnable{

	ColaImpresion cola; 
	
	public Impresora (ColaImpresion cola) {
		this.cola = cola;
	}
	@Override
	public void run() {
		for (int i=0; i<cola.tamano; i++) {
			System.out.print(cola.recibir());
			try {
				System.out.print(" ... ");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
