/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.converter;

import Entities.ParamterDefault;
import Entities.ParamterFieldType;
import Facades.ParamterDefaultFacadeLocal;
import Facades.ParamterFieldTypeFacadeLocal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author ahmed.elemam
 */
public class CparamterDefault implements Converter{
    
      @EJB
    private ParamterDefaultFacadeLocal ParamterDefaultFacade;

 @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
   if (value == null || value.isEmpty()) {
                return null;
            }
 
            try {
                  
                Object obj =  ParamterDefaultFacade.find(Integer.parseInt(value));
                
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
                throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to parmetertype", value)), e);
            }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
  if (!(value instanceof ParamterDefault)) {
                return null;
            }
 
           String s =  String.valueOf(((Entities.ParamterDefault) value).getId());
           
           return s;
    }
    
}
