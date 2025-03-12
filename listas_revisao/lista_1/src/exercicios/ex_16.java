package exercicios;

import java.util.Scanner;

public class ex_16 {
	public static class ConversorTempo{
		
		private Integer segundos;
		
		public ConversorTempo() {
		}

		public ConversorTempo(Integer segundos) {
			this.segundos = segundos;
		}

		public Integer getSegundos() {
			return segundos;
		}
		
		public void leituraSegundos(Scanner sc) {
			System.out.print("Digite o tempo em segundos: ");
			escritaSegundos(sc.nextInt());
		}
		
		public void escritaSegundos(Integer segundos) {
			this.segundos = segundos;
		}
		
		public int conversaoHoras() {
			return segundos / 3600;
		}
		
		public int conversaoMinutos() {
			return (segundos % 3600) /60;
		}
		
		public int conversorSegundos() {
			return segundos % 60;
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		try {
			ConversorTempo conversorTempo = new ConversorTempo();
			conversorTempo.leituraSegundos(sc);
			
			System.out.println("Tempo: %d:%d:%d".formatted(conversorTempo.conversaoHoras(), 
					conversorTempo.conversaoMinutos(), 
					conversorTempo.conversorSegundos()));
		} catch(Exception e) {
        	System.out.println("Dígito inválido. Tente novamente.");
		} finally {
			sc.close();
		}
		
	}
}
