package exercicios;

import java.util.Random;

public class ex_14 {
	public static void main(String args[]) {
		Integer[] primeiroVetor = new Integer[50];
		Integer[] segundoVetor = new Integer[50];
		Integer[] vetorFinal = new Integer[100];
		
		Random random = new Random();
		int auxilar = 0;
		int indicePrimeiroVetor = 0;
		int indiceSegundoVetor = 0;
		int indiceVetorFinal = 0;

		for(int i = 0; i < 50; i++) {
			primeiroVetor[i] = random.nextInt(1000);
			segundoVetor[i] = random.nextInt(1000);
		}
		
		for(int i = 0; i <= 50 - 1; i++) {
			for(int j = 0; j <= 50 - 1; j++) {
				if(primeiroVetor[j] > primeiroVetor[i]) {
					auxilar = primeiroVetor[i]; 
					primeiroVetor[i] = primeiroVetor[j];
					primeiroVetor[j] = auxilar;
				}
				if(segundoVetor[j] > segundoVetor[i]) {
					auxilar = segundoVetor[i]; 
					segundoVetor[i] = segundoVetor[j];
					segundoVetor[j] = auxilar;
				}
			}
		}
				
		while(indicePrimeiroVetor < 50 && indiceSegundoVetor < 50) {
			if(primeiroVetor[indicePrimeiroVetor] < segundoVetor[indiceSegundoVetor]) {
				vetorFinal[indiceVetorFinal++] = primeiroVetor[indicePrimeiroVetor++];
			}else {
				vetorFinal[indiceVetorFinal++] = segundoVetor[indiceSegundoVetor++];
			}
		}
		
		while (indicePrimeiroVetor < 50) {
		    vetorFinal[indiceVetorFinal++] = primeiroVetor[indicePrimeiroVetor++];
		}

		while (indiceSegundoVetor < 50) {
		    vetorFinal[indiceVetorFinal++] = segundoVetor[indiceSegundoVetor++];
		}
		
		for (int i = 0; i < vetorFinal.length; i++) {
			System.out.print("%d, ".formatted(vetorFinal[i]));
		}
	}
}
