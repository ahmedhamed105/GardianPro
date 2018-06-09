/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ConfigParmeter;
import Entities.TerminalParserLog;
import javax.ejb.Local;

/**
 *
 * @author mohammed.ayad
 */
@Local
public interface TerminalParserLogFacadeLocal {

    public void saveNewTerminalLog(TerminalParserLog parserLog);

    public ConfigParmeter loadTimerParserParametes(String parameterName,String parameterValue);
    public void refresh(ConfigParmeter configParmeter);

}
