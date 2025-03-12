package exercicios;

import java.util.Scanner;

public class ex_6 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Digite um número inteiro: ");
			Integer numero = sc.nextInt();
			
			Integer divisao = numero;
			Integer contador = 0;
			
			while(divisao != 0) {
				contador++;
				divisao /= 10;
			}
			
			System.out.println("\nO número %d contém %d dígitos".formatted(numero, contador));
		} catch(Exception e) {
        	System.out.println("Dígito inválido. Tente novamente.");
		} finally {
			sc.close();
		}
	}
}
