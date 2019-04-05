/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.update;

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
public class UpdateFuncionarioTest {
    
    private static final Long ID = new Long(66666666);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateFuncionario create = new TableCreateFuncionario();
        create.criaTabela();
        DeletaFuncionario delete = new DeletaFuncionario();
        delete.deletaFuncionario(ID);
        InsertFuncionario insert = new InsertFuncionario();
        insert.persisteFuncionario(new Funcionario(ID, ID, "Departamento D"));
    }

    @Test
    public void testAtualizaFuncionario() throws Exception {
        boolean result;
        UpdateFuncionario update = new UpdateFuncionario();
        
        try {
            result = update.atualizaFuncionario(
                    new Funcionario(ID, ID, "Departamento Dd"));
        }catch (Exception e) {
            result = false;
        }
        
        Assert.assertEquals(true, result);
    }
    
}
