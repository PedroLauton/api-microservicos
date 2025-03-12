package entidades;

public class Guiche {

	private Double valorPagoCliente;
	private Double valorTroco;
	
	private Pedido pedido;
		
	public Double getValorPagoCliente() {
		return valorPagoCliente;
	}
	
	public void setValorPagoCliente(Double valorPagoCliente) {
		this.valorPagoCliente = valorPagoCliente;
	}
	
	public Double getValorTroco() {
		return valorTroco;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void calcularTroco() {
		valorTroco = valorPagoCliente - pedido.getValorTotal();
	}
}
