public class Algoritmo47 {

    public void main(){

        double[] valores = new double[10];
        double soma = 0;

        // Lê os 10 valores
        for(int i = 0; i < valores.length; i++){

            valores[i] = Integer.parseInt(
                IO.readln("Digite o número: ")
            );

            soma = soma + valores[i];
        }

        // Calcula a média
        double media = soma / valores.length;

        // Imprime os valores
        for(int i = 0; i < valores.length; i++){
            IO.println("Valor: " + valores[i]);
        }

        IO.println("Soma: " + soma);
        IO.println("Média: " + media);
    }
}