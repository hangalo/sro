
package sro.modelo;

import java.util.Date;
import java.util.Objects;


public class Ocorrencia {
  private Integer idOcorrencia;
private Date dataOcorrencia;
private Date dataRegisto;
private Agente agente;
private OrigemComunicacao origemComunicacao;
private StatusOcorrencia statusOcorrencia;
private String pontoReferenciaOcorrencia;
private String ruaOcorrencia;
private String bairroOcorrencia;
private String comunaOcorrencia;
private Municipio municipio;
private NaturezaOcorrencia naturezaOcorrencia;
private String descricaoGeralOcorrencia;

    public Ocorrencia() {
    }

    public Ocorrencia(Integer idOcorrencia, Date dataOcorrencia, Date dataRegisto, Agente agente, OrigemComunicacao origemComunicacao, StatusOcorrencia statusOcorrencia, String pontoReferenciaOcorrencia, String ruaOcorrencia, String bairroOcorrencia, String comunaOcorrencia, Municipio municipio, NaturezaOcorrencia naturezaOcorrencia, String descricaoGeralOcorrencia) {
        this.idOcorrencia = idOcorrencia;
        this.dataOcorrencia = dataOcorrencia;
        this.dataRegisto = dataRegisto;
        this.agente = agente;
        this.origemComunicacao = origemComunicacao;
        this.statusOcorrencia = statusOcorrencia;
        this.pontoReferenciaOcorrencia = pontoReferenciaOcorrencia;
        this.ruaOcorrencia = ruaOcorrencia;
        this.bairroOcorrencia = bairroOcorrencia;
        this.comunaOcorrencia = comunaOcorrencia;
        this.municipio = municipio;
        this.naturezaOcorrencia = naturezaOcorrencia;
        this.descricaoGeralOcorrencia = descricaoGeralOcorrencia;
    }

    public Integer getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Integer idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Date getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(Date dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public OrigemComunicacao getOrigemComunicacao() {
        return origemComunicacao;
    }

    public void setOrigemComunicacao(OrigemComunicacao origemComunicacao) {
        this.origemComunicacao = origemComunicacao;
    }

    public StatusOcorrencia getStatusOcorrencia() {
        return statusOcorrencia;
    }

    public void setStatusOcorrencia(StatusOcorrencia statusOcorrencia) {
        this.statusOcorrencia = statusOcorrencia;
    }

    public String getPontoReferenciaOcorrencia() {
        return pontoReferenciaOcorrencia;
    }

    public void setPontoReferenciaOcorrencia(String pontoReferenciaOcorrencia) {
        this.pontoReferenciaOcorrencia = pontoReferenciaOcorrencia;
    }

    public String getRuaOcorrencia() {
        return ruaOcorrencia;
    }

    public void setRuaOcorrencia(String ruaOcorrencia) {
        this.ruaOcorrencia = ruaOcorrencia;
    }

    public String getBairroOcorrencia() {
        return bairroOcorrencia;
    }

    public void setBairroOcorrencia(String bairroOcorrencia) {
        this.bairroOcorrencia = bairroOcorrencia;
    }

    public String getComunaOcorrencia() {
        return comunaOcorrencia;
    }

    public void setComunaOcorrencia(String comunaOcorrencia) {
        this.comunaOcorrencia = comunaOcorrencia;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public NaturezaOcorrencia getNaturezaOcorrencia() {
        return naturezaOcorrencia;
    }

    public void setNaturezaOcorrencia(NaturezaOcorrencia naturezaOcorrencia) {
        this.naturezaOcorrencia = naturezaOcorrencia;
    }

    public String getDescricaoGeralOcorrencia() {
        return descricaoGeralOcorrencia;
    }

    public void setDescricaoGeralOcorrencia(String descricaoGeralOcorrencia) {
        this.descricaoGeralOcorrencia = descricaoGeralOcorrencia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.idOcorrencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ocorrencia other = (Ocorrencia) obj;
        return Objects.equals(this.idOcorrencia, other.idOcorrencia);
    }



}
