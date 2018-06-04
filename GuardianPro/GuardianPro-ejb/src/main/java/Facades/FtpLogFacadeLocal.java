/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.FtpLog;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface FtpLogFacadeLocal {

    void create(FtpLog ftpLog);

    void edit(FtpLog ftpLog);

    void remove(FtpLog ftpLog);

    FtpLog find(Object id);

    List<FtpLog> findAll();

    List<FtpLog> findRange(int[] range);

    int count();
    
   
    
}
