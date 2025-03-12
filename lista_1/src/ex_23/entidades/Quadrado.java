package ex_23.entidades;

public class Quadrado extends FiguraGeometrica{
	
	private Double lado;

	public Quadrado(String nomeFormaGeometrica, Double lado) {
		super(nomeFormaGeometrica);
		this.lado = lado;
	}

	public Double getLado() {
		return lado;
	}

	public void setLado(Double lado) {
		this.lado = lado;
	}

	@Override
	public Double calcularArea() {
		return Math.pow(lado, 2);
	}
}
