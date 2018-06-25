/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ConfigParmeter;
import Entities.TerminalHasParts;
import Entities.TerminalParserLog;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mohammed.ayad
 */
@Local
public interface TerminalParserLogFacadeLocal {
    
      void create(TerminalParserLog terminalParserLog);

    void edit(TerminalParserLog terminalParserLog);

    void remove(TerminalParserLog terminalParserLog);

    TerminalParserLog find(Object id);

    List<TerminalParserLog> findAll();

    List<TerminalParserLog> findRange(int[] range);

    int count();

    public void saveNewTerminalLog(TerminalParserLog parserLog);

    public ConfigParmeter loadTimerParserParametes(String parameterName,String parameterValue);
    public void refresh(ConfigParmeter configParmeter);
    public boolean isTerminalLogExist(String terminalTid);

}
