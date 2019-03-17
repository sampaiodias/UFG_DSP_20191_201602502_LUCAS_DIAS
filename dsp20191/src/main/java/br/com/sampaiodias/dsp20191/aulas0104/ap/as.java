/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package main.java.br.com.sampaiodias.dsp20191.aulas0104.ap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que resolve a atividade supervisionada 0104
 * @author Lucas Sampaio Dias
 */
public class as {
    
    public static void main(String[] args) throws IOException {
        criarArquivoContagem();
        BufferedReader br = App.getConteudo("src/main/resources/UF.csv");
        
        List<UnidadeFederacao> ufs = new ArrayList<>();
        String linha;
        int i = 0;
        
        while ((linha = br.readLine()) != null) {
            if (i > 0 && linha.length() > 0) {
                ufs.add(getUnidadeFederacao(linha));
            }
            i++;
        }
        
        for(UnidadeFederacao uf : ufs){
		System.out.println(uf.toString());
	}
    }

    private static UnidadeFederacao getUnidadeFederacao(String linha) 
            throws NumberFormatException {
        String[] conteudoLinha = linha.split(",");
        UnidadeFederacao uf = new UnidadeFederacao(
                Integer.parseInt(conteudoLinha[0]),
                conteudoLinha[1],
                conteudoLinha[2],
                Integer.parseInt(conteudoLinha[3]));
        return uf;
    }

    private static void criarArquivoContagem() {
        String caminho = "src/main/resources/exemplo.txt";
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            builder.append(i + 1);
            builder.append("\n");
        }
        
        App.criarArquivo(caminho, builder.toString());
    }
}
