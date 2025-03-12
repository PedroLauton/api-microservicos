package lista_2;

import java.util.Scanner;

public class ex_14 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Double[] notas = new Double[3];
		
		try {
			for(int i = 0; i < 3; i++) {
				System.out.print("Digite a " + (i + 1)  + "º do aluno(a): ");
				notas[i] = sc.nextDouble();
			}
			
			statusFinal(mediaAritimetica(notas));
		} catch(Exception e) {
			System.out.println("\nDígito inválido. tente novamente.");
		} finally {
			sc.close();
		}
	}
	
	public static Double mediaAritimetica(Double[] notas) {		
		Double auxiliar = 0.0;
		for(int i = 0; i < notas.length; i++) {
			auxiliar += notas[i];
		}
		return auxiliar / notas.length;
	}
	
	public static void statusFinal(Double media) {		
		if(media >= 7) {
			System.out.println("\nO aluno está Aprovado! A média foi %.2f".formatted(media));
		} else if(media < 7 && media >= 3) {
			System.out.println("\nO aluno está de Exame! A média foi %.2f".formatted(media));
		} else {
			System.out.println("\nO aluno está Reprovado! A média foi %.2f".formatted(media));
		}
	}
}
