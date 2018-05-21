/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timer.schedual;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
//import org.apache.commons.io.FileUtils;

/**
 *
 * @author ahmed.ibraheem
 */
@Singleton
@LocalBean
@Startup
public class IntervalTimer {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Resource
    private TimerService timerService;
    
    @PostConstruct
    private void init()
    {
        timerService.createTimer(20, "IntervalTimerDemo_Info");
    }
    
    @Timeout
    public void execute(Timer timer) {
        System.out.println("Timer Service : " + timer.getInfo());
        System.out.println("Current Time : " + new Date());
        System.out.println("Next Timeout : " + timer.getNextTimeout());
        System.out.println("Time Remaining : " + timer.getTimeRemaining());
        System.out.println("____________________________________________");
        Date fileDate = new Date();
        String fileExt;
        fileExt= String.valueOf(fileDate.getTimezoneOffset());     
//         try {
//            Path fileToMovePath = 
//                Files.createFile(Paths.get("F:/FIB/Git/My Works/test2/" + fileExt + ".txt"));
//            Path targetPath = Paths.get("F:/FIB/Git/My Works/test/");
//            Files.move(fileToMovePath, targetPath.resolve(fileToMovePath.getFileName()));
//        } catch (IOException ex) {
//            Logger.getLogger(IntervalTimer.class.getName()).log(Level.SEVERE, null, ex);
//        }

        File source = new File("F:/FIB/Git/My Works/test/XMLfile.txt");
        File destination = new File("F:/FIB/Git/My Works/test2/XMLfile"+fileExt+".txt");
       boolean result =  move(source,destination);
        System.out.println("File Result >>>>" +result);
    }
    
    
    private boolean move(File sourceFile, File destFile)
    {
        if (sourceFile.isDirectory())
        {
            for (File file : sourceFile.listFiles())
            {
                move(file, new File(file.getPath().substring("temp".length()+1)));
            }
        }
        else
        {
            try {
                Files.move(Paths.get(sourceFile.getPath()), Paths.get(destFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

}
