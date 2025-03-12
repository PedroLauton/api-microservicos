package ex_23.entidades;

public class Triangulo extends FiguraGeometrica{
	
	private Double base;
	private Double altura;

	public Triangulo(String nomeFormaGeometrica, Double base, Double altura) {
		super(nomeFormaGeometrica);
		this.base = base;
		this.altura = altura;
	}

	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public Double calcularArea() {
		return base * altura / 2;
	} 
}
