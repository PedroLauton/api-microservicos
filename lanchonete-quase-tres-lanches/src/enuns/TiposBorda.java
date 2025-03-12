package enuns;

public enum TiposBorda {
	
	CATUPIRY(100, 11.00, "Catupiry"),
	CHEEDAR(100, 11.00, "Cheedar"),
	MOLHO_ESPECIAL(100, 15.00, "Molho Especial"),
	NORMAL(100, 0.0, "Normal");
	
	private final Integer peso;
	private final Double valor;
	private final String nomeReal;
	
	TiposBorda(Integer peso, Double valor, String nomeReal) {
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
