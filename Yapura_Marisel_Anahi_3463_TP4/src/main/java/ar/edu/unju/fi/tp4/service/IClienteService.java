package ar.edu.unju.fi.tp4.service;

import java.util.List;

import ar.edu.unju.fi.tp4.model.Cliente;

public interface IClienteService {
	
	
	public void guardarCliente(Cliente cliente);
	public void addCliente(Cliente cliente);
	public List<Cliente>getClientes();
	public void generarListaClientes();
	
	

}
