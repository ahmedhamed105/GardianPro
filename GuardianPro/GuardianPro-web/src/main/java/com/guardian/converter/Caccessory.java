/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.converter;

import Entities.Accessory;
import Entities.Application;
import Facades.AccessoryFacadeLocal;
import java.io.Serializable;
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
@FacesConverter(value = "caccessory")
public class Caccessory implements Converter, Serializable {
    
        @EJB
    private AccessoryFacadeLocal accessoryFacade;

   @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
   if (value == null || value.isEmpty()) {
                return null;
            }
 
            try {
                  
                Object obj =  accessoryFacade.find(Integer.parseInt(value));
                
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
                throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to inputtype", value)), e);
            }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
  if (!(value instanceof Accessory)) {
                return null;
            }
 
           String s =  String.valueOf(((Accessory) value).getId());
           
           return s;
    }
}
