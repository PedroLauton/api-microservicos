package br.com.vcriquinho.entities;

import java.util.ArrayList;
import java.util.List;

public class ContaInvestimentoAutomatico extends Conta{
	
	private List<ProdutoFinanceiro> produtos;
	private Double taxaServcico;

	public ContaInvestimentoAutomatico(Double saldo) {
		super(saldo);
		produtos = new ArrayList<>();
	}

	public List<ProdutoFinanceiro> getProdutos() {
		return produtos;
	}

	public void addProdutos(ProdutoFinanceiro produto) {
		produtos.add(produto);
	}
}
