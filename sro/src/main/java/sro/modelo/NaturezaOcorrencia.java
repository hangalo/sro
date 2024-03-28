
package sro.modelo;

import java.util.Objects;


public class NaturezaOcorrencia {
    private Integer idNaturezaOcorrencia;
    private String descricaoNaturezaOcorrencia;

    public NaturezaOcorrencia() {
    }

    public NaturezaOcorrencia(Integer idNaturezaOcorrencia, String descricaoNaturezaOcorrencia) {
        this.idNaturezaOcorrencia = idNaturezaOcorrencia;
        this.descricaoNaturezaOcorrencia = descricaoNaturezaOcorrencia;
    }

    public Integer getIdNaturezaOcorrencia() {
        return idNaturezaOcorrencia;
    }

    public void setIdNaturezaOcorrencia(Integer idNaturezaOcorrencia) {
        this.idNaturezaOcorrencia = idNaturezaOcorrencia;
    }

    public String getDescricaoNaturezaOcorrencia() {
        return descricaoNaturezaOcorrencia;
    }

    public void setDescricaoNaturezaOcorrencia(String descricaoNaturezaOcorrencia) {
        this.descricaoNaturezaOcorrencia = descricaoNaturezaOcorrencia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idNaturezaOcorrencia);
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
        final NaturezaOcorrencia other = (NaturezaOcorrencia) obj;
        return Objects.equals(this.idNaturezaOcorrencia, other.idNaturezaOcorrencia);
    }

    @Override
    public String toString() {
        return "NaturezaOcorrencia{" + "descricaoNaturezaOcorrencia=" + descricaoNaturezaOcorrencia + '}';
    }
    
}
