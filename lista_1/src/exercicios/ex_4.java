package exercicios;

import java.util.Scanner;

public class ex_4 {
	public static class Produto {

		private String nome;
		private Double preco;
		private Integer qtd;
		
		public Produto() {
		}
		
		public Produto(String nome, Double preco, Integer qtd) {
			this.nome = nome;
			this.preco = preco;
			this.qtd = qtd;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}

		public Integer getQtd() {
			return qtd;
		}

		public void setQtd(Integer qtd) {
			this.qtd = qtd;
		}
		
		public Double valorPago() {
			Double valorBase = preco * qtd;
			
			if(qtd <= 10) {
				return desconto(valorBase, 0);
			} else if(qtd >= 11 && qtd <= 20) {
				return desconto(valorBase, 10);
			} else if(qtd >= 21 && qtd <= 50) {
				return desconto(valorBase, 20);
			} else {
				return desconto(valorBase, 30);
			}
		}
		
		public Double desconto(Double valorBase, Integer desconto) {
			return valorBase - (valorBase / 100 * desconto); 
		}
		
		public void imprimeDados() {
			String dados = """
					
					======================================
					Nome do produto: %s
					Preço unitário: %.2f
					Quantidade comprada: %d
					
					Valor total a ser pago: %.2f
					======================================
					""".formatted(nome, preco, qtd, valorPago());
			
			System.out.println(dados);
		}
	}
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		
		System.out.print("Digite o nome do produto: ");
		produto.setNome(sc.nextLine());
		
		System.out.print("Digite o preço do produto: ");
		produto.setPreco(sc.nextDouble());
		
		System.out.print("Digite a quantidade do produto comprado: ");
		produto.setQtd(sc.nextInt());
		
		produto.imprimeDados();
	}
}
