/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.query;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class ConsultaFuncionarioTest {
    
    private static final Long ID = new Long(77777777);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateFuncionario create = new TableCreateFuncionario();
        create.criaTabela();
        DeletaFuncionario delete = new DeletaFuncionario();
        delete.deletaFuncionario(ID);
        InsertFuncionario insert = new InsertFuncionario();
        insert.persisteFuncionario(new Funcionario(ID, ID, "Funcionário C"));
    }

    @Test
    public void testConsultaPorId() throws Exception {
        Funcionario funcionario = new Funcionario(null, null, null);
        
        try{
            funcionario = new ConsultaFuncionario().consultaPorId(ID);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        Assert.assertEquals(ID, funcionario.getId());
    }
    
}
