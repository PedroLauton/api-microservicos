package ex_23.entidades;

public abstract class FiguraGeometrica {
	
	private String nomeFormaGeometrica;

	public FiguraGeometrica(String nomeFormaGeometrica) {
		this.nomeFormaGeometrica = nomeFormaGeometrica;
	}

	public String getNomeFormaGeometrica() {
		return nomeFormaGeometrica;
	}
	
	public void setNomeFormaGeometrica(String nomeFormaGeometrica) {
		this.nomeFormaGeometrica = nomeFormaGeometrica;
	}
	
	public abstract Double calcularArea();
}
