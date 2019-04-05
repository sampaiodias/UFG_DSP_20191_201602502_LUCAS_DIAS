/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.query;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Lucas Sampaio Dias
 */
public class ConsultaDepartamento extends PersistenciaJdbc  {
    private Departamento departamento;

    public ConsultaDepartamento() {
        departamento = new Departamento(null, null);
    }

    public Departamento consultaPorId(Long id) throws Exception{

        preparaPersistencia();
        
        try {
            String sql = "SELECT * FROM DEPARTAMENTO WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,id);

            ResultSet rs = pstmt.executeQuery(  );
            while(rs.next()){
                departamento.setId(rs.getLong("ID"));
                departamento.setNome(rs.getString("NOME"));
            }

            rs.close();
            pstmt.close();
            stmt.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return departamento;
    }
}
