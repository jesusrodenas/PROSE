/**
 * 
 */
package psp.UD02.progmultihilo.taxi.synch;

/**
 * @author JESUS
 *
 */
public class Cliente implements Runnable{
	String nombreCliente;
	int numKmCarrera;	
	private Taxi taxi;
		
	/**
	 * @param nombreCliente
	 * @param numKmCarrera
	 * @param taxi
	 */
	public Cliente(String nombreCliente, int numKmCarrera, Taxi taxi) {
		super();
		this.nombreCliente = nombreCliente;
		this.numKmCarrera = numKmCarrera;
		this.taxi = taxi;
	}

	@Override
	public void run() {
		synchronized(taxi) {
			taxi.iniciaCarrera(this);
			taxi.finalizaCarrera(this);			
		}
	}

}
