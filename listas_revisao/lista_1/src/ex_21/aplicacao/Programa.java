package ex_21.aplicacao;

import ex_21.entidades.Biblioteca;
import ex_21.entidades.Livro;
import ex_21.entidades.Pessoa;

public class Programa {
	public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Livro primeiroLivro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien");
        Livro segundoLivro = new Livro("1984", "George Orwell");
        
        biblioteca.adicionarLivro(primeiroLivro);
        biblioteca.adicionarLivro(segundoLivro);
        
        Pessoa pessoa = new Pessoa("João");
        biblioteca.emprestarLivro("1984", pessoa);
        
        System.out.println("\nLista de livros:");
        biblioteca.listarLivros();
        
        System.out.println("\nLista de empréstimos:");
        biblioteca.listarEmprestimos();
    }
}
