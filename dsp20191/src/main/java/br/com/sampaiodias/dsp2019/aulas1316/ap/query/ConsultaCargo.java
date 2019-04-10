/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.query;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Cargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Lucas Sampaio Dias
 */
public class ConsultaCargo extends PersistenciaJdbc {
    private Cargo cargo;

    public ConsultaCargo() {
        cargo = new Cargo(null, null, null);
    }
    
    public Cargo consultaPorId(Long id) throws Exception{

        preparaPersistencia();
        
        try {
            String sql = "SELECT * FROM CARGO WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,id);

            ResultSet rs = pstmt.executeQuery(  );
            while(rs.next()){
                cargo.setId(rs.getLong("ID"));
                cargo.setNome(rs.getString("NOME"));
                cargo.setSalario(rs.getDouble("SALARIO"));
            }

            rs.close();
            pstmt.close();
            stmt.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return cargo;
    }
}
