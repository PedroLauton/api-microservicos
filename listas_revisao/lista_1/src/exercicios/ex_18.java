package exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex_18 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Integer numero;
		
		try{
			System.out.print("Digite um número inteiro positivo (até 9 dígitos): ");
			numero = sc.nextInt();
			
			System.out.println("\nNúmero convertido: " + conversorNumeroporExtenso(numero));
		} catch(Exception e) {
        	System.out.println("Dígito inválido. Tente novamente.");
		} finally {
			sc.close();
		}
	}
	
	public static String conversorNumeroporExtenso(Integer numero) {
        Map<Integer, String> dicionarioNumerico = new HashMap<>();
        StringBuilder numeroPorExtenso = new StringBuilder();

        unidades(dicionarioNumerico);
        dezenas(dicionarioNumerico);
        centenas(dicionarioNumerico);

        int centenasMilhoes = numero / 100000000;
        int dezenasMilhoes = (numero % 100000000) / 10000000;
        int unidadesMilhoes = (numero % 10000000) / 1000000;
        
        int centenasMilhares = (numero % 1000000) / 100000;
        int dezenasMilhares = (numero % 100000) / 10000;
        int unidadesMilhares = (numero % 10000) / 1000;
        
        int centenas = (numero % 1000) / 100;
        int dezenas = (numero % 100) / 10;
        int unidades = numero % 10;

        if (centenasMilhoes > 0) {
            numeroPorExtenso.append(dicionarioNumerico.get(centenasMilhoes * 100)).append(" ");
        }
        if (dezenasMilhoes == 1 && unidadesMilhoes > 0) {
            numeroPorExtenso.append(dicionarioNumerico.get(dezenasMilhoes * 10 + unidadesMilhoes)).append(" ");
        } else {
            if (dezenasMilhoes > 0) {
                numeroPorExtenso.append(dicionarioNumerico.get(dezenasMilhoes * 10)).append(" ");
            }
            if (unidadesMilhoes > 0) {
                numeroPorExtenso.append(dicionarioNumerico.get(unidadesMilhoes)).append(" ");
            }
        }
        if (centenasMilhoes > 0 || dezenasMilhoes > 0 || unidadesMilhoes > 0) {
            numeroPorExtenso.append("milhões ");
        }
        
        if (centenasMilhares > 0) {
            numeroPorExtenso.append(dicionarioNumerico.get(centenasMilhares * 100)).append(" ");
        }
        if (dezenasMilhares == 1 && unidadesMilhares > 0) {
            numeroPorExtenso.append(dicionarioNumerico.get(dezenasMilhares * 10 + unidadesMilhares)).append(" ");
        } else {
            if (dezenasMilhares > 0) {
                numeroPorExtenso.append(dicionarioNumerico.get(dezenasMilhares * 10)).append(" ");
            }
            if (unidadesMilhares > 0) {
                numeroPorExtenso.append(dicionarioNumerico.get(unidadesMilhares)).append(" ");
            }
        }
        if (centenasMilhares > 0 || dezenasMilhares > 0 || unidadesMilhares > 0) {
            numeroPorExtenso.append("mil ");
        }
        
        if (centenas > 0) {
            numeroPorExtenso.append(dicionarioNumerico.get(centenas * 100)).append(" ");
        }
        if (dezenas == 1 && unidades > 0) {
            numeroPorExtenso.append(dicionarioNumerico.get(dezenas * 10 + unidades)).append(" ");
        } else {
            if (dezenas > 0) {
                numeroPorExtenso.append(dicionarioNumerico.get(dezenas * 10)).append(" ");
            }
            if (unidades > 0) {
                numeroPorExtenso.append(dicionarioNumerico.get(unidades)).append(" ");
            }
        }
        
        return numeroPorExtenso.toString().trim();
    }
	
	private static void unidades(Map<Integer, String> dicionarioNumerico) {
		dicionarioNumerico.put(0, "zero");
		dicionarioNumerico.put(1, "um");
		dicionarioNumerico.put(2, "dois");
		dicionarioNumerico.put(3, "três");
		dicionarioNumerico.put(4, "quatro");
		dicionarioNumerico.put(5, "cinco");
		dicionarioNumerico.put(6, "seis");
		dicionarioNumerico.put(7, "sete");
		dicionarioNumerico.put(8, "oito");
		dicionarioNumerico.put(9, "nove");
	}
	
	private static void dezenas(Map<Integer, String> dicionarioNumerico) {
		dicionarioNumerico.put(10, "dez");
		dicionarioNumerico.put(20, "vinte");
		dicionarioNumerico.put(30, "trinta");
		dicionarioNumerico.put(40, "quarenta");
		dicionarioNumerico.put(50, "cinquenta");
		dicionarioNumerico.put(60, "sessenta");
		dicionarioNumerico.put(70, "setenta");
		dicionarioNumerico.put(80, "oitenta");
		dicionarioNumerico.put(90, "noventa");
		
		dicionarioNumerico.put(11, "onze");
		dicionarioNumerico.put(12, "doze");
		dicionarioNumerico.put(13, "treze");
		dicionarioNumerico.put(14, "quatorze");
		dicionarioNumerico.put(15, "quinze");
		dicionarioNumerico.put(16, "dezesseis");
		dicionarioNumerico.put(17, "dezessete");
		dicionarioNumerico.put(18, "dezoito");
		dicionarioNumerico.put(19, "dezenove");
	}
	
	private static void centenas(Map<Integer, String> dicionarioNumerico) {
	    dicionarioNumerico.put(100, "cem");
	    dicionarioNumerico.put(200, "duzentos");
	    dicionarioNumerico.put(300, "trezentos");
	    dicionarioNumerico.put(400, "quatrocentos");
	    dicionarioNumerico.put(500, "quinhentos");
	    dicionarioNumerico.put(600, "seicentos");
	    dicionarioNumerico.put(700, "setecentos");
	    dicionarioNumerico.put(800, "oitocentos");
	    dicionarioNumerico.put(900, "novecentos");
	}
}
