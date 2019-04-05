/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.insert;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class InsertDepartamentoTest {
    
    private static final Long ID = new Long(99999999);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateDepartamento create = new TableCreateDepartamento();
        create.criaTabela();
        DeletaDepartamento deleta = new DeletaDepartamento();
        deleta.deletaDepartamento(ID);
    }

    @Test
    public void testPersisteDepartamento() throws Exception {
        boolean result;
        Departamento departamento = new Departamento(ID, "Departamento A");
        
        try{
            result = 
                    new InsertDepartamento().persisteDepartamento(departamento);
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        
        Assert.assertTrue(result);
    }
    
}
