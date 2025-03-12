
# Exercício 7 

Considere	 os	 programas	 a	 seguir,	 que	 leem um	 código	 repetidamente	 e	 imprimem o	
código	lido	até	que	o	código	lido	seja	igual	a	-1.	O	código	-1	não	deve	ser	impresso.	

**A.** Qual	das	duas	soluções	é	a	correta?

**B.** Como	a	solução	incorreta	poderia	ser	corrigida?

Programa A
```java
import java.util.Scanner;
    
public class Codigo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int codigo;

        System.out.println("Informe o código: ");
        codigo = teclado.nextInt();
        
        while (codigo != -1) {
            System.out.println("Código: " + codigo);
            System.out.println("Informe o código: ");
            codigo = teclado.nextInt();
        }
    }
}
```
Programa B
```java
import java.util.Scanner;

public class Codigo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int codigo;

        do {
            System.out.print("Informe o código: ");
            codigo = teclado.nextInt();
            System.out.println("Código: " + codigo);
        }while (codigo != -1);
    }  
}
```
## Respostas

A. A solução que satifaz o enunciado da questão é o programa A, pois a sua execução não permite a impressão do número -1. 

B. A solução B está incorreta porque usando o 'do while' o laço de repetição é executado ao menos uma vez, mesmo que a condição para repetição não seja atendida. No código B, a coleta do número é feita somente dentro do laço, enquanto no código A a coleta é feita em dois locais diferentes, um antes do laço, e outro dentro. Caso a primeira coleta não satifaça a condição do while, o número não é impresso. Já no código B, mesmo que não satisfaça, o fluxo do código imprime o número -1.