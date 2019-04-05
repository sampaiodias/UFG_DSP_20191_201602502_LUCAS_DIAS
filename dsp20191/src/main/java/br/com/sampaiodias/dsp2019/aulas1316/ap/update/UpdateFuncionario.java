/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.update;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;

/**
 * @author Lucas Sampaio Dias
 */
public class UpdateFuncionario extends PersistenciaJdbc{
    public boolean atualizaFuncionario(Funcionario funcionario) throws Exception {
        preparaPersistencia();
        
        String sql = "UPDATE FUNCIONARIO " +
                "SET ID = '" + funcionario.getId() +
                "', MATRICULA = '" + funcionario.getMatricula()+
                "', NOME = '" + funcionario.getNome() +
                "' WHERE ID = " + funcionario.getId();
        
        stmt.executeUpdate(sql);
        System.out.println("O departamento foi atualizado corretamente.");
        stmt.close();
        connection.close();
        
        return true;
    }
}
