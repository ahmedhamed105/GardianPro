/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timer.schedual;

import Entities.ConfigParmeter;
import Entities.EmailLog;
import Entities.TerminalParserLog;
import Facades.EmailLogFacadeLocal;
import Facades.TerminalFacadeLocal;
import Facades.TerminalParserLogFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

/**
 *
 * @author martin
 */
//@Startup
@Singleton
@LocalBean
public class EmailTimer {

    @EJB
    private EmailLogFacadeLocal emailLogFacade;

    @EJB
    TerminalParserLogFacadeLocal terminalLogFile;
    
    


    @Schedule(hour = "*", minute = "*/2", second = "*", persistent = false)
    public void execute(Timer timer) {

        System.out.println("Email Executing ...");

        System.out.println("Execution Time : " + new Date());
        
        List<EmailLog> emails=emailLogFacade.FindALL_notsend();
        System.out.println("emails "+emails);
        if(emails != null){
        for(EmailLog email:emails){
         System.out.println("email "+email.getEto());
         boolean send=   emailLogFacade.send_email(email);
         System.out.println("send "+send);
             if(send){
                  Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                  email.setEsendnot(1);
                  email.setUpdateDate(date);
                  emailLogFacade.edit(email);
             }
        }
        }
       

    }

    @PostConstruct
    public void init() {
        System.out.println("intit..............");
//        parseTerminalsLogFiles("E:\\3yad\\private\\projects\\GardianPro\\20180602_001014_40000001.LOG");
       
    }



    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
