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
import sro.modelo.NaturezaOcorrencia;



public class NaturezaOcorrenciaDAO implements DAO<NaturezaOcorrencia>{
    private static final String INSERT = "INSERT INTO natureza_ocorrencia(descricao_natureza_ocorrencia)VALUES(?);";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_ALL = "SELECT id_natureza_ocorrencia, descricao_natureza_ocorrencia FROM natureza_ocorrencia";
    private static final String SELECT_BY_ID ="SELECT id_natureza_ocorrencia, descricao_natureza_ocorrencia FROM natureza_ocorrencia WHERE id_natureza_ocorrencia = ?";
    DataBaseUtil dataBaseUtil = new DataBaseUtil();
    @Override
    
    public Boolean guardar(NaturezaOcorrencia naturezaOcorrencia) {
         PreparedStatement ps = null;
     //   Connection conn = null;
       Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
         //   conn = ConexaoDB.fezarConexao();
        //   conn = dataBaseUtil.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, naturezaOcorrencia.getDescricaoNaturezaOcorrencia());
           

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
           //  ConexaoDB.fechar(ps);
        }
    }

    @Override
    public Boolean modificar(NaturezaOcorrencia naturezaOcorrencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(NaturezaOcorrencia naturezaOcorrencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NaturezaOcorrencia> listarTodos() {
        PreparedStatement ps = null;
      //  Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<NaturezaOcorrencia> naturezaOcorrencias = new ArrayList<>();
        try {
           // conn = ConexaoDB.fezarConexao();
           //  conn = dataBaseUtil.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                NaturezaOcorrencia naturezaOcorrencia = new NaturezaOcorrencia();
                popularComDados(naturezaOcorrencia, rs);
                naturezaOcorrencias.add(naturezaOcorrencia);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
        //    ConexaoDB.fechar(conn, ps, rs);
        }
        return naturezaOcorrencias;
    }

    @Override
    public NaturezaOcorrencia pesquisaPorId(int id) {
          PreparedStatement ps = null;
      //  Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        NaturezaOcorrencia naturezaOcorrencia = new NaturezaOcorrencia();
        try {
          //  conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("origemComunicacaoDAO:findById: nenhum registo com o id: " + id);
            }
                        popularComDados(naturezaOcorrencia, rs);
        } catch (SQLException ex) {
            System.err.println("origemComunicacaoDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
          //   ConexaoDB.fechar(conn, ps, rs);
        }
        return naturezaOcorrencia;
    }
    
     private void popularComDados(NaturezaOcorrencia naturezaOcorrencia, ResultSet rs) {
        try {
        
            naturezaOcorrencia.setIdNaturezaOcorrencia(rs.getInt("id_natureza_ocorrencia"));
            naturezaOcorrencia.setDescricaoNaturezaOcorrencia(rs.getString("descricao_natureza_ocorrencia"));
            

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
