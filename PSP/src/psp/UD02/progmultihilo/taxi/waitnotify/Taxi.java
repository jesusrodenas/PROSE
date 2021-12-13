/**
 *
 */
package psp.UD02.progmultihilo.taxi.waitnotify;

/**
 * @author JESUS
 *
 */
public class Taxi {
	private double precioKmCarrera = 2.5;
	private double importeCarrera = 0;
	private int numKmCarrera = 0;
	private boolean disponible = true;

	/**
	 * Este método inicará la carrera y actualizará los datos del taxi con los datos del cliente.
	 * mientras el taxi esté no disponible, dormiré hasta que algún cliente lo deje y despierte a
	 * todos los clientes que están esperando dormidos.
	 * @param c
	 */
	public synchronized void iniciaCarrera(Cliente c) {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// En primer lugar pongo el taxi para que nadie más "se meta"
		disponible = false;
		this.importeCarrera = 0;
		this.numKmCarrera = c.numKmCarrera;
		System.out.println(c.nombreCliente + " toma el taxi.");

	}

	/**
	 * Este método representa la finalización de la carrera: muestra la información de finalización y despierta a todos aquellos hilos
	 * que duermen esperando a que el taxi esté disponible.
	 * @param c
	 */
	public synchronized void finalizaCarrera(Cliente c) {
		this.importeCarrera = this.numKmCarrera * this.precioKmCarrera;
		String mensaje = "Finaliza el trayecto de: " + c.nombreCliente;
		mensaje += "(" + this.numKmCarrera + "): ";
		mensaje += this.importeCarrera + " euros.";
		System.out.println(mensaje);
		disponible = true;
		notifyAll();
	}
}
