/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.criacao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;

/**
 * @author Lucas Sampaio Dias
 */
public class TableLotacaoCreate extends PersistenciaJdbc{
    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Criando a tabela Lotacao");

        String sql = "CREATE TABLE IF NOT EXISTS LOTACAO(\n" +
                "ID LONG NOT NULL PRIMARY KEY,\n" +
                "ID_CARGO LONG NOT NULL,\n" +
                "ID_DEPARTAMENTO LONG NOT NULL,\n" +
                "DATA_INICIAL VARCHAR(10) NOT NULL\n" +
                "DATA_FINAL VARCHAR(10) NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Lotacao criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
