package entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

public class CadastroPessoas {
	
	private Integer qtdAtual;
	private List<Pessoa> pessoas = new ArrayList<>(); 
	
	public Integer getQtdAtual() {
		return qtdAtual;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void cadastrarPessoa(Pessoa pessoa) throws InvalidAttributesException {
		if(pessoa instanceof Pessoa) {
			pessoas.add(pessoa);
			ordenarLista();
			atualizarQtdAtual();
		}else {
			throw new InvalidAttributesException("Você deve fornecer um objeto do tipo Pessoa.");
		}
	}
	
	public void imprimiCadastro() {
		System.out.println("Quantidade de Pessoas cadastradas: " + qtdAtual + "\n\nLista de cadastros:");
		
		for (Pessoa pessoa : pessoas) {
			System.out.println("\n====================================");
			pessoa.imprimeDados();
			System.out.println("====================================");
		}
	}
	
	private void atualizarQtdAtual() {
		qtdAtual = pessoas.size();
	}
	
	private void ordenarLista() {
		pessoas.sort(Comparator.comparing(p -> prioridadeOrdenacao(p)));
	}	
	
	private Integer prioridadeOrdenacao(Pessoa pessoa) {
		if(pessoa instanceof Cliente) {return 0;}
		if(pessoa instanceof Gerente) {return 1;}
		if(pessoa instanceof Funcionario) {return 2;}
		return 3;
	}
}
