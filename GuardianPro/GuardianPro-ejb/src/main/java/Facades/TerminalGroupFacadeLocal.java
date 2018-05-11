/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TerminalGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TerminalGroupFacadeLocal {

    void create(TerminalGroup terminalGroup);

    void edit(TerminalGroup terminalGroup);

    void remove(TerminalGroup terminalGroup);

    TerminalGroup find(Object id);

    List<TerminalGroup> findAll();

    List<TerminalGroup> findRange(int[] range);

    int count();
    
    boolean group_find(String group);
    
}
