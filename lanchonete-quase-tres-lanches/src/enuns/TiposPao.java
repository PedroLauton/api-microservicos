package enuns;

public enum TiposPao {
	
	AUSTRALIANO(100, 7.00, "Australiano"),
	BAGUETE(100, 5.00, "Baguete"),
	BRIOCHE(100, 4.00, "Brioche");
	
	private final Integer peso;
	private final Double valor;
	private final String nomeReal;
	
	TiposPao(Integer peso, Double valor, String nomeReal) {
		this.peso = peso;
		this.valor = valor;
		this.nomeReal = nomeReal;
	}

	public Integer getPeso() {
		return peso;
	}

	public Double getValor() {
		return valor;
	}

	public String getNomeReal() {
		return nomeReal;
	}
}
