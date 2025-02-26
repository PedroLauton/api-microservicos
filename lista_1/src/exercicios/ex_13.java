package exercicios;

import java.util.Random;

public class ex_13 {
	public static void main(String args[]) {
		
		Integer[] vetor = new Integer[100];
		Random random = new Random();
		int auxilar = 0; 

		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = random.nextInt(1000);
		}
		
		//BubleSort
		for(int i = 0; i <= vetor.length - 1; i++) {
			for(int j = 0; j <= vetor.length - 1; j++) {
				if(vetor[j] > vetor[i]) {
					auxilar = vetor[i]; 
					vetor[i] = vetor[j];
					vetor[j] = auxilar;
				}
			}
		}
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.print("%d, ".formatted(vetor[i]));
		}
	}
}
