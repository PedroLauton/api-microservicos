package entidades;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Prato {
	
	private LocalDate dataValidade;
	
	protected Double precoVenda;
	protected Integer peso;
	
	public Double getPrecoVenda() {
		return precoVenda;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade() {
		dataValidade = LocalDate.now().plusDays(1);
	}

	public Integer getPeso() {
		return peso;
	}

	public abstract void calcularPreco();
	public abstract void calcularPeso();
	public abstract void montarPrato(Scanner sc);
}
