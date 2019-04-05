/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.delete;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaLotacao;
import java.sql.PreparedStatement;

/**
 * @author Lucas Sampaio Dias
 */
public class DeletaLotacao extends PersistenciaJdbc {
    public boolean deletaLotacao(Long id) {
        boolean result = false;
        try {
            Lotacao lotacao = 
                    new ConsultaLotacao().consultaPorId(id);
            if (lotacao.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM LOTACAO WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("A lotação foi excluida corretamente!");
                pstmt.close();
            }else{
                System.out.println(
                        "NÃ£o foi encontrado lotação com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
