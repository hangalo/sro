
package sro.modelo;

import java.util.Objects;


public class Crime {
    private Integer idCrime;
    private String descricaoCrime;
    private TipoCrime tipoCrime;

    public Crime() {
    }

    public Crime(Integer idCrime, String descricaoCrime, TipoCrime tipoCrime) {
        this.idCrime = idCrime;
        this.descricaoCrime = descricaoCrime;
        this.tipoCrime = tipoCrime;
    }

    public Integer getIdCrime() {
        return idCrime;
    }

    public void setIdCrime(Integer idCrime) {
        this.idCrime = idCrime;
    }

    public String getDescricaoCrime() {
        return descricaoCrime;
    }

    public void setDescricaoCrime(String descricaoCrime) {
        this.descricaoCrime = descricaoCrime;
    }

    public TipoCrime getTipoCrime() {
        return tipoCrime;
    }

    public void setTipoCrime(TipoCrime tipoCrime) {
        this.tipoCrime = tipoCrime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idCrime);
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
        final Crime other = (Crime) obj;
        return Objects.equals(this.idCrime, other.idCrime);
    }

    @Override
    public String toString() {
        return "Crime{" + "descricaoCrime=" + descricaoCrime + '}';
    }
    
    
}
