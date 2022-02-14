/**
 * 
 */
package psp.UD03.progcomred.proyecto.ejercicio2;
import java.util.Scanner;

import psp.UD03.progcomred.proyecto.cliente.ClienteServicio;
import psp.UD03.progcomred.proyecto.modelo.Pedido;
import psp.UD03.progcomred.proyecto.modelo.Tienda;

/**
 * @author JESUS
 *
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteServicio cs = new ClienteServicio();
		Scanner teclado;
		boolean finalizar = false;
		int producto = -1;
		
		Tienda aLaCarta = new Tienda(cs, "A la carta");
		aLaCarta.setCarta(cs.obtenerProductos());
		
		Pedido pedido = new Pedido();
		
		System.out.println("Establecimiento: " + aLaCarta.getNombreEstablecimiento());
		System.out.println("Iniciando su pedido");
		
		while (!finalizar) {
			System.out.println("¿Qué artículo desea?");
			aLaCarta.muestraCarta();
			teclado = new Scanner(System.in);
			
			producto = teclado.nextInt();
			pedido.anadirProducto(aLaCarta.getCarta().get(producto));			
			
			System.out.println("Producto añadido.");
			System.out.println("¿Finalizar pedido? (S/N)");
			teclado = new Scanner(System.in);
			finalizar = teclado.next().equals("S");		
			
		}
		pedido.muestraPedido();
		System.out.println("¿Registrar pedido? (S/N)");
		teclado = new Scanner(System.in);
		
		if(teclado.next().equals("S")) {
			cs.guardaPedido(aLaCarta, pedido);
			System.out.println("Pedido almacenado.");
		}else {
			System.out.println("Pedido descartado.");
		}
	}
}