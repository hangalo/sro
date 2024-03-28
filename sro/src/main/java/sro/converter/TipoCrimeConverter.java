/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sro.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import sro.dao.TipoCrimeDAO;
import sro.modelo.TipoCrime;

@FacesConverter(value = "tipoCrimeConverter")
public class TipoCrimeConverter implements Converter {

   TipoCrimeDAO tipoCrimeDAO = new TipoCrimeDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return tipoCrimeDAO.pesquisaPorId(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: " + ex.getMessage());
        }
        return null;
    }
    

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      
      if (value != null) {
             TipoCrime  tipoCrime = ( TipoCrime) value;
            return String.valueOf(tipoCrime.getIdTipoCrime());
        }
        return null;
    }

}
