package bean.Views;

import java.io.Serializable;

public class ProductoView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigoProducto;
	private String descripcion;
	private boolean esPaquete;
	
	public ProductoView(int codigo, String descripcion) {
		this.setCodigoProducto(codigo);
		this.setDescripcion(descripcion);
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}
	
	public boolean getEsPaquete()
	{
		return this.esPaquete;
	}
	
	public void setEsPaquete(boolean esPaquete)
	{
		this.esPaquete = esPaquete;
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
}

