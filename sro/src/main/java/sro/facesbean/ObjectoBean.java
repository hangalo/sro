/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sro.facesbean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import sro.dao.ObjectoDAO;
import sro.modelo.Objecto;

/**
 *
 * @author informatica
 */
@Named(value = "objectoBean")
@ViewScoped
public class ObjectoBean implements Serializable {

   
   Objecto objecto = new Objecto();
    ObjectoDAO objectoDAO = new ObjectoDAO();
    List<Objecto> objectos;
    
   @PostConstruct
    public void init() {
        objectos = objectoDAO.listarTodos();
    }
    
    
     public void guardar(ActionEvent event){
     if (objectoDAO.guardar(objecto)) {
            objecto = new Objecto();
            addMessage(FacesMessage.SEVERITY_INFO, "Sucesso ao guardar os dados", "Sucesso ao guardar os dados");
           
        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao guardar os dados", "Erro ao guardar os dados");
            
        }
    }
    
    
     public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
