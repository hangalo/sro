
package sro.modelo;


import java.util.Date;
import java.util.Objects;


public class Vitima {
    private Integer idVitima;
    private String numeroBI;
    private String numeroContribuinte;
    private String nomeVitima;
    private String sobrenomeVitima;
    private Date dataNascimentoVitima;
    private Sexo sexo;
    private String casaVitima;
    private String ruaVitima;
    private String bairroVitima;
    private String comunaVitima;
    private Municipio municipio;

    public Vitima() {
    }

    public Vitima(Integer idVitima, String numeroBI, String numeroContribuinte, String nomeVitima, String sobrenomeVitima, Date dataNascimentoVitima, Sexo sexo, String casaVitima, String ruaVitima, String bairroVitima, String comunaVitima, Municipio municipio) {
        this.idVitima = idVitima;
        this.numeroBI = numeroBI;
        this.numeroContribuinte = numeroContribuinte;
        this.nomeVitima = nomeVitima;
        this.sobrenomeVitima = sobrenomeVitima;
        this.dataNascimentoVitima = dataNascimentoVitima;
        this.sexo = sexo;
        this.casaVitima = casaVitima;
        this.ruaVitima = ruaVitima;
        this.bairroVitima = bairroVitima;
        this.comunaVitima = comunaVitima;
        this.municipio = municipio;
    }

    public Integer getIdVitima() {
        return idVitima;
    }

    public void setIdVitima(Integer idVitima) {
        this.idVitima = idVitima;
    }

    public String getNumeroBI() {
        return numeroBI;
    }

    public void setNumeroBI(String numeroBI) {
        this.numeroBI = numeroBI;
    }

    public String getNumeroContribuinte() {
        return numeroContribuinte;
    }

    public void setNumeroContribuinte(String numeroContribuinte) {
        this.numeroContribuinte = numeroContribuinte;
    }

    public String getNomeVitima() {
        return nomeVitima;
    }

    public void setNomeVitima(String nomeVitima) {
        this.nomeVitima = nomeVitima;
    }

    public String getSobrenomeVitima() {
        return sobrenomeVitima;
    }

    public void setSobrenomeVitima(String sobrenomeVitima) {
        this.sobrenomeVitima = sobrenomeVitima;
    }

    public Date getDataNascimentoVitima() {
        return dataNascimentoVitima;
    }

    public void setDataNascimentoVitima(Date dataNascimentoVitima) {
        this.dataNascimentoVitima = dataNascimentoVitima;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCasaVitima() {
        return casaVitima;
    }

    public void setCasaVitima(String casaVitima) {
        this.casaVitima = casaVitima;
    }

    public String getRuaVitima() {
        return ruaVitima;
    }

    public void setRuaVitima(String ruaVitima) {
        this.ruaVitima = ruaVitima;
    }

    public String getBairroVitima() {
        return bairroVitima;
    }

    public void setBairroVitima(String bairroVitima) {
        this.bairroVitima = bairroVitima;
    }

    public String getComunaVitima() {
        return comunaVitima;
    }

    public void setComunaVitima(String comunaVitima) {
        this.comunaVitima = comunaVitima;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idVitima);
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
        final Vitima other = (Vitima) obj;
        return Objects.equals(this.idVitima, other.idVitima);
    }

    @Override
    public String toString() {
        return "Vitima{" + "nomeVitima=" + nomeVitima + ", sobrenomeVitima=" + sobrenomeVitima + '}';
    }
    
    
}
