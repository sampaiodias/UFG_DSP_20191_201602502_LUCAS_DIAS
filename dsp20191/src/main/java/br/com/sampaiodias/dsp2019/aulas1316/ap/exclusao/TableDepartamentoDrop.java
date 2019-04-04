/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.exclusao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;

/**
 * @author Lucas Sampaio Dias
 */
public class TableDepartamentoDrop extends PersistenciaJdbc{
    public boolean excluiTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Excluindo a tabela Departamento");

        String sql = "DROP TABLE IF EXISTS DEPARTAMENTO";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Departamento excluida com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
