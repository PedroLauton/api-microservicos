package lista_2;

import java.util.Scanner;

public class ex_3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Digite um número qualquer! ");
			Double numero = sc.nextDouble();
			
			if(numeroMaiorCinquenta(numero)) {
				System.out.println("\nO número " + numero + " é maior que 50!");
			}else {
				System.out.println("\nO número " + numero + " não é maior que 50!");
			}
		} catch( Exception e) {
			System.out.println("\nDigito inválido, tente novamente.");
		} finally {
			sc.close();
		}
	}
	
	public static boolean numeroMaiorCinquenta(Double numero) {
		if(numero > 50) {
			return true;
		} else {
			return false;
		}
	}
}
