/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.delete;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 * @author Lucas Sampaio Dias
 */
public class DeletaCargoTest {
    
    private static final Long ID = new Long(88888888);
    
    @BeforeClass
    public static void beforeClass() throws Exception {
        TableCreateCargo create = new TableCreateCargo();
        create.criaTabela();
        InsertCargo p = new InsertCargo();
        p.persisteCargo(new Cargo(ID, "Cargo A", new Double(1000)));
    }

    @Test
    public void testDeletaCargo() {
        boolean result;
        try {
            result = new DeletaCargo().deletaCargo(ID);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
}
