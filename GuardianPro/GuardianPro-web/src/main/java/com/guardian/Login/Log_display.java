/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.EmailHistory;
import Entities.FtpMessages;
import Entities.LogScreen;
import Entities.TerminalParserLog;
import Facades.EmailHistoryFacadeLocal;
import Facades.FtpMessagesFacadeLocal;
import Facades.LogScreenFacadeLocal;
import Facades.TerminalParserLogFacadeLocal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author ahmed.elemam
 */
public class Log_display {

    @EJB
    private TerminalParserLogFacadeLocal terminalParserLogFacade;

    @EJB
    private LogScreenFacadeLocal logScreenFacade;
    
       @EJB
    private EmailHistoryFacadeLocal emailHistoryFacade;
       
        @EJB
    private FtpMessagesFacadeLocal ftpMessagesFacade;
    
    
    
    

    /**
     * Creates a new instance of Log_display
     */
    public Log_display() {
    }
    
    public List<LogScreen> log(int page){
        
      return logScreenFacade.Select_log_User(Login.login, page);
    
    
    }
    
     public List<LogScreen> ALL(int pa){
        
      return logScreenFacade.findAll();
    
    
    }
     
     
          public List<TerminalParserLog> ALLdownload(int pa){
        
           return terminalParserLogFacade.findAll();
    
    }
    
          
                 public List<EmailHistory> email(int pa){
        
           return emailHistoryFacade.findAll();
    
    }
                 
    public List<FtpMessages> ftp(int pa){
        
           return ftpMessagesFacade.findAll();
    
    }
}
