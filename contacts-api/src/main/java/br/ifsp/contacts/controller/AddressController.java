package br.ifsp.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.repository.AddressRepository;
import br.ifsp.contacts.repository.ContactRepository;

@RestController
@RequestMapping("/api/contacts/{id}/addresses")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	/*
	 * Para validar a existência do contato, é necessário utilizar
	 * o 'contactRepository' para apenas validar o id, sem manipular
	 * o objeto Contact.
	 */
	@Autowired
	private ContactRepository contactRepository;
	
	/*
	 * @PathVariable capta o id enviado na URL e transforma no parâmetro do método.
	 */
	@GetMapping
	public List<Address> getAddressByContacts(@PathVariable Long id){
		
		contactRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
		
		List<Address> addresses = addressRepository.findByContactId(id);
		
		return addresses;
	}
	
	/*
	 * @RequestBody capta o Json enviado no corpo da requisição e popula a classe 'addreess'
	 * com os respectivos valores das chaves Json. É importante salientar que os atributos da classe
	 * e chaves do Json devem ter o mesmo nome para que o relacionamento aconteça, além da classe 
	 * ter os getters e setters de cada atributo. 
	 */
	@PostMapping
	public Address getAddressByContacts(@PathVariable Long id, @RequestBody Address address){
		
		contactRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
		
		// Salva o Id do contato no Address
		address.setContactId(id);
		
		// Salva no repositório o  novo Address
		return addressRepository.save(address);
	}
}
