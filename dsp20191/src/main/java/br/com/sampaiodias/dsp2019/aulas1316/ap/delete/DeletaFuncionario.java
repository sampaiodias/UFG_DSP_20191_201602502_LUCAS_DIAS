/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.delete;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaFuncionario;
import java.sql.PreparedStatement;

/**
 * @author Lucas Sampaio Dias
 */
public class DeletaFuncionario extends PersistenciaJdbc {
    public boolean deletaFuncionario(Long id){
        boolean result = false;
        try {
            Funcionario funcionario = 
                    new ConsultaFuncionario().consultaPorId(id);
            if (funcionario.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM FUNCIONARIO WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O funcionário foi excluido corretamente!");
                pstmt.close();
            }else{
                System.out.println(
                        "NÃ£o foi encontrado funcionário com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
