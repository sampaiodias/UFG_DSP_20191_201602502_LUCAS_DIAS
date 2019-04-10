/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.update;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.delete.DeletaLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.insert.InsertLotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;
import java.util.Date;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class UpdateLotacaoTest {
    
    private static final Long ID = new Long(66666666);
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        TableCreateLotacao create = new TableCreateLotacao();
        create.criaTabela();
        DeletaLotacao delete = new DeletaLotacao();
        delete.deletaLotacao(ID);
        
        Date inicio = Lotacao.DATE_FORMAT.parse("01/02/2003");
        Date fim = Lotacao.DATE_FORMAT.parse("10/11/2012");
        
        InsertLotacao insert = new InsertLotacao();
        insert.persisteLotacao(
                new Lotacao(ID, new Cargo(ID, "Cargo C", new Double(1000)), 
                        new Departamento(ID, "Departamento C"),
                        new Funcionario(ID, ID, ""),
                        inicio, fim));
    }

    @Test
    public void testAtualizaLotacao() throws Exception {
        boolean result;
        UpdateLotacao update = new UpdateLotacao();
        Date inicio = Lotacao.DATE_FORMAT.parse("05/05/2003");
        Date fim = Lotacao.DATE_FORMAT.parse("05/12/2015");
        Lotacao lot = new Lotacao(ID, new Cargo(ID, "Cargo C", new Double(1000)), 
                        new Departamento(ID, "Departamento C"), 
                        new Funcionario(ID, ID, ""),
                        inicio, fim);
        
        try {
            result = update.atualizaLotacao(lot);
        }catch (Exception e) {
            result = false;
        }
        
        Assert.assertEquals(true, result);
    }
    
}
