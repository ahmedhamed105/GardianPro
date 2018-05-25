/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TerminalStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TerminalStatusFacadeLocal {

    void create(TerminalStatus terminalStatus);

    void edit(TerminalStatus terminalStatus);

    void remove(TerminalStatus terminalStatus);

    TerminalStatus find(Object id);

    List<TerminalStatus> findAll();

    List<TerminalStatus> findRange(int[] range);

    int count();
    
}
