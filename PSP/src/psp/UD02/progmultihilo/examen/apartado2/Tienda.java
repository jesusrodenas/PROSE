package psp.UD02.progmultihilo.examen.apartado2;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author JESUS
 *
 */

/** CONTESTA AQU� A LA PREGUNTA PLANTEADA EN EL APARTADO 3
 * �Podr�as garantizar cu�l de los clientes entra primero al probador? �Por qu�?
 * 
 *
 */

public class Tienda {
	public static void main(String[] args) {
		Probador probador = new Probador();
		
		List<String> listaAntonio = new ArrayList<String>();
		List<String> listaMaria = new ArrayList<String>();
		List<String> listaJuan = new ArrayList<String>();
		
		listaAntonio.add("Camisa");
		listaAntonio.add("Pantalones");
		listaAntonio.add("Sombrero");		
	
		listaMaria.add("Vestido");
		listaMaria.add("Botas");	
		
		listaJuan.add("Camiseta");
		listaJuan.add("Gorra");
		listaJuan.add("Zapatillas");
		listaJuan.add("Bermudas");
		
		Runnable cAntonio = new Cliente("Antonio", listaAntonio, probador);
		Runnable cMaria = new Cliente("Mar�a", listaMaria, probador);
		Runnable cJuan = new Cliente("Juan", listaJuan, probador);
		
 		Thread tAntonio = new Thread(cAntonio);
 		Thread tMaria = new Thread(cMaria);
 		Thread tJuan = new Thread(cJuan);

 		tAntonio.start();
 		tMaria.start();
 		tJuan.start();
	}
}
