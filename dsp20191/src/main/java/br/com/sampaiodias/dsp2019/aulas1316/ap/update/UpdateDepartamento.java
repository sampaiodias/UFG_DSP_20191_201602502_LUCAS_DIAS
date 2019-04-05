/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.update;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;

/**
 * @author Lucas Sampaio Dias
 */
public class UpdateDepartamento extends PersistenciaJdbc {
    public boolean atualizaDepartamento(Departamento departamento) throws Exception {
        preparaPersistencia();
        
        String sql = "UPDATE DEPARTAMENTO " +
                "SET ID = '" + departamento.getId() +
                "', NOME = '" + departamento.getNome() +
                "' WHERE ID = " + departamento.getId();
        
        stmt.executeUpdate(sql);
        System.out.println("O departamento foi atualizado corretamente.");
        stmt.close();
        connection.close();
        
        return true;
    }
}
