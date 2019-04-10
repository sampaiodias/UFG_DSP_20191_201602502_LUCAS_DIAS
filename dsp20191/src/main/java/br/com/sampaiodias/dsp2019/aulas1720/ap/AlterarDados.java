/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1720.ap;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.drop.TableDropCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.drop.TableDropDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.drop.TableDropFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.drop.TableDropLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.update.UpdateCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.update.UpdateDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.update.UpdateFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.update.UpdateLotacao;
import java.util.Date;

/**
 * Exercício que resolve a questão 3 da Atividade Pratica - aulas1720
 * @author Lucas Sampaio Dias
 */
public class AlterarDados {
    public static void main(String[] args) throws Exception {
        alteraCargo();
        alteraDepartamento();
        alteraFuncionario();
        alteraLotacao();
    }
    
    private static void alteraCargo() throws Exception {
        //Exclui todos os dados para que não exista um objeto
        //igual ao que será usado para o teste deste método
        TableDropCargo drop = new TableDropCargo();
        drop.excluiTabela();
        
        //Cria a tabela no banco
        TableCreateCargo table = new TableCreateCargo();
        table.criaTabela();
        
        //Cria um objeto de testes e persiste o objeto no banco
        Cargo cargo = new Cargo(new Long(100), "A", new Double(1000));
        InsertCargo insert = new InsertCargo();
        insert.persisteCargo(cargo);
        
        //Altera o nome do objeto e persiste a alteração no banco
        cargo.setNome("Cargo B");
        UpdateCargo update = new UpdateCargo();
        update.atualizaCargo(cargo);
        
        //Imprime a alteração
        ConsultaCargo query = new ConsultaCargo();
        System.out.println("Novo nome do cargo: " + 
                query.consultaPorId(new Long(100)).getNome());
    }
    
    private static void alteraDepartamento() throws Exception {
        //Exclui todos os dados para que não exista um objeto
        //igual ao que será usado para o teste deste método
        TableDropDepartamento drop = new TableDropDepartamento();
        drop.excluiTabela();
        
        //Cria a tabela no banco
        TableCreateDepartamento table = new TableCreateDepartamento();
        table.criaTabela();
        
        //Cria um objeto de testes e persiste o objeto no banco
        Departamento departamento = new Departamento(new Long(100), "A");
        InsertDepartamento insert = new InsertDepartamento();
        insert.persisteDepartamento(departamento);
        
        //Altera o nome do objeto e persiste a alteração no banco
        departamento.setNome("Departamento B");
        UpdateDepartamento update = new UpdateDepartamento();
        update.atualizaDepartamento(departamento);
        
        //Imprime a alteração
        ConsultaDepartamento query = new ConsultaDepartamento();
        System.out.println("Novo nome do departamento: " + 
                query.consultaPorId(new Long(100)).getNome());
    }
    
    private static void alteraFuncionario() throws Exception {
        //Exclui todos os dados para que não exista um objeto
        //igual ao que será usado para o teste deste método
        TableDropFuncionario drop = new TableDropFuncionario();
        drop.excluiTabela();
        
        //Cria a tabela no banco
        TableCreateFuncionario table = new TableCreateFuncionario();
        table.criaTabela();
        
        //Cria um objeto de testes e persiste o objeto no banco
        Funcionario funcionario = 
                new Funcionario(new Long(100), new Long(100), "Funcionario A");
        InsertFuncionario insert = new InsertFuncionario();
        insert.persisteFuncionario(funcionario);
        
        //Altera o nome do objeto e persiste a alteração no banco
        funcionario.setNome("Funcionario B");
        UpdateFuncionario update = new UpdateFuncionario();
        update.atualizaFuncionario(funcionario);
        
        //Imprime a alteração
        ConsultaFuncionario query = new ConsultaFuncionario();
        System.out.println("Novo nome do Funcionario: " + 
                query.consultaPorId(new Long(100)).getNome());
    }
    
    private static void alteraLotacao() throws Exception {
        //Exclui todos os dados para que não exista um objeto
        //igual ao que será usado para o teste deste método
        TableDropLotacao drop = new TableDropLotacao();
        drop.excluiTabela();
        
        //Cria a tabela no banco
        TableCreateLotacao table = new TableCreateLotacao();
        table.criaTabela();
        
        //Cria um objeto de testes e persiste o objeto no banco
        Long ID = new Long(100);
        Lotacao lotacao = new Lotacao(ID, new Cargo(ID, "", new Double(1000)), 
                new Departamento(ID, ""), new Date(), new Date());
        InsertLotacao insert = new InsertLotacao();
        insert.persisteLotacao(lotacao);
        
        //Altera o nome do objeto e persiste a alteração no banco
        lotacao.setDataInicial("10/04/2019");
        UpdateLotacao update = new UpdateLotacao();
        update.atualizaLotacao(lotacao);
        
        //Imprime a alteração
        ConsultaLotacao query = new ConsultaLotacao();
        System.out.println("Nova data da lotação: " + 
                query.consultaPorId(ID).getDataInicialToString());
    }
}
