/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sro.facesbean;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import sro.dao.CrimeDAO;
import sro.dao.ItensOcorrenciaDAO;
import sro.dao.SuspeitoDAO;
import sro.dao.VitimaDAO;
import sro.modelo.Crime;
import sro.modelo.ItensOcorrencia;
import sro.modelo.Suspeito;
import sro.modelo.Vitima;

/**
 *
 * @author informatica
 */
@Named(value = "itensOcorrenciaBean")
@Dependent
public class ItensOcorrenciaBean {

    List<ItensOcorrencia> cestoItensOcorrencias = new ArrayList<>();
    List<ItensOcorrencia> itensOcorrencias = new ArrayList<>();
    ItensOcorrencia itensOcorrencia = new ItensOcorrencia();
    ItensOcorrenciaDAO itensOcorrenciaDAO = new ItensOcorrenciaDAO();
    CrimeDAO crimeDAO = new CrimeDAO();
    SuspeitoDAO suspeitoDAO = new SuspeitoDAO();
    VitimaDAO vitimaDAO = new VitimaDAO();

    @PostConstruct
    public void init() {
        itensOcorrencias = itensOcorrenciaDAO.listarTodos();

    }

    public String addicionarCrimeAOcorrencia(Crime crime) {
        Crime crimeEncontrado = crimeDAO.pesquisaPorId(crime.getIdCrime());

        int index = isExistingCrime(crime);
        if (index == -1) {
            this.cestoItensOcorrencias.add(new ItensOcorrencia(crime));
        } else {
            if (this.cestoItensOcorrencias.get(index).getCrime().getIdCrime() == crimeEncontrado.getIdCrime()) {
                addMessage(FacesMessage.SEVERITY_WARN, "Aviso - Crime já adicionado", "Crime já Adicionado");
            }
        }

        return null;
    }

    public String addicionarSuspeitoAOcorrencia(Suspeito suspeito) {
        Suspeito suspeitoEncontrado = suspeitoDAO.pesquisaPorId(suspeito.getIdSuspeito());

        int index = isExistingSuspeito(suspeito);
        if (index == -1) {
            this.cestoItensOcorrencias.add(new ItensOcorrencia(suspeito));
        } else {
            if (this.cestoItensOcorrencias.get(index).getSuspeito().getIdSuspeito() == suspeitoEncontrado.getIdSuspeito()) {
                addMessage(FacesMessage.SEVERITY_WARN, "Aviso - Suspeito já adicionado", "Suspeito já Adicionado");
            }
        }

        return null;
    }

    
     public String addicionarVitimaAOcorrencia(Vitima vitima) {
        Vitima vitimaEncontrada = vitimaDAO.pesquisaPorId(vitima.getIdVitima());

        int index = isExistingVitima(vitima);
        if (index == -1) {
            this.cestoItensOcorrencias.add(new ItensOcorrencia(vitima));
        } else {
            if (this.cestoItensOcorrencias.get(index).getVitima().getIdVitima()== vitimaEncontrada.getIdVitima()) {
                addMessage(FacesMessage.SEVERITY_WARN, "Aviso - Vítima já adicionada", "Vítima já Adicionada");
            }
        }

        return null;
    }

    private int isExistingCrime(Crime crime) {

        for (int i = 0; i < this.cestoItensOcorrencias.size(); i++) {
            if (this.cestoItensOcorrencias.get(i).getCrime().getIdCrime() == crime.getIdCrime()) {
                return i;
            }
        }
        return -1;

    }

    private int isExistingSuspeito(Suspeito suspeito) {
        for (int i = 0; i < this.cestoItensOcorrencias.size(); i++) {
            if (this.cestoItensOcorrencias.get(i).getSuspeito().getIdSuspeito() == suspeito.getIdSuspeito()) {
                return i;
            }
        }
        return -1;

    }

    private int isExistingVitima(Vitima vitima) {
        for (int i = 0; i < this.cestoItensOcorrencias.size(); i++) {
            if (this.cestoItensOcorrencias.get(i).getVitima().getIdVitima() == vitima.getIdVitima()) {
                return i;
            }
        }
        return -1;

    }

    public void guardar(ActionEvent event) {
        if (itensOcorrenciaDAO.guardar(itensOcorrencia)) {
            itensOcorrencia = new ItensOcorrencia();
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
