package lista_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex_21 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		Integer a = 0, b = 0, c = 0;

		try {
			System.out.print("Digite um valor para A: ");
			a = sc.nextInt();

			System.out.print("Digite um valor para B: ");
			b = sc.nextInt();

			System.out.print("Digite um valor para C: ");
			c = sc.nextInt();
		

			Integer discriminante = discriminante(a, b, c);
			System.out.println("\nO discriminante é: " + discriminante);
			
			Double[] raizes = equacaoSegungoGrau(discriminante, a, b, c);
			
			if(raizes == null) {
				System.out.println("\nEssa equação não tem raizes reais. \n\nEcerrando...");
				System.exit(0);
			}
			
			System.out.println("\nAs raizes são: ");
			
			for (int i = 0; i < raizes.length; i++) {
				System.out.println("Raiz " + (i + 1) + ": " + raizes[i]);
			}
		}  catch (InputMismatchException e) {
			System.out.println("Digite um número. Reiniciando...");
		} finally{
			sc.close();
		}
	}

	public static Integer discriminante(Integer a, Integer b, Integer c) {
		return (b * b) - (4 * a * c);
	}

	private static Double[] equacaoSegungoGrau(Integer discriminante, Integer a, Integer b, Integer c) {
		
		if(discriminante < 0) {
			return null;
		}
		
		Double primeiraRaiz = ((-b) + Math.sqrt(discriminante)) / (2 * a);
		Double segundaRaiz = ((-b) - Math.sqrt(discriminante)) / (2 * a);
		
		Double[] raizes = new Double[2];
		
		raizes[0] = primeiraRaiz;
		raizes[1] = segundaRaiz;

		return raizes;
	}
}
