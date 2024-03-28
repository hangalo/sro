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
import sro.modelo.Agente;
import sro.modelo.Sexo;

public class AgenteDAO implements DAO<Agente> {

    private static final String INSERT = "INSERT INTO agente(numero_agente, nome_agente, sobrenome_agente, data_nascimento, sexo_agente, telefone_movicel_agente,telefone_unitel_agente, telefone_africell_agente, email_agente ) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM crime WHERE id_crime = ?";
    private static final String SELECT_ALL = "SELECT numero_agente, nome_agente, sobrenome_agente, data_nascimento, sexo_agente, telefone_movicel_agente,telefone_unitel_agente, telefone_africell_agente, email_agente FROM agente";
    private static final String SELECT_BY_ID = "SELECT numero_agente, nome_agente, sobrenome_agente, data_nascimento, sexo_agente, telefone_movicel_agente,telefone_unitel_agente, telefone_africell_agente, email_agente FROM agente WHERE numero_agente =?";
    private static final String SELECT_BY_NOME = "SELECT numero_agente, nome_agente, sobrenome_agente, data_nascimento, sexo_agente, telefone_movicel_agente,telefone_unitel_agente, telefone_africell_agente, email_agente FROM agente WHERE numero_agente LIKE ? OR nome_agente LIKE ? OR sobrenome_agente LIKE ? OR telefone_movicel_agente LIKE ? OR telefone_unitel_agente LIKE ? OR telefone_africell_agente LIKE ?  ";

    @Override
    public Boolean guardar(Agente agente) {

        PreparedStatement ps = null;
        //Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
          //  conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, agente.getNumeroAgente());
            ps.setString(2, agente.getNomeAgente());
            ps.setString(3, agente.getSobrenomeAgente());
            ps.setDate(4, new java.sql.Date(agente.getDataNascimento().getTime()));
            ps.setString(5, agente.getSexo().getAbreviatura());
            ps.setString(6, agente.getTelefoneMovicel());
            ps.setString(7, agente.getTelefoneUnitel());
            ps.setString(8, agente.getTelefoneAfricell());
            ps.setString(9, agente.getEmailAgente());

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
    public Boolean modificar(Agente t) {
        return null;
    }

    @Override
    public Boolean eliminar(Agente t) {
        return null;
    }

    @Override
    public List<Agente> listarTodos() {
        PreparedStatement ps = null;
       // Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Agente> agentes = new ArrayList<>();
        try {
         ///   conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Agente agente = new Agente();
                popularComDados(agente, rs);
                agentes.add(agente);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
       ///     ConexaoDB.fechar(conn, ps, rs);
        }
        return agentes;
    }

    @Override
    public Agente pesquisaPorId(int id) {
        return null;
    }

    public List<Agente> findByNomeSobrenome(String valor) {
        PreparedStatement ps = null;
       // Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Agente> agentes = new ArrayList<>();
        try {
          //  conn = ConexaoDB.fezarConexao();;
            ps = conn.prepareStatement(SELECT_BY_NOME);
            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");
            ps.setString(3, "%" + valor + "%");
            ps.setString(4, "%" + valor + "%");
            ps.setString(5, "%" + valor + "%");
            ps.setString(6, "%" + valor + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Agente agente = new Agente();
                popularComDados(agente, rs);
                agentes.add(agente);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
        //    ConexaoDB.fechar(conn, ps, rs);
        }
        return agentes;
    }

    private void popularComDados(Agente agente, ResultSet rs) {
        try {
            agente.setNumeroAgente(rs.getString("numero_agente"));
            agente.setNomeAgente(rs.getString("nome_agente"));
            agente.setSobrenomeAgente(rs.getString("sobrenome_agente"));
            agente.setDataNascimento(rs.getDate("data_nascimento"));

            agente.setSexo(Sexo.getAbreviatura(rs.getString("sexo_agente")));
            agente.setTelefoneMovicel(rs.getString("telefone_movicel_agente"));
            agente.setTelefoneUnitel(rs.getString("telefone_unitel_agente"));
            agente.setTelefoneAfricell(rs.getString("telefone_africell_agente"));
            agente.setEmailAgente(rs.getString("email_agente"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
