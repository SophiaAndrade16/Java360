import java.util.ArrayList;
import java.util.List;
public class Algoritmo46 {
    public void main(){
        List<String> frutas = new ArrayList<>();
        frutas.add("Goiaba");
        frutas.add("Amora");
        frutas.add("Melancia");
        frutas.add("Mamão");

        IO.println("Primeira fruta:"+frutas.get(0));
        IO.println(frutas);
        frutas.set(1,"uva");
        IO.println(frutas);
        for(String fruta:frutas){
         IO.println("elemento:"+fruta);
        }
        IO.println("Total de frutas:"+frutas.size());
        frutas.remove("Mamão");
        frutas.remove("Goiaba");
        frutas.remove("Melancia");

        IO.println("Total de frutas:"+frutas.size());
        IO.println("lista"+frutas);
        frutas.add("Laranja");
        frutas.add("Morango");
        IO.println("lista"+frutas);
        frutas.remove(1);
        IO.println("listas"+frutas);
    }
    
}
