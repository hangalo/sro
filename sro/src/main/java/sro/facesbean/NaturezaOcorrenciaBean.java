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
import sro.dao.NaturezaOcorrenciaDAO;
import sro.modelo.NaturezaOcorrencia;

/**
 *
 * @author informatica
 */
@Named(value = "naturezaOcorrenciaBean")
@ViewScoped
public class NaturezaOcorrenciaBean implements Serializable {

    NaturezaOcorrencia naturezaOcorrencia = new NaturezaOcorrencia();
    NaturezaOcorrenciaDAO naturezaOcorrenciaDAO = new NaturezaOcorrenciaDAO();
    List<NaturezaOcorrencia> naturezaOcorrencias;
    
   @PostConstruct
    public void init() {
        naturezaOcorrencias = naturezaOcorrenciaDAO.listarTodos();

    }

    public NaturezaOcorrencia getNaturezaOcorrencia() {
        return naturezaOcorrencia;
    }

    public void setNaturezaOcorrencia(NaturezaOcorrencia naturezaOcorrencia) {
        this.naturezaOcorrencia = naturezaOcorrencia;
    }

    public List<NaturezaOcorrencia> getNaturezaOcorrencias() {
        return naturezaOcorrencias;
    }

    public void setNaturezaOcorrencias(List<NaturezaOcorrencia> naturezaOcorrencias) {
        this.naturezaOcorrencias = naturezaOcorrencias;
    }
    
    
    
    
     public void guardar(ActionEvent event){
     if (naturezaOcorrenciaDAO.guardar(naturezaOcorrencia)) {
            naturezaOcorrencia = new NaturezaOcorrencia();
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
