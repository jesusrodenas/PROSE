package psp.UD02.progmultihilo.examen.apartado3;
import java.util.List;

/**
 * 
 */

/**
 * @author JESUS
 *
 */
public class Cliente implements Runnable {
	private String nombre;
	private List<String> articulos;
	private Probador probador;

	/**
	 * @param nombre
	 * @param articulos
	 * @param probador
	 */
	public Cliente(String nombre, List<String> articulos, Probador probador) {
		super();
		this.nombre = nombre;
		this.articulos = articulos;
		this.probador = probador;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the articulos
	 */
	public List<String> getArticulos() {
		return articulos;
	}
	/**
	 * @param articulos the articulos to set
	 */
	public void setArticulos(List<String> articulos) {
		this.articulos = articulos;
	}
	
	/**
	 * @return the probador
	 */
	public Probador getProbador() {
		return probador;
	}
	/**
	 * @param probador the probador to set
	 */
	public void setProbador(Probador probador) {
		this.probador = probador;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		probador.pasoPorProbador(this);	
	}
	
	
}
