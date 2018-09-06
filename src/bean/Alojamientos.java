package bean;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("AL")
public class Alojamientos extends Productos {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fechaDesde;
	private String nombreAlojamiento;
	private Date FechaHasta;
	private float precio;
	private String ubicacion;
	
	public Alojamientos()
	{
		
	}
	
	public Alojamientos(String descripcion,Date fechaDesde, Date fechaHasta, String nombreAlojamiento, float precio, String ubicacion)
	{
		this.setFechaDesde(fechaDesde);
		this.setFechaHasta(fechaHasta);
		this.setNombreAlojamiento(nombreAlojamiento);
		this.setPrecio(precio); 
		this.setUbicacion(ubicacion);
		this.descripcion = descripcion;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return FechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		FechaHasta = fechaHasta;
	}

	public String getNombreAlojamiento() {
		return nombreAlojamiento;
	}

	public void setNombreAlojamiento(String nombreAlojamiento) {
		this.nombreAlojamiento = nombreAlojamiento;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public float getPrecio() {
		return this.precio;
		
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
