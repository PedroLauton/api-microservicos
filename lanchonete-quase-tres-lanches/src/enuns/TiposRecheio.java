package enuns;

public enum TiposRecheio {
	
	BROCOLIS(200, 20.00, "Brócolis"),
	CARNE(200, 25.00, "Carne"),
	QUEIJO(200, 20.00, "Queijo"),
	FRANGO(200, 23.00, "Frango"),
	CAMARAO(200, 30.00, "Camarao");
	
	private final Integer peso;
	private final Double valor;
	private final String nomeReal;
	
	TiposRecheio(Integer peso, Double valor, String nomeReal) {
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
