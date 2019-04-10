/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.insert;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;

/**
 * @author Lucas Sampaio Dias
 */
public class InsertCargo extends PersistenciaJdbc {
    public boolean persisteCargo(Cargo cargo) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO CARGO " +
                "VALUES('" + cargo.getId() +
                "','" + cargo.getNome() +
                "','" + cargo.getSalario()+
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O cargo foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }
}
