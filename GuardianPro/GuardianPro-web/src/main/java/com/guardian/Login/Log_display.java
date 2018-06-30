/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.EmailHistory;
import Entities.FtpMessages;
import Entities.Groups;
import Entities.LogScreen;
import Entities.TerminalParserLog;
import Facades.EmailHistoryFacadeLocal;
import Facades.FtpMessagesFacadeLocal;
import Facades.LogScreenFacadeLocal;
import Facades.TerminalParserLogFacadeLocal;
import java.util.ArrayList;
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
    
      private List<EmailHistory> EmailHistoryFilter = new ArrayList<>();
      
    
   private List<FtpMessages> FtpMessagesFilter = new ArrayList<>(); 

    /**
     * Creates a new instance of Log_display
     */
    public Log_display() {
    }

    public List<FtpMessages> getFtpMessagesFilter() {
        return FtpMessagesFilter;
    }

    public void setFtpMessagesFilter(List<FtpMessages> FtpMessagesFilter) {
        this.FtpMessagesFilter = FtpMessagesFilter;
    }
    
    

    public List<EmailHistory> getEmailHistoryFilter() {
        return EmailHistoryFilter;
    }

    public void setEmailHistoryFilter(List<EmailHistory> EmailHistoryFilter) {
        this.EmailHistoryFilter = EmailHistoryFilter;
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
