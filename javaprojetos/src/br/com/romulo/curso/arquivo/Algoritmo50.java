
package br.com.romulo.curso.arquivo;
public class Algoritmo50 {
    void main(){
        try {
            int idade = Integer.parseInt(IO.readln("Qual a sua idade?"));
            String resultado = (idade >= 18) ? "Maior" : "Menor";
            IO.print(resultado);
        }
        
        catch (NumberFormatException e) {
        IO.println("valor inválido.digite um número!");
        }
        finally{

        IO.println("😉-Encerrado SystemSys");

        }
    }
    
}
