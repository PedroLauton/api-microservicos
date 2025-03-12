package entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private String nomeCliente;
	private Double taxaServico;
	private Double valorTotal;
	
	private List<Prato> itensConsumidos = new ArrayList<>();
	
	public Pedido() {
		valorTotal = 0.0;
	}
	
	public Pedido(String nomeCliente, Double taxaServico, Double valorTotal) {
		this.nomeCliente = nomeCliente;
		this.taxaServico = taxaServico;
		this.valorTotal = valorTotal;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(Double taxaServico) {
		this.taxaServico = taxaServico;
	}

	public List<Prato> getItensConsumidos() {
		return itensConsumidos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void addItensConsumidos(Prato prato) {
		itensConsumidos.add(prato);
	}
	
	public void calcularTotal() {
		for (Prato prato : itensConsumidos) {
			valorTotal += prato.getPrecoVenda();
		}
	}
	
	public void gerarNotaFiscal() {
		System.out.println("========================================================");
		System.out.println("\nNome do Cliente: " + nomeCliente);
		System.out.println("\nItens pedidos:");
		for (Prato prato : itensConsumidos) {
			System.out.println(prato);
		}
		System.out.println("\nValor total do pedido: " + valorTotal);
		System.out.println("========================================================");
	}
}
