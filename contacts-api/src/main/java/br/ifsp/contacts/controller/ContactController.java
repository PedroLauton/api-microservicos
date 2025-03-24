package br.ifsp.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.ContactRepository;

/**
 * Classe responsável por mapear as rotas/endpoints relacionados
 * aos contatos. Cada método abaixo corresponde a uma operação
 * em nosso sistema.
 * 
 * @RestController: Indica que esta classe é um controlador 
 *                  responsável por responder requisições REST.
 * @RequestMapping("/api/contacts"): Indica o caminho base.
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    /**
     * @Autowired permite que o Spring "injete" automaticamente
     * uma instância de ContactRepository aqui, 
     * sem que precisemos criar manualmente.
     */
    @Autowired
    private ContactRepository contactRepository;

    /**
     * Método para obter todos os contatos.
     * 
     * @GetMapping indica que este método vai responder a chamadas HTTP GET.
     * Exemplo de acesso: GET /api/contacts
     */
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    /**
     * Método para obter um contato específico pelo seu ID.
     * 
     * @PathVariable "amarra" a variável {id} da URL 
     * ao parâmetro do método.
     * Exemplo de acesso: GET /api/contacts/1
     */
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        // findById retorna um Optional, então usamos orElseThrow
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));
    }
    
    /**
     * Método para obter um contato específico pelo nome.
     * 
     * @RequestParam capta os parâmetros da consulta e 'amarra'
     * ao parâmetro do método.
     * Exemplo de acesso: GET /api/contacts/search?nome=Maria
     */
    @GetMapping("/search")
    public List<Contact> getContactByNome(@RequestParam String nome){
    	return contactRepository.findByNomeContainingIgnoreCase(nome);
    }

    /**
     * Método para criar um novo contato.
     * 
     * @PostMapping indica que este método responde a chamadas HTTP POST.
     * @RequestBody indica que o objeto Contact será preenchido 
     * com os dados JSON enviados no corpo da requisição.
     */
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    /**
     * Método para atualizar um contato existente.
     * 
     * @PutMapping indica que este método responde a chamadas HTTP PUT.
     * Exemplo de acesso: PUT /api/contacts/1
     */
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        // Buscar o contato existente
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));

        // Atualizar os campos
        existingContact.setNome(updatedContact.getNome());
        existingContact.setTelefone(updatedContact.getTelefone());
        existingContact.setEmail(updatedContact.getEmail());

        // Salvar alterações
        return contactRepository.save(existingContact);
    }
    
    /**
     * Método para atualizar alguns campos de um contato existente.
     * 
     * @PatchMapping indica que este método responde a chamadas HTTP Patch.
     * Exemplo de acesso: Patch /api/contacts/1
     */
    @PatchMapping("/{id}")
    public Contact updateSomeFields(@PathVariable Long id, @RequestBody Contact contactUpdate) {
    	//Caso não encontre um contato, retorna ero e o código HTTP 404.
    	Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
    	
    	//Se o atributo for diferente de nulo, ele atualiza o contato existente.
    	if(contactUpdate.getEmail() != null) {
    		existingContact.setEmail(contactUpdate.getEmail());
    	}
    	if(contactUpdate.getNome() != null) {
    		existingContact.setNome(contactUpdate.getNome());
    	}
    	if(contactUpdate.getTelefone() != null) {
    		existingContact.setTelefone(contactUpdate.getTelefone());
    	}
    	
    	return contactRepository.save(existingContact);
    }


    /**
     * Método para excluir um contato pelo ID.
     * 
     * @DeleteMapping indica que este método responde a chamadas HTTP DELETE.
     * Exemplo de acesso: DELETE /api/contacts/1
     */
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }
}