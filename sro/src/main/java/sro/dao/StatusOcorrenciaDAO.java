/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sro.db.util.ConexaoDB;
import sro.db.util.ConnectionFactory;
import sro.db.util.DataBaseUtil;

import sro.modelo.StatusOcorrencia;

/**
 *
 * @author informatica
 */
public class StatusOcorrenciaDAO implements DAO<StatusOcorrencia>{
   
    private static final String INSERT = "INSERT INTO status_ocorrencia (descricao_status_ocorrencia) VALUES(?)";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_ALL = "SELECT id_status_ocorrencia, descricao_status_ocorrencia FROM  status_ocorrencia";
    private static final String SELECT_BY_ID ="SELECT id_status_ocorrencia, descricao_status_ocorrencia FROM  status_ocorrencia WHERE id_status_ocorrencia =?";
   
   
    @Override
    public Boolean guardar(StatusOcorrencia statusOcorrencia) {
         PreparedStatement ps = null;
       // Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
          //  conn = ConexaoDB.fezarConexao();
          //  conn = dataBaseUtil.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, statusOcorrencia.getDescricaoStatusOcorrencia());
           

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
          //   ConexaoDB.fechar(conn, ps);
        }
    }

    @Override
    public Boolean modificar(StatusOcorrencia statusOcorrencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(StatusOcorrencia statusOcorrencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StatusOcorrencia> listarTodos() {
        PreparedStatement ps = null;
     //   Connection conn = null;
      Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<StatusOcorrencia> statusOcorrencias = new ArrayList<>();
        try {
           // conn = ConexaoDB.fezarConexao();
         //   conn = dataBaseUtil.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatusOcorrencia statusOcorrencia = new StatusOcorrencia();
                popularComDados(statusOcorrencia, rs);
                statusOcorrencias.add(statusOcorrencia);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
          //  ConexaoDB.fechar(conn, ps, rs);
        }
        return statusOcorrencias;
    }

    @Override
    public StatusOcorrencia pesquisaPorId(int id) {
          PreparedStatement ps = null;
        ///Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        StatusOcorrencia statusOcorrencia = new StatusOcorrencia();
        try {
          //  conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("StatusOcorrenciaSAO:findById: nenhum registo com o id: " + id);
            }
                        popularComDados(statusOcorrencia, rs);
        } catch (SQLException ex) {
            System.err.println("StatusOcorrenciaDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
          //ConexaoDB.fechar(conn, ps, rs);
        }
        return statusOcorrencia;
    }
    
     private void popularComDados(StatusOcorrencia statusOcorrencia, ResultSet rs) {
        try {
        
            statusOcorrencia.setIdStatusOcorrencia(rs.getInt("id_status_ocorrencia"));
            statusOcorrencia.setDescricaoStatusOcorrencia(rs.getString("descricao_status_ocorrencia"));
            

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
 
}
