package br.com.vcriquinho.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.vcriquinho.entities.Conta;

public class ContaRepository implements CrudRepository<Conta>{

	private final List<Conta> contas;
	private int proximoId = 1;
	
	public ContaRepository() {
		contas = new ArrayList<>();
	}
	
	@Override
	public void salvar(Conta conta) {
		conta.setId(proximoId++);
		contas.add(conta);
	}

	@Override
	public Conta lerDadoId(int id) {
		return contas.get(id);
	}

	@Override
	public List<Conta> listarDados() {
		return contas;
	}

	@Override
	public void atualizarDado(Conta conta) {
		deletarDado(conta.getId());
		contas.add(conta);
	}

	@Override
	public void deletarDado(int id) {
		contas.removeIf(c -> c.getId() == id);
	}

}
