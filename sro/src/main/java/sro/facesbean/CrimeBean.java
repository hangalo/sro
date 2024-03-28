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
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;
import sro.dao.CrimeDAO;
import sro.modelo.Crime;
import sro.modelo.TipoCrime;

/**
 *
 * @author informatica
 */
@Named(value = "crimeBean")
@ViewScoped
public class CrimeBean implements Serializable {

    List<Crime> crimes = new ArrayList<>();
    Crime crime = new Crime();
    TipoCrime tipoCrime = new TipoCrime();
    CrimeDAO crimeDAO = new CrimeDAO();

    @PostConstruct
    public void init() {
        crimes = crimeDAO.listarTodos();

    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    public TipoCrime getTipoCrime() {
        return tipoCrime;
    }

    public void setTipoCrime(TipoCrime tipoCrime) {
        this.tipoCrime = tipoCrime;
    }

    
     public void reset() {
        PrimeFaces.current().resetInputs("form:panel");
    }
    
    public void guardar(ActionEvent event) {
        if (crimeDAO.guardar(crime)) {
            crime = new Crime();
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
