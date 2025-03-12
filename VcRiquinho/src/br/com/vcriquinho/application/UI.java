package br.com.vcriquinho.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.vcriquinho.entities.Cliente;
import br.com.vcriquinho.entities.PessoaFisica;
import br.com.vcriquinho.entities.PessoaJuridica;

public class UI {
	
	public static void menuInicial() {
		String exibicao = """
				========================= Vc Riquinho =========================
				
				Bem vindo(a) colaborador(a), o que você deseja? 
				
				
				1. Gerenciar clientes;
				2. Gerenciar contas;
				3. Gerenciar produtos financeiros. 
				4. Finalizar expediente.
				
				Obs: Utilize somente número para selecionar as opções.
				
				===============================================================
				
				Escolha: """;
		System.out.print(exibicao);
	}
	
	public static void escolheMenuGerenciamento(int escolha) {
		switch(escolha) {
			case 1: menuInicialCliente(); break;
			case 2: menuInicialConta(); break;
			case 3: menuInicialProduto(); break;
			default: throw new InputMismatchException("Por favor, dígite um valor válido.");
		}
	}
	
	public static void escolheAcao(int escolhaMenu, int escolhaAcao, Scanner sc) {
		switch(escolhaMenu) {
			case 1: escolhaClienteAcao(escolhaAcao, sc); break;
			//case 2: escolhaContaAcao(); break;
			//case 3: escolhaProdutoAcao(); break;
			default: throw new InputMismatchException("Por favor, dígite um valor válido.");
		}
	}
	
	public static void escolhaClienteAcao(int escolhaAcao, Scanner sc) {
		switch(escolhaAcao) {
			case 1: cadastrarCliente(sc); break;
			case 2: menuInicialConta(); break;
			case 3: menuInicialProduto(); break;
			default: throw new InputMismatchException("Por favor, dígite um valor válido.");
		}
	}
	
	public static Cliente cadastrarCliente(Scanner sc) {
		System.out.println("O cliente é pessoa física ou pessoa jurídica? \n\n1. Pessoa física\n2. Pessoa jurídica\n\nEscolha: ");
		int tipoCliente = sc.nextInt();
		
		if(tipoCliente == 1) {
			System.out.println("\nDigite o  nome do cliente: ");
			String nomeCliente = sc.nextLine();
			
			System.out.println("\nDigite o  email do cliente: ");
			String emailCliente = sc.nextLine();
			
			System.out.println("\nDigite o  CPF do cliente: ");
			Long cpfCliente = sc.nextLong();
			
			return new PessoaFisica(nomeCliente, emailCliente, cpfCliente);
		} else {
			System.out.println("\nDigite o  nome da empresa: ");
			String nomeEmpresa = sc.nextLine();
			
			System.out.println("\nDigite o  email da empresa: ");
			String emailEmpresa = sc.nextLine();
			
			System.out.println("\nDigite o  CNPJ da empresa: ");
			Long cpfEmpresa = sc.nextLong();
			
			return new PessoaJuridica(nomeEmpresa, emailEmpresa, cpfEmpresa);
		}
		
	}
	
	public static void menuInicialCliente() {
		String exibicao = """
				\n========================= Vc Riquinho =========================
				
				Gerenciamento de Clientes!
				O que você deseja fazer?
				
				1. Cadastrar cliente
				2. Atualizar dados
				3. Listar clientes
				4. Buscar por ID
				5. Excluir clientes
				6. Voltar
				
				Obs: Utilize somente número para selecionar as opções.
				
				===============================================================
				
				Escolha: """;
		System.out.print(exibicao);
	}
	
	public static void menuCliente() {
		String exibicao = """
				\n========================= Vc Riquinho =========================
				
				Gerenciamento de Clientes!
				O que você deseja fazer?
				
				1. Cadastrar cliente
				2. Atualizar dados
				3. Listar clientes
				4. Buscar por ID
				5. Excluir clientes
				6. Voltar
				
				Obs: Utilize somente número para selecionar as opções.
				
				===============================================================
				
				Escolha: """;
		System.out.print(exibicao);
	}
	
	public static void menuInicialConta() {
		String exibicao = """
				\n========================= Vc Riquinho =========================
				
				Gerenciamento de Clientes!
				O que você deseja fazer?
				
				1. Cadastrar cliente
				2. Atualizar dados
				3. Listar clientes
				4. Buscar por ID
				5. Excluir clientes
				6. Voltar
				
				Obs: Utilize somente número para selecionar as opções.
				
				===============================================================
				
				Escolha: """;
		System.out.print(exibicao);
	}
	
	public static void menuInicialProduto() {
		String exibicao = """
				\n========================= Vc Riquinho =========================
				
				Gerenciamento de Clientes!
				O que você deseja fazer?
				
				1. Cadastrar cliente
				2. Atualizar dados
				3. Listar clientes
				4. Buscar por ID
				5. Excluir clientes
				6. Voltar
				
				Obs: Utilize somente número para selecionar as opções.
				
				===============================================================
				
				Escolha: """;
		System.out.print(exibicao);
	}
	
}
