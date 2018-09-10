/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Email.FTPLog;
import Email.Ftputils;
import Email.returnvalues;
import Entities.FtpMessages;
import Entities.User;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class FtpMessagesFacade extends AbstractFacade<FtpMessages> implements FtpMessagesFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FtpMessagesFacade() {
        super(FtpMessages.class);
    }
    
    
    
    
    
     @Override
    public FTPClient Ftp_open(FTPLog ftp){
     Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        FTPClient ftpClient = new FTPClient();
    
        FtpMessages mes;

        try {

        ftpClient.connect(ftp.getServerip(), Integer.parseInt(ftp.getfPort()));
        mes=new FtpMessages();
        mes.setFTPLogID(0);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
        mes.setFmessages(Ftputils.showServerReply(ftpClient));
        create(mes);

            int replyCode = ftpClient.getReplyCode();
            System.out.println("Server reply code: " + replyCode);
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                  mes=new FtpMessages();
        mes.setFTPLogID(0);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
         mes.setFmessages("Operation failed. Server reply code: " + replyCode);
            create(mes);
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return null;
            }
//
            boolean success = ftpClient.login(ftp.getfUsername(), ftp.getFpassword());
            
            
            if(success){
              System.out.println("login status: " + success);
             mes=new FtpMessages();
        mes.setFTPLogID(0);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
        mes.setFmessages(Ftputils.showServerReply(ftpClient));
            create(mes);
            
            return ftpClient;
            }else{
              System.out.println("login status: " + success);
             mes=new FtpMessages();
       mes.setFTPLogID(0);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
        mes.setFmessages(Ftputils.showServerReply(ftpClient));
            create(mes);
            
            return null;
            
            }
          
        } catch (Exception ex) {
              mes=new FtpMessages();
       mes.setFTPLogID(0);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
      mes.setFmessages("Oops! Something wrong happened" +ex.getMessage());
            create(mes);      
            System.out.println("Oops! Something wrong happened");
            System.err.println(ex);
            return null;
        }
    
    }
    
     @Override
    public boolean Ftp_action(FTPLog ftp,int type,FTPClient ftpClient){
       
       
          //  Ftputils.showServerReply(ftpClient);
//
try {
             
        
 Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
     
      FtpMessages  mes=new FtpMessages();
         mes.setFTPLogID(0);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages("LOGGED IN SERVER");
            create(mes);
                 
                System.out.println("LOGGED IN SERVER");
//                Ftputils.createNewDirectory(ftpClient, "download123");
                //store in shard folder directly
                returnvalues val = null;
                if(type == 1){
                   val=  Ftputils.storeNewFile(ftpClient, new File(ftp.getLocalDIR()+ftp.getFilename()),ftp.getFtpDir());
               mes=new FtpMessages();
        mes.setFTPLogID(1);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
           
                }else if(type == 2){
                // create DIR
                      val=  Ftputils.createNewDirectory(ftpClient,ftp.getFtpDir());
               mes=new FtpMessages();
        mes.setFTPLogID(2);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 3){
                //delete Exis tDirectory
                      val=  Ftputils.deleteExistDirectory(ftpClient,ftp.getFtpDir());
               mes=new FtpMessages();
        mes.setFTPLogID(3);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 4){
                //delete Exis file
                      val=  Ftputils.deleteExistFile(ftpClient,ftp.getFtpDir()+ftp.getFilename());
               mes=new FtpMessages();
        mes.setFTPLogID(4);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 5){
               val=  Ftputils.checkFileExists(ftpClient,ftp.getFtpDir()+ftp.getFilename());
               mes=new FtpMessages();
      mes.setFTPLogID(5);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 6){
               val=  Ftputils.CopyfileFTP(ftpClient,ftp.getFtpDir(),ftp.getFilename(),ftp.getLocalDIR());
               mes=new FtpMessages();
      mes.setFTPLogID(6);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 7){
               val=  Ftputils.checkFileExists(ftpClient,ftp.getFtpDir());
               mes=new FtpMessages();
       mes.setFTPLogID(7);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }
                else if(type == 8){
               val=   Ftputils.deleteExistFileFolder(ftpClient,ftp.getFtpDir());
               mes=new FtpMessages();
       mes.setFTPLogID(8);
        mes.setUserID(ftp.getUserID());
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }
                
    return val.isStatus();
          

 } catch (Exception e) {
     
    return false;
}

    }

    @Override
    public boolean Ftp_Close(FTPClient ftpClient,User userID){
       
   
          Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        try {
   
            ftpClient.logout();
            ftpClient.disconnect();
                FtpMessages  mes=new FtpMessages();
         mes.setFTPLogID(100);
        mes.setUserID(userID);
        mes.setCreateDate(date);
       mes.setFmessages("disconnect FTP session");
            create(mes);
           return true;
        } catch (IOException ex) {
             FtpMessages  mes=new FtpMessages();
         mes.setFTPLogID(100);
        mes.setUserID(userID);
        mes.setCreateDate(date);
       mes.setFmessages("Error disconnect FTP session "+ex.getMessage());
            create(mes);
             return false;
        }
    }

        
    
    }
    
    

