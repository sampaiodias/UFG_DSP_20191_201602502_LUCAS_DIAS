/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.delete;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;
import java.util.Date;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Lucas Sampaio Dias
 */
public class DeletaLotacaoTest {
    
    private static final Long ID = new Long(88888888);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateLotacao create = new TableCreateLotacao();
        create.criaTabela();
        
        Date inicio = Lotacao.DATE_FORMAT.parse("01/02/2003");
        Date fim = Lotacao.DATE_FORMAT.parse("10/11/2012");
        
        InsertLotacao insert = new InsertLotacao();
        insert.persisteLotacao(
                new Lotacao(ID, new Cargo(ID, "Cargo C"), 
                        new Departamento(ID, "Departamento C"), 
                        inicio, fim));
    }

    @Test
    public void testDeletaLotacao() {
        boolean result;
        try {
            result = new DeletaLotacao().deletaLotacao(ID);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
}
