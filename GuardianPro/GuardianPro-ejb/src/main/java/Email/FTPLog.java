/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Entities.User;
import java.util.Date;

/**
 *
 * @author ahmed.elemam
 */
public class FTPLog {
    
   
    private String ftpDir;
  
    private String localDIR;
   
    private String filename;
    
    private String fUsername;
   
    private String fpassword;
   
    private String fPort;
   
    private Date createDate;
   
    private Date updateDate;
   
    private User userID;
    
     private String serverip;

    public String getServerip() {
        return serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
    }
     
     

    public String getFtpDir() {
        return ftpDir;
    }

    public void setFtpDir(String ftpDir) {
        this.ftpDir = ftpDir;
    }

    public String getLocalDIR() {
        return localDIR;
    }

    public void setLocalDIR(String localDIR) {
        this.localDIR = localDIR;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getfUsername() {
        return fUsername;
    }

    public void setfUsername(String fUsername) {
        this.fUsername = fUsername;
    }

    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword;
    }

    public String getfPort() {
        return fPort;
    }

    public void setfPort(String fPort) {
        this.fPort = fPort;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }
    
    
    
    
    
}
