
package sro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import sro.db.util.ConexaoDB;
import sro.modelo.ItensOcorrencia;


public class ItensOcorrenciaDAO implements DAO<ItensOcorrencia>{
/**/
    private static final String INSERT = "INSERT INTO itens_ocorrencia (id_crime, id_ocorrencia,id_vitima, id_suspeito, id_objecto, anexos) VALUES (?, ?, ?, ?, ?, ?)";
    @Override
    public Boolean guardar(ItensOcorrencia itensOcorrencia) {
      
        /*
        
         id_objecto, anexos
        */
   
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        try {
            conn = ConexaoDB.fezarConexao();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, itensOcorrencia.getCrime().getIdCrime());
            ps.setInt(2,itensOcorrencia.getOcorrencia().getIdOcorrencia());
            ps.setInt(3, itensOcorrencia.getVitima().getIdVitima());
            ps.setInt(4, itensOcorrencia.getSuspeito().getIdSuspeito());
            ps.setBytes(6, itensOcorrencia.getAnexo());
            ps.setInt(7, itensOcorrencia.getObjecto().getIdObjecto());
            ps.setString(8, itensOcorrencia.getUrlAnexo());
           
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
    public Boolean modificar(ItensOcorrencia t) {
        return null;
    }

    @Override
    public Boolean eliminar(ItensOcorrencia t) {
      return null;
    }

    @Override
    public List<ItensOcorrencia> listarTodos() {
    return null;
    }

    @Override
    public ItensOcorrencia pesquisaPorId(int id) {
      return null;
    }
    
}
