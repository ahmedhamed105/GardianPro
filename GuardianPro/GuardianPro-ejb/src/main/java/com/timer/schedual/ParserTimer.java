/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timer.schedual;

import Entities.ConfigParmeter;
import Entities.TerminalParserLog;
import Facades.TerminalFacadeLocal;
import Facades.TerminalParserLogFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

/**
 *
 * @author martin
 */
//@Startup
@Singleton
@LocalBean
public class ParserTimer {

    @EJB
    TerminalParserLogFacadeLocal terminalLogFile;
    @EJB
    private UserFacadeLocal userFacade;

    @Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
    public void execute(Timer timer) {

        System.out.println("Executing ...");

        System.out.println("Execution Time : " + new Date());
        ConfigParmeter configParmeter = terminalLogFile.loadTimerParserParametes("parameter", "TIMER_PARSER_FLAG");
        terminalLogFile.refresh(configParmeter);
        if(configParmeter.getPValue()!=null){
            boolean timerParserFlag = Boolean.parseBoolean(configParmeter.getPValue().trim());
            System.out.println("Timer Parser Flag : " + timerParserFlag);
            if (timerParserFlag) {//here will be data base flage that control the process
                ConfigParmeter logFilePath = terminalLogFile.loadTimerParserParametes("parameter", "TERMINAL_LOG_FILE_PATH");
                terminalLogFile.refresh(logFilePath);
                if(logFilePath.getPValue()!=null){
                    parseTerminalsLogFiles(logFilePath.getPValue().trim());
                }

            }
        }
        System.out.println("____________________________________________");

    }

    @PostConstruct
    public void init() {
        System.out.println("intit..............");
//        parseTerminalsLogFiles("E:\\3yad\\private\\projects\\GardianPro\\20180602_001014_40000001.LOG");
       
    }

    private void parseTerminalsLogFiles(String filePath) {
        try {
            System.out.format("Start parsing terminal log file:\n %s", filePath);
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            if (lines != null && lines.size() > 0) {
                Map<String, String> fileContent = new HashMap<>();
                for (String line : lines) {
                    String[] values = line.split("=");
                    String key = values[0];
                    String value = values[1];
                    fileContent.put(key, value);

                }
                System.out.println("File content ... " + fileContent);
                createLogAndSave(fileContent);
            }
            System.out.format("end parsing terminal log file:\n %s", filePath);

        } catch (IOException ex) {
            System.err.println(ex);

        }

    }

    private void createLogAndSave(Map<String, String> fileContent) {
        TerminalParserLog parserLog = new TerminalParserLog();
        parserLog.setTid(fileContent.get("TID"));
        parserLog.setDt(fileContent.get("DT"));
        parserLog.setVer(fileContent.get("VER"));
        parserLog.setMode(fileContent.get("MODE"));
        parserLog.setErr(fileContent.get("ERR"));
        terminalLogFile.saveNewTerminalLog(parserLog);
//        com.guardian.Login.
//        Login.login = userFacade.find(1);
//        if(Login.login==null || Login.login.getId() == 0){
//            
//        }}

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
