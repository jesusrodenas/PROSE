package psp.UD02.progmultihilo.examen.apartado3;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author JESUS
 *
 */

/** CONTESTA AQUÍ A LA PREGUNTA PLANTEADA EN EL APARTADO 3
 * ¿Podrías garantizar cuál de los clientes entra primero al probador? ¿Por qué?
 * Por las ejecuciones podría parecer que siempre Antonio es el primero en entrar al probador pero realmente no existe una garantía de
 * que eso sea así. Lo que sucede es que en tan pocas istrucciones, lo normal es que el procesamiento de Antonio finalice icluso antes de
 * que entre María. Si colocamos un sleep  antes del paso por probador del Thread tAntonio simulando una pérdida del micro, 
 * veríamos cómo María entra antes que Antonio al probador. Una vez iniciados los tres hilos, no se puede garantizar cuál de ellos accederá al probador
 * en primer lugar.
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
		Runnable cMaria = new Cliente("María", listaMaria, probador);
		Runnable cJuan = new Cliente("Juan", listaJuan, probador);
		
 		Thread tAntonio = new Thread(cAntonio);
 		Thread tMaria = new Thread(cMaria);
 		Thread tJuan = new Thread(cJuan);

 		tAntonio.start();
 		tMaria.start();
 		tJuan.start();
	}
}
