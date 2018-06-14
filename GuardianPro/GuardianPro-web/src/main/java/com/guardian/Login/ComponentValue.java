/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ComponentName;
import Facades.ComponentNameFacadeLocal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author ahmed.ibraheem
 */


public class ComponentValue {
    List<ComponentName> ComponentNames;
    
    @EJB
    private ComponentNameFacadeLocal componentNameFacade;
    
    
    public ComponentValue(){
       
    }
    
    public String getValueById(int id){
    
        ComponentName cn= componentNameFacade.find(id);
        return cn.getValue();
    }
    
}
