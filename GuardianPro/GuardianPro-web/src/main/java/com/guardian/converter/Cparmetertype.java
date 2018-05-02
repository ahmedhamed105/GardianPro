/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.converter;

import Entities.InputType;
import Entities.ParameterType;
import Facades.ParameterTypeFacadeLocal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ahmed.elemam
 */
@FacesConverter(value = "Cparmetertype")
public class Cparmetertype implements Converter{
    
      @EJB
    private ParameterTypeFacadeLocal parameterTypeFacade;

 @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
   if (value == null || value.isEmpty()) {
                return null;
            }
 
            try {
                  
                Object obj =  parameterTypeFacade.find(Integer.parseInt(value));
                
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
                throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to parmetertype", value)), e);
            }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
  if (!(value instanceof ParameterType)) {
                return null;
            }
 
           String s =  String.valueOf(((Entities.ParameterType) value).getId());
           
           return s;
    }
    
}
