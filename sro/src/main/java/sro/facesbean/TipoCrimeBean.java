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
import sro.dao.TipoCrimeDAO;
import sro.modelo.TipoCrime;

/**
 *
 * @author informatica
 */
@Named(value = "tipoCrimeBean")
@ViewScoped
public class TipoCrimeBean implements Serializable {

    List<TipoCrime> tipoCrimes = new ArrayList<>();
    TipoCrime tipoCrime = new TipoCrime();
    TipoCrimeDAO tipoCrimeDAO = new TipoCrimeDAO();

    @PostConstruct
    public void init() {
        tipoCrimes = tipoCrimeDAO.listarTodos();

    }

    public List<TipoCrime> getTipoCrimes() {
        return tipoCrimes;
    }

    public void setTipoCrimes(List<TipoCrime> tipoCrimes) {
        this.tipoCrimes = tipoCrimes;
    }

    public TipoCrime getTipoCrime() {
        return tipoCrime;
    }

    public void setTipoCrime(TipoCrime tipoCrime) {
        this.tipoCrime = tipoCrime;
    }

    public void guardar(ActionEvent event) {
        if (tipoCrimeDAO.guardar(tipoCrime)) {
            tipoCrime = new TipoCrime();
            gotoTipoCrimeForm();
            addMessage(FacesMessage.SEVERITY_INFO, "Sucesso ao guardar os dados", "Sucesso ao guardar os dados");

        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao guardar os dados", "Erro ao guardar os dados");

        }
    }

    private String gotoTipoCrimeForm() {
        return "/gestao/tabelas/gestao_tipo_crime?faces-redirect=true";

    }

    public void reset() {
        PrimeFaces.current().resetInputs("form:panel");
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

}
