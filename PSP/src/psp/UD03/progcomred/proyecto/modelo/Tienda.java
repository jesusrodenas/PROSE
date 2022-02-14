/**
 * 
 */
package psp.UD03.progcomred.proyecto.modelo;

import java.util.Map;

import psp.UD03.progcomred.proyecto.cliente.ClienteServicio;

/**
 * @author JESUS
 *
 */
public class Tienda {
	private String nombreEstablecimiento;
	private Integer idTienda;
	private Map<Integer, Producto> carta;
	
	private ClienteServicio cs;
	
	public Tienda (ClienteServicio cs, String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
		idTienda = cs.nuevoEstablecimiento(nombreEstablecimiento);
	}
	
	public Tienda (String nombreEstablecimiento, Map<Integer, Producto> carta) {
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.carta = carta;
	}
	
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}
	
	public void muestraCarta() {
		String lineaMuestra = "";
		for (Map.Entry<Integer, Producto> entry : carta.entrySet()) {
			lineaMuestra += (entry.getKey()) + "." + entry.getValue().getNombreProducto() + " ";
		}
		System.out.println(lineaMuestra);
	}

	/**
	 * @return the nombreEstablecimiento
	 */
	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	/**
	 * @param nombreEstablecimiento the nombreEstablecimiento to set
	 */
	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	/**
	 * @return the carta
	 */
	public Map<Integer, Producto> getCarta() {
		return carta;
	}

	/**
	 * @param carta the carta to set
	 */
	public void setCarta(Map<Integer, Producto> carta) {
		this.carta = carta;
	}

	/**
	 * @return the idTienda
	 */
	public Integer getIdTienda() {
		return idTienda;
	}
}
