package br.ifsp.contacts.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.contacts.dto.contact.ContactPatchDTO;
import br.ifsp.contacts.dto.contact.ContactRequestDTO;
import br.ifsp.contacts.dto.contact.ContactResponseDTO;
import br.ifsp.contacts.exception.ResourceNotFoundException;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.ContactRepository;
import jakarta.validation.Valid;

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
    
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Método para obter todos os contatos.
     * 
     * @GetMapping indica que este método vai responder a chamadas HTTP GET.
     * Exemplo de acesso: GET /api/contacts
     */
    @GetMapping
	@ResponseStatus(HttpStatus.OK)
    public Page<ContactResponseDTO> getAllContacts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nome") String sort) {
        
    	// Constrói o objeto pageable com os parâmetros fornecidos. 
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Contact> contacts = contactRepository.findAll(pageable);
        return contacts.map(contact -> modelMapper.map(contact, ContactResponseDTO.class));
    }
    

    /**
     * Método para obter um contato específico pelo seu ID.
     * 
     * @PathVariable "amarra" a variável {id} da URL 
     * ao parâmetro do método.
     * Exemplo de acesso: GET /api/contacts/1
     */
    @GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public ContactResponseDTO getContactById(@PathVariable Long id) {
        // findById retorna um Optional, então usamos orElseThrow
        Contact contact =  contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível encontrar o contato com o ID fornecido: " + id));
        
        return modelMapper.map(contact, ContactResponseDTO.class);
    }
    
    /**
     * Método para obter um contato específico pelo nome.
     * 
     * @RequestParam capta os parâmetros da consulta e 'amarra'
     * ao parâmetro do método.
     * Exemplo de acesso: GET /api/contacts/search?nome=Maria
     */
    @GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
    public Page<ContactResponseDTO> getContactByNome(@RequestParam String nome, Pageable pageable){
    	return contactRepository.findByNomeContainingIgnoreCase(nome, pageable)
    			.map(contact -> modelMapper.map(contact, ContactResponseDTO.class));
    }

    /**
     * Método para criar um novo contato.
     * 
     * @PostMapping indica que este método responde a chamadas HTTP POST.
     * @RequestBody indica que o objeto Contact será preenchido 
     * com os dados JSON enviados no corpo da requisição.
     */
    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public ContactResponseDTO createContact(@RequestBody @Valid ContactRequestDTO contactDTO) {
    	System.out.println(contactDTO.getNome());
    	Contact contact = modelMapper.map(contactDTO, Contact.class);
        return modelMapper.map(contactRepository.save(contact), ContactResponseDTO.class);
    }

    /**
     * Método para atualizar um contato existente.
     * 
     * @PutMapping indica que este método responde a chamadas HTTP PUT.
     * Exemplo de acesso: PUT /api/contacts/1
     */
    @PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public ContactResponseDTO updateContact(@PathVariable Long id, @RequestBody @Valid ContactRequestDTO contactDTO) {
        // Buscar o contato existente
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível encontrar o contato com o ID fornecido: " + id));
        
        Contact resquestContact = modelMapper.map(contactDTO, Contact.class);
        
        // Atualizar os campos
        existingContact.setNome(resquestContact.getNome());
        existingContact.setTelefone(resquestContact.getTelefone());
        existingContact.setEmail(resquestContact.getEmail());

        // Salvar alterações
        return modelMapper.map(contactRepository.save(existingContact), ContactResponseDTO.class);
    }
    
    /**
     * Método para atualizar alguns campos de um contato existente.
     * 
     * @PatchMapping indica que este método responde a chamadas HTTP Patch.
     * Exemplo de acesso: Patch /api/contacts/1
     */
    @PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public ContactResponseDTO updateSomeFields(@PathVariable Long id, @RequestBody ContactPatchDTO contactDTO) {
    	//Caso não encontre um contato, retorna ero e o código HTTP 404.
    	Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível encontrar o contato com o ID fornecido: " + id));
    	
    	Contact resquestContact = modelMapper.map(contactDTO, Contact.class);
    	
    	//Se o atributo for diferente de nulo, ele atualiza o contato existente.
    	if(resquestContact.getEmail() != null) {
    		existingContact.setEmail(resquestContact.getEmail());
    	}
    	if(resquestContact.getNome() != null) {
    		existingContact.setNome(resquestContact.getNome());
    	}
    	if(resquestContact.getTelefone() != null) {
    		existingContact.setTelefone(resquestContact.getTelefone());
    	}
    	
        return modelMapper.map(contactRepository.save(existingContact), ContactResponseDTO.class);
    }


    /**
     * Método para excluir um contato pelo ID.
     * 
     * @DeleteMapping indica que este método responde a chamadas HTTP DELETE.
     * Exemplo de acesso: DELETE /api/contacts/1
     */
    @DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id) {
    	contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível encontrar o contato com o ID fornecido: " + id));
    	
        contactRepository.deleteById(id);
    }
}