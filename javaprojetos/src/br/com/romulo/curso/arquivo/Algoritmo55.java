package br.com.romulo.curso.arquivo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Algoritmo55 {

    
    private static Map<String, Ambiente> ambientes = new HashMap<>();
    private static final String CAMINHO_ARQUIVO = "ambientes.txt";
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) {
      
        carregarDoArquivo();

        int opcao = -1;

      
        do {
            try {
                String menu = "=== CADASTRO DE DICIONÁRIO DE AMBIENTES ===\n\n"
                        + "1 - Cadastrar Ambiente\n"
                        + "2 - Listar Ambientes\n"
                        + "3 - Pesquisar Ambiente\n"
                        + "4 - Alterar Ambiente\n"
                        + "5 - Excluir Ambiente\n"
                        + "0 - Sair\n\n"
                        + "Escolha uma opção:";

                String entrada = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);

                if (entrada == null) {
                    opcao = 0;
                } else {
                    opcao = Integer.parseInt(entrada);
                }

                switch (opcao) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        listar();
                        break;
                    case 3:
                        pesquisar();
                        break;
                    case 4:
                        alterar();
                        break;
                    case 5:
                        excluir();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saindo do programa. Até logo!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Digite um número do menu.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira apenas números inteiros válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                
            }

        } while (opcao != 0);
    }


    private static void cadastrar() {
        String chave = JOptionPane.showInputDialog("Digite a chave do ambiente (ex: F07):");
        if (chave == null || chave.trim().isEmpty()) return;

        chave = chave.trim().toUpperCase();

        if (ambientes.containsKey(chave)) {
            JOptionPane.showMessageDialog(null, "Erro: Chave já cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String descricao = JOptionPane.showInputDialog("Digite a descrição (ex: Laboratório de Programação):");
        if (descricao == null || descricao.trim().isEmpty()) return;

        Ambiente novoAmbiente = new Ambiente(chave, descricao);
        ambientes.put(chave, novoAmbiente);

        salvarNoArquivo();
        JOptionPane.showMessageDialog(null, "Ambiente cadastrado com sucesso!");
    }

    private static void listar() {
        if (ambientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ambiente cadastrado.");
            return;
        }

        StringBuilder lista = new StringBuilder("=== AMBIENTES CADASTRADOS ===\n\n");
        for (Map.Entry<String, Ambiente> entry : ambientes.entrySet()) {
            lista.append(entry.getValue().toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private static void pesquisar() {
        String chave = JOptionPane.showInputDialog("Digite a chave para pesquisar:");
        if (chave == null || chave.trim().isEmpty()) return;

        chave = chave.trim().toUpperCase();
        Ambiente ambiente = ambientes.get(chave);

        if (ambiente != null) {
            JOptionPane.showMessageDialog(null, "Ambiente encontrado:\n\n" + ambiente.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Ambiente não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void alterar() {
        String chave = JOptionPane.showInputDialog("Digite a chave do ambiente que deseja alterar:");
        if (chave == null || chave.trim().isEmpty()) return;

        chave = chave.trim().toUpperCase();

        if (!ambientes.containsKey(chave)) {
            JOptionPane.showMessageDialog(null, "Chave não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String novaDescricao = JOptionPane.showInputDialog("Digite a nova descrição:");
        if (novaDescricao == null || novaDescricao.trim().isEmpty()) return;

        Ambiente ambiente = ambientes.get(chave);
        ambiente.setDescricao(novaDescricao);
        ambiente.setDataRegistro(LocalDateTime.now()); // Atualiza data de alteração

        salvarNoArquivo();
        JOptionPane.showMessageDialog(null, "Ambiente alterado com sucesso!");
    }

    private static void excluir() {
        String chave = JOptionPane.showInputDialog("Digite a chave do ambiente para excluir:");
        if (chave == null || chave.trim().isEmpty()) return;

        chave = chave.trim().toUpperCase();

        if (ambientes.remove(chave) != null) {
            salvarNoArquivo();
            JOptionPane.showMessageDialog(null, "Ambiente excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Chave não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    private static void salvarNoArquivo() {
        try (FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, false);
             PrintWriter pw = new PrintWriter(fw)) {

            for (Ambiente env : ambientes.values()) {
                pw.println(env.getChave() + ";" + env.getDescricao() + ";" + env.getDataFormatada());
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no arquivo: " + e.getMessage(), "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private static void carregarDoArquivo() {
        try (FileReader fr = new FileReader(CAMINHO_ARQUIVO);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    String chave = dados[0];
                    String descricao = dados[1];
                    LocalDateTime data = LocalDateTime.parse(dados[2], FORMATO_DATA);

                    ambientes.put(chave, new Ambiente(chave, descricao, data));
                }
            }
        } catch (IOException e) {
          
        }
    }
}