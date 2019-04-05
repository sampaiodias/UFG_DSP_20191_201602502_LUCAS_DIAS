/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.delete;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import java.sql.PreparedStatement;

/**
 * @author Lucas Sampaio Dias
 */
public class DeletaCargo extends PersistenciaJdbc {
    public boolean deletaCargo(Long id){
        boolean result = false;
        try {
            Cargo cargo = new ConsultaCargo().consultaPorId(id);
            if (cargo.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM CARGO WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O cargo foi excluido corretamente!");
                pstmt.close();
            }else{
                System.out.println("NÃ£o foi encontrado cargo com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
