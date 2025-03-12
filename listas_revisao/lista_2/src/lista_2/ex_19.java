package lista_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex_19 {
	public static class RangeOfValuesException extends RuntimeException{

		private static final long serialVersionUID = 1L;
		
		public RangeOfValuesException(String mensagem) {
			super(mensagem);
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Double valor;
		
		try {
			System.out.print("Digite um número real entre 0.00 e 100.00: ");
			valor = sc.nextDouble();
			
			if(valor < 0.00 || valor > 100.00) {
				throw new RangeOfValuesException("\nValor fora do intervalo aceito! Tente novamente.");
			}
			
			System.out.println("Número por extenso: " + conversorPorExtenso(valor));
		} catch(RangeOfValuesException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("\nDígito inválido. tente novamente.");
		} finally {
			sc.close();
		}
	}
	
	public static String conversorPorExtenso(Double valor) {
	    Map<Integer, String> dicionarioNumeros = new HashMap<>();
	    StringBuilder numeroPorExtenso = new StringBuilder();

	    unidades(dicionarioNumeros);
	    dezenas(dicionarioNumeros);
	    centena(dicionarioNumeros);

	    int reais = valor.intValue();
	    int centavos = (int) Math.round((valor - reais) * 100);

	    if (reais == 100) {
	        numeroPorExtenso.append(dicionarioNumeros.get(100)).append(" reais");
	    } else {
	        int dezena = (reais / 10) * 10;
	        int unidade = reais % 10;

	        if (reais >= 11 && reais <= 19) {
	            numeroPorExtenso.append(dicionarioNumeros.get(reais));
	        } else {
	            if (dezena > 0) {
	                numeroPorExtenso.append(dicionarioNumeros.get(dezena));
	                if (unidade > 0) {
	                    numeroPorExtenso.append(" e ");
	                }
	            }
	            if (unidade > 0) {
	                numeroPorExtenso.append(dicionarioNumeros.get(unidade));
	            }
	        }
	        numeroPorExtenso.append(" reais");
	    }

	    if (centavos > 0) {
	        if (numeroPorExtenso.length() > 0) {
	            numeroPorExtenso.append(" e ");
	        }
	        if (centavos >= 11 && centavos <= 19) {
	            numeroPorExtenso.append(dicionarioNumeros.get(centavos)).append(" centavos");
	        } else {
	            int dezenaCentavo = (centavos / 10) * 10;
	            int unidadeCentavo = centavos % 10;
	            if (dezenaCentavo > 0) {
	                numeroPorExtenso.append(dicionarioNumeros.get(dezenaCentavo));
	                if (unidadeCentavo > 0) {
	                    numeroPorExtenso.append(" e ");
	                }
	            }
	            if (unidadeCentavo > 0) {
	                numeroPorExtenso.append(dicionarioNumeros.get(unidadeCentavo));
	            }
	            numeroPorExtenso.append(" centavos");
	        }
	    }
	    return numeroPorExtenso.toString();
	}
	
	private static void unidades(Map<Integer, String> dicionarioNumeros) {
		dicionarioNumeros.put(0, "");
		dicionarioNumeros.put(1, "um");
		dicionarioNumeros.put(2, "dois");
		dicionarioNumeros.put(3, "três");
		dicionarioNumeros.put(4, "quatro");
		dicionarioNumeros.put(5, "cinco");
		dicionarioNumeros.put(6, "seis");
		dicionarioNumeros.put(7, "sete");
		dicionarioNumeros.put(8, "oito");
		dicionarioNumeros.put(9, "nove");
	}
	
	private static void dezenas(Map<Integer, String> dicionarioNumeros) {
		dicionarioNumeros.put(10, "dez");
		dicionarioNumeros.put(20, "vinte");
		dicionarioNumeros.put(30, "trinta");
		dicionarioNumeros.put(40, "quarenta");
		dicionarioNumeros.put(50, "cinquenta");
		dicionarioNumeros.put(60, "sessenta");
		dicionarioNumeros.put(70, "setenta");
		dicionarioNumeros.put(80, "oitenta");
		dicionarioNumeros.put(90, "noventa");
		
		dicionarioNumeros.put(11, "onze");
		dicionarioNumeros.put(12, "doze");
		dicionarioNumeros.put(13, "treze");
		dicionarioNumeros.put(14, "quatorze");
		dicionarioNumeros.put(15, "quinze");
		dicionarioNumeros.put(16, "dezesseis");
		dicionarioNumeros.put(17, "dezessete");
		dicionarioNumeros.put(18, "dezoito");
		dicionarioNumeros.put(19, "dezenove");
	}
	
	private static void centena(Map<Integer, String> conversorPorExtenso) {
		conversorPorExtenso.put(100, "cem");
	}
}
