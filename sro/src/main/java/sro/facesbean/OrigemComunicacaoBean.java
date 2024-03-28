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
import sro.dao.OrigemComunicacaoDAO;
import sro.modelo.OrigemComunicacao;


@Named(value = "origemComunicacaoBean")
@ViewScoped
public class OrigemComunicacaoBean implements Serializable {

    List<OrigemComunicacao> origemComunicacoes = new ArrayList<>();
    OrigemComunicacao origemComunicacao = new OrigemComunicacao();
    OrigemComunicacaoDAO origemComunicacaoDAO = new OrigemComunicacaoDAO();

    @PostConstruct
    public void init() {
        origemComunicacoes = origemComunicacaoDAO.listarTodos();

    }

    public List<OrigemComunicacao> getOrigemComunicacoes() {
        return origemComunicacoes;
    }

    public void setOrigemComunicacoes(List<OrigemComunicacao> origemComunicacoes) {
        this.origemComunicacoes = origemComunicacoes;
    }

    public OrigemComunicacao getOrigemComunicacao() {
        return origemComunicacao;
    }

    public void setOrigemComunicacao(OrigemComunicacao origemComunicacao) {
        this.origemComunicacao = origemComunicacao;
    }

    
     public void guardar(ActionEvent event){
     if (origemComunicacaoDAO.guardar(origemComunicacao)) {
            origemComunicacao = new OrigemComunicacao();
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
