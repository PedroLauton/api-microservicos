package lista_2;

import java.util.Scanner;

public class ex_20 {
	public static class NegativeValueException extends RuntimeException{

		private static final long serialVersionUID = 1L;
		
		public NegativeValueException(String mensagem) {
			super(mensagem);
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Double medidaMetros = 0.0;
		
		try {
			System.out.print("Digite uma medida em metros: ");
			medidaMetros = sc.nextDouble();
			
			if(medidaMetros < 0) {
				throw new NegativeValueException("\nValor negativo! Tente novamente.");
			}
			
			System.out.println("\nValor em metros: " + medidaMetros);
			System.out.println("Valor em Pés: %.3f".formatted(conversaoPes(medidaMetros)));
		} catch(NegativeValueException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("\nDígito inválido. tente novamente.");
		} finally {
			sc.close();
		}
	}
	
	public static Double conversaoPes(Double medidaMetros) {
		return medidaMetros * 3.315;
	}
}
