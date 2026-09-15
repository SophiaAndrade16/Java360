

public class Algoritmo13 {
   

    public void main(){
        int num1 = Integer.parseInt(IO.readln("Entre com o primeiro número:"));
        int num2 = Integer.parseInt(IO.readln("Entre com o segundo número:"));
  
        if(num1 > num2){
            IO.println("Maior: " + num1);
            IO.println("Menor: " + num2);
        }else if(num2 > num1){
            IO.println("Maior: " + num2);
            IO.println("Menor: " + num1);
        }else if(num1 == num2){
            IO.println("Os dois números são iguais: " + num1);
        }
    }

}

