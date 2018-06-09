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
    public boolean Ftp_action(FtpLog ftp,int type){
       
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
                return false;
            }
//
            boolean success = ftpClient.login(ftp.getFUsername(), ftp.getFpassword());
            
            System.out.println("login status: " + success);
             mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
        mes.setFmessages(Ftputils.showServerReply(ftpClient));
            create(mes);
             
          //  Ftputils.showServerReply(ftpClient);
//
            if (!success) {
                     mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
       mes.setFmessages("Could not login to the server");
            create(mes);
                 
                System.out.println("Could not login to the server");
               return false;
            } else {
                              mes=new FtpMessages();
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
                
              
                
           
//store in exist folder inside shard folder directly
//                storeNewFile(ftpClient, new File("E:\\3yad\\private\\projects\\GardianPro\\new.txt"), "upload123");
              //  Ftputils.deleteExistDirectory(ftpClient, "download123");
//               Ftputils.deleteExistFile(ftpClient,"Projects.zip");
              //  Ftputils.deleteExistFile(ftpClient,"/upload123/new.txt");


                // logs out
                ftpClient.logout();
                ftpClient.disconnect();
                 if(val.isStatus()){
            return true;
            }else
             return false;

            }

        } catch (IOException ex) {
              mes=new FtpMessages();
        mes.setFTPLogID(ftp);
        mes.setCreateDate(date);
      mes.setFmessages("Oops! Something wrong happened" +ex.getMessage());
            create(mes);      
            System.out.println("Oops! Something wrong happened");
            System.err.println(ex);
            return false;
        }
    
    }
    
    
      
}
