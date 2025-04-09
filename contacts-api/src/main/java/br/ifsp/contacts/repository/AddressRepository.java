package br.ifsp.contacts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
	// List<Address> findByContact(Contact contact); <- Método original, antes de implementar a paginação.
	
	Page<Address> findByContact(Contact contact, Pageable pageable);
}
