/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TerminalTemplate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TerminalTemplateFacadeLocal {

    void create(TerminalTemplate terminalTemplate);

    void edit(TerminalTemplate terminalTemplate);

    void remove(TerminalTemplate terminalTemplate);

    TerminalTemplate find(Object id);

    List<TerminalTemplate> findAll();

    List<TerminalTemplate> findRange(int[] range);

    int count();
    
}
