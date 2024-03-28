package sro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sro.db.util.ConexaoDB;
import sro.db.util.ConnectionFactory;
import sro.modelo.Crime;
import sro.modelo.TipoCrime;

public class CrimeDAO implements DAO<Crime> {

    private static final String INSERT = "INSERT INTO crime(descricao_crime, id_tipo_crime) VALUES( ?, ?)";
    private static final String UPDATE = "UPDATE crime SET  descricao_crime = ?, id_tipo_crime = ? WHERE id_crime = ?";
    private static final String DELETE = "DELETE FROM crime WHERE id_crime = ?";
    private static final String SELECT_ALL = "SELECT id_crime, descricao_crime, descricao_tipo_crime, detalhes_tipo_crime FROM crime c INNER JOIN tipo_crime tc ON c.id_tipo_crime = tc.id_tipo_crime";
    private static final String SELECT_BY_ID = "SELECT id_crime, descricao_crime, descricao_tipo_crime, detalhes_tipo_crime FROM crime c INNER JOIN tipo_crime tc ON c.id_tipo_crime = tc.id_tipo_crime WHERE id_crime =?";
    private static final String SELECT_BY_NOME_CRIME = "SELECT id_crime, descricao_crime, descricao_tipo_crime, detalhes_tipo_crime FROM crime c INNER JOIN tipo_crime tc ON c.id_tipo_crime = tc.id_tipo_crime WHERE descricao_crime LIKE ?";
    private static final String SELECT_BY_TIPO_CRIME = " SELECT id_crime, descricao_crime, descricao_tipo_crime, detalhes_tipo_crime FROM crime c INNER JOIN tipo_crime tc ON c.id_tipo_crime = tc.id_tipo_crime WHERE tc.id_tipo_crime = ?";

    @Override
    public Boolean guardar(Crime crime) {
        PreparedStatement ps = null;
        //Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
            //  conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, crime.getDescricaoCrime());
            ps.setInt(2, crime.getTipoCrime().getIdTipoCrime());

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
            //  ConexaoDB.fechar(conn, ps);
        }
    }

    @Override
    public Boolean modificar(Crime crime) {
        PreparedStatement ps = null;
        // Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
            // conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, crime.getDescricaoCrime());
            ps.setInt(2, crime.getTipoCrime().getIdTipoCrime());
            ps.setInt(3, crime.getIdCrime());

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
            //  ConexaoDB.fechar(conn, ps);
        }
    }

    @Override
    public Boolean eliminar(Crime crime) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (crime == null) {
            System.err.println("O campo  nao pode ser nulo");
        }

        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, crime.getIdCrime());
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
    public List<Crime> listarTodos() {
        PreparedStatement ps = null;
      //  Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Crime> crimes = new ArrayList<>();
        try {
          // conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Crime crime = new Crime();
                popularComDados(crime, rs);
                crimes.add(crime);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:List<Crime> listarTodos() " + ex.getLocalizedMessage());
        } finally {
          ///  ConexaoDB.fechar(conn, ps, rs);
        }
        return crimes;
    }

    @Override
    public Crime pesquisaPorId(int id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Crime crime = new Crime();
        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("ExameDAO:findById: nenhum registo com o id: " + id);
            }
            popularComDados(crime, rs);
        } catch (SQLException ex) {
            System.err.println("ExameDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fechar(conn, ps, rs);
        }
        return crime;
    }

    public Crime pesquisaPorTipoExame(TipoCrime tipoCrime) {
        PreparedStatement ps = null;
        Connection conn = ConnectionFactory.getConnection();
        // Connection conn = null;
        ResultSet rs = null;
        Crime crime = new Crime();
        try {
            //   conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_TIPO_CRIME);
            ps.setInt(1, tipoCrime.getIdTipoCrime());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("ExameDAO:pesquisaPorTipoExame: nenhum registo com o id: " + tipoCrime.getIdTipoCrime());
            }
            popularComDados(crime, rs);
        } catch (SQLException ex) {
            System.err.println("ExameDAO:pesquisaPorTipoExame: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
         //   ConexaoDB.fechar(conn, ps, rs);
        }
        return crime;
    }

    public List<Crime> pesquisarPorNome(String valor) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Crime> crimes = new ArrayList<>();
        try {
            conn = ConexaoDB.fezarConexao();

            ps = conn.prepareStatement(SELECT_BY_NOME_CRIME);
            ps.setString(1, "%" + valor + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Crime crime = new Crime();
                popularComDados(crime, rs);
                crimes.add(crime);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fechar(conn, ps, rs);
        }
        return crimes;
    }

    private void popularComDados(Crime crime, ResultSet rs) {
        try {
            /*
            , , descricao_tipo_crime, detalhes_tipo_crime */
            crime.setIdCrime(rs.getInt("id_crime"));
            crime.setDescricaoCrime(rs.getString("descricao_crime"));

            TipoCrime tipoCrime = new TipoCrime();
            tipoCrime.setDescricaoTipoCrime(rs.getString("descricao_tipo_crime"));

            tipoCrime.setDetalhesTipoCrime(rs.getString("detalhes_tipo_crime"));
           
            crime.setTipoCrime(tipoCrime);

        } catch (SQLException ex) {
            System.err.println("ExameDAO: popularComDados: Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
