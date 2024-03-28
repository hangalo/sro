
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
import sro.modelo.OrigemComunicacao;



public class OrigemComunicacaoDAO implements DAO<OrigemComunicacao>{

    private static final String INSERT = "INSERT INTO origem_comunicacao(descricao_origem_comunicacao) VALUES(?);";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_ALL = "SELECT id_origem_comunicacao, descricao_origem_comunicacao FROM origem_comunicacao";
    private static final String SELECT_BY_ID ="SELECT id_origem_comunicacao, descricao_origem_comunicacao FROM origem_comunicacao WHERE id_origem_comunicacao =?";
    
   
    @Override
    
    public Boolean guardar(OrigemComunicacao origemComunicacao) {
        PreparedStatement ps = null;
    //    Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
        //    conn = dataBaseUtil.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, origemComunicacao.getDescricaoOrigemComunicacao());
           

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
    public Boolean modificar(OrigemComunicacao t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(OrigemComunicacao t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrigemComunicacao> listarTodos() {
        PreparedStatement ps = null;
       // Connection conn = null;
        ResultSet rs = null;
         Connection conn = ConnectionFactory.getConnection();
        List<OrigemComunicacao> origemComunicacoes = new ArrayList<>();
        try {
           // conn = ConexaoDB.fezarConexao();
           //  conn = dataBaseUtil.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrigemComunicacao origemComunicacao = new OrigemComunicacao();
                popularComDados(origemComunicacao, rs);
                origemComunicacoes.add(origemComunicacao);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
         ///   ConexaoDB.fechar(conn, ps, rs);
        }
        return origemComunicacoes;
    }

    @Override
    public OrigemComunicacao pesquisaPorId(int id) {
          PreparedStatement ps = null;
       // Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        OrigemComunicacao origemComunicacao = new OrigemComunicacao();
        try {
         //   conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("origemComunicacaoDAO:findById: nenhum registo com o id: " + id);
            }
                        popularComDados(origemComunicacao, rs);
        } catch (SQLException ex) {
            System.err.println("origemComunicacaoDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           //  ConexaoDB.fechar(conn, ps, rs);
        }
        return origemComunicacao;
    }
    
     private void popularComDados(OrigemComunicacao origemComunicacao, ResultSet rs) {
        try {
         
            origemComunicacao.setIdOrigemComunicacao(rs.getInt("id_origem_comunicacao"));
            origemComunicacao.setDescricaoOrigemComunicacao(rs.getString("descricao_origem_comunicacao"));
            

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

    
}
