/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.EmailLog;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface EmailLogFacadeLocal {

    void create(EmailLog emailLog);

    void edit(EmailLog emailLog);

    void remove(EmailLog emailLog);

    EmailLog find(Object id);

    List<EmailLog> findAll();

    List<EmailLog> findRange(int[] range);

    int count();
    
    boolean send_email(EmailLog em);
    
}
