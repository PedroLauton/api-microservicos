package exercicios;

import java.util.Scanner;

public class ex_10 {
	public static class Investimento{
		
		private Double valorInvestidoMes;
		private Double taxaJuros;
		private Double valorTotal;
		
		public Investimento() {
			valorTotal = 0.0;
		}
		
		public Investimento(Double valorInvestidoMes, Double taxaJuros) {
			this.valorInvestidoMes = valorInvestidoMes;
			this.taxaJuros = taxaJuros;
			valorTotal = 0.0;
		}

		public Double getValorInvestidoMes() {
			return valorInvestidoMes;
		}

		public void setValorInvestidoMes(Double valorInvestidoMes) {
			this.valorInvestidoMes = valorInvestidoMes;
		}

		public Double getTaxaJuros() {
			return taxaJuros;
		}
		
		public void setTaxaJuros(Double taxaJuros) {
			this.taxaJuros = taxaJuros;
		}
		
		public Double getValorTotal() {
			return valorTotal;
		}

		public void rendimentoAnual() {
			Double rendimento = 0.0;
			for (int i = 0; i < 12; i++) {
				valorTotal += valorInvestidoMes; 
				rendimento = valorTotal * taxaJuros;
				valorTotal += rendimento;
			}
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Investimento investimento = new Investimento();
		String escolha;
		
		try {
			System.out.print("Digite o valor investido mês a mês: ");
			investimento.setValorInvestidoMes(sc.nextDouble());
			
			System.out.print("Digite a taxa de juros: ");
			investimento.setTaxaJuros(sc.nextDouble());
			
			do {
				investimento.rendimentoAnual();
				System.out.println("\nSaldo do investimento após 1 ano: " + investimento.getValorTotal());
				System.out.println("Desejar processar mais um ano? (S/N)");
				escolha = sc.next();
			}while(!escolha.equals("N"));
		} catch(Exception e) {
			System.out.println("Digite um caratere válido.");
		} finally {
			sc.close();
		}
	}
}
