package entidades;

import java.util.Scanner;

import aplicação.UI;
import enuns.TiposBorda;
import enuns.TiposMolho;
import enuns.TiposPao;
import enuns.TiposRecheio;

public class Lanche extends Prato{
	
	private TiposPao pao;
	private TiposRecheio recheio;
	private TiposMolho molho;
	
	public Lanche() {
	}
	
	public Lanche(TiposPao pao, TiposRecheio recheio, TiposMolho molho) {
		this.pao = pao;
		this.recheio = recheio;
		this.molho = molho;
	}

	public TiposPao getPao() {
		return pao;
	}

	public void setPao(TiposPao pao) {
		this.pao = pao;
	}

	public TiposRecheio getRecheio() {
		return recheio;
	}

	public void setRecheio(TiposRecheio recheio) {
		this.recheio = recheio;
	}

	public TiposMolho getMolho() {
		return molho;
	}

	public void setMolho(TiposMolho molho) {
		this.molho = molho;
	}

	@Override
	public void calcularPreco() {
		precoVenda = pao.getValor() + recheio.getValor() + molho.getValor();
	}
	
	@Override
	public void calcularPeso() {
		peso = pao.getPeso() + recheio.getPeso() + molho.getPeso();
	}

	@Override
	public void montarPrato(Scanner sc) {
		UI.menuMontagemPao();
		escolhaPao(sc.nextInt());
		
		UI.menuMontagemRecheio();
		escolhaRecheio(sc.nextInt());
		
		UI.menuMontagemMolho();
		escolhaMolho(sc.nextInt());	
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
	
	private void escolhaPao(Integer escolha) {
		switch(escolha){
			case 1: setPao(TiposPao.AUSTRALIANO); break;
			case 2: setPao(TiposPao.BAGUETE); break;
			case 3: setPao(TiposPao.BRIOCHE); break;
			default: setMolho(null); break;
		}
	}
	
	@Override
	public String toString() {
		return "Lanche de " + recheio.getNomeReal() + " com molho " + molho.getNomeReal() + " e pão " + pao.getNomeReal() + "................... 1x " + precoVenda;
	}
}
