package lista_2;

import java.util.Scanner;

public class ex_22 {
	
	public static class NegativeTimeException extends RuntimeException{

		private static final long serialVersionUID = 1L;
		
		public NegativeTimeException(String mensagem) {
			super(mensagem);
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		Double P0, V, A, T;
		
		try {
			System.out.print("Digite um valor para a Posição Inicial: ");
			P0 = sc.nextDouble();
			
			System.out.print("Digite um valor para a Velocidade: ");
			V = sc.nextDouble();
			
			System.out.print("Digite um valor para  a Aceleração: ");
			A = sc.nextDouble();
			
			System.out.print("Digite um valor para o Tempo: ");
			T = sc.nextDouble();
			
			if(T < 0) {
				throw new NegativeTimeException("\nNão existe tempo negativo comprovado...ainda...");
			}
			
			System.out.println("\nA posição final do móvel é: %.2f".formatted(cacularPosicaoFinal(P0, V, A, T)));
		} catch(NegativeTimeException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("\nDígito inválido. tente novamente.");
		} finally {
			sc.close();
		}
	}
	
	public static Double cacularPosicaoFinal(Double P0, Double V, Double A, Double T) {		
		return P0 + V * T + (A * Math.pow(T, 2)) / 2;
	}
}
