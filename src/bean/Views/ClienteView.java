package bean.Views;

import java.io.Serializable;

public class ClienteView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Nombre;
	int dni;

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	

}
