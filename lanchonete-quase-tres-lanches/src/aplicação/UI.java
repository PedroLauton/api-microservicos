package aplicação;

public class UI {
	
	public static void menuLanchonete() {
		String menu = """
				
				================== Quase Três Lanches ==================
									 
				Menu de Pedidos
									 
				Qual será o pedido?
								   
				1 - Pizza;
				2 - Salgadinho;
				3 - Lanche;
				
				4 - Fechar o sistema.
								   
				lembre-se, cliente feliz faz o pix!
							
				========================================================
				
				Escolha:  """;
		System.out.print(menu);
	}
	
	public static void nomeCliente() {
		String nome = """
				========================================================
				
				Primeiramente, qual o nome do cliente?
				
				Resposta: """;
		System.out.print(nome);
	}
	
	public static void menuMontagemMolho() {
		String menuMontagem = """
				
				========================================================

				Molho
				
				Qual será o molho?
								   
				1 - Tomate;
				2 - Barbecue;
				3 - Branco;
				4 - Tasty;
				5 - Rosé.
								   							
				========================================================
				
				Escolha:  """;
		System.out.print(menuMontagem);
	}
	
	public static void menuMontagemRecheio() {
		String menuMontagem = """
				
				========================================================

				Recheio
				
				Qual será o recheio?
								   
				1 - Brócolis;
				2 - Carne;
				3 - Queijo;
				4 - Frango;
				5 - Camarão.
								   							
				========================================================
				
				Escolha:  """;
		System.out.print(menuMontagem);
	}
	
	public static void menuMontagemBorda() {
		String menuMontagem = """
				
				========================================================

				Borda
				
				Qual será a Borda?
								   
				1 - Catupiry;
				2 - Cheedar;
				3 - Molho especial;
				4 - normal.
								   							
				========================================================
				
				Escolha:  """;
		System.out.print(menuMontagem);
	}
	
	public static void menuMontagemMassa() {
		String menuMontagem = """
				
				========================================================

				Massa
				
				Qual será a massa?
								   
				1 - Frita;
				2 - Assada;
								   							
				========================================================
				
				Escolha:  """;
		System.out.print(menuMontagem);
	}
	
	public static void menuMontagemPao() {
		String menuMontagem = """
				
				========================================================

				Pão
				
				Qual será a pão?
								   
				1 - Australiano;
				2 - Baguete;
				3 - Brioche.
								   							
				========================================================
				
				Escolha:  """;
		System.out.print(menuMontagem);
	}
	
	public static void desejaContinuar() {
		String mensagem = """
				
				========================================================
				
				Adicionar mais um prato?
				
				1 - Sim
				2 - Não
				
				========================================================
				
				Escolha: """;
		System.out.print(mensagem);
	}
	
	public static void menuPagamento() {
		String menuMontagem = """
				
				========================================================

				Pagamento 
				
				Qual será a forma de pagamento?
								   
				1 - Cartão;
				2 - Dinheiro;
								   							
				========================================================
				
				Escolha:  """;
		System.out.print(menuMontagem);
	}
	
	public static void limparTela() {

	}
}
