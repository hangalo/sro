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
import sro.modelo.Municipio;
import sro.modelo.Provincia;

/**
 *
 * @author informatica
 */
public class MunicipioDAO implements DAO<Municipio> {

    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_ALL = "SELECT id_municipio, nome_municipio, nome_provincia FROM  municipio m INNER JOIN provincia p ON m.id_provincia = p.id_provincia";
    private static final String SELECT_BY_ID = "SELECT id_municipio, nome_municipio, nome_provincia FROM  municipio m INNER JOIN provincia p ON m.id_provincia = p.id_provincia WHERE m.id_municipio =?";
    private static final String SELECT_MUNICIPIO_BY_PROVINCIA = "SELECT id_municipio, nome_municipio, nome_provincia FROM  municipio m INNER JOIN provincia p ON m.id_provincia = p.id_provincia WHERE m.id_provincia = ?";

    @Override
    public Boolean guardar(Municipio t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean modificar(Municipio t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(Municipio t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Municipio> listarTodos() {
        PreparedStatement ps = null;
        //Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Municipio> municipios = new ArrayList<>();
        try {
          //  conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio municipio = new Municipio();
                popularComDados(municipio, rs);
                municipios.add(municipio);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
          //  ConexaoDB.fechar(conn, ps, rs);
        }
        return municipios;
    }

    @Override
    public Municipio pesquisaPorId(int id) {
        PreparedStatement ps = null;
        //Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Municipio municipio = new Municipio();

        try {
           // conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(municipio, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           //  ConexaoDB.fechar(conn, ps, rs);
        }

        return municipio;
    }
    
    public List<Municipio> findByIdProvincia(Provincia p) {
        PreparedStatement ps = null;
       // Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        System.out.println("Provincia DAO <<<<<=====" + p.getNomeProvincia());
         
        List<Municipio> municipios = new ArrayList<>();
        try {
           // conn = ConexaoDB.fezarConexao();
           
            ps = conn.prepareStatement(SELECT_MUNICIPIO_BY_PROVINCIA);
            ps.setInt(1, p.getIdProvincia());
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio municipio = new Municipio();
                popularComDados(municipio, rs);
                municipios.add(municipio);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
             ConexaoDB.fechar(conn, ps, rs);
        }
        return municipios;
    }

    private void popularComDados(Municipio municipio, ResultSet rs) {
        try {

            municipio.setIdMunicipio(rs.getInt("id_municipio"));
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            Provincia p = new Provincia();
            p.setNomeProvincia(rs.getString("nome_provincia"));
            municipio.setProvincia(p);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
