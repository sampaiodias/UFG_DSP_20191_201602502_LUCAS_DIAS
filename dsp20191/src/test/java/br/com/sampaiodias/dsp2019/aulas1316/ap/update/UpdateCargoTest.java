/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.update;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class UpdateCargoTest {
    
    private static final Long ID = new Long(66666666);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateCargo create = new TableCreateCargo();
        create.criaTabela();
        DeletaCargo delete = new DeletaCargo();
        delete.deletaCargo(ID);
        InsertCargo insert = new InsertCargo();
        insert.persisteCargo(new Cargo(ID, "Cargo B"));
    }

    @Test
    public void testAtualizaCargo() throws Exception {
        boolean result;
        UpdateCargo update = new UpdateCargo();
                
        try{
            result = update.atualizaCargo(new Cargo(ID, "Cargo C"));
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
        }     
        
        Assert.assertEquals(true, result);
    }
    
}
