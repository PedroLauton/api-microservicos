package aplicação;

import java.util.InputMismatchException;
import java.util.Scanner;

import entidades.Guiche;
import entidades.Pedido;
import entidades.Prato;

public class Programa {
	public static void main(String args[]) {
		
		Integer escolha = 0;
		Integer escolhaPagamento = 0;
		Scanner sc = new Scanner(System.in);
		
		Guiche guiche = new Guiche();
		Pedido pedido = new Pedido();
		Processamento processamento = new Processamento();
		
		try {
			
			UI.nomeCliente();
			pedido.setNomeCliente(sc.nextLine());
			
			do {
				UI.menuLanchonete();
				escolha = sc.nextInt();
				sc.nextLine();
				
				Prato prato = processamento.escolherPrato(escolha);
				
				prato.montarPrato(sc);
				prato.calcularPreco();
				prato.calcularPeso();

				pedido.addItensConsumidos(prato);
				
				UI.desejaContinuar();
				escolha = sc.nextInt();
				
				if(escolha == 2) {
					escolha = 4;
				}
				
			}while(escolha != 4);
			
			pedido.calcularTotal();
			
			do {
				guiche.setPedido(pedido);
				
				UI.menuPagamento();
				escolhaPagamento = sc.nextInt();
				
				if(escolhaPagamento == 1) {
					System.out.println("\nO valor total é " + pedido.getValorTotal());
					System.out.println("\nProcessando cartão..........\n\nPagamento realizado com sucesso!");
				} else if(escolhaPagamento == 2) {
					System.out.println("\nO valor total é " + pedido.getValorTotal());
					System.out.print("\nInsira a quantia paga pelo cliente: ");
					guiche.setValorPagoCliente(sc.nextDouble());
					
					guiche.calcularTroco();
					System.out.println("\nO troco do cliente será: " + guiche.getValorTroco());
				} else {
					System.out.println("\nMetódo inválido. Tente novamente.");
				}
			}while(escolhaPagamento != 1 && escolhaPagamento !=2);
			
			System.out.println("\nImprimindo nota fiscal............\n");
			pedido.gerarNotaFiscal();
		}catch(InputMismatchException e) {
			System.out.println("\nValor inválido, digite novamente!");
            sc.nextLine(); 

            System.out.println("\nPressione Enter para tentar novamente...");
            sc.nextLine(); 
		}
	}
}
