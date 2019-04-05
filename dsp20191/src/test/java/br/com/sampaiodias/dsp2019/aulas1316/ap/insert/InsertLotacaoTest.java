/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.insert;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class InsertLotacaoTest {
    
    private static final Long ID = new Long(99999999);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateLotacao create = new TableCreateLotacao();
        create.criaTabela();
        DeletaLotacao deleta = new DeletaLotacao();
        deleta.deletaLotacao(ID);
    }

    @Test
    public void testPersisteLotacao() throws Exception {
        boolean result;
        Lotacao lotacao = new Lotacao(ID, ID, ID, "01/02/2003", "10/12/2012");
        
        try{
            result = 
                    new InsertLotacao().persisteLotacao(lotacao);
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        
        Assert.assertTrue(result);
    }
    
}
