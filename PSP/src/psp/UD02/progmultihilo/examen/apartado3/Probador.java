package psp.UD02.progmultihilo.examen.apartado3;
/**
 * 
 */

/**
 * @author JESUS
 *
 */
public class Probador {
	public boolean disponible = true;
	
	public synchronized void pasoPorProbador(Cliente c) {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		disponible = false;
		// me pruebo los artículos
		System.out.println(c.getNombre() + " accede al probador. Los artículos que se prueba son:");
		for (String articulo : c.getArticulos()) {
			System.out.println(articulo);
		}
		disponible = true;
		notifyAll();
	}
}
