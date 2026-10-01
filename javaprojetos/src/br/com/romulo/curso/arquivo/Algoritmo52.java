package br.com.romulo.curso.arquivo;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Algoritmo52 {
      
    void main(){

         int r = 0;
         do{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            IO.println("Digite uma dúvida?");
            String duvida = IO.readln();
            String carimbo = LocalDateTime.now().format(formato);
         
            try(FileWriter arquivo = new FileWriter("registro.txt", true)){
            arquivo.write("[" +  carimbo + "]" + duvida +"\n" );
            IO.println("✅ Registrado ["+carimbo+"]" + duvida);
            IO.println("Deseja registrar nova mensagem 1- sim 0-não:");
            
            r = Integer.parseInt(IO.readln());


             }catch(IOException e){
            IO.println(" ERRO ao salvar a sua dúvida " + e.getMessage());
             }

            IO.print("adicionar msg:1 [sim] 0[nao]");
            r = Integer.parseInt(IO.readln());

        }while(r==1);
    }
}

    
