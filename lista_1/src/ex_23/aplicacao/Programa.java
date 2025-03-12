package ex_23.aplicacao;

import java.util.ArrayList;
import java.util.List;

import ex_23.entidades.Circulo;
import ex_23.entidades.FiguraGeometrica;

public class Programa {
	public static void main(String args[]) {
		List<FiguraGeometrica> figuras = new ArrayList<>();
		figuras.add(new Circulo("Círculo", 20.0));
		figuras.add(new Circulo("Quadrado", 17.5));
		figuras.add(new Circulo("Retângulo", 27.0));
		figuras.add(new Circulo("Triângulo", 60.0));
		
		for (FiguraGeometrica figuraGeometrica : figuras) {
			System.out.println("Nome da Figura: " + figuraGeometrica.getNomeFormaGeometrica());
			System.out.println("Área da figura: %.2f\n".formatted(figuraGeometrica.calcularArea()));
		}
	}
}
