/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sro.facesbean;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
import sro.modelo.EstadoCivil;
import sro.modelo.Sexo;

/**
 *
 * @author informatica
 */
@Named(value = "auxBean")
@RequestScoped
public class AuxBean {

     public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getAbreviatura()));
        }
        return list;
    }
     
       public List<SelectItem> getOpEstadoCivil() {
        List<SelectItem> list = new ArrayList<>();
        for (EstadoCivil estadoCivl : EstadoCivil.values()) {
            list.add(new SelectItem(estadoCivl, estadoCivl.getAbreviatura()));
        }
        return list;
    }
}
