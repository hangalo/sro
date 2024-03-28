/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sro.facesbean;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sro.dao.VitimaDAO;
import sro.modelo.Municipio;
import sro.modelo.Vitima;

@Named(value = "vitimaBean")
//@ViewScoped
@SessionScoped
public class VitimaBean implements Serializable {

    List<Vitima> vitimas = new ArrayList<>();
    List<Vitima> listaPorNome = new ArrayList<>();
    List<Vitima> listaEntreDatas = new ArrayList<>();
    Vitima vitima = new Vitima();
    VitimaDAO vitimaDAO = new VitimaDAO();
    String nomeSobrenome;
    Municipio municipio = new Municipio();
    Date inicio, fim;

    @PostConstruct
    public void init() {
        vitimas = vitimaDAO.listarTodos();

    }

    public List<Vitima> getVitimas() {
        return vitimas;
    }

    public void setVitimas(List<Vitima> vitimas) {
        this.vitimas = vitimas;
    }

    public Vitima getVitima() {
        return vitima;
    }

    public void setVitima(Vitima vitima) {
        this.vitima = vitima;
    }

    public List<Vitima> getListaPorNome() {
        return listaPorNome;
    }

    public void setListaPorNome(List<Vitima> listaPorNome) {
        this.listaPorNome = listaPorNome;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
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

    public List<Vitima> getListaEntreDatas() {
        return listaEntreDatas;
    }

    public void setListaEntreDatas(List<Vitima> listaEntreDatas) {
        this.listaEntreDatas = listaEntreDatas;
    }

    
    
    
    public void executarProcuraVitimaPorNomeSobrenome(ActionEvent event) {
        listaPorNome = vitimaDAO.findByNomeSobrenome(nomeSobrenome);

    }

    public void executarBuscaVitimaEntreDatasPorMuniciopio(ActionEvent event) {
        listaEntreDatas = vitimaDAO.findAllPorMunicipioIntervaloData(municipio, inicio, fim);

    }

    public void executarBuscaVitimaEntreDatasNascimento(ActionEvent event) {
        listaEntreDatas = vitimaDAO.findAllPorIntervaloDataNascimento(inicio, fim);

    }

    public void guardar(ActionEvent event) {
        if (vitimaDAO.guardar(vitima)) {
            vitima = new Vitima();
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
