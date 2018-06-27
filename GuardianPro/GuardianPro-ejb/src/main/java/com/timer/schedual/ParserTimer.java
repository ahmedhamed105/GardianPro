/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timer.schedual;

import Email.Encryption;
import Email.FTPLog;
import Email.Ftputils;
import Entities.ConfigParmeter;
import Entities.TerminalParserLog;
import Entities.User;
import Facades.ConfigParmeterFacadeLocal;
import Facades.FtpMessagesFacadeLocal;
import Facades.TerminalParserLogFacadeLocal;
import Facades.UserFacadeLocal;
import static com.timer.schedual.BusinessTimer.FTP_server;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

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
    private ConfigParmeterFacadeLocal configParmeterFacade;
    @EJB
    private UserFacadeLocal userFacade;
    @EJB
    private FtpMessagesFacadeLocal ftpMessagesFacade;

    private FTPClient ftpclien;
    private User login ;

    @Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
    public void execute(Timer timer) {

        System.out.println("Executing ...");

        System.out.println("Execution Time : " + new Date());
        ConfigParmeter configParmeter = terminalLogFile.loadTimerParserParametes("parameter", "TIMER_PARSER_FLAG");
        terminalLogFile.refresh(configParmeter);
        if (configParmeter.getPValue() != null) {
            boolean timerParserFlag = Boolean.parseBoolean(configParmeter.getPValue().trim());
            System.out.println("Timer Parser Flag : " + timerParserFlag);
            if (timerParserFlag) {//here will be data base flage that control the process
                ConfigParmeter logFilePath = terminalLogFile.loadTimerParserParametes("parameter", "TERMINAL_LOG_FILE_PATH");
                terminalLogFile.refresh(logFilePath);
                if (logFilePath.getPValue() != null) {
                    parseandSaveTerminalsLogFiles(logFilePath.getPValue().trim());
                }

            }
        }
        System.out.println("____________________________________________");

    }

    @PostConstruct
    public void init() {
        System.out.println("intit..............");
//        parseTerminalsLogFiles("E:\\3yad\\private\\projects\\GardianPro\\20180602_001014_40000001.LOG");
        connectToFtp();

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
    public boolean connectToFtp() {
        String ftpServer = configParmeterFacade.getparameter("FTP_server").getPValue();
        System.out.println("ftpServer " + ftpServer);
        if (configParmeterFacade.getparameter("FTP_server").getEncryption() == 1) {
            ftpServer = Encryption.decrypt(configParmeterFacade.getparameter("FTP_server").getPValue());
        }
        String ftpPort = configParmeterFacade.getparameter("FTP_port").getPValue();
        System.out.println("ftpPort " + ftpPort);
        if (configParmeterFacade.getparameter("FTP_port").getEncryption() == 1) {
            ftpPort = Encryption.decrypt(configParmeterFacade.getparameter("FTP_port").getPValue());
        }
        String ftpUser = configParmeterFacade.getparameter("FTP_user").getPValue();
        System.out.println("ftpUser " + ftpUser);

        if (configParmeterFacade.getparameter("FTP_user").getEncryption() == 1) {
            ftpUser = Encryption.decrypt(configParmeterFacade.getparameter("FTP_user").getPValue());
        }
        String ftpPass = configParmeterFacade.getparameter("FTP_pass").getPValue();
        System.out.println("ftpPass " + ftpPass);

        if (configParmeterFacade.getparameter("FTP_pass").getEncryption() == 1) {
            ftpPass = Encryption.decrypt(configParmeterFacade.getparameter("FTP_pass").getPValue());
        }
        login = userFacade.find(1);
        Date now = new Date();
        FTPLog ftp = new FTPLog();
        ftp.setfPort(ftpPort);
        ftp.setfUsername(ftpUser);
        ftp.setServerip(FTP_server);
        ftp.setFpassword(ftpPass);
        ftp.setLocalDIR("//");
        ftp.setFilename("");
        ftp.setFtpDir("");
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);

        ftpclien = ftpMessagesFacade.Ftp_open(ftp);

        if (ftpclien == null) {
            return false;
        } else {
            return true;
        }

    }

    private void parseandSaveTerminalsLogFiles(String dirName) {
        try {
            System.out.println("dirName " + dirName);
            boolean dirExist=ftpclien.changeWorkingDirectory(dirName);
            if(dirExist){
                FTPFile[] files=ftpclien.listFiles();
                for (FTPFile file : files) {
//                    connectToFtp();
                    String fileName=file.getName();
                    System.out.println("file name "+fileName);
                    InputStream inputStream = ftpclien.retrieveFileStream(fileName);
                    System.out.println("inputStream "+inputStream);
                    Ftputils.showServerReply(ftpclien);
                    Scanner sc = new Scanner(inputStream);
                    Map<String, String> fileContent = new HashMap<>();
                    while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println(line);
                    String[] values = line.split("=");
                    String key = values[0];
                    String value = values[1];
                    fileContent.put(key, value);
//                    boolean closedFlag=ftpMessagesFacade.Ftp_Close(ftpclien,login);
//                    System.out.println("closedFlag "+closedFlag);
                }
                //Closing the channels
                sc.close();
                inputStream.close();
                boolean readFlag=ftpclien.completePendingCommand();
                System.out.println("is file has been read succussfully "+readFlag);
                System.out.println("File content ... " + fileContent);
                if(fileContent.size()>0){
                    String terminalTid=fileContent.get("TID");
                    if(terminalTid!=null && !terminalTid.equalsIgnoreCase("")){
                        boolean isTerminalLogExist=terminalLogFile.isTerminalLogExist(terminalTid);
                        System.out.println("is terminal log exist before "+isTerminalLogExist);
                        if(isTerminalLogExist){
                            System.out.println(fileName+ " log exist before");

                        }else{
                            createLogAndSave(fileContent);
                        }
                    }
                    
                }
                

                }
            }
//            InputStream inputStream = ftpclien.retrieveFileStream("/TerminalLog/20180602_001014_40000001.LOG");
//            Ftputils.showServerReply(ftpclien);
//            Scanner sc = new Scanner(inputStream);
//            System.out.println("hasNextLine "+sc.hasNextLine());
            //Reading the file line by line and printing the same
//            if (sc.hasNextLine()) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//            Map<String, String> fileContent = new HashMap<>();
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//                String[] values = line.split("=");
//                String key = values[0];
//                String value = values[1];
//                fileContent.put(key, value);
//
//            }
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                System.out.println(line);
//                String[] values = line.split("=");
//                String key = values[0];
//                String value = values[1];
//                fileContent.put(key, value);
//            }

//            }
            //Closing the channels
//            sc.close();
//            inputStream.close();
//            reader.close();
//            System.out.println("File content ... " + fileContent);
//            if(fileContent.size()>0){
//                createLogAndSave(fileContent);
//            }
//            ftpMessagesFacade.Ftp_Close(ftpclien,login);
        } catch (IOException ex) {
            Logger.getLogger(ParserTimer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
