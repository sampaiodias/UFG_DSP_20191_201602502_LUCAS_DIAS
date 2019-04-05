/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.update;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;

/**
 * @author Lucas Sampaio Dias
 */
public class UpdateLotacao extends PersistenciaJdbc {
    public boolean atualizaLotacao(Lotacao lotacao) throws Exception {
        preparaPersistencia();
        
        String sql = "UPDATE LOTACAO " +
                "SET ID = '" + lotacao.getId() +
                "', ID_CARGO = '" + lotacao.getCargo().getId() +
                "', ID_DEPARTAMENTO = '" + lotacao.getDepartamento().getId() +
                "', DATA_INICIAL = '" + lotacao.getDataInicialToString() +
                "', DATA_FINAL = '" + lotacao.getDataFinalToString() +
                "' WHERE ID = " + lotacao.getId();
        
        stmt.executeUpdate(sql);
        System.out.println("A lotação foi atualizada corretamente.");
        stmt.close();
        connection.close();
        
        return true;
    }
}
