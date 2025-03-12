package aplicacao;

import javax.naming.directory.InvalidAttributesException;

import entidades.CadastroPessoas;
import entidades.Cliente;
import entidades.Data;
import entidades.Funcionario;
import entidades.Gerente;

public class TesteCadastro {
	public static void main(String args[]) {
		
		CadastroPessoas cadastroPessoas = new CadastroPessoas();
		
		Cliente clienteUm = new Cliente("Pedro Lauton", new Data(14,07,2008), 1313);
		Cliente clienteDois = new Cliente("Gabriela Santana", new Data(26,05,2008), 1414);
		Funcionario funcionarioUm = new Funcionario("Caio Dib", new Data(15,11,2007), 2500.00);
		Funcionario funcionarioDois = new Funcionario("Jorge Amado", new Data(18,05,1978), 3000.00);
		Gerente gerente = new Gerente("Leonardo Lauton", new Data(03,02,2007), 5000.00, "Mercado");
		
		try {
			cadastroPessoas.cadastrarPessoa(funcionarioDois);
			cadastroPessoas.cadastrarPessoa(clienteUm);
			cadastroPessoas.cadastrarPessoa(gerente);
			cadastroPessoas.cadastrarPessoa(clienteDois);
			cadastroPessoas.cadastrarPessoa(funcionarioUm);
		} catch (InvalidAttributesException e) {
			e.getMessage();
		}
		
		cadastroPessoas.imprimiCadastro();
	}
}
