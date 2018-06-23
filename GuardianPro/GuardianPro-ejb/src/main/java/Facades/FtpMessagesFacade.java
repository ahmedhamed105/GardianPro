/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Email.Ftputils;
import Email.returnvalues;
import Entities.FtpLog;
import Entities.FtpMessages;
import java.io.File;
import java.io.IOException;
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
    public FTPClient Ftp_open(FtpLog ftp){
     Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        FTPClient ftpClient = new FTPClient();
    
        FtpMessages mes;

        try {

        ftpClient.connect(ftp.getServerip(), Integer.parseInt(ftp.getFPort()));
        mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
        mes.setFmessages(Ftputils.showServerReply(ftpClient));
        create(mes);

            int replyCode = ftpClient.getReplyCode();
            System.out.println("Server reply code: " + replyCode);
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                  mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
         mes.setFmessages("Operation failed. Server reply code: " + replyCode);
            create(mes);
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return null;
            }
//
            boolean success = ftpClient.login(ftp.getFUsername(), ftp.getFpassword());
            
            
            if(success){
              System.out.println("login status: " + success);
             mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
        mes.setFmessages(Ftputils.showServerReply(ftpClient));
            create(mes);
            
            return ftpClient;
            }else{
              System.out.println("login status: " + success);
             mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
        mes.setFmessages(Ftputils.showServerReply(ftpClient));
            create(mes);
            
            return null;
            
            }
          
        } catch (IOException ex) {
              mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
      mes.setFmessages("Oops! Something wrong happened" +ex.getMessage());
            create(mes);      
            System.out.println("Oops! Something wrong happened");
            System.err.println(ex);
            return null;
        }
    
    }
    
     @Override
    public boolean Ftp_action(FtpLog ftp,int type,FTPClient ftpClient){
       
       
          //  Ftputils.showServerReply(ftpClient);
//
try {
             
        
 Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
     
      FtpMessages  mes=new FtpMessages();
        mes.setFTPLogID(ftp);
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
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
           
                }else if(type == 2){
                // create DIR
                      val=  Ftputils.createNewDirectory(ftpClient,ftp.getFtpDir());
               mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 3){
                //delete Exis tDirectory
                      val=  Ftputils.deleteExistDirectory(ftpClient,ftp.getFtpDir());
               mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 4){
                //delete Exis file
                      val=  Ftputils.deleteExistFile(ftpClient,ftp.getFtpDir()+ftp.getFilename());
               mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 5){
               val=  Ftputils.checkFileExists(ftpClient,ftp.getFtpDir()+ftp.getFilename());
               mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 6){
               val=  Ftputils.CopyfileFTP(ftpClient,ftp.getFtpDir(),ftp.getFilename(),ftp.getLocalDIR());
               mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
       mes.setFmessages(val.getMessage());
            create(mes);
                
                }else if(type == 7){
               val=  Ftputils.checkFileExists(ftpClient,ftp.getFtpDir());
               mes=new FtpMessages();
        mes.setFTPLogID(ftp);
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
    public boolean Ftp_Close(FTPClient ftpClient){
        try {
            ftpClient.logout();
            ftpClient.disconnect();
           return true;
        } catch (IOException ex) {
            Logger.getLogger(FtpMessagesFacade.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }

        
    
    }
    
    

