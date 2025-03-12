package br.com.vcriquinho.entities;

public class PessoaJuridica extends Cliente{
	
	private Long cnpj;
	
	public PessoaJuridica(String nome, String email, Long cnpj) {
		super(nome, email);
		this.cnpj = cnpj;
	}

	public Long getCnpj() {
		return cnpj;
	}
}
