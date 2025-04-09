package br.ifsp.contacts.dto.contact;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactPatchDTO {
    private Optional<String> nome = Optional.empty();
    private Optional<String> email = Optional.empty();
    private Optional<String> telefone = Optional.empty();
	
    public ContactPatchDTO() {
	}
    
    public Optional<String> getNome() {
		return nome;
	}
    
	public void setNome(Optional<String> nome) {
		this.nome = nome;
	}
	
	public Optional<String> getEmail() {
		return email;
	}
	
	public void setEmail(Optional<String> email) {
		this.email = email;
	}
	
	public Optional<String> getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Optional<String> telefone) {
		this.telefone = telefone;
	}
}

