package br.com.vcriquinho.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	
	private int id;
	private String nome;
	private String email;
	private List<Conta> contas;
	
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
		contas = new ArrayList<Conta>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void addConta(Conta conta) {
		contas.add(conta);
	}
}
