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
import java.util.ArrayList;
import java.util.List;
import sro.dao.StatusOcorrenciaDAO;
import sro.modelo.StatusOcorrencia;


@Named(value = "statusOcorrenciaBean")
@ViewScoped
public class StatusOcorrenciaBean implements Serializable {

     List<StatusOcorrencia> statusOcorrencias = new ArrayList<>();
    StatusOcorrencia statusOcorrencia = new StatusOcorrencia();
    StatusOcorrenciaDAO statusOcorrenciaDAO = new StatusOcorrenciaDAO();

    @PostConstruct
    public void init() {
        statusOcorrencias = statusOcorrenciaDAO.listarTodos();

    }

    public List<StatusOcorrencia> getStatusOcorrencias() {
        return statusOcorrencias;
    }

    public void setStatusOcorrencias(List<StatusOcorrencia> statusOcorrencias) {
        this.statusOcorrencias = statusOcorrencias;
    }

    public StatusOcorrencia getStatusOcorrencia() {
        return statusOcorrencia;
    }

    public void setStatusOcorrencia(StatusOcorrencia statusOcorrencia) {
        this.statusOcorrencia = statusOcorrencia;
    }
    
    
    
    
     public String guardar(){
     if (statusOcorrenciaDAO.guardar(statusOcorrencia)) {
            statusOcorrencia = new StatusOcorrencia();
            addMessage(FacesMessage.SEVERITY_INFO, "Sucesso ao guardar os dados", "Sucesso ao guardar os dados");
            return null;
        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao guardar os dados", "Erro ao guardar os dados");
             return null;
        }
    
    }
    
    
     public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
}
