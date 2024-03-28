
package sro.modelo;

import java.util.Objects;


public class Provincia {
    private Integer idProvincia;
    private String nomeProvincia;

    public Provincia() {
    }

    public Provincia(Integer idProvincia, String nomeProvincia) {
        this.idProvincia = idProvincia;
        this.nomeProvincia = nomeProvincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNomeProvincia() {
        return nomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        this.nomeProvincia = nomeProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idProvincia);
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
        final Provincia other = (Provincia) obj;
        return Objects.equals(this.idProvincia, other.idProvincia);
    }

    @Override
    public String toString() {
        return "Provincia{" + "nomeProvincia=" + nomeProvincia + '}';
    }
    
}
