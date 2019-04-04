/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package main.java.br.com.sampaiodias.dsp20191.aulas0104.ap;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Resolve o exercício inicial da disciplina de criar, escrever e ler
 * em um arquivo txt.
 * @author Lucas Sampaio Dias
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String conteudo = "Teste";
        String caminho = "src/main/resources/exemplo.txt";

        criarArquivo(caminho, conteudo);    
        System.out.println("Conteúdo do arquivo: ");
        imprimirConteudo(getConteudo(caminho));
    }      

    public static BufferedReader getConteudo(String caminho) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fileReader);
        return br;
    }      

    public static void imprimirConteudo(BufferedReader br) throws IOException {
        String linha;
        while ((linha = br.readLine()) != null) {
            System.out.println(linha);
        }
    }      

    public static void criarArquivo(String caminho, String conteudo) {
        try (FileWriter fileWriter = new FileWriter(caminho)) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(conteudo);
        } catch(Exception e){System.out.println(e);}
    }
}
