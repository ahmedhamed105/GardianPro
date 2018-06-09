/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Email.Ftputils;
import static Email.Ftputils.storeNewFile;
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
public class FtpLogFacade extends AbstractFacade<FtpLog> implements FtpLogFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FtpLogFacade() {
        super(FtpLog.class);
    }
    
    
   
    
}
