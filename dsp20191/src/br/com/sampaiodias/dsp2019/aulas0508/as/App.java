/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas0508.as;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Resolve a Atividade Supervisionada - aulas0508.
 * @author Lucas Sampaio Dias
 */
public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Aluno> alunos = getAlunosNoArquivo("avaliacao.dat");
        alunos.forEach((aluno) -> {
            System.out.println(aluno.toString());
        });
    }
    
    public static ArrayList<Aluno> getAlunosNoArquivo(String arquivo) 
            throws IOException {
        BufferedReader br = App.getConteudo("src/main/resources/" + arquivo);
        
        ArrayList<Aluno> alunos = new ArrayList<>();
        String linha;
        
        while ((linha = br.readLine()) != null) {
            if (linha.length() > 0) {
                StringTokenizer token = new StringTokenizer(linha, ",");
                Aluno a = new Aluno(token.nextToken(),
                        Long.parseLong(token.nextToken()), 
                        Double.parseDouble(token.nextToken()), 
                        Double.parseDouble(token.nextToken()));
                alunos.add(a);
            }
        }
        
        return alunos;
    }
    
    private static BufferedReader getConteudo(String caminho) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fileReader);
        return br;
    }  
}
