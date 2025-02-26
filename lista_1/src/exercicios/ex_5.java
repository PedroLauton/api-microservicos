package exercicios;

public class ex_5 {
	public static void main(String args[]) {
		System.out.println("Tabela de multiplicação\n");
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 11; j++) {
				System.out.println(i + " x " + j + " = " + (i*j));
			}
			System.out.println("\n");
		}
	}
}
