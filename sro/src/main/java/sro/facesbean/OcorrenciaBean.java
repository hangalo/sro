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
import java.util.Date;
import java.util.List;
import sro.dao.OcorrenciaDAO;
import sro.modelo.Agente;
import sro.modelo.Municipio;
import sro.modelo.Ocorrencia;

/**
 *
 * @author informatica
 */
@Named(value = "ocorrenciaBean")
@ViewScoped
public class OcorrenciaBean implements Serializable {
    
    List<Ocorrencia> ocorrencias = new ArrayList<>();
    List<Ocorrencia> listaEntreDatas = new ArrayList<>();
    Ocorrencia ocorrencia = new Ocorrencia();
    OcorrenciaDAO ocorrenciaDAO = new OcorrenciaDAO();
    String numeroAgente;
    Date inicio, fim;
    Municipio municipio = new Municipio();
    
    @PostConstruct
    public void init() {
        ocorrencias = ocorrenciaDAO.listarTodos();
        
    }
    
    public String getNumeroAgente() {
        return numeroAgente;
    }
    
    public void setNumeroAgente(String numeroAgente) {
        this.numeroAgente = numeroAgente;
    }
    
    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }
    
    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
    
    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }
    
    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
    
     public void executarBuscaEntreDatasPorMuniciopio(ActionEvent event) {
        listaEntreDatas = ocorrenciaDAO.findAllPorMunicipioIntervaloData(municipio, inicio, fim);

    }

    public void executarBuscaEntreDatasOcorrencia(ActionEvent event) {
        listaEntreDatas = ocorrenciaDAO.findAllPorIntervaloDataNascimento(inicio, fim);

    }
    
    public void guardar(ActionEvent event) {
        Agente agente = new Agente(numeroAgente);
        ocorrencia.setAgente(agente);
        if (ocorrenciaDAO.guardar(ocorrencia)) {
            ocorrencia = new Ocorrencia();
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
