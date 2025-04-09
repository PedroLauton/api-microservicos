package br.ifsp.contacts.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.contacts.dto.address.AddressRequestDTO;
import br.ifsp.contacts.dto.address.AddressResponseDTO;
import br.ifsp.contacts.exception.ResourceNotFoundException;
import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.AddressRepository;
import br.ifsp.contacts.repository.ContactRepository;

@RestController
@RequestMapping("/api/contacts")
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
	
	@Autowired
    private ModelMapper modelMapper;
	/*
	 * @PathVariable capta o id enviado na URL e transforma no parâmetro do método.
	 */
	@GetMapping("/{id}/addresses")
	@ResponseStatus(HttpStatus.OK)
	public Page<AddressResponseDTO> getAddressByContacts(@PathVariable Long id, Pageable pageable){
		Contact contact = contactRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Não foi possível encontrar o contato com o ID fornecido: " + id));
		
		return addressRepository.findByContact(contact, pageable)
				.map(address -> modelMapper.map(address, AddressResponseDTO.class));
	}
	
	/*
	 * @RequestBody capta o Json enviado no corpo da requisição e popula a classe 'addreess'
	 * com os respectivos valores das chaves Json. É importante salientar que os atributos da classe
	 * e chaves do Json devem ter o mesmo nome para que o relacionamento aconteça, além da classe 
	 * ter os getters e setters de cada atributo. 
	 */
	@PostMapping("/{id}/addresses")
	@ResponseStatus(HttpStatus.CREATED)
	public AddressResponseDTO getAddressByContacts(@PathVariable Long id, @RequestBody AddressRequestDTO addressDTO){
		
		Contact contact = contactRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Não foi possível encontrar o contato com o ID fornecido: " + id));
		
		//Transforma o DTO para a entidade Address
		Address address = modelMapper.map(addressDTO, Address.class);
		
		// Salva o Id do contato no Address
		address.setContact(contact);
		
		// Salva no repositório o  novo Address
		return modelMapper.map(addressRepository.save(address), AddressResponseDTO.class);
	}
}
