package br.com.vcriquinho.entities;

public class RendaVariavel extends ProdutoFinanceiro{
	
	private Double rendimentoMensalEsperado;
	
	public RendaVariavel(String nome, String descricao,Double rendimentoMensalEsperado) {
		super(nome, descricao);
		this.rendimentoMensalEsperado = rendimentoMensalEsperado;
	}

	public Double getRendimentoMensalEsperado() {
		return rendimentoMensalEsperado;
	}

	public void setRendimentoMensalEsperado(Double rendimentoMensalEsperado) {
		this.rendimentoMensalEsperado = rendimentoMensalEsperado;
	}
}
