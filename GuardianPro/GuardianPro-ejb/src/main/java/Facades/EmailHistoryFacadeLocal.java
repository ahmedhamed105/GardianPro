/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.EmailHistory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface EmailHistoryFacadeLocal {

    void create(EmailHistory emailHistory);

    void edit(EmailHistory emailHistory);

    void remove(EmailHistory emailHistory);

    EmailHistory find(Object id);

    List<EmailHistory> findAll();

    List<EmailHistory> findRange(int[] range);

    int count();
    
}
