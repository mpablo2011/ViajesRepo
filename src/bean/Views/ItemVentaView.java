package bean.Views;

import java.io.Serializable;

public class ItemVentaView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int codigoProducto;
	String descripcion;
	int cantidad;
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
