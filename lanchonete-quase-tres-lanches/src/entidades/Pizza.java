package entidades;

import java.util.Scanner;

import aplicação.UI;
import enuns.TiposBorda;
import enuns.TiposMolho;
import enuns.TiposRecheio;

public class Pizza extends Prato{
	
	private TiposMolho molho;
	private TiposRecheio recheio;
	private TiposBorda borda;
	
	public Pizza() {
	}
	
	public Pizza(TiposMolho molho, TiposRecheio recheio, TiposBorda borda) {
		this.molho = molho;
		this.recheio = recheio;
		this.borda = borda;
	}

	public TiposMolho getMolho() {
		return molho;
	}
	
	public void setMolho(TiposMolho molho) {
		this.molho = molho;
	}

	public TiposRecheio getRecheio() {
		return recheio;
	}

	public void setRecheio(TiposRecheio recheio) {
		this.recheio = recheio;
	}

	public TiposBorda getBorda() {
		return borda;
	}

	public void setBorda(TiposBorda borda) {
		this.borda = borda;
	}

	@Override
	public void calcularPreco() {
		precoVenda = molho.getValor() + recheio.getValor() + borda.getValor();
	}
	
	@Override
	public void calcularPeso() {
		peso = molho.getPeso() + recheio.getPeso() + borda.getPeso();
	}

	@Override
	public void montarPrato(Scanner sc) {
		UI.menuMontagemMolho();
		escolhaMolho(sc.nextInt());
		
		UI.menuMontagemRecheio();
		escolhaRecheio(sc.nextInt());
		
		UI.menuMontagemBorda();
		escolhaBorda(sc.nextInt());
	}
	
	private void escolhaMolho(Integer escolha) {
		switch(escolha){
			case 1: setMolho(TiposMolho.TOMATE); break;
			case 2: setMolho(TiposMolho.BARBECUE); break;
			case 3: setMolho(TiposMolho.TASTY); break;
			case 4: setMolho(TiposMolho.ROSE); break;
			default: setMolho(null); break;
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
	
	private void escolhaBorda(Integer escolha) {
		switch(escolha){
			case 1: setBorda(TiposBorda.CATUPIRY); break;
			case 2: setBorda(TiposBorda.CHEEDAR); break;
			case 3: setBorda(TiposBorda.MOLHO_ESPECIAL); break;
			case 4: setBorda(TiposBorda.NORMAL); break;
			default: setMolho(null); break;
		}
	}
	
	@Override
	public String toString() {
		return "Pizza de " + recheio.getNomeReal() + " com molho " + molho.getNomeReal() + " e borda " + borda.getNomeReal() + "................... 1x " + precoVenda;
	}
}
