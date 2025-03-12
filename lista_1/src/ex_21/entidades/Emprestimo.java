package ex_21.entidades;

public class Emprestimo {
	
	private Livro livro;
    private Pessoa pessoa;

    public Emprestimo(Livro livro, Pessoa pessoa) {
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Empréstimo: " + livro.getTitulo() + " para " + pessoa.getNome();
    }
}
