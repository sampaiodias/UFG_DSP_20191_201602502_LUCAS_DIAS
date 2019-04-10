/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1720.ap;

import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaLotacao;

/**
 * Exercício que resolve a questão 3 da Atividade Pratica - aulas1720
 * @author Lucas Sampaio Dias
 */
public class RemoverDados {
    public static void main(String[] args) {
        deletarCargo();
        deletarDepartamento();
        deletarFuncionario();
        deletarLotacao();
    }

    private static void deletarCargo() {
        DeletaCargo deleta = new DeletaCargo();
        deleta.deletaCargo(new Long(100));
    }
    
    private static void deletarDepartamento() {
        DeletaDepartamento deleta = new DeletaDepartamento();
        deleta.deletaDepartamento(new Long(100));
    }
    
    private static void deletarFuncionario() {
        DeletaFuncionario deleta = new DeletaFuncionario();
        deleta.deletaFuncionario(new Long(100));
    }
    
    private static void deletarLotacao() {
        DeletaLotacao deleta = new DeletaLotacao();
        deleta.deletaLotacao(new Long(100));
    }
}
