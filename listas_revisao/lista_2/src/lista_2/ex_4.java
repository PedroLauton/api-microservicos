package lista_2;

import java.util.Scanner;

public class ex_4 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Digite um número qualquer! ");
			Double numero = sc.nextDouble();
			
			if(numeroMaiorCinquenta(numero)) {
				System.out.println("\nO número " + numero + " é maior que 100!");
			}else {
				System.out.println("\nO número " + numero + " é igual ou menor que 100!");
			}
		} catch( Exception e) {
			System.out.println("\nDigito inválido, tente novamente.");
		} finally{
			sc.close();
		}
	}
	
	public static boolean numeroMaiorCinquenta(Double numero) {
		if(numero > 100) {
			return true;
		} else {
			return false;
		}
	}
}
