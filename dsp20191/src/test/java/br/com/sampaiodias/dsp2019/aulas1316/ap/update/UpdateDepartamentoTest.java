/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.update;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class UpdateDepartamentoTest {
    
    private static final Long ID = new Long(66666666);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateDepartamento create = new TableCreateDepartamento();
        create.criaTabela();
        DeletaDepartamento delete = new DeletaDepartamento();
        delete.deletaDepartamento(ID);
        InsertDepartamento insert = new InsertDepartamento();
        insert.persisteDepartamento(new Departamento(ID, "Departamento D"));
    }

    @Test
    public void testAtualizaDepartamento() throws Exception {
        boolean result;
        UpdateDepartamento update = new UpdateDepartamento();
        
        try {
            result = update.atualizaDepartamento(
                    new Departamento(ID, "Departamento Dd"));
        }catch (Exception e) {
            result = false;
        }
        
        Assert.assertEquals(true, result);
    }
    
}
