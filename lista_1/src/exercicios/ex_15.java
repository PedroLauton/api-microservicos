package exercicios;

public class ex_15 {
	public static class Avaliacao{
		
		private Double primeiraAvalicao;
		private Double segundaAvalicao;
		private Double mediaAvaliacao;

		public Avaliacao(Double primeiraAvalicao, Double segundaAvalicao) {
			this.primeiraAvalicao = primeiraAvalicao;
			this.segundaAvalicao = segundaAvalicao;
			calculoMedia();
		}

		public Double getPrimeiraAvalicao() {
			return primeiraAvalicao;
		}

		public void setPrimeiraAvalicao(Double primeiraAvalicao) {
			this.primeiraAvalicao = primeiraAvalicao;
		}

		public Double getSegundaAvalicao() {
			return segundaAvalicao;
		}

		public void setSegundaAvalicao(Double segundaAvalicao) {
			this.segundaAvalicao = segundaAvalicao;
		}

		public Double getMediaAvaliacao() {
			return mediaAvaliacao;
		}
		
		public void notificacaoAprovacao() {
			if(mediaAvaliacao < 4) {
				System.out.print("você está reprovado.");
			} else if(mediaAvaliacao >= 4 && mediaAvaliacao < 6) {
				System.out.print("você está de recuperação. Procure pelo professor Robson para realizar o IFA.");
			} else {
				System.out.print("você está aprovado!");
			}
		}
		
		private void calculoMedia() {
			mediaAvaliacao = (primeiraAvalicao + segundaAvalicao) / 2;
		}
	}
	
	public static void main(String args[]) {
		Avaliacao avalicao = new Avaliacao(5.0, 5.7);
		System.out.print("=============== Sistema de média ===============\n\nAluno, ");
		avalicao.notificacaoAprovacao();
	}
}
