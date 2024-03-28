/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sro.facesbean;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import sro.dao.MunicipioDAO;
import sro.modelo.Municipio;


@Named(value = "municipioBean")
@ViewScoped
public class MunicipioBean implements Serializable {

    List<Municipio> municipios = new ArrayList<>();
    Municipio municipio = new Municipio();
   MunicipioDAO municipioDAO = new MunicipioDAO();

    @PostConstruct
    public void init() {
        municipios = municipioDAO.listarTodos();

    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
    
    
     
    
}
