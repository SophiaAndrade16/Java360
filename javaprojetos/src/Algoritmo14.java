public class Algoritmo14 {

    public void main(){
        int opcao = Integer.parseInt(IO.readln("Escolha uma opção (1, 2 ou 3):"));

        switch(opcao){
            case 1 -> IO.println("jogo iniciado");
            case 2 -> IO.println("suas vidas estão acabando");
            case 3 -> IO.println("Game Over!");
            default -> IO.println("Número inválido");
        }
    }

}