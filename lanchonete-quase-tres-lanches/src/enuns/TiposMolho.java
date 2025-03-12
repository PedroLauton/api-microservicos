package enuns;

public enum TiposMolho {
	
	TOMATE(25, 0.50, "Tomate"),
	BARBECUE(25, 0.75, "Barbecue"),
	BRANCO(25, 0.55, "Branco"),
	TASTY(25, 0.75, "Tasty"),
	ROSE(25, 0.75, "Rosé");
	
	private final Integer peso;
	private final Double valor;
	private final String nomeReal;
	
	TiposMolho(Integer peso, Double valor, String nomeReal) {
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
