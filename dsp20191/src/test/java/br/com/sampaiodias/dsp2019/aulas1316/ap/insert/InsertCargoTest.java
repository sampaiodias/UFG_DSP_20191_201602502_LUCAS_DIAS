/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.insert;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class InsertCargoTest {
    
    private static final Long ID = new Long(99999999);
    
    @BeforeClass
    public static void beforeClass() throws Exception {
        TableCreateCargo create = new TableCreateCargo();
        create.criaTabela();
        DeletaCargo deleta = new DeletaCargo();
        deleta.deletaCargo(ID);
    }

    @Test
    public void testPersisteCargo() throws Exception {
        boolean result;
        Cargo cargo = new Cargo(ID, "Cargo A");
        try{
            result = new InsertCargo().persisteCargo(cargo);
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
}
