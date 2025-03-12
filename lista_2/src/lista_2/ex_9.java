package lista_2;

import java.util.Scanner;

public class ex_9 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Double[] vetorNumeros = new Double[3];
		
		try {
			for(int i = 0; i < 3; i++) {
				System.out.print("Digite um número real: ");
				vetorNumeros[i] = sc.nextDouble();
			}
			
			System.out.println("\nO menor valor fornecido é: " + menorValor(vetorNumeros));
		} catch(Exception e) {
			System.out.println("\nDígito inválido. tente novamente.");
		} finally {
			sc.close();
		}
	}
	
	public static Double menorValor(Double[] vetorNumero) {
		Double menorNumero = vetorNumero[0];
		
		for(int i = 0; i < vetorNumero.length; i++) {
			if(vetorNumero[i] < menorNumero) {
				menorNumero = vetorNumero[i];
			}
		}
		return menorNumero;
	}
}
