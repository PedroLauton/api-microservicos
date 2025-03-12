package lista_2;

import java.util.Scanner;

public class ex_10 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Double[] vetorNumeros = new Double[3];
		
		try {
			for(int i = 0; i < 3; i++) {
				System.out.print("Digite um número real: ");
				vetorNumeros[i] = sc.nextDouble();
			}
			
			ordenaVetor(vetorNumeros);
			
			System.out.println("\nNúmeros ordenados: ");
			for (Double numero : vetorNumeros) {
				System.out.print(numero + ", ");
			}
			
		} catch(Exception e) {
			System.out.println("\nDígito inválido. tente novamente.");
		} finally {
			sc.close();
		}
	}
	
	public static void ordenaVetor(Double[] vetorNumero) {
		Double auxiliar = vetorNumero[0];
		
		for(int i = 0; i < vetorNumero.length; i++) {
			for(int j = 0; j < vetorNumero.length; j++) {
				if(vetorNumero[j] > vetorNumero[i]) {
					auxiliar = vetorNumero[i]; 
					vetorNumero[i] = vetorNumero[j];
					vetorNumero[j] = auxiliar;
				}
			}
		}
	}
}
