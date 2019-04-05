/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.create;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;

/**
 * @author Lucas Sampaio Dias
 */
public class TableCreateCargo extends PersistenciaJdbc {
    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Criando a tabela Cargo");

        String sql = "CREATE TABLE IF NOT EXISTS CARGO(\n" +
                "ID LONG NOT NULL PRIMARY KEY,\n" +
                "NOME VARCHAR(100) NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Cargo criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
