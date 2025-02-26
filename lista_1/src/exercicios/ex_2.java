package exercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex_2 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		
		Integer x1 = 0;
		Integer y1 = 0;
		Integer z1 = 0;
		
		Integer x2 = 0;
		Integer y2 = 0;
		Integer z2 = 0;

		try {
			System.out.print("Digite um valor para o corpo 1(A): ");
			x1 = sc.nextInt();

			System.out.print("Digite um valor para o corpo 1(B): ");
			y1 = sc.nextInt();

			System.out.print("Digite um valor para o corpo 1(C): ");
			z1 = sc.nextInt();
			
			System.out.print("Digite um valor para o corpo 2(A): ");
			x2 = sc.nextInt();

			System.out.print("Digite um valor para o corpo 2(B): ");
			y2 = sc.nextInt();

			System.out.print("Digite um valor para o corpo 2(C): ");
			z2 = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Digite um número. Reiniciando...");
		}
		
        System.out.println("\nA distância entre os pontos é: %.2f".formatted(distanciaEntrePontos(x1, y1, z1, x2, y2, z2)));
	}
	
	public static Double distanciaEntrePontos(Integer x1, Integer y1, Integer z1, Integer x2, Integer y2, Integer z2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
	}
}


