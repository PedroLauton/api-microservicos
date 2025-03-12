package aplicação;

import java.util.InputMismatchException;

import entidades.Lanche;
import entidades.Pizza;
import entidades.Salgadinho;
import entidades.Prato;

public class Processamento {
	
	public Prato escolherPrato(Integer escolha) {
	    switch(escolha) {
	        case 1: return new Pizza();
	        case 2: return new Salgadinho();
	        case 3: return new Lanche();
	        case 4: break;
	        default: throw new InputMismatchException("Prato inválido.");
	    }
	    return null;
	}
	
}
