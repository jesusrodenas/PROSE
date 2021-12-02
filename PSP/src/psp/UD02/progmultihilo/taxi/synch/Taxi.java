/**
 * 
 */
package psp.UD02.progmultihilo.taxi.synch;

/**
 * @author JESUS
 *
 */
public class Taxi {
	private double precioKmCarrera = 2.5;
	private double importeCarrera = 0;
	private int numKmCarrera = 0;
	private boolean disponible = true;
	
	public void iniciaCarrera(Cliente c) {
		this.importeCarrera = 0;		
		this.numKmCarrera = c.numKmCarrera;
		System.out.println(c.nombreCliente + " toma el taxi.");
	}
	
	public void finalizaCarrera(Cliente c) {
		this.importeCarrera = this.numKmCarrera * this.precioKmCarrera;
		String mensaje = "Finaliza el trayecto de: " + c.nombreCliente;
		mensaje       += "(" + this.numKmCarrera + "): ";
		mensaje       += this.importeCarrera + " euros.";
		System.out.println(mensaje);	
	}
}
