package exercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex_8 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Integer numeroAnterior = 0;
		Integer numeroAtual = 1;
		Integer numeroFuturo = 0;
		
		System.out.print("Informe uma número inteiro não negativo para a série de Fibonacci: ");
		int numero = sc.nextInt();
		
		if(numero <= 0) {
			throw new InputMismatchException("O número informado deve ser maior que zero.");
		}
		
		System.out.println("\nSequência de Fibonacci \n");
		
		if(numero >= 1 ) {
			System.out.print(numeroAnterior);
		}
		
		if(numero >= 2) {
			System.out.print(", %d, ".formatted(numeroAtual));
		}
		
		for(int i = 2; i < numero; i++) {
			numeroFuturo = numeroAnterior + numeroAtual;
			
			System.out.print("%d, ".formatted(numeroFuturo));
			
			numeroAnterior = numeroAtual;
			numeroAtual = numeroFuturo;
		}
		
		
	}
}
