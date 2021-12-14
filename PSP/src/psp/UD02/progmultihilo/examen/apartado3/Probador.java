package psp.UD02.progmultihilo.examen.apartado2;
/**
 * 
 */

/**
 * @author JESUS
 *
 */
public class Probador {
	public void pasoPorProbador(Cliente c) {
		System.out.println(c.getNombre() + " accede al probador. Los art�culos que se prueba son:");
		for (String articulo : c.getArticulos()) {
			System.out.println(articulo);
		}
	}
}
