package exercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ex_33 {
	public static void main(String args[]) {
		ex_13();
		ex_14();
	}
	
	public static void ex_13() {
		List<Integer> vetor = new ArrayList<>();
		Random random = new Random();

		for(int i = 0; i < 100; i++) {
			vetor.add(random.nextInt(1000));
		}
		
		vetor.sort(Comparator.comparing(x -> x));
		
		System.out.println("Refatoração do exercício 13");
		for (Integer integer : vetor) {
			System.out.print("%d, ".formatted(integer));
		}
	}
	
	public static void ex_14() {
		List<Integer> primeiroVetor = new ArrayList<>();
		List<Integer> segundoVetor = new ArrayList<>();
		List<Integer> vetorFinal = new ArrayList<>();
		
		Random random = new Random();
		

		for(int i = 0; i < 50; i++) {
			primeiroVetor.add(random.nextInt(1000));
			segundoVetor.add(random.nextInt(1000));
		}
		
		primeiroVetor.sort(Comparator.comparing(x -> x));
		segundoVetor.sort(Comparator.comparing(x -> x));

		vetorFinal.addAll(primeiroVetor);
		vetorFinal.addAll(segundoVetor);
		
		vetorFinal.sort(Comparator.comparing(x -> x));
		
		System.out.println("\n\nRefatoração do exercício 14");
		for (Integer integer : vetorFinal) {
			System.out.print("%d, ".formatted(integer));
		}
	}
}
