	package enuns;

public enum TiposMassa {
	
	FRITA(50, 4.00, "Frita"), 
	ASSADA(50, 5.00, "Assada");
	
	private final Integer peso;
	private final Double valor;
	private final String nomeReal;
	
	TiposMassa(Integer peso, Double valor, String nomeReal) {
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
