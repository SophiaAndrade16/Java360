import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Algoritmo49 {

    public static void main(String[] args) {

        ArrayList<String> laboratorios = new ArrayList<>();

        int opcao;

        do {

            String laboratorio = JOptionPane.showInputDialog(
                    "Qual laboratório deseja adicionar?\n"
                    + "F03, F05 ou F07"
            );

            laboratorios.add(laboratorio);

            String escolha = JOptionPane.showInputDialog(
                    "Deseja adicionar outro laboratório?\n"
                    + "1 - Adicionar\n"
                    + "2 - Sair"
            );

            opcao = Integer.parseInt(escolha);

        } while (opcao == 1);

        JOptionPane.showMessageDialog(
                null,
                "Quantidade de laboratórios adicionados: "
                + laboratorios.size()
        );

        String resultado = "Laboratórios adicionados:\n";

        for (String laboratorio : laboratorios) {
            resultado += laboratorio + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
        
    