/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.delete;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertDepartamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 * @author Lucas Sampaio Dias
 */
public class DeletaDepartamentoTest {
    
    private static final Long ID = new Long(88888888);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateDepartamento create = new TableCreateDepartamento();
        create.criaTabela();
        InsertDepartamento d = new InsertDepartamento();
        d.persisteDepartamento(new Departamento(ID, "Departamento B"));
    }

    @Test
    public void testDeletaDepartamento() {
        boolean result;
        try {
            result = new DeletaDepartamento().deletaDepartamento(ID);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
}
