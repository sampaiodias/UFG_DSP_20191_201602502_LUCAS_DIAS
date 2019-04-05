/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.query;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Lucas Sampaio Dias
 */
public class ConsultaFuncionario extends PersistenciaJdbc{
    private Funcionario funcionario;
    
    public ConsultaFuncionario() {
        funcionario = new Funcionario(null, null, null);
    }
    
    public Funcionario consultaPorId(Long id) throws Exception{

        preparaPersistencia();
        
        try {
            String sql = "SELECT * FROM FUNCIONARIO WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,id);

            ResultSet rs = pstmt.executeQuery(  );
            while(rs.next()){
                funcionario.setId(rs.getLong("ID"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setMatricula(rs.getLong("MATRICULA"));
            }

            rs.close();
            pstmt.close();
            stmt.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return funcionario;
    }
}
