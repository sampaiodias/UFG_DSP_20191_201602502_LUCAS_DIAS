/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.query;

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
public class ConsultaCargoTest {
    
    private static final Long ID = new Long(77777777);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateCargo create = new TableCreateCargo();
        create.criaTabela();
        DeletaCargo delete = new DeletaCargo();
        delete.deletaCargo(ID);
        InsertCargo insert = new InsertCargo();
        insert.persisteCargo(new Cargo(ID, "Cargo C", new Double(1000)));
    }

    @Test
    public void testConsultaPorId() throws Exception {
        Cargo cargo = new Cargo(null, null, new Double(1000));
        
        try{
            cargo = new ConsultaCargo().consultaPorId(ID);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        Assert.assertEquals(ID, cargo.getId());
    }
    
}
