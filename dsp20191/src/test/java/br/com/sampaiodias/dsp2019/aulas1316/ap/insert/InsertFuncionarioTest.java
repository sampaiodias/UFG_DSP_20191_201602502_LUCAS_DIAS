/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.insert;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaFuncionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class InsertFuncionarioTest {
    
    private static final Long ID = new Long(99999999);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateFuncionario create = new TableCreateFuncionario();
        create.criaTabela();
        DeletaFuncionario deleta = new DeletaFuncionario();
        deleta.deletaFuncionario(ID);
    }

    @Test
    public void testPersisteFuncionario() throws Exception {
        boolean result;
        Funcionario funcionario = new Funcionario(ID, ID, "Funcionario A");
        
        try{
            result = 
                    new InsertFuncionario().persisteFuncionario(funcionario);
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        
        Assert.assertTrue(result);
    }
    
}
