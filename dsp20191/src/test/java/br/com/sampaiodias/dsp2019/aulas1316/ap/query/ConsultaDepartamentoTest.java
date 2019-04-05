/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.query;

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
public class ConsultaDepartamentoTest {
    
    private static final Long ID = new Long(77777777);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateDepartamento create = new TableCreateDepartamento();
        create.criaTabela();
        DeletaDepartamento delete = new DeletaDepartamento();
        delete.deletaDepartamento(ID);
        InsertDepartamento insert = new InsertDepartamento();
        insert.persisteDepartamento(new Departamento(ID, "Departamento C"));
    }

    @Test
    public void testConsultaPorId() throws Exception {
        Departamento departamento = new Departamento(null, null);
        
        try{
            departamento = new ConsultaDepartamento().consultaPorId(ID);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        Assert.assertEquals(ID, departamento.getId());
    }
    
}
