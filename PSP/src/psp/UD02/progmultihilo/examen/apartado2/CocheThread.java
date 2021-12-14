package psp.UD02.progmultihilo.examen.apartado2;
/**
 * 
 */

/**
 * @author JESUS
 *
 */
public class CocheThread extends Thread {
	
	/**
	 * Estos son los atributos de la clase CocheThread.
	 * NO ES NECESARIO AÑADIR NINGUNO MÁS.
	 */
	private Semaforo semaforo;
	private int segundos;	
	
	public CocheThread (String nombre, int segundos, Semaforo semaforo) {
		super(nombre);
		this.segundos = segundos;
		this.semaforo = semaforo;
	}
	
	/**
	 * Se usa el objeto compartido como objeto de bloqueo para garantizar que no es usado por
	 * de un hilo CocheThread en un instante.
	 */
	@Override
	public void run() {
		synchronized (semaforo) {
			semaforo.cerrarCarril(this);
			try {
				Thread.sleep(segundos*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			semaforo.abrirCarril(this);
		}
	}
	
	public int getSegundos() {
		return segundos;
	}
}
