package com.guardian.util;

import Entities.ActionLog;
import Entities.User;
import Facades.ActionLogFacade;
import Facades.ActionLogFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author mohamed.sobhi
 */
public class ActionlogingUtil {

    public static ActionLog addToLogging(String pagename, User user, String message) {
        ActionLog log = new ActionLog();
        log.setActionDate(new Date());
        log.setMessage(message);
        log.setPagename(pagename);
        log.setUserID(user);

        return log;
    }

}
