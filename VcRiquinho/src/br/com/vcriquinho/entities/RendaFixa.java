package br.com.vcriquinho.entities;

import java.time.LocalDate;

public class RendaFixa extends ProdutoFinanceiro{
	
	private final Double redimentoMensalFixo = 0.02;
	private LocalDate peridoCarencia;
	
	public RendaFixa(String nome, String descricao, LocalDate peridoCarencia) {
		super(nome, descricao);
		this.peridoCarencia = peridoCarencia;
	}

	public LocalDate getPeridoCarencia() {
		return peridoCarencia;
	}

	public Double getRedimentoMensalFixo() {
		return redimentoMensalFixo;
	}
	
	public boolean carenciaCumprida() {
		return (peridoCarencia.isBefore(LocalDate.now()) || peridoCarencia.isEqual(LocalDate.now())) ? true : false;
	}
}
