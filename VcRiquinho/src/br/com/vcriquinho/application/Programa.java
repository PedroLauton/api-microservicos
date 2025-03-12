package br.com.vcriquinho.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.vcriquinho.entities.Cliente;
import br.com.vcriquinho.entities.Conta;
import br.com.vcriquinho.entities.ProdutoFinanceiro;
import br.com.vcriquinho.repositories.ClienteRepository;
import br.com.vcriquinho.repositories.ContaRepository;
import br.com.vcriquinho.repositories.CrudRepository;
import br.com.vcriquinho.repositories.ProdutoRepository;

public class Programa {
	
	private static final CrudRepository<Cliente> clientesRepository = new ClienteRepository();
    private static final CrudRepository<Conta> contasRepository = new ContaRepository();
    private static final CrudRepository<ProdutoFinanceiro> produtosRepository = new ProdutoRepository();
    
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int escolhaMenuInicial = 0;
		int escolhaMenuGerenciamento = 0;
		
		do {
			UI.menuInicial();
			escolhaMenuInicial = sc.nextInt();
			
			while(escolhaMenuInicial != 4 && escolhaMenuGerenciamento != 6) {				
				CrudRepository<?> entidadeRepository = escolhaGenciamento(escolhaMenuInicial);
				
				UI.escolheMenuGerenciamento(escolhaMenuInicial);
				escolhaMenuGerenciamento = sc.nextInt();
				UI.escolheAcao(escolhaMenuInicial, escolhaMenuGerenciamento, sc);
				escolhaCRUD(entidadeRepository, escolhaMenuGerenciamento);
				
			}
		}while(escolhaMenuInicial != 4);
	}
	
	public static CrudRepository<?> escolhaGenciamento(int escolhaMenuInicial) throws InputMismatchException{
		return switch(escolhaMenuInicial) {
			case 1 -> clientesRepository;
			case 2 -> contasRepository;
			case 3 -> produtosRepository;
			default -> throw new InputMismatchException("Erro na seleção. Por favor, digite um número válido.");
		};
	}
	
	public static void escolhaCRUD(CrudRepository<?> entidadeRepository, int escolhaMenuGerenciamento) throws InputMismatchException{
		switch(escolhaMenuGerenciamento) {
			//case 1: entidadeRepository.salvar(entidadeRepository); break;
			//case 2: entidadeRepository.atualizarDado(entidadeRepository); break;;
			case 3: entidadeRepository.lerDadoId(escolhaMenuGerenciamento); break;
			case 4: entidadeRepository.listarDados(); break;
			case 5: entidadeRepository.deletarDado(escolhaMenuGerenciamento); break;
			case 6: break;
			default: throw new InputMismatchException("Erro na seleção. Por favor, digite um número válido.");
		}
	}
}
