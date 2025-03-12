package exercicios;

import java.util.Scanner;

public class ex_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x1, y1, x2, y2, distancia;
		
		try {
			System.out.println("Entre com as coordenadas x e y dos pontos nesta ordem:");
			x1 = sc.nextFloat();
			y1 = sc.nextFloat();
			x2 = sc.nextFloat();
			y2 = sc.nextFloat();
			
			distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			System.out.println("A distância é: %.2f".formatted(distancia));
		} catch (Exception e) {
			System.out.println("Digite um número. Reiniciando...");
		} finally{
			sc.close();
		}
	}
}
