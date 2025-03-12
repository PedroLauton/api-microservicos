package exercicios;

import java.util.Scanner;

public class ex_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
        	System.out.print("Digite um número inteiro: ");
            int numero = sc.nextInt();
            
            System.out.print("Digite o erro máximo permitido: ");
            double erroMaximo = sc.nextDouble();
            
            double raiz = calcularRaizQuadrada(numero, erroMaximo);
            System.out.println("Raiz quadrada aproximada: " + raiz);
        } catch(Exception e) {
        	System.out.println("Dígito inválido. Tente novamente.");
        } finally {
            sc.close();
        }
    }
    
    public static double calcularRaizQuadrada(int numero, double erroMaximo) {
        double estimativa = numero / 2.0;
        while (Math.abs(estimativa * estimativa - numero) > erroMaximo) {
            estimativa = (estimativa + numero / estimativa) / 2.0;
        }
        return estimativa;
    }
}
