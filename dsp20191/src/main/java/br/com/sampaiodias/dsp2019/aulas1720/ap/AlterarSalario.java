/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1720.ap;

import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.update.UpdateCargo;
import java.util.ArrayList;
import java.util.Date;

/**
 * Exercício que resolve as questões 6 e 7 da Atividade Pratica - aulas1720
 * @author Lucas Sampaio Dias
 */
public class AlterarSalario {
    
    public static Double salario = new Double(2500);
    public static Cargo cargo;
    public static Departamento departamento;
    
    public static void main(String[] args) throws Exception {
        AlterarDados.alteraCargo();
        AlterarDados.alteraDepartamento();
        AlterarDados.alteraFuncionario();
        AlterarDados.alteraLotacao();
        
        cargo = new ConsultaCargo().consultaPorId(new Long(100));
        departamento = 
                new ConsultaDepartamento().consultaPorId(new Long(100));
        
        Funcionario f1 = new Funcionario(new Long(200), Long.MAX_VALUE, "João");
        Funcionario f2 = new Funcionario(new Long(201), Long.MAX_VALUE, "John");
        
        new InsertFuncionario().persisteFuncionario(f1);
        new InsertFuncionario().persisteFuncionario(f2);
        
        Lotacao lotacao1 = new Lotacao(new Long(500), cargo, departamento, f1, 
                new Date(), new Date());
        Lotacao lotacao2 = new Lotacao(new Long(501), cargo, departamento, f2, 
                new Date(), new Date());
        
        new InsertLotacao().persisteLotacao(lotacao1);
        new InsertLotacao().persisteLotacao(lotacao2);
        

        alterarSalario(cargo, departamento, salario);
        imprimirFuncionariosComSalario(salario);
    }
    
    public static void alterarSalario(Cargo cargo, Departamento departamento,
            Double novoSalario) throws Exception {
        ArrayList<Lotacao> lotacoes = new ConsultaLotacao().consultaTodos(
                cargo.getId(), departamento.getId());
        for(Lotacao lot : lotacoes) {
            if (lot.getCargo().getId() == cargo.getId() &&
                    lot.getDepartamento().getId() == departamento.getId()) {
                lot.getCargo().setSalario(novoSalario);
                new UpdateCargo().atualizaCargo(lot.getCargo());
            }
        }
    }
    
    public static void imprimirFuncionariosComSalario(Double salario) 
            throws Exception {
        ArrayList<Lotacao> lotacoes = new ConsultaLotacao().consultaTodos();
        System.out.println("\nFuncionários com salário alterado:");
        for(Lotacao lot : lotacoes) {
            if (lot.getCargo().getSalario().equals(salario) &&
                    lot.getCargo().getId() == cargo.getId() &&
                    lot.getDepartamento().getId() == departamento.getId()) {
                System.out.println(lot.getFuncionario().getNome());
            }
        }
    }
}
