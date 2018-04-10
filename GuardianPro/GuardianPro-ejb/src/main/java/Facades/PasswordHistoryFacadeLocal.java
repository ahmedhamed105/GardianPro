/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.PasswordHistory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface PasswordHistoryFacadeLocal {

    void create(PasswordHistory passwordHistory);

    void edit(PasswordHistory passwordHistory);

    void remove(PasswordHistory passwordHistory);

    PasswordHistory find(Object id);

    List<PasswordHistory> findAll();

    List<PasswordHistory> findRange(int[] range);

    int count();
    
}
