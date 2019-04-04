/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.exclusao;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class TableDropTest {
    @Test
    public void dropTabelaCargoTest(){
        boolean result;
        try{
            result = new TableCargoDrop().excluiTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void dropTabelaFuncionarioTest(){
        boolean result;
        try{
            result = new TableFuncionarioDrop().excluiTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void dropTabelaLotacaoTest(){
        boolean result;
        try{
            result = new TableLotacaoDrop().excluiTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void dropTabelaDepartamentoTest(){
        boolean result;
        try{
            result = new TableDepartamentoDrop().excluiTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
