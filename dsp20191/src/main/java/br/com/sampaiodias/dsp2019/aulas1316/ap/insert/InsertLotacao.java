/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.insert;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;

/**
 * @author Lucas Sampaio Dias
 */
public class InsertLotacao extends PersistenciaJdbc {
    public boolean persisteLotacao(Lotacao lotacao) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO LOTACAO " +
                "VALUES('" + lotacao.getId() +
                "','" + lotacao.getCargo().getId() +
                "','" + lotacao.getDepartamento().getId() +
                "','" + lotacao.getDataInicialToString() +
                "','" + lotacao.getDataFinalToString() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("A lotação foi persistida corretamente.");
        stmt.close();
        connection.close();

        return true;
    }
}
