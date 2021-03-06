/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Email.FTPLog;
import Entities.FtpMessages;
import Entities.User;
import java.util.List;
import javax.ejb.Local;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface FtpMessagesFacadeLocal {

    void create(FtpMessages ftpMessages);

    void edit(FtpMessages ftpMessages);

    void remove(FtpMessages ftpMessages);

    FtpMessages find(Object id);

    List<FtpMessages> findAll();

    List<FtpMessages> findRange(int[] range);

    int count();
    
    public FTPClient Ftp_open(FTPLog ftp);
    
    public boolean Ftp_Close(FTPClient ftpClient,User userID);

    public boolean Ftp_action(FTPLog ftp,int type,FTPClient ftpClient);
    
}
