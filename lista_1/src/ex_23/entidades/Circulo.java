package ex_23.entidades;

public class Circulo extends FiguraGeometrica{
	
	private final Double pi = 3.1415;
	private Double raio; 

	public Circulo(String nomeFormaGeometrica, Double raio) {
		super(nomeFormaGeometrica);
		this.raio = raio;
	}

	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}

	public Double getPi() {
		return pi;
	}

	@Override
	public Double calcularArea() {
		return pi * Math.pow(raio, 2);
	}
}
