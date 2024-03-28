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
import sro.dao.SuspeitoDAO;
import sro.modelo.Municipio;
import sro.modelo.Suspeito;

@Named(value = "suspeitoBean")
@ViewScoped
public class SuspeitoBean implements Serializable {

    List<Suspeito> suspeitos = new ArrayList<>();
    List<Suspeito> listaPorNome = new ArrayList<>();
    List<Suspeito> listaEntreDatas = new ArrayList<>();
    Suspeito suspeito = new Suspeito();
    SuspeitoDAO suspeitoDAO = new SuspeitoDAO();
    String nomeSobrenome;
    Municipio municipio = new Municipio();
    Date inicio, fim;

    @PostConstruct
    public void init() {
        suspeitos = suspeitoDAO.listarTodos();

    }

    public List<Suspeito> getSuspeitos() {
        return suspeitos;
    }

    public void setSuspeitos(List<Suspeito> suspeitos) {
        this.suspeitos = suspeitos;
    }

    public Suspeito getSuspeito() {
        return suspeito;
    }

    public void setSuspeito(Suspeito suspeito) {
        this.suspeito = suspeito;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
    }

    public List<Suspeito> getListaPorNome() {
        return listaPorNome;
    }

    public void setListaPorNome(List<Suspeito> listaPorNome) {
        this.listaPorNome = listaPorNome;
    }

    public List<Suspeito> getListaEntreDatas() {
        return listaEntreDatas;
    }

    public void setListaEntreDatas(List<Suspeito> listaEntreDatas) {
        this.listaEntreDatas = listaEntreDatas;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

      public void executarBuscaSuspeitoEntreDatasPorMuniciopio(ActionEvent event) {
        listaEntreDatas = suspeitoDAO.findAllPorMunicipioIntervaloData(municipio, inicio, fim);

    }
    
      
      public void executarBuscaSuspeitoEntreDatasNascimento(ActionEvent event) {
        listaEntreDatas = suspeitoDAO.findAllPorIntervaloDataNascimento(inicio, fim);

    }
    
    public void executarProcuraSuspeitoPorNomeSobrenome(ActionEvent event) {
      ///  procuraSuspeitoPorNomeSobrenome();
       listaPorNome = suspeitoDAO.findByNomeSobrenome(nomeSobrenome);
    }
  
    
    public void guardar(ActionEvent event) {
        if (suspeitoDAO.guardar(suspeito)) {
            suspeito = new Suspeito();
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
