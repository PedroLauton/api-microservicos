package br.com.vcriquinho.entities;

public abstract class Conta {
	
	private int id;
	private Double saldo;
	
	public Conta(Double saldo) {
		this.saldo = saldo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void deposito(Double valor) {
		saldo += valor;
	}
}
