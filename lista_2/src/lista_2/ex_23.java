package lista_2;

import java.util.Scanner;

public class ex_23 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		Double PV, J;
		Integer N;
		
		try {
			System.out.print("Digite um valor para o Capital Inicial: ");
			PV = sc.nextDouble();
			
			System.out.print("Digite um valor para a Taxa de Juros: ");
			J = sc.nextDouble();
			
			System.out.print("Digite um valor para  o Período da Aplicação: ");
			N = sc.nextInt();
			
			System.out.println("\nO Capital Futuro será: : %.2f".formatted(cacularCapitalFuturo(PV, J, N)));
		} catch(Exception e) {
			System.out.println("\nDígito inválido. Digite um número real para o Capital Inicial e a Taxa de Juros, e um valor inteiro para o Período de Aplicação.");
		} finally {
			sc.close();
		}
	}
	
	public static Double cacularCapitalFuturo(Double PV, Double J, Integer N) {		
		return PV * Math.pow((1 + J / 100), N);
	}
}
