/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aulas1316.ap.query;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.sampaiodias.dsp2019.aulas1316.ap.model.Lotacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Lucas Sampaio Dias
 */
public class ConsultaLotacao extends PersistenciaJdbc {
    
    private Lotacao lotacao;
    
    public ConsultaLotacao() {
        lotacao = new Lotacao(null, null, null, null, new Date(), new Date());
    }

    public Lotacao consultaPorId(Long id) throws Exception{

        preparaPersistencia();
        
        try {
            String sql = "SELECT * FROM LOTACAO WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,id);

            ResultSet rs = pstmt.executeQuery(  );
            while(rs.next()){
                lotacao.setId(rs.getLong("ID"));
                lotacao.setCargo(rs.getLong("ID_CARGO"));
                lotacao.setDepartamento(rs.getLong("ID_DEPARTAMENTO"));
                lotacao.setFuncionario(rs.getLong("ID_FUNCIONARIO"));
                lotacao.setDataInicial(rs.getString("DATA_INICIAL"));
                lotacao.setDataInicial(rs.getString("DATA_FINAL"));
            }

            rs.close();
            pstmt.close();
            stmt.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return lotacao;
    }
    
    public ArrayList<Lotacao> consultaTodos() 
            throws Exception{

        preparaPersistencia();
        ArrayList<Lotacao> lotacoes = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM LOTACAO";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery(  );
            while(rs.next()){
                Lotacao lot = new Lotacao(
                        rs.getLong("ID"),
                        rs.getLong("ID_CARGO"),
                        rs.getLong("ID_DEPARTAMENTO"),
                        rs.getLong("ID_FUNCIONARIO"),
                        rs.getString("DATA_INICIAL"),
                        rs.getString("DATA_FINAL")
                );
                lotacoes.add(lot);
            }

            rs.close();
            pstmt.close();
            stmt.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return lotacoes;
    }
    
    public ArrayList<Lotacao> consultaTodos(Long idCargo, Long idDepartamento) 
            throws Exception{

        preparaPersistencia();
        ArrayList<Lotacao> lotacoes = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM LOTACAO WHERE "
                    + "ID_CARGO = ? AND ID_DEPARTAMENTO = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,idCargo);
            pstmt.setLong(2,idDepartamento);

            ResultSet rs = pstmt.executeQuery(  );
            while(rs.next()){
                Lotacao lot = new Lotacao(
                        rs.getLong("ID"),
                        rs.getLong("ID_CARGO"),
                        rs.getLong("ID_DEPARTAMENTO"),
                        rs.getLong("ID_FUNCIONARIO"),
                        rs.getString("DATA_INICIAL"),
                        rs.getString("DATA_FINAL")
                );
                lotacoes.add(lot);
            }

            rs.close();
            pstmt.close();
            stmt.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return lotacoes;
    }
}
