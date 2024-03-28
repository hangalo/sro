
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
import sro.modelo.Sexo;
import sro.modelo.Suspeito;



public class SuspeitoDAO implements DAO<Suspeito>{
    
    private static final String INSERT = "INSERT INTO suspeito( bi_suspeito, numero_contribuinte, nome_suspeito, sobrenome_suspeito, data_nasicmento, sexo_suspeito, casa_suspeito, rua_suspeito, bairro_suspeito, comuna_suspeito, id_municipio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_ALL = "SELECT id_suspeito, bi_suspeito, numero_contribuinte, nome_suspeito, sobrenome_suspeito, data_nasicmento, casa_suspeito, rua_suspeito, bairro_suspeito, sexo_suspeito, comuna_suspeito, nome_municipio FROM suspeito s INNER JOIN municipio m ON s.id_municipio=m.id_municipio";
    private static final String SELECT_BY_ID = "SELECT id_suspeito, bi_suspeito, numero_contribuinte, nome_suspeito, sobrenome_suspeito, data_nasicmento, casa_suspeito, rua_suspeito, bairro_suspeito, sexo_suspeito,comuna_suspeito, nome_municipio FROM suspeito s INNER JOIN municipio m ON s.id_municipio=m.id_municipio WHERE id_suspeito =?";
    private static final String SELECT_BY_NOME = "SELECT id_suspeito, bi_suspeito, numero_contribuinte, nome_suspeito, sobrenome_suspeito, data_nasicmento, casa_suspeito, rua_suspeito, bairro_suspeito, sexo_suspeito, comuna_suspeito, nome_municipio FROM suspeito s INNER JOIN municipio m ON s.id_municipio=m.id_municipio WHERE bi_suspeito LIKE ? OR numero_contribuinte LIKE ? OR nome_suspeito LIKE ? OR sobrenome_suspeito LIKE ?";
    private static final String SELECT_ALL_ENTRE_DATAS_NASCIMENTO = "SELECT id_suspeito, bi_suspeito, numero_contribuinte, nome_suspeito, sobrenome_suspeito, data_nasicmento, casa_suspeito, rua_suspeito, bairro_suspeito, sexo_suspeito, comuna_suspeito, nome_municipio FROM suspeito s INNER JOIN municipio m ON s.id_municipio=m.id_municipio  WHERE data_nasicmento Between ? and ? ORDER BY nome_suspeito, sobrenome_suspeito";
    private static final String SELECT_ALL_ENTRE_DATAS_POR_MUNICIPIO="SELECT id_suspeito, bi_suspeito, numero_contribuinte, nome_suspeito, sobrenome_suspeito, data_nasicmento, casa_suspeito, rua_suspeito, bairro_suspeito, sexo_suspeito, comuna_suspeito, nome_municipio FROM suspeito s INNER JOIN municipio m ON s.id_municipio=m.id_municipio WHERE s.id_municipio = ? AND data_nasicmento Between ? and ?  ORDER BY nome_suspeito, sobrenome_suspeito";
    @Override
    public Boolean guardar(Suspeito suspeito) {
        PreparedStatement ps = null;
      //  Connection conn = null;
       Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
         //   conn = ConexaoDB.fezarConexao();
         /*
         bi_suspeito, numero_contribuinte, nome_suspeito, sobrenome_suspeito,
         data_nasicmento, sexo_suspeito, casa_suspeito, rua_suspeito, 
         bairro_suspeito, comuna_suspeito, id_municipio
         */
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, suspeito.getNumeroBI());
            ps.setString(2, suspeito.getNumeroContribuinte());
            ps.setString(3, suspeito.getNomeSuspeito());
            ps.setString(4, suspeito.getSobrenomeSuspeito());
            ps.setDate(5, new java.sql.Date(suspeito.getDataNascimento().getTime()));
            ps.setString(6, suspeito.getSexo().getAbreviatura());
            ps.setString(7, suspeito.getCasaSuspeito());
            ps.setString(8, suspeito.getRuaSuspeito());
            ps.setString(9, suspeito.getBairroSuspeito());
            ps.setString(10, suspeito.getComunaSuspeito());
            ps.setInt(11, suspeito.getMunicipio().getIdMunicipio());
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
    public Boolean modificar(Suspeito suspeito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(Suspeito suspeito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Suspeito> listarTodos() {
        PreparedStatement ps = null;
       // Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Suspeito> suspeitos = new ArrayList<>();
        try {
          //  conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Suspeito suspeito = new Suspeito();
                popularComDados(suspeito, rs);
                suspeitos.add(suspeito);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados=>listarTodos: " + ex.getLocalizedMessage());
        } finally {
        ///    ConexaoDB.fechar(conn, ps, rs);
        }
        return suspeitos;
    }

    @Override
    public Suspeito pesquisaPorId(int id) {
        PreparedStatement ps = null;
           Connection conn = ConnectionFactory.getConnection();
      //  Connection conn = null;
        ResultSet rs = null;
        Suspeito suspeito = new Suspeito();
        try {
        //    conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("origemComunicacaoDAO:findById: nenhum registo com o id: " + id);
            }
            popularComDados(suspeito, rs);
        } catch (SQLException ex) {
            System.err.println("origemComunicacaoDAO:findeByID: Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
        //    ConexaoDB.fechar(conn, ps, rs);
        }
        return suspeito;
    }
    
    public List<Suspeito> findByNomeSobrenome(String valor) {
        PreparedStatement ps = null;
      //  Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Suspeito> suspeitos = new ArrayList<>();
        try {
       //     conn = ConexaoDB.fezarConexao();;
            ps = conn.prepareStatement(SELECT_BY_NOME);
            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");
            ps.setString(3, "%" + valor + "%");
            ps.setString(4, "%" + valor + "%");
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Suspeito suspeito = new Suspeito();
                popularComDados(suspeito, rs);
                suspeitos.add(suspeito);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
        //    ConexaoDB.fechar(conn, ps, rs);
        }
        return suspeitos;
    }

     public List<Suspeito> findAllPorIntervaloDataNascimento(Date inicio, Date fim) {
        PreparedStatement ps = null;
       // Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Suspeito> items = new ArrayList<>();
        try {
          //  conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(SELECT_ALL_ENTRE_DATAS_NASCIMENTO);
            ps.setDate(1, new java.sql.Date(inicio.getTime()));
            ps.setDate(2, new java.sql.Date(fim.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Suspeito item = new Suspeito();
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
    
    public List<Suspeito> findAllPorMunicipioIntervaloData(Municipio municipio, Date inicio, Date fim) {
        PreparedStatement ps = null;
      //  Connection conn = null;
      Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Suspeito> items = new ArrayList<>();
        try {
           // conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(SELECT_ALL_ENTRE_DATAS_POR_MUNICIPIO);
            ps.setInt(1, municipio.getIdMunicipio());
            ps.setDate(2, new java.sql.Date(inicio.getTime()));
            ps.setDate(3, new java.sql.Date(fim.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Suspeito item = new Suspeito();
                popularComDados(item, rs);
                items.add(item);
            }
        } catch (SQLException ex) {
            System.err.println("SuspeitoDAO =>findAllPorMunicipioIntervaloData:Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           // ConnectionDB.closeConnection(conn);
        }
        return items;
    }
     
    private void popularComDados(Suspeito suspeito, ResultSet rs) {
        try {

            suspeito.setIdSuspeito(rs.getInt("id_suspeito"));
            suspeito.setNumeroBI(rs.getString("bi_suspeito"));
            suspeito.setNumeroContribuinte(rs.getString("numero_contribuinte"));
            suspeito.setNomeSuspeito(rs.getString("nome_suspeito"));
            suspeito.setSobrenomeSuspeito(rs.getString("sobrenome_suspeito"));
            suspeito.setDataNascimento(rs.getDate("data_nasicmento"));
            suspeito.setSexo(Sexo.getAbreviatura(rs.getString("sexo_suspeito")));
            suspeito.setCasaSuspeito(rs.getString("casa_suspeito"));
            suspeito.setRuaSuspeito(rs.getString("rua_suspeito"));
            suspeito.setBairroSuspeito(rs.getString("bairro_suspeito"));
            suspeito.setComunaSuspeito(rs.getString("comuna_suspeito"));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            suspeito.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados SuspeitoDAO=>popularComDados: " + ex.getLocalizedMessage());
        }
    }
}
