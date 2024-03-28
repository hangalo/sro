/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sro.modelo;

import java.util.Objects;

public class Objecto {
    private Integer idObjecto;
    private String descricaoObjecto;

    public Objecto() {
    }

    public Objecto(Integer idObjecto, String descricaoObjecto) {
        this.idObjecto = idObjecto;
        this.descricaoObjecto = descricaoObjecto;
    }

    public Integer getIdObjecto() {
        return idObjecto;
    }

    public void setIdObjecto(Integer idObjecto) {
        this.idObjecto = idObjecto;
    }

    public String getDescricaoObjecto() {
        return descricaoObjecto;
    }

    public void setDescricaoObjecto(String descricaoObjecto) {
        this.descricaoObjecto = descricaoObjecto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idObjecto);
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
        final Objecto other = (Objecto) obj;
        return Objects.equals(this.idObjecto, other.idObjecto);
    }

    @Override
    public String toString() {
        return "Objecto{" + "descricaoObjecto=" + descricaoObjecto + '}';
    }
    
    
    
    
    
    
}
