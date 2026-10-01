package br.com.romulo.curso.arquivo;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Algoritmo55{

    private static final String ARQUIVO = "ambientes.txt";

    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private static final Map<String, String> ambientes =
            new HashMap<>();



    public static void main(String[] args) {

        
        carregarArquivo();

        int opcao;

        do {

            opcao = menu();

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
                    excluir();
                    break;

                case 5:
                    alterar();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(
                            null,
                            "Programa encerrado. Até logo!"
                    );
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida!",
                            "Atenção",
                            JOptionPane.WARNING_MESSAGE
                    );
            }

        } while (opcao != 0);
    }


    private static int menu() {

        String texto = JOptionPane.showInputDialog(
                null,
                "===== CADASTRO DE AMBIENTES =====\n\n"
                + "1 - Cadastrar\n"
                + "2 - Listar\n"
                + "3 - Pesquisar\n"
                + "4 - Excluir\n"
                + "5 - Alterar\n"
                + "0 - Sair\n\n"
                + "Escolha uma opção:",
                "Menu Principal",
                JOptionPane.QUESTION_MESSAGE
        );

        if (texto == null) {
            return 0;
        }

        try {

            return Integer.parseInt(texto.trim());

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Digite apenas números!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

            return -1;
        }
    }

    private static void cadastrar() {

        String chave = JOptionPane.showInputDialog(
                "Digite a chave do ambiente:\n"
                + "Exemplo: F07"
        );

        if (chave == null || chave.trim().isEmpty()) {
            return;
        }

        chave = chave.trim().toUpperCase();

        if (ambientes.containsKey(chave)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Essa chave já está cadastrada!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String descricao = JOptionPane.showInputDialog(
                "Digite a descrição do ambiente:"
        );

        if (descricao == null || descricao.trim().isEmpty()) {
            return;
        }

        descricao = descricao.trim();

        ambientes.put(chave, descricao);

        
        salvarArquivo();

        JOptionPane.showMessageDialog(
                null,
                "Ambiente cadastrado com sucesso!"
        );
    }


    private static void listar() {

        if (ambientes.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum ambiente cadastrado."
            );

            return;
        }

        StringBuilder lista = new StringBuilder();

        lista.append("===== AMBIENTES CADASTRADOS =====\n\n");

        for (Map.Entry<String, String> ambiente
                : ambientes.entrySet()) {

            lista.append("Chave: ")
                    .append(ambiente.getKey())
                    .append("\n");

            lista.append("Descrição: ")
                    .append(ambiente.getValue())
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(
                null,
                lista.toString(),
                "Lista de Ambientes",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private static void pesquisar() {

        String chave = JOptionPane.showInputDialog(
                "Digite a chave que deseja pesquisar:"
        );

        if (chave == null || chave.trim().isEmpty()) {
            return;
        }

        chave = chave.trim().toUpperCase();

        if (ambientes.containsKey(chave)) {

            String descricao = ambientes.get(chave);

            JOptionPane.showMessageDialog(
                    null,
                    "Ambiente encontrado!\n\n"
                    + "Chave: " + chave + "\n"
                    + "Descrição: " + descricao
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Ambiente não encontrado!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    private static void excluir() {

        String chave = JOptionPane.showInputDialog(
                "Digite a chave que deseja excluir:"
        );

        if (chave == null || chave.trim().isEmpty()) {
            return;
        }

        chave = chave.trim().toUpperCase();

        if (!ambientes.containsKey(chave)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ambiente não encontrado!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente excluir o ambiente "
                + chave + "?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {

            ambientes.remove(chave);

            salvarArquivo();

            JOptionPane.showMessageDialog(
                    null,
                    "Ambiente excluído com sucesso!"
            );
        }
    }


    private static void alterar() {

        String chave = JOptionPane.showInputDialog(
                "Digite a chave do ambiente que deseja alterar:"
        );

        if (chave == null || chave.trim().isEmpty()) {
            return;
        }

        chave = chave.trim().toUpperCase();

        if (!ambientes.containsKey(chave)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ambiente não encontrado!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        String descricaoAtual = ambientes.get(chave);

        String novaDescricao = JOptionPane.showInputDialog(
                "Descrição atual:\n"
                + descricaoAtual
                + "\n\nDigite a nova descrição:"
        );

        if (novaDescricao == null
                || novaDescricao.trim().isEmpty()) {
            return;
        }

        novaDescricao = novaDescricao.trim();

        ambientes.put(chave, novaDescricao);

        
        salvarArquivo();

        JOptionPane.showMessageDialog(
                null,
                "Ambiente alterado com sucesso!"
        );
    }


    private static void salvarArquivo() {

        
        LocalDateTime agora = LocalDateTime.now();

        String dataHora = agora.format(FORMATO);

        FileWriter writer = null;

        try {

            writer = new FileWriter(ARQUIVO);

            writer.write(
                    "# Atualizado em: "
                    + dataHora
                    + System.lineSeparator()
            );

            for (Map.Entry<String, String> ambiente
                    : ambientes.entrySet()) {

                writer.write(
                        ambiente.getKey()
                        + ";"
                        + ambiente.getValue()
                        + System.lineSeparator()
                );
            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao salvar o arquivo:\n"
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } finally {

            if (writer != null) {

                try {

                    writer.close();

                } catch (IOException e) {

                    System.out.println(
                            "Erro ao fechar o arquivo."
                    );
                }
            }

            System.out.println(
                    "Operação de gravação finalizada em: "
                    + dataHora
            );
        }
    }


    private static void carregarArquivo() {

        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {

            ambientes.put(
                    "F07",
                    "Laboratório de Programação Java"
            );

            ambientes.put(
                    "B03",
                    "Sala de Aula Padrão"
            );

            ambientes.put(
                    "G09",
                    "Oficina de Lanternagem e Pintura"
            );

            salvarArquivo();

            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(ARQUIVO))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                if (linha.startsWith("#")
                        || linha.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linha.split(";", 2);

                if (partes.length == 2) {

                    String chave =
                            partes[0].trim();

                    String descricao =
                            partes[1].trim();

                    ambientes.put(
                            chave,
                            descricao
                    );
                }
            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao carregar o arquivo:\n"
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

