package app;

import bean.Cliente;
import bean.srv.ClienteSRV;

public class ClienteController {
	
	private static ClienteController instancia;

	public static ClienteController getInstancia() {
		if (instancia == null) {
			instancia = new ClienteController();
		}
		return instancia;
	}
	
	public Cliente buscarCliente(int dni) {
		
		ClienteSRV srv = new ClienteSRV();
		Cliente cli = srv.buscarCliente(dni);
		
		return cli;
		
	}
	
	public int altaCliente(int dni, String nombre, int telefono, String mail) {
		
		ClienteSRV srv = new ClienteSRV();
		Cliente aux = srv.buscarCliente(dni);
		
		if(aux == null)
		{
			Cliente cli = new Cliente();
			cli.setDni(dni);
			cli.setMail(mail);
			cli.setNombre(nombre);
			cli.setTelefono(telefono);
			
			srv.grabarCliente(cli);
			
			return 1;
		}
		else
		{
			return -1;
		}
	}

	public int bajaCliente(int dni) {

		ClienteSRV srv = new ClienteSRV();
		Cliente cli = srv.buscarCliente(dni);
		
		if(cli == null)
		{	
			return -1;
		}
		else
		{
			srv.eliminarCliente(cli);
			return 1;
		}
	}	
}
