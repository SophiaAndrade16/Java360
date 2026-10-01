package br.com.romulo.curso.arquivo;

public class Algoritmo51 {

    public static void main(String[] args) {

        try {

            IO.print("Entre com o número: ");
            int numero = Integer.parseInt(IO.readln());

            IO.print("Entre com o divisor: ");
            int divisor = Integer.parseInt(IO.readln());

            int resultado = numero / divisor;

            IO.println("Resultado: " + resultado);

        } catch (ArithmeticException e) {

            IO.println("não é possível dividir um número por zero.");

        } finally {

            IO.println("Obrigado por usar a calculadora! ");
        }
    }
}


