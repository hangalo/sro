
package sro.modelo;

import jakarta.enterprise.inject.Model;
import java.util.Date;
import java.util.Objects;

@Model
public class Agente {
    private String numeroAgente;
    private String nomeAgente;
    private String sobrenomeAgente;
    private Date dataNascimento;
    private Sexo sexo;
    private String telefoneMovicel;
    private String telefoneUnitel;
    private String telefoneAfricell;
    private String emailAgente;
    

    public Agente() {
    }
    
 
      public Agente( String numeroAgente) {
        this.numeroAgente = numeroAgente;
       
    }
    public Agente( String numeroAgente, String nomeAgente, String sobrenomeAgente, Date dataNascimento, Sexo sexo) {
        this.numeroAgente = numeroAgente;
        this.nomeAgente = nomeAgente;
        this.sobrenomeAgente = sobrenomeAgente;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

   

    public String getNumeroAgente() {
        return numeroAgente;
    }

    public void setNumeroAgente(String numeroAgente) {
        this.numeroAgente = numeroAgente;
    }

    public String getNomeAgente() {
        return nomeAgente;
    }

    public void setNomeAgente(String nomeAgente) {
        this.nomeAgente = nomeAgente;
    }

    public String getSobrenomeAgente() {
        return sobrenomeAgente;
    }

    public void setSobrenomeAgente(String sobrenomeAgente) {
        this.sobrenomeAgente = sobrenomeAgente;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

     public String getTelefoneMovicel() {
        return telefoneMovicel;
    }

    public void setTelefoneMovicel(String telefoneMovicel) {
        this.telefoneMovicel = telefoneMovicel;
    }

    public String getTelefoneUnitel() {
        return telefoneUnitel;
    }

    public void setTelefoneUnitel(String telefoneUnitel) {
        this.telefoneUnitel = telefoneUnitel;
    }

    public String getTelefoneAfricell() {
        return telefoneAfricell;
    }

    public void setTelefoneAfricell(String telefoneAfricell) {
        this.telefoneAfricell = telefoneAfricell;
    }
    public String getEmailAgente() {
        return emailAgente;
    }

    public void setEmailAgente(String emailAgente) {
        this.emailAgente = emailAgente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.numeroAgente);
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
        final Agente other = (Agente) obj;
        return Objects.equals(this.numeroAgente, other.numeroAgente);
    }
    
    

    @Override
    public String toString() {
        return "Agente{" + "nomeAgente=" + nomeAgente + ", sobrenomeAgente=" + sobrenomeAgente + '}';
    }

    

   
    
    
}
