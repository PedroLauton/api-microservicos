package exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex_17 {
	public static class NumbeOutOfRangeException extends RuntimeException{

		private static final long serialVersionUID = 1L;
		
		public NumbeOutOfRangeException(String mensagem) {
			super(mensagem);
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Integer numeroEntrada = 0;
		
		try {
			System.out.print("Digite um número inteiro positivo (até 3 dígitos): ");
			numeroEntrada = sc.nextInt();
			
			if(numeroEntrada < 1 || numeroEntrada > 999){
				throw new NumbeOutOfRangeException("Dígito fora do intervalo aceito. Tente novamente.");
			}
			
			System.out.println("\nNúmero convertido: " + conversorRomano(numeroEntrada));
		} catch(NumbeOutOfRangeException e) {
        	System.out.println(e.getMessage());
		} catch(Exception e) {
        	System.out.println("Dígito inválido. Tente novamente.");
		} finally {
			sc.close();
		}		
	}
	
	public static String conversorRomano(Integer numero) {
		Map<Integer, String> dicionarioRomano = new HashMap<>();
		
		unidadesRomanas(dicionarioRomano);
		dezenasRomanas(dicionarioRomano);
		centenasRomanas(dicionarioRomano);
		
		return dicionarioRomano.get(centena(numero)) + dicionarioRomano.get(dezena(numero)) + dicionarioRomano.get(unidade(numero));
	}
	
	public static Integer unidade(Integer numero) {
		return numero % 10;
	}
	
	public static Integer dezena(Integer numero) {
		return ((numero / 10) % 10) * 10;
	}
	
	public static Integer centena(Integer numero) {
		return (numero / 100) * 100;
	}
	
	private static void unidadesRomanas(Map<Integer, String> dicionarioRomano) {
		dicionarioRomano.put(0, "");
		dicionarioRomano.put(1, "I");
		dicionarioRomano.put(2, "II");
		dicionarioRomano.put(3, "III");
		dicionarioRomano.put(4, "IV");
		dicionarioRomano.put(5, "V");
		dicionarioRomano.put(6, "VI");
		dicionarioRomano.put(7, "VII");
		dicionarioRomano.put(8, "VIII");
		dicionarioRomano.put(9, "IX");
	}
	
	private static void dezenasRomanas(Map<Integer, String> dicionarioRomano) {
		dicionarioRomano.put(10, "X");
		dicionarioRomano.put(20, "XX");
		dicionarioRomano.put(30, "XXX");
		dicionarioRomano.put(40, "XL");
		dicionarioRomano.put(50, "L");
		dicionarioRomano.put(60, "LX");
		dicionarioRomano.put(70, "LXX");
		dicionarioRomano.put(80, "LXXX");
		dicionarioRomano.put(90, "XC");
	}
	
	private static void centenasRomanas(Map<Integer, String> dicionarioRomano) {
		dicionarioRomano.put(100, "C");
		dicionarioRomano.put(200, "CC");
		dicionarioRomano.put(300, "CCC");
		dicionarioRomano.put(400, "CD");
		dicionarioRomano.put(500, "D");
		dicionarioRomano.put(600, "DC");
		dicionarioRomano.put(700, "DCC");
		dicionarioRomano.put(800, "DCCCC");
		dicionarioRomano.put(900, "CM");
	}
}
