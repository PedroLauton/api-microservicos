package entidades;

import java.util.Scanner;

import aplicação.UI;
import enuns.TiposMassa;
import enuns.TiposMolho;
import enuns.TiposRecheio;

public class Salgadinho extends Prato{

	private TiposRecheio recheio;
	private TiposMassa massa;
	
	public Salgadinho() {
	}
	
	public Salgadinho(TiposRecheio recheio, TiposMassa massa) {
		this.recheio = recheio;
		this.massa = massa;
	}

	public TiposRecheio getRecheio() {
		return recheio;
	}

	public void setRecheio(TiposRecheio recheio) {
		this.recheio = recheio;
	}

	public TiposMassa getMassa() {
		return massa;
	}

	public void setMassa(TiposMassa massa) {
		this.massa = massa;
	}

	@Override
	public void calcularPreco() {
		precoVenda = recheio.getValor() + massa.getValor();
	}
	
	@Override
	public void calcularPeso() {
		peso = recheio.getPeso() + massa.getPeso();
	}

	@Override
	public void montarPrato(Scanner sc) {
		UI.menuMontagemRecheio();
		escolhaRecheio(sc.nextInt());
		
		UI.menuMontagemMassa();
		escolhaMassa(sc.nextInt());	
	}
	
	private void escolhaMassa(Integer escolha) {
		switch(escolha){
			case 1: setMassa(TiposMassa.ASSADA); break;
			case 2: setMassa(TiposMassa.FRITA); break;
			default: setMassa(null); break;
		}
	}
	
	private void escolhaRecheio(Integer escolha) {
		switch(escolha){
			case 1: setRecheio(TiposRecheio.BROCOLIS); break;
			case 2: setRecheio(TiposRecheio.CARNE); break;
			case 3: setRecheio(TiposRecheio.QUEIJO); break;
			case 4: setRecheio(TiposRecheio.FRANGO); break;
			case 5: setRecheio(TiposRecheio.CAMARAO); break;
			default: setRecheio(null); break;
		}
	}

	@Override
	public String toString() {
		return "Salgadinho de " + recheio.getNomeReal() + " com Massa " + massa.getNomeReal() + "................... 1x " + precoVenda;
	}
}
