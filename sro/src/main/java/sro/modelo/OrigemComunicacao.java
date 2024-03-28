
package sro.modelo;

import java.util.Objects;


public class OrigemComunicacao {
   private Integer idOrigemComunicacao;
   private String descricaoOrigemComunicacao;

    public OrigemComunicacao() {
    }

    public OrigemComunicacao(Integer idOrigemComunicacao, String descricaoOrigemComunicacao) {
        this.idOrigemComunicacao = idOrigemComunicacao;
        this.descricaoOrigemComunicacao = descricaoOrigemComunicacao;
    }

    public Integer getIdOrigemComunicacao() {
        return idOrigemComunicacao;
    }

    public void setIdOrigemComunicacao(Integer idOrigemComunicacao) {
        this.idOrigemComunicacao = idOrigemComunicacao;
    }

    public String getDescricaoOrigemComunicacao() {
        return descricaoOrigemComunicacao;
    }

    public void setDescricaoOrigemComunicacao(String descricaoOrigemComunicacao) {
        this.descricaoOrigemComunicacao = descricaoOrigemComunicacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idOrigemComunicacao);
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
        final OrigemComunicacao other = (OrigemComunicacao) obj;
        return Objects.equals(this.idOrigemComunicacao, other.idOrigemComunicacao);
    }

    @Override
    public String toString() {
        return "OrigemComunicacao{" + "descricaoOrigemComunicacao=" + descricaoOrigemComunicacao + '}';
    }
   
}
