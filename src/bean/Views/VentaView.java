package bean.Views;

import java.util.Date;
import java.io.Serializable;

public class VentaView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float totalVenta;
	private int idVenta;
	private Date fechaVenta;
	private int dni;
	private String NombreCliente;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public float getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(float f) {
		this.totalVenta = f;
	}
	
	
}

