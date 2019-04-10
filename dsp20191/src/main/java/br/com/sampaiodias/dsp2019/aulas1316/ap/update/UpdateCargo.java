/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.update;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;

/**
 * @author Lucas Sampaio Dias
 */
public class UpdateCargo extends PersistenciaJdbc {
    public boolean atualizaCargo(Cargo cargo) throws Exception {
        preparaPersistencia();
        
        String sql = "UPDATE CARGO " +
                "SET ID = '" + cargo.getId() +
                "', NOME = '" + cargo.getNome() +
                "', SALARIO = '" + cargo.getSalario()+
                "' WHERE ID = " + cargo.getId();
        
        stmt.executeUpdate(sql);
        System.out.println("O cargo foi atualizado corretamente.");
        stmt.close();
        connection.close();
        
        return true;
    }
}
