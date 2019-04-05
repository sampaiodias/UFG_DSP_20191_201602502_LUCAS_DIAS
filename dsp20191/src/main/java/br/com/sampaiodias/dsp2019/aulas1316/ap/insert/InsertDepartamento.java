/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.insert;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;

/**
 * @author Lucas Sampaio Dias
 */
public class InsertDepartamento extends PersistenciaJdbc {
    public boolean persisteDepartamento(Departamento departamento) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO DEPARTAMENTO " +
                "VALUES('" + departamento.getId() +
                "','" + departamento.getNome() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O departamento foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }
}
