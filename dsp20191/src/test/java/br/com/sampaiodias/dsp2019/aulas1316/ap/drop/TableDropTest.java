/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.drop;

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
            result = new TableDropCargo().excluiTabela();
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
            result = new TableDropFuncionario().excluiTabela();
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
            result = new TableDropLotacao().excluiTabela();
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
            result = new TableDropDepartamento().excluiTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
