
package sro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sro.db.util.ConnectionFactory;
import sro.modelo.Municipio;
import sro.modelo.Ocorrencia;
import sro.modelo.Vitima;


public class OcorrenciaDAO implements DAO<Ocorrencia>{

    private static final String INSERT = "INSERT INTO ocorrencia (data_ocorrencia,numero_agente, id_origem_comunicacao, id_status_ocorrencia, pronto_referencia_ocorrencia, rua_ocorrencia, bairro_ocorrencia, id_municipio, descricao_geral_ocorrencia, id_natureza_ocorrencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
   
    private static final String SELECT_ALL ="SELECT id_ocorrencia, oc.numero_agente, data_ocorrencia, data_registo, descricao_origem_comunicacao, descricao_status_ocorrencia, pronto_referencia_ocorrencia, rua_ocorrencia,"
            + " bairro_ocorrencia, comunca_ocorrencia, nome_municipio, descricao_natureza_ocorrencia,"
            + " descricao_geral_ocorrencia "
            + "FROM ocorrencia oc "
            + "INNER JOIN agente ag ON oc.numero_agente=ag.numero_agente "
            + "INNER JOIN origem_comunicacao cn ON oc.id_origem_comunicacao = cn.id_origem_comunicacao "
            + "INNER JOIN status_ocorrencia sto ON oc.id_status_ocorrencia=sto.id_status_ocorrencia"
            + " INNER JOIN municipio mn ON oc.id_municipio = mn.id_municipio "
            + "INNER JOIN natureza_ocorrencia noc ON oc.id_natureza_ocorrencia = noc.id_natureza_ocorrencia";
    
    private static final String SELECT_ALL_ENTRE_DATAS_OCORRENCIA = "SELECT id_ocorrencia, oc.numero_agente, data_ocorrencia, data_registo, descricao_origem_comunicacao, descricao_status_ocorrencia, pronto_referencia_ocorrencia, rua_ocorrencia,"
            + " bairro_ocorrencia, comunca_ocorrencia, nome_municipio, descricao_natureza_ocorrencia,"
            + " descricao_geral_ocorrencia "
            + "FROM ocorrencia oc "
            + "INNER JOIN agente ag ON oc.numero_agente=ag.numero_agente "
            + "INNER JOIN origem_comunicacao cn ON oc.id_origem_comunicacao = cn.id_origem_comunicacao "
            + "INNER JOIN status_ocorrencia sto ON oc.id_status_ocorrencia=sto.id_status_ocorrencia"
            + " INNER JOIN municipio mn ON oc.id_municipio = mn.id_municipio "
            + "INNER JOIN natureza_ocorrencia noc ON oc.id_natureza_ocorrencia = noc.id_natureza_ocorrencia WHERE data_ocorrencia Between ? and ? ORDER BY data_ocorrencia";
    
     private static final String SELECT_ALL_ENTRE_DATAS_POR_MUNICIPIO = "SELECT id_ocorrencia, oc.numero_agente, data_ocorrencia, data_registo, descricao_origem_comunicacao, descricao_status_ocorrencia, pronto_referencia_ocorrencia, rua_ocorrencia,"
            + " bairro_ocorrencia, comunca_ocorrencia, nome_municipio, descricao_natureza_ocorrencia,"
            + " descricao_geral_ocorrencia "
            + "FROM ocorrencia oc "
            + "INNER JOIN agente ag ON oc.numero_agente=ag.numero_agente "
            + "INNER JOIN origem_comunicacao cn ON oc.id_origem_comunicacao = cn.id_origem_comunicacao "
            + "INNER JOIN status_ocorrencia sto ON oc.id_status_ocorrencia=sto.id_status_ocorrencia"
            + " INNER JOIN municipio mn ON oc.id_municipio = mn.id_municipio "
            + "INNER JOIN natureza_ocorrencia noc ON oc.id_natureza_ocorrencia = noc.id_natureza_ocorrencia WHERE mn.id_municipio = ? data_ocorrencia Between ? and ? ORDER BY data_ocorrencia";
    
    
   
    
    @Override
    public Boolean guardar(Ocorrencia ocorrencia) {
      
   
        PreparedStatement ps = null;
     //   Connection conn = null;
      Connection conn = ConnectionFactory.getConnection();
        boolean flagControlo = false;
        try {
      //      conn = ConexaoDB.fezarConexao();
      
      
      /*
      data_ocorrencia 1,numero_agente2, id_origem_comunicacao3, 
      id_status_ocorrencia4, pronto_referencia_ocorrencia5,
      rua_ocorrencia, bairro_ocorrencia, id_municipio, 
      descricao_geral_ocorrencia, id_natureza_ocorrencia
      
      */
            ps = conn.prepareStatement(INSERT);
            ps.setDate(1, new java.sql.Date(ocorrencia.getDataOcorrencia().getTime()));
            ps.setString(2, ocorrencia.getAgente().getNumeroAgente());
            ps.setInt(3, ocorrencia.getOrigemComunicacao().getIdOrigemComunicacao());
            ps.setInt(4, ocorrencia.getStatusOcorrencia().getIdStatusOcorrencia());
            ps.setString(5, ocorrencia.getPontoReferenciaOcorrencia());
            ps.setString(6, ocorrencia.getRuaOcorrencia());
            ps.setString(7, ocorrencia.getBairroOcorrencia());
            ps.setInt(8, ocorrencia.getMunicipio().getIdMunicipio());
            ps.setString(9, ocorrencia.getDescricaoGeralOcorrencia());
            ps.setInt(10, ocorrencia.getNaturezaOcorrencia().getIdNaturezaOcorrencia());
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
    public Boolean modificar(Ocorrencia t) {
       return null;
    }

    @Override
    public Boolean eliminar(Ocorrencia t) {
           return null;
    }

    @Override
    public List<Ocorrencia> listarTodos() {
           return null;
    }

    @Override
    public Ocorrencia pesquisaPorId(int id) {
          return null;
    }
    
      public List<Ocorrencia> findAllPorIntervaloDataNascimento(Date inicio, Date fim) {
        PreparedStatement ps = null;
       // Connection conn = null;
         Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Ocorrencia> items = new ArrayList<>();
        try {
          //  conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(SELECT_ALL_ENTRE_DATAS_OCORRENCIA);
            ps.setDate(1, new java.sql.Date(inicio.getTime()));
            ps.setDate(2, new java.sql.Date(fim.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Ocorrencia item = new Ocorrencia();
//                popularComDados(item, rs);
                items.add(item);
            }
        } catch (SQLException ex) {
            System.err.println(":Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           // ConnectionDB.closeConnection(conn);
        }
        return items;
    }
    
    public List<Ocorrencia> findAllPorMunicipioIntervaloData(Municipio municipio, Date inicio, Date fim) {
        PreparedStatement ps = null;
      //  Connection conn = null;
      Connection conn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List<Ocorrencia> items = new ArrayList<>();
        try {
           // conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(SELECT_ALL_ENTRE_DATAS_POR_MUNICIPIO);
            ps.setInt(1, municipio.getIdMunicipio());
            ps.setDate(2, new java.sql.Date(inicio.getTime()));
            ps.setDate(3, new java.sql.Date(fim.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Ocorrencia item = new Ocorrencia();
//                popularComDados(item, rs);
                items.add(item);
            }
        } catch (SQLException ex) {
            System.err.println("VitimaDAO =>findAllPorMunicipioIntervaloData:Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           // ConnectionDB.closeConnection(conn);
        }
        return items;
    }
    /*
    private void popularComDados(Ocorrencia ocorrencia, ResultSet rs) {
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
    */
    
}
