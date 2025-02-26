package exercicios;

import java.util.Scanner;

public class ex_11 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Integer numero = 0;
		Integer erroMaximo = 0;

		System.out.print("Digite um número inteiro positivo: ");
		numero = sc.nextInt();
		
		System.out.print("Qual o erro máximo? ");
		erroMaximo = sc.nextInt();
		
		for(Double i = 0.0; i < numero; i = i + 0.1) {
			if(i * i > numero) {
				System.out.println("\nNão possui raiz quadrada.");
				break;
			}
			else if(i * i == numero) {
				System.out.println("\nA raiz quadrada do número %d é %f".formatted(numero, i));
				break;
			}
		}
	}
}
