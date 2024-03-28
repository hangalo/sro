
package sro.modelo;


import java.util.Date;
import java.util.Objects;


public class Suspeito {
    private Integer idSuspeito;
    private String numeroBI;
    private String numeroContribuinte;
    private String nomeSuspeito;
    private String sobrenomeSuspeito;
    private Date dataNascimento;
    private String casaSuspeito;
    private String ruaSuspeito;
    private String bairroSuspeito;
    private String comunaSuspeito;
    private Sexo sexo;
    private Municipio municipio;

    public Suspeito() {
    }

    public Suspeito(Integer idSuspeito, String numeroBI, String numeroContribuinte, String nomeSuspeito, String sobrenomeSuspeito, Date dataNascimento, String casaSuspeito, String ruaSuspeito, String bairroSuspeito, String comunaSuspeito, Sexo sexo, Municipio municipio) {
        this.idSuspeito = idSuspeito;
        this.numeroBI = numeroBI;
        this.numeroContribuinte = numeroContribuinte;
        this.nomeSuspeito = nomeSuspeito;
        this.sobrenomeSuspeito = sobrenomeSuspeito;
        this.dataNascimento = dataNascimento;
        this.casaSuspeito = casaSuspeito;
        this.ruaSuspeito = ruaSuspeito;
        this.bairroSuspeito = bairroSuspeito;
        this.comunaSuspeito = comunaSuspeito;
        this.sexo = sexo;
        this.municipio = municipio;
    }

   

   

    public Integer getIdSuspeito() {
        return idSuspeito;
    }

    public void setIdSuspeito(Integer idSuspeito) {
        this.idSuspeito = idSuspeito;
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

    public String getNomeSuspeito() {
        return nomeSuspeito;
    }

    public void setNomeSuspeito(String nomeSuspeito) {
        this.nomeSuspeito = nomeSuspeito;
    }

    public String getSobrenomeSuspeito() {
        return sobrenomeSuspeito;
    }

    public void setSobrenomeSuspeito(String sobrenomeSuspeito) {
        this.sobrenomeSuspeito = sobrenomeSuspeito;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCasaSuspeito() {
        return casaSuspeito;
    }

    public void setCasaSuspeito(String casaSuspeito) {
        this.casaSuspeito = casaSuspeito;
    }

    public String getRuaSuspeito() {
        return ruaSuspeito;
    }

    public void setRuaSuspeito(String ruaSuspeito) {
        this.ruaSuspeito = ruaSuspeito;
    }

    public String getBairroSuspeito() {
        return bairroSuspeito;
    }

    public void setBairroSuspeito(String bairroSuspeito) {
        this.bairroSuspeito = bairroSuspeito;
    }

    public String getComunaSuspeito() {
        return comunaSuspeito;
    }

    public void setComunaSuspeito(String comunaSuspeito) {
        this.comunaSuspeito = comunaSuspeito;
    }

  
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idSuspeito);
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
        final Suspeito other = (Suspeito) obj;
        return Objects.equals(this.idSuspeito, other.idSuspeito);
    }

    @Override
    public String toString() {
        return "Suspeito{" + "nomeSuspeito=" + nomeSuspeito + ", sobrenomeSuspeito=" + sobrenomeSuspeito + '}';
    }
   
    
    
}
