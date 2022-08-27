/*
    Equipe:
    ┌────────────────────────────────┐
    │ Manoel Felipe de Almeida Bina; │
    │ Nicholas Davi da Cruz.         │
    └────────────────────────────────┘
*/

package Hashes;

import java.io.*;
import java.util.Scanner;

// Classe pública "Cadastro"
public class Cadastro {

    // Scanner para entrada de dados
    public Scanner in = new Scanner(System.in);

    // Nova instância da classe MD5 para armazenar as senhas hasheadas
    public MD5 md5 = new MD5();

    // Atributo privado: variável que armazena valores de texto
    // (Strings) para a execução do programa (nome, senha)
    private String text;

    // Linhas a serem lidas no arquivo .txt
    private String line;

    // Método construtor da Classe "Cadastro"
    // Lança uma exceção que detecta se não existir um arquivo .txt
    public Cadastro(String text) {
        this.text = text;
    }

    // Getter para acessar o valor de "text"
    public String getText() {
        return text;
    }

    // Setter para alterar o valor de "text"
    public void setText(String text) {
        this.text = text;
    }

    // Setter para alterar o valor de "line"
    public void setLine(String line) {
        this.line = line;
    }

    // Método "write" escreve os dados passados como parâmetro em um arquivo .txt
    public void write() throws Exception {

        // Os valores destas variáveis iniciam-se todos como "null"
        // Para serem alterados durante a execução
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;

        try { // Executar este bloco de código se houver um arquivo aberto
              // Modo "append" == True para adicionar mais dados ao arquivo

            // Escritor de arquivos (gerador) sempre no modo "append"
            fileWriter = new FileWriter("passwords.txt", true);

            // Provê a entrada de Strings para escrevê-las no arquivo
            bufferedWriter = new BufferedWriter(fileWriter);

            // Efetua a escrita do texto passado
            printWriter = new PrintWriter(bufferedWriter);

            // Mensagem: Inserção de dados do usuário
            System.out.print("Insira seu nome de usuário: ");

            // A variável nome recebe o nome passado
            String nome = in.nextLine();

            if(nome.length() != 4) {
                System.out.println("Dados inválidos! Insira um nome de usuário de exatamente 4 caracteres.");
                return ;
            }

            // Mensagem: Inserção de dados do usuário
            System.out.print("Insira sua senha: ");

            // A variável printWriter recebe a senha passada
            setText(in.nextLine());

            if(getText().length() != 4) {
                System.out.println("Dados inválidos! Insira uma senha de exatamente 4 caracteres.");
                return ;
            }

            printWriter.println(md5.md5Hash(getText()));

            // Mensagem: "O cadastro foi realizado com sucesso"
            System.out.println("Dados armazenados no arquivo com sucesso!");

            // "Dar descarga", limpar a cadeia de entrada de dados
            printWriter.flush();

            // Fechar o PrintWriter
            printWriter.close();

            // Fechar o BufferWriter
            bufferedWriter.close();

            // Fechar o FileWriter
            fileWriter.close();

        }
            catch (IOException io) { // Não é possível fazer nada. Exceção de input
                                       // e output de dados.
                // ¯\_(ツ)_/¯

                System.out.println("Exceção de entrada e saída de dados. Execute o programa novamente.");

            }


    }
}