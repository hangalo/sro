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
import java.util.Date;
import java.util.List;
import sro.db.util.ConexaoDB;
import sro.db.util.ConnectionFactory;
import sro.modelo.Municipio;
import sro.modelo.OrigemComunicacao;
import sro.modelo.Sexo;
import sro.modelo.Vitima;

/**
 *
 * @author informatica
 */
public class VitimaDAO implements DAO<Vitima> {

    private static final String INSERT = "INSERT INTO vitima(numero_bi, numero_contribuinte, nome_vitima, sobrenome_vitima, data_nascimento_vitima, sexo_vitima, casa_vitima, rua_vitima, bairro_vitima, comuna_vitima, id_municipio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_ALL = "SELECT id_vitima, numero_bi, numero_contribuinte, nome_vitima, sobrenome_vitima, data_nascimento_vitima, sexo_vitima, casa_vitima, rua_vitima, bairro_vitima, comuna_vitima, nome_municipio FROM vitima v INNER JOIN municipio m ON v.id_municipio = m.id_municipio";
    private static final String SELECT_BY_ID = "SELECT id_vitima, numero_bi, numero_contribuinte, nome_vitima, sobrenome_vitima, data_nascimento_vitima, sexo_vitima, casa_vitima, rua_vitima, bairro_vitima, comuna_vitima, nome_municipio FROM vitima v INNER JOIN municipio m ON v.id_municipio = m.id_municipio WHERE id_vitima =?";
    private static final String SELECT_BY_NOME = "SELECT id_vitima, numero_bi, numero_contribuinte, nome_vitima, sobrenome_vitima, data_nascimento_vitima, sexo_vitima, casa_vitima, rua_vitima, bairro_vitima, comuna_vitima, nome_municipio FROM vitima v INNER JOIN municipio m ON v.id_municipio = m.id_municipio WHERE numero_bi LIKE ? OR numero_contribuinte LIKE ? OR nome_vitima LIKE ? OR sobrenome_vitima LIKE ?";
    private static final String SELECT_ALL_ENTRE_DATAS_NASCIMENTO = "SELECT id_vitima, numero_bi, numero_contribuinte, nome_vitima, sobrenome_vitima, data_nascimento_vitima, sexo_vitima, casa_vitima, rua_vitima, bairro_vitima, comuna_vitima, nome_municipio FROM vitima v INNER JOIN municipio m ON v.id_municipio = m.id_municipio WHERE data_nascimento_vitima Between ? and ? ORDER BY nome_vitima, sobrenome_vitima";
    private static final String SELECT_ALL_ENTRE_DATAS_POR_MUNICIPIO="SELECT id_vitima, numero_bi, numero_contribuinte, nome_vitima, sobrenome_vitima, data_nascimento_vitima, sexo_vitima, casa_vitima, rua_vitima, bairro_vitima, comuna_vitima, nome_municipio FROM vitima v INNER JOIN municipio m ON v.id_municipio = m.id_municipio WHERE v.id_municipio = ? AND data_nascimento_vitima Between ? and ?  ORDER BY nome_vitima, sobrenome_vitima";
    @Override
    public Boolean guardar(Vitima vitima) {
        PreparedStatement ps = null;
      //  Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
          
          //  conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, vitima.getNumeroBI());
            ps.setString(2, vitima.getNumeroContribuinte());
            ps.setString(3, vitima.getNomeVitima());
            ps.setString(4, vitima.getSobrenomeVitima());
            ps.setDate(5, new java.sql.Date(vitima.getDataNascimentoVitima().getTime()));
            ps.setString(6, vitima.getSexo().getAbreviatura());
            ps.setString(7, vitima.getCasaVitima());
            ps.setString(8, vitima.getRuaVitima());
            ps.setString(9, vitima.getBairroVitima());
            ps.setString(10, vitima.getComunaVitima());
            ps.setInt(11, vitima.getMunicipio().getIdMunicipio());
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
    public Boolean modificar(Vitima vitima) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(Vitima vitima) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vitima> listarTodos() {
        PreparedStatement ps = null;
       // Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Vitima> vitimas = new ArrayList<>();
        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vitima vitima = new Vitima();
                popularComDados(vitima, rs);
                vitimas.add(vitima);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
         //   ConexaoDB.fechar(conn, ps, rs);
        }
        return vitimas;
    }

    @Override
    public Vitima pesquisaPorId(int id) {
        PreparedStatement ps = null;
       // Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Vitima vitima = new Vitima();
        try {
          //  conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("origemComunicacaoDAO:findById: nenhum registo com o id: " + id);
            }
            popularComDados(vitima, rs);
        } catch (SQLException ex) {
            System.err.println("origemComunicacaoDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
         //   ConexaoDB.fechar(conn, ps, rs);
        }
        return vitima;
    }
    
    public List<Vitima> findByNomeSobrenome(String valor) {
        PreparedStatement ps = null;
       // Connection conn = null;
        Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Vitima> vitimas = new ArrayList<>();
        try {
          //  conn = ConexaoDB.fezarConexao();;
            ps = conn.prepareStatement(SELECT_BY_NOME);
            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");
            ps.setString(3, "%" + valor + "%");
            ps.setString(4, "%" + valor + "%");
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Vitima vitima = new Vitima();
                popularComDados(vitima, rs);
                vitimas.add(vitima);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           // ConexaoDB.fechar(conn, ps, rs);
        }
        return vitimas;
    }

    
     public List<Vitima> findAllPorIntervaloDataNascimento(Date inicio, Date fim) {
        PreparedStatement ps = null;
       // Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Vitima> items = new ArrayList<>();
        try {
          //  conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(SELECT_ALL_ENTRE_DATAS_NASCIMENTO);
            ps.setDate(1, new java.sql.Date(inicio.getTime()));
            ps.setDate(2, new java.sql.Date(fim.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Vitima item = new Vitima();
                popularComDados(item, rs);
                items.add(item);
            }
        } catch (SQLException ex) {
            System.err.println(":Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           // ConnectionDB.closeConnection(conn);
        }
        return items;
    }
    
    public List<Vitima> findAllPorMunicipioIntervaloData(Municipio municipio, Date inicio, Date fim) {
        PreparedStatement ps = null;
      //  Connection conn = null;
      Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Vitima> items = new ArrayList<>();
        try {
           // conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(SELECT_ALL_ENTRE_DATAS_POR_MUNICIPIO);
            ps.setInt(1, municipio.getIdMunicipio());
            ps.setDate(2, new java.sql.Date(inicio.getTime()));
            ps.setDate(3, new java.sql.Date(fim.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Vitima item = new Vitima();
                popularComDados(item, rs);
                items.add(item);
            }
        } catch (SQLException ex) {
            System.err.println("VitimaDAO =>findAllPorMunicipioIntervaloData:Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           // ConnectionDB.closeConnection(conn);
        }
        return items;
    }
    
    
    
    
    
    private void popularComDados(Vitima vitima, ResultSet rs) {
        try {

            vitima.setIdVitima(rs.getInt("id_vitima"));
            vitima.setNumeroBI(rs.getString("numero_bi"));
            vitima.setNumeroContribuinte(rs.getString("numero_contribuinte"));
            vitima.setNomeVitima(rs.getString("nome_vitima"));
            vitima.setSobrenomeVitima(rs.getString("sobrenome_vitima"));
            vitima.setDataNascimentoVitima(rs.getDate("data_nascimento_vitima"));
            vitima.setSexo(Sexo.getAbreviatura(rs.getString("sexo_vitima")));
            vitima.setCasaVitima(rs.getString("casa_vitima"));
            vitima.setRuaVitima(rs.getString("rua_vitima"));
            vitima.setBairroVitima(rs.getString("bairro_vitima"));
            vitima.setComunaVitima(rs.getString("comuna_vitima"));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            vitima.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
