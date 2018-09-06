package bean;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class VisitasTuristicas extends Productos {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fecha;
	private String nombreGuia;
	private String ubicacion;
	private Float precio;
	
	public  VisitasTuristicas()
	{
		
	}
	
	public VisitasTuristicas(String descripcion,Date fecha,String nombre,String ubicacion,float precio)
	{
		this.descripcion = descripcion;
		this.fecha = fecha; 
		this.nombreGuia = nombre;
		this.ubicacion = ubicacion;
		this.precio = precio;
	}
	
	public float getPrecio() {
		return this.precio;
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreGuia() {
		return nombreGuia;
	}

	public void setNombreGuia(String nombreGuia) {
		this.nombreGuia = nombreGuia;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
