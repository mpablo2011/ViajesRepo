package bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name = "dni")
	private int dni;
	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	@Column (name = "telefono", nullable = false, length = 20)
	private int telefono;
	@Column (name = "mail", nullable = false, length = 80)
	private String mail;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
