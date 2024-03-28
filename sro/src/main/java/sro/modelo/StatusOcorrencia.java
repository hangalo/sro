
package sro.modelo;

import java.util.Objects;


public class StatusOcorrencia {
    private Integer idStatusOcorrencia;
    private String descricaoStatusOcorrencia;

    public StatusOcorrencia() {
    }

    public StatusOcorrencia(Integer idStatusOcorrencia, String descricaoStatusOcorrencia) {
        this.idStatusOcorrencia = idStatusOcorrencia;
        this.descricaoStatusOcorrencia = descricaoStatusOcorrencia;
    }

   
    public Integer getIdStatusOcorrencia() {
        return idStatusOcorrencia;
    }

    public void setIdStatusOcorrencia(Integer idStatusOcorrencia) {
        this.idStatusOcorrencia = idStatusOcorrencia;
    }

    public String getDescricaoStatusOcorrencia() {
        return descricaoStatusOcorrencia;
    }

    public void setDescricaoStatusOcorrencia(String descricaoStatusOcorrencia) {
        this.descricaoStatusOcorrencia = descricaoStatusOcorrencia;
    }

   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idStatusOcorrencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StatusOcorrencia other = (StatusOcorrencia) obj;
        return Objects.equals(this.idStatusOcorrencia, other.idStatusOcorrencia);
    }

    @Override
    public String toString() {
        return "StatusOcorrencia{" + "descricaoOcorrencia=" + descricaoStatusOcorrencia + '}';
    }
    
}
