/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas0508.as;

/**
 * Classe que representa o conceito de Aluno.
 * @author Lucas Sampaio Dias
 */
public class Aluno {
    public final String nome;
    public final long matricula;
    public final double nota1;
    public final double nota2;
    
    public Aluno (String nome, long matricula, double nota1, double nota2) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    
    public boolean isAprovado() {
        return (nota1 + nota2) / 2 >= 5.0f;
    }
    
    @Override
    public String toString() {
        return matricula + " - " + nome + " - Aprovado: " + isAprovado() + " (" 
                + nota1 + " ; " + nota2 + ")"; 
    }
}
