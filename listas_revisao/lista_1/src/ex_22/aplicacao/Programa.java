package ex_22.aplicacao;

import ex_22.entidades.Pessoa;

public class Programa {
	public static void main(String[] args) {
        Pessoa avoPaterno = new Pessoa("Carlos", 80, null, null);
        Pessoa avoMaterno = new Pessoa("Maria", 78, null, null);
        Pessoa pai = new Pessoa("João", 50, avoPaterno, null);
        Pessoa mae = new Pessoa("Ana", 48, null, avoMaterno);
        Pessoa filho = new Pessoa("Pedro", 25, pai, mae);

        filho.exibirArvoreGenealogica();
    }
}
