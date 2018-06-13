/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ConfigParmeter;
import Facades.ConfigParmeterFacadeLocal;
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

    static {

        ConfigParmeterFacadeLocal configParmeterFacade = (ConfigParmeterFacadeLocal) Constants.lookupEJB("ConfigParmeterFacade");
        if (configParmeterFacade != null) {
            System.out.println("success to load config Parmeter");
            messagesFormate = configParmeterFacade.findAllMessagesFormat("INFO_MESSAGE_FORMATE", "ERROR_MESSAGE_FORMATE","EXCEPTION_MESSAGE_FORMATE");
            System.out.println("messages Formate "+messagesFormate);
        } else {
            System.out.println("failed to load config Parmeter");

        }

    }

    /**
     * Creates a new instance of Messages
     */
    public Messages() {
    }

    public static void addInfoMessage(String summary, int type) {
        if (type == 1) {
            String infoMsgFormate=messagesFormate.get(0).getPValue();
            if(infoMsgFormate!=null &&!infoMsgFormate.equalsIgnoreCase("")){
                summary=infoMsgFormate+summary;
                System.out.println("summary : "+summary);
            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (type == 2) {
            String errorMsgFormate=messagesFormate.get(0).getPValue();
            if(errorMsgFormate!=null &&!errorMsgFormate.equalsIgnoreCase("")){
                summary=errorMsgFormate+summary;
                System.out.println("summary : "+summary);
            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

}
