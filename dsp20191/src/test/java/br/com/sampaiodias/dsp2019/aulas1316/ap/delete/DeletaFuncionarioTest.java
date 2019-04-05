/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.delete;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 * @author Lucas Sampaio Dias
 */
public class DeletaFuncionarioTest {
    
    private static final Long ID = new Long(88888887);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateFuncionario create = new TableCreateFuncionario();
        create.criaTabela();
        InsertFuncionario insert = new InsertFuncionario();
        insert.persisteFuncionario(new Funcionario(ID, ID, "Funcionario B"));
    }

    @Test
    public void testDeletaDepartamento() {
        boolean result;
        try{
            result = new DeletaFuncionario().deletaFuncionario(ID);
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
}
