package entidades;

public class Funcionario extends Pessoa{

	private Double salario;

	public Funcionario(String nome, Data nascimento, Double salario) {
		super(nome, nascimento);
		this.salario = salario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double calculaImpostos() {
		return (salario / 100) * 3;
	}
	
	@Override
	public void imprimeDados() {
		String dados = """
				Funcionário
				
				Nome: %s
				Data de nascimento: %s
				Salário: %.2f
				
				Imposto sobre o salário: %.2f""".formatted(nome, nascimento.toString(), salario, calculaImpostos());
		
		System.out.println(dados);		
	}
}
