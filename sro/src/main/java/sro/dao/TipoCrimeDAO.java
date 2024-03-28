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
import sro.modelo.TipoCrime;

public class TipoCrimeDAO implements DAO<TipoCrime> {

    private static final String INSERT = "INSERT INTO tipo_crime(descricao_tipo_crime, detalhes_tipo_crime) VALUES( ?, ?)";
    private static final String UPDATE = "UPDATE tipo_crime SET descricao_tipo_crime = ?, detalhes_tipo_crime = ? WHERE id_tipo_crime = ?";
    private static final String DELETE = "DELETE FROM tipo_crime WHERE id_tipo_crime=?";
    private static final String SELECT_ALL = "SELECT id_tipo_crime, descricao_tipo_crime, detalhes_tipo_crime FROM  tipo_crime";
    private static final String SELECT_BY_ID = "SELECT id_tipo_crime, descricao_tipo_crime, detalhes_tipo_crime FROM  tipo_crime WHERE id_tipo_crime=?";

     DataBaseUtil dataBaseUtil = new DataBaseUtil();
    @Override
    public Boolean guardar(TipoCrime tipoCrime) {
        PreparedStatement ps = null;
       // Connection conn = null;
        
          Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
           // conn = ConexaoDB.fezarConexao();
           //   conn = dataBaseUtil.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, tipoCrime.getDescricaoTipoCrime());
            ps.setString(2, tipoCrime.getDetalhesTipoCrime());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getLocalizedMessage());
            e.printStackTrace();
            return false;
        } finally {
    //  ConexaoDB.fechar(ps);
    //  ConexaoDB.fechar(conn);
        }
    }

    @Override
    public Boolean modificar(TipoCrime tipoCrime) {
      PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, tipoCrime.getDescricaoTipoCrime());
            ps.setString(2, tipoCrime.getDetalhesTipoCrime());
            ps.setInt(3, tipoCrime.getIdTipoCrime());

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
            ConexaoDB.fechar(conn, ps);
        }
    }

    @Override
    public Boolean eliminar(TipoCrime tipoCrime) {
       Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (tipoCrime == null) {
            System.err.println("O campo  nao pode ser nulo");
        }

        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, tipoCrime.getIdTipoCrime());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao eliminar dados: " + e.getMessage());
            return false;
        } finally {
            ConexaoDB.fechar(conn, ps);
        }
    }

    @Override
    public List<TipoCrime> listarTodos() {
       PreparedStatement ps = null;
       // Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<TipoCrime> tipoCrimes = new ArrayList<>();
        try {
             conn = dataBaseUtil.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoCrime tipoCrime = new TipoCrime();
                popularComDados(tipoCrime, rs);
                tipoCrimes.add(tipoCrime);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           /// ConexaoDB.fechar(conn, ps, rs);
        }
        return tipoCrimes;
    }

    @Override
    public TipoCrime pesquisaPorId(int id) {
       Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = null;
     // Connection conn = null;
        ResultSet rs = null;
        TipoCrime tipoCrime = new TipoCrime();
        try {
         //   conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("ExameDAO:findById: nenhum registo com o id: " + id);
            }
            popularComDados(tipoCrime, rs);
        } catch (SQLException ex) {
            System.err.println("ExameDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            //ConexaoDB.fechar(conn, ps, rs);
        }
        return tipoCrime;
    
    
    }

    
     private void popularComDados(TipoCrime tipoCrime, ResultSet rs) {
        try {
            tipoCrime.setIdTipoCrime(rs.getInt("id_tipo_crime"));
            tipoCrime.setDescricaoTipoCrime(rs.getString("descricao_tipo_crime"));
            tipoCrime.setDetalhesTipoCrime(rs.getString("detalhes_tipo_crime"));
            

        } catch (SQLException ex) {
            System.err.println("TipoCrimeDAO: popularComDados: Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
