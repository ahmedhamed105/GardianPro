/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.LogScreen;
import Facades.LogScreenFacadeLocal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author ahmed.elemam
 */
public class Log_display {

    @EJB
    private LogScreenFacadeLocal logScreenFacade;
    
    

    /**
     * Creates a new instance of Log_display
     */
    public Log_display() {
    }
    
    public List<LogScreen> log(int page){
        
      return logScreenFacade.Select_log_User(Login.login, page);
    
    
    }
    
}
