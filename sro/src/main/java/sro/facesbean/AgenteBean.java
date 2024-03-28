
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
import sro.dao.AgenteDAO;
import sro.modelo.Agente;


@Named(value = "agenteBean")
@ViewScoped
public class AgenteBean implements Serializable {
    
    Agente agente = new Agente();
    AgenteDAO agenteDAO = new AgenteDAO();
    private List<Agente> agentes = new ArrayList<>();
    List<Agente> listaPorNome = new ArrayList<>();
    String nomeSobrenome;
    
      @PostConstruct
    public void init(){
     agentes = agenteDAO.listarTodos();
    }
    
    
    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    
   
    
    
    
    
   

    public List<Agente> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<Agente> agentes) {
        this.agentes = agentes;
    }

    public List<Agente> getListaPorNome() {
        return listaPorNome;
    }

    public void setListaPorNome(List<Agente> listaPorNome) {
        this.listaPorNome = listaPorNome;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
    }
    
    
    
     public void executarProcuraPorNomeSobrenome(ActionEvent event) {
      listaPorNome = agenteDAO.findByNomeSobrenome(nomeSobrenome);

    }
    
   
    
     public void guardar(ActionEvent event){
         
       
     if (agenteDAO.guardar(agente)) {
            agente = new Agente();
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
