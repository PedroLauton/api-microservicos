package ex_20.aplicacao;

import ex_20.entidades.Agenda;
import ex_20.entidades.Contato;

public class Programa {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        
        Contato joaoContato = new Contato("João", "1233-1233");
        Contato mariaContato = new Contato("Maria", "1234-1234");

        agenda.adicionarContato(joaoContato);
        agenda.adicionarContato(mariaContato);

        System.out.println("Contatos na agenda:");
        agenda.listarContatos();

        System.out.println("\nBuscando contato 'Maria':");
        Contato contato = agenda.buscarContato("Maria");
        System.out.println(contato != null ? contato : "Contato não encontrado.");
    }
}
