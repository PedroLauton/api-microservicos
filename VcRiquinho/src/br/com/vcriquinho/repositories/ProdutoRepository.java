package br.com.vcriquinho.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.vcriquinho.entities.ProdutoFinanceiro;

public class ProdutoRepository implements CrudRepository<ProdutoFinanceiro>{

	private final List<ProdutoFinanceiro> produtos;
	private int proximoId = 1;
	
	public ProdutoRepository() {
		produtos = new ArrayList<>();
	}
	
	@Override
	public void salvar(ProdutoFinanceiro produto) {
		produto.setId(proximoId++);
		produtos.add(produto);
	}

	@Override
	public ProdutoFinanceiro lerDadoId(int id) {
		return produtos.get(id);
	}

	@Override
	public List<ProdutoFinanceiro> listarDados() {
		return produtos;
	}

	@Override
	public void atualizarDado(ProdutoFinanceiro produto) {
		deletarDado(produto.getId());
        produtos.add(produto);
	}

	@Override
	public void deletarDado(int id) {
		produtos.removeIf(p -> p.getId() == id);
	}
	
}
