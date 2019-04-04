/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.criacao;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class TableCreateTest {
    
    @Test
    public void criaCargoTest() {
        boolean result;
        try{
            result = new TableCargoCreate().criaTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void criaFuncionarioTest() {
        boolean result;
        try{
            result = new TableFuncionarioCreate().criaTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void criaDepartamentoTest() {
        boolean result;
        try{
            result = new TableDepartamentoCreate().criaTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void criaLotacaoTest() {
        boolean result;
        try{
            result = new TableLotacaoCreate().criaTabela();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
