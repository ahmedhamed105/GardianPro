/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface FormatfacadeLocal {
    
    String formatText(String action, String user,String component, boolean status);
    
}
