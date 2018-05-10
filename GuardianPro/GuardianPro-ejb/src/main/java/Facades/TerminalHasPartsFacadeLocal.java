/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TerminalHasParts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TerminalHasPartsFacadeLocal {

    void create(TerminalHasParts terminalHasParts);

    void edit(TerminalHasParts terminalHasParts);

    void remove(TerminalHasParts terminalHasParts);

    TerminalHasParts find(Object id);

    List<TerminalHasParts> findAll();

    List<TerminalHasParts> findRange(int[] range);

    int count();
    
}
