/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.FtpLog;
import Entities.FtpMessages;
import java.util.List;
import javax.ejb.Local;

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

    public boolean Ftp_action(FtpLog ftp,int type);
    
}
