/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.EmailSmsSend;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface EmailSmsSendFacadeLocal {

    void create(EmailSmsSend emailSmsSend);

    void edit(EmailSmsSend emailSmsSend);

    void remove(EmailSmsSend emailSmsSend);

    EmailSmsSend find(Object id);

    List<EmailSmsSend> findAll();

    List<EmailSmsSend> findRange(int[] range);

    int count();
    
}
