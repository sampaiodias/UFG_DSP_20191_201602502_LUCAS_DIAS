/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.insert;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;

/**
 * @author Lucas Sampaio Dias
 */
public class InsertFuncionario extends PersistenciaJdbc {
    public boolean persisteFuncionario(Funcionario funcionario) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO FUNCIONARIO " +
                "VALUES('" + funcionario.getId() +
                "','" + funcionario.getMatricula()+
                "','" + funcionario.getNome() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O funcionário foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }
}
