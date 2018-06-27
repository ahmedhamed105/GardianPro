/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ConfigParmeter;
import Entities.User;
import Facades.ConfigParmeterFacadeLocal;
import Facades.LogScreenFacadeLocal;
import com.guardian.util.Constants;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed.elemam
 */
public class Messages {

    private static List<ConfigParmeter> messagesFormate;
    private static LogScreenFacadeLocal logScreenFacade;

    static {

        ConfigParmeterFacadeLocal configParmeterFacade = (ConfigParmeterFacadeLocal) Constants.lookupEJB("ConfigParmeterFacade");
        if (configParmeterFacade != null) {
            System.out.println("success to load config Parmeter");
            messagesFormate = configParmeterFacade.findAllMessagesFormat("INFO_MESSAGE_FORMATE", "ERROR_MESSAGE_FORMATE","EXCEPTION_MESSAGE_FORMATE");
            System.out.println("messages Formate "+messagesFormate);
        } else {
            System.out.println("failed to load config Parmeter");

        }
        logScreenFacade = (LogScreenFacadeLocal) Constants.lookupEJB("LogScreenFacade");
        if(logScreenFacade!=null){
            System.out.println("success to load logScreenFacade");
        
        }

    }

    /**
     * Creates a new instance of Messages
     */
    public Messages() {
    }

    public static void addInfoMessage(String summary, int type,int pageId) {
        if (type == 1) {
            if(messagesFormate.size()>0 && messagesFormate.get(0)!=null){
                String infoMsgFormate=messagesFormate.get(0).getPValue();
                if(infoMsgFormate!=null &&!infoMsgFormate.equalsIgnoreCase("")){
                    summary=infoMsgFormate+summary;
                    System.out.println("summary : "+summary);
                }
            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (type == 2) {
            if(messagesFormate.size()>0 && messagesFormate.get(1)!=null){
                String errorMsgFormate=messagesFormate.get(1).getPValue();
                if(errorMsgFormate!=null &&!errorMsgFormate.equalsIgnoreCase("")){
                    summary=errorMsgFormate+summary;
                    System.out.println("summary : "+summary);
                }
            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else if (type == 3) {
            if(messagesFormate.size()>0 && messagesFormate.get(2)!=null){
                String errorMsgFormate=messagesFormate.get(2).getPValue();
                if(errorMsgFormate!=null &&!errorMsgFormate.equalsIgnoreCase("")){
                    summary=errorMsgFormate+summary;
                    System.out.println("summary : "+summary);
                }
            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        User user=Login.login;
//        System.out.println("user "+user.getId());
if(user!=null){
logScreenFacade.createLogScreenObject(user,pageId, type, summary);
}
        
    }
   
}
