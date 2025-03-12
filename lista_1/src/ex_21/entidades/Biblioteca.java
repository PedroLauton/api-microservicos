package ex_21.entidades;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Livro> livros;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void emprestarLivro(String titulo, Pessoa pessoa) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && !livro.isEmprestado()) {
                livro.emprestar();
                emprestimos.add(new Emprestimo(livro, pessoa));
                System.out.println("Livro emprestado com sucesso.");
                return;
            }
        }
        System.out.println("Livro não disponível para empréstimo.");
    }

    public void listarEmprestimos() {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }
}
