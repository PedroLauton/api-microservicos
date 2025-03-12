package br.com.vcriquinho.entities;

public class ContaCDI extends Conta{
	
	private final Double taxaServico = 0.07;
	private final Double taxaCDI = 0.01035;
	
	public ContaCDI(Double saldo) {
		super(saldo);
	}
	
	public Double getTaxaServico() {
		return taxaServico;
	}
	public Double getTaxaCDI() {
		return taxaCDI;
	} 
}
