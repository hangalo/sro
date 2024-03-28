package sro.modelo;

import java.util.Objects;

public class ItensOcorrencia {

    private Crime crime;
    private Ocorrencia ocorrencia;
    private Vitima vitima;
    private Suspeito suspeito;
    private Objecto objecto;
    private byte[] anexo;
    private String urlAnexo;

    public ItensOcorrencia() {
    }

    public ItensOcorrencia(Crime crime) {
        this.crime = crime;

    }

     public ItensOcorrencia(Crime crime, Ocorrencia ocorrencia, Vitima vitima, Suspeito suspeito, Objecto objecto, byte[] anexo, String urlAnexo) {
        this.crime = crime;
        this.ocorrencia = ocorrencia;
        this.vitima = vitima;
        this.suspeito = suspeito;
        this.objecto = objecto;
        this.anexo = anexo;
        this.urlAnexo = urlAnexo;
    }
     
      public ItensOcorrencia(Vitima vitima) {
        
        this.vitima = vitima;
        
    }
    public ItensOcorrencia( Suspeito suspeito) {
      
        this.suspeito = suspeito;
       
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Vitima getVitima() {
        return vitima;
    }

    public void setVitima(Vitima vitima) {
        this.vitima = vitima;
    }

    public Suspeito getSuspeito() {
        return suspeito;
    }

    public void setSuspeito(Suspeito suspeito) {
        this.suspeito = suspeito;
    }

    public Objecto getObjecto() {
        return objecto;
    }

    public void setObjecto(Objecto objecto) {
        this.objecto = objecto;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public String getUrlAnexo() {
        return urlAnexo;
    }

    public void setUrlAnexo(String urlAnexo) {
        this.urlAnexo = urlAnexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.crime);
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
        final ItensOcorrencia other = (ItensOcorrencia) obj;
        return Objects.equals(this.crime, other.crime);
    }

}
