package entidades;

public class Cliente extends Pessoa{
	
	private Integer codigo;

	public Cliente(String nome, Data nascimento, Integer codigo) {
		super(nome, nascimento);
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Override 
	public void imprimeDados() {
		String dados = """
				Cliente
				
				Nome: %s
				Data de nascimento: %s
				Código: %d""".formatted(nome, nascimento.toString(), codigo);
		
		System.out.println(dados);
	}
}
