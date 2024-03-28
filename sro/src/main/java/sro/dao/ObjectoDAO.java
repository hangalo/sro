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
import sro.modelo.Objecto;
import sro.modelo.TipoCrime;

/**
 *
 * @author informatica
 */
public class ObjectoDAO implements DAO<Objecto>{
    private static final String INSERT = "INSERT INTO tipo_crime(descricao_tipo_crime, detalhes_tipo_crime) VALUES( ?, ?)";
    private static final String UPDATE = "UPDATE tipo_crime SET descricao_tipo_crime = ?, detalhes_tipo_crime = ? WHERE id_tipo_crime = ?";
    private static final String DELETE = "DELETE FROM tipo_crime WHERE id_tipo_crime=?";
    private static final String SELECT_ALL = "SELECT id_objecto, descricao_objecto FROM objecto";
    private static final String SELECT_BY_ID = "SELECT id_objecto, descricao_objecto FROM objecto WHERE id_objecto=?";

    @Override
    public Boolean guardar(Objecto objecto) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, objecto.getDescricaoObjecto());
          

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
    public Boolean modificar(Objecto objecto) {
      PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, objecto.getDescricaoObjecto());
           
            ps.setInt(3, objecto.getIdObjecto());

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
    public Boolean eliminar(Objecto objecto) {
       Connection conn = null;
        PreparedStatement ps = null;
        boolean flagControlo = false;
        if (objecto == null) {
            System.err.println("O campo  nao pode ser nulo");
        }

        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, objecto.getIdObjecto());
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
    public List<Objecto> listarTodos() {
       PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Objecto> objectos = new ArrayList<>();
        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Objecto objecto = new Objecto();
                popularComDados(objecto, rs);
                objectos.add(objecto);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fechar(conn, ps, rs);
        }
        return objectos;
    }

    @Override
    public Objecto pesquisaPorId(int id) {
    
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Objecto objecto = new Objecto();
        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("ExameDAO:findById: nenhum registo com o id: " + id);
            }
            popularComDados(objecto, rs);
        } catch (SQLException ex) {
            System.err.println("ExameDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fechar(conn, ps, rs);
        }
        return objecto;
    
    
    }

    
     private void popularComDados(Objecto objecto, ResultSet rs) {
        try {
            objecto.setIdObjecto(rs.getInt("id_objecto"));
            objecto.setDescricaoObjecto(rs.getString("descricao_objecto"));
           
            

        } catch (SQLException ex) {
            System.err.println("TipoCrimeDAO: popularComDados: Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
