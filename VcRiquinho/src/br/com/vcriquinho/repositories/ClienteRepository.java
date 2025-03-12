package br.com.vcriquinho.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.vcriquinho.entities.Cliente;

public class ClienteRepository implements CrudRepository<Cliente>{

	private final List<Cliente> clientes;
	private int proximoId = 1;
	
	public ClienteRepository() {
		clientes = new ArrayList<>();
	}
	
	@Override
	public void salvar(Cliente cliente) {
		cliente.setId(proximoId++);
		clientes.add(cliente);
	}

	@Override
	public Cliente lerDadoId(int id) {
		return clientes.get(id);
	}

	@Override
	public List<Cliente> listarDados() {
		return clientes;
	}

	@Override
	public void atualizarDado(Cliente cliente) {
		deletarDado(cliente.getId());
		clientes.add(cliente);
	}

	@Override
	public void deletarDado(int id) {
		clientes.removeIf(c -> c.getId() == id);
	}

}
