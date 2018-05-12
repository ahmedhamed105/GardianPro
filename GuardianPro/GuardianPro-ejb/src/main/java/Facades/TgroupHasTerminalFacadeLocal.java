/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Terminal;
import Entities.TgroupHasTerminal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TgroupHasTerminalFacadeLocal {

    void create(TgroupHasTerminal tgroupHasTerminal);

    void edit(TgroupHasTerminal tgroupHasTerminal);

    void remove(TgroupHasTerminal tgroupHasTerminal);

    TgroupHasTerminal find(Object id);

    List<TgroupHasTerminal> findAll();

    List<TgroupHasTerminal> findRange(int[] range);

    int count();
    
    boolean find_term(Terminal term);
    
}
