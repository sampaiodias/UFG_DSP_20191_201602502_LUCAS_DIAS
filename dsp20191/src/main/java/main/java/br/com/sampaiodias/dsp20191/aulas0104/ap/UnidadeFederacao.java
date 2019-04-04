/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package main.java.br.com.sampaiodias.dsp20191.aulas0104.ap;

/**
 * Classe que representa o conceito de Unidade Federativa.
 * @author Lucas Sampaio Dias
 */
public class UnidadeFederacao {
    public final int id;
    public final String sigla;
    public final String nome;
    public final int codigoRegiao;
    
    public UnidadeFederacao(int id, String sigla, String nome, 
            int codigoRegiao) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.codigoRegiao = codigoRegiao;
    }
    
    @Override
    public String toString() {
        return nome + " - " + sigla + ". ID: " + id + ". Região: " + 
                codigoRegiao + ".";
    }
}
