/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sro.modelo;

/**
 *
 * @author informatica
 */
public enum EstadoCivil {
     Solteiro("S", "Solteiro(a)"), Casado("C", "Casado(a)"), Viuvo("V", "Viuvo(a)");
    
    private String abreviatura;
    private String extensao;
    
    private EstadoCivil( String abreviatura, String extensao) {
        this.abreviatura = abreviatura;
        this.extensao = extensao;
    }
    
    public String getAbreviatura() {
        return abreviatura;
    }
    
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    public String getExtensao() {
        return extensao;
    }
    
    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    //Metodo auxiliar para interagir com o enum
    public static EstadoCivil getAbreviatura(String id) {
        
        for (EstadoCivil s : values()) {
            if(s.getAbreviatura().equals(id)){
            
            return s;
            }
        }
       return null; 
    }
    
}
