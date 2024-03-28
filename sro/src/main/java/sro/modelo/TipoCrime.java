/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sro.modelo;

import java.util.Objects;

public class TipoCrime {
    private Integer idTipoCrime;
    private String descricaoTipoCrime;
    private String detalhesTipoCrime;

    public TipoCrime() {
    }

    public TipoCrime(Integer idTipoCrime, String descricaoTipoCrime, String detalhesTipoCrime) {
        this.idTipoCrime = idTipoCrime;
        this.descricaoTipoCrime = descricaoTipoCrime;
        this.detalhesTipoCrime = detalhesTipoCrime;
    }

    public Integer getIdTipoCrime() {
        return idTipoCrime;
    }

    public void setIdTipoCrime(Integer idTipoCrime) {
        this.idTipoCrime = idTipoCrime;
    }

    public String getDescricaoTipoCrime() {
        return descricaoTipoCrime;
    }

    public void setDescricaoTipoCrime(String descricaoTipoCrime) {
        this.descricaoTipoCrime = descricaoTipoCrime;
    }

    public String getDetalhesTipoCrime() {
        return detalhesTipoCrime;
    }

    public void setDetalhesTipoCrime(String detalhesTipoCrime) {
        this.detalhesTipoCrime = detalhesTipoCrime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.idTipoCrime);
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
        final TipoCrime other = (TipoCrime) obj;
        return Objects.equals(this.idTipoCrime, other.idTipoCrime);
    }

    @Override
    public String toString() {
        return this.descricaoTipoCrime;
    }
    
    
}
