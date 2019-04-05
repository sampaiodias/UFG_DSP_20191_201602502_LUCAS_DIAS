/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.delete;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaDepartamento;
import java.sql.PreparedStatement;

/**
 * @author Lucas Sampaio Dias
 */
public class DeletaDepartamento extends PersistenciaJdbc {
    public boolean deletaDepartamento(Long id){
        boolean result = false;
        try {
            Departamento departamento = 
                    new ConsultaDepartamento().consultaPorId(id);
            if (departamento.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM DEPARTAMENTO WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O departamento foi excluido corretamente!");
                pstmt.close();
            }else{
                System.out.println(
                        "NÃ£o foi encontrado departamento com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
