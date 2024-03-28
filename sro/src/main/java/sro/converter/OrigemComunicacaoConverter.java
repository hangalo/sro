/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sro.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import sro.dao.MunicipioDAO;
import sro.dao.OrigemComunicacaoDAO;
import sro.modelo.Municipio;
import sro.modelo.OrigemComunicacao;

@FacesConverter(value = "origemComunicacaoConverter")
public class OrigemComunicacaoConverter implements Converter {

    OrigemComunicacaoDAO origemComunicacaoDAO = new OrigemComunicacaoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return origemComunicacaoDAO.pesquisaPorId(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }
    

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      
      if (value != null) {
            OrigemComunicacao origemComunicacao = (OrigemComunicacao) value;
            return String.valueOf(origemComunicacao.getIdOrigemComunicacao());
        }
        return null;
    }

}
