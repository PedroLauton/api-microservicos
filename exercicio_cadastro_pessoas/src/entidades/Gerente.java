package entidades;

public class Gerente extends Funcionario{
	
	private String area;
	
	public Gerente(String nome, Data nascimento, Double salario, String area) {
		super(nome, nascimento, salario);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public Double calculaImpostos() {
		return (super.getSalario() / 100) * 5;
	}

	
	@Override
	public void imprimeDados() {
		String dados = """
				Gerente
				
				Nome: %s
				Data de nascimento: %s
				Salário: %.2f
				Área: %s
				
				Imposto sobre o salário: %.2f""".formatted(nome, nascimento.toString(), super.getSalario(), area, calculaImpostos());
		
		System.out.println(dados);
	}
}
