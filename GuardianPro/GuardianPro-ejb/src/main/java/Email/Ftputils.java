/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author ahmed.elemam
 */
public class Ftputils {
    
   public static String showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        StringBuffer buf=new StringBuffer();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {      
                buf.append("showServerReply SERVER: "+aReply+" ");
                System.out.println("showServerReply SERVER: " + aReply);
            }
        }
        return buf.toString();
    }

    public static returnvalues createNewDirectory(FTPClient ftpClient, String directoryName) {
        boolean dirFlag = false;
        StringBuilder buf=new StringBuilder();
        returnvalues val=new returnvalues();
        try {
            System.out.format("Create New Directory: %s", directoryName);
            dirFlag = ftpClient.makeDirectory("/" + directoryName);
            buf.append(showServerReply(ftpClient));
            if (dirFlag) {
                buf.append(" Successfully created directory: " + directoryName);
                System.out.println("Successfully created directory: " + directoryName);
            } else {
                 buf.append(" Failed to create directory. See server's reply.");
                System.out.println("Failed to create directory. See server's reply.");
            }

        } catch (IOException ex) {
             buf.append(ex.getMessage());
            System.err.println(ex);
        }
         val.setStatus(dirFlag);
        val.setMessage(buf.toString());
        return val;
    }

    public static returnvalues storeNewFile(FTPClient ftpClient, File newFile, String storedPath) {
        boolean fileFlag = false;
        String actualFilePath = null;
        StringBuilder buf=new StringBuilder();
        returnvalues val=new returnvalues();
        try {
             buf.append(",store New File: "+newFile.getName());
            System.out.format("store New File: %s", newFile);
            if (storedPath != null && !storedPath.equalsIgnoreCase("")) {//have folder name to store in
                buf.append(",has folders to store in ");
                System.out.println(",has folders to store in ");
                actualFilePath = "/" + storedPath + "/" + newFile.getName();

            } else {
                 buf.append(",hasn't folders to store in ");
                System.out.println("hasn't folders to store in ");
                actualFilePath = newFile.getName();

            }
            System.out.println("actual File Path: " + actualFilePath);
            buf.append(",actual File Path: " + actualFilePath);
            InputStream storedFile = new FileInputStream(newFile);
            fileFlag = ftpClient.storeFile(actualFilePath, storedFile);
             buf.append(showServerReply(ftpClient));
            if (fileFlag) {
                 buf.append(",Successfully created file: " + newFile.getName());
                System.out.println("Successfully created file: " + newFile.getName());
            } else {
                 buf.append("Failed to create file. See server's reply.");
                System.out.println("Failed to create file. See server's reply.");
            }

        } catch (IOException ex) {
            buf.append(","+ex);
            System.err.println(ex);
        }
        val.setStatus(fileFlag);
        val.setMessage(buf.toString());
        return val;
    }

    public static returnvalues deleteExistDirectory(FTPClient ftpClient, String directoryName) {
        boolean dirFlag = false;
          StringBuilder buf=new StringBuilder();
        returnvalues val=new returnvalues();
        try {
            System.out.format("delete exist Directory: %s", directoryName);
            dirFlag = ftpClient.removeDirectory("/" + directoryName);
           buf.append(showServerReply(ftpClient));
            if (dirFlag) {
                buf.append(" Successfully deleted directory: " + directoryName);
                System.out.println("Successfully deleted directory: " + directoryName);
            } else {
                buf.append(" Failed to delete directory. See server's reply.");
                System.out.println("Failed to delete directory. See server's reply.");
            }

        } catch (IOException ex) {
             buf.append(ex.getMessage());
            System.err.println(ex);
        }
         val.setStatus(dirFlag);
        val.setMessage(buf.toString());
        return val;
    }

    public static returnvalues deleteExistFile(FTPClient ftpClient, String fileName) {
        boolean dirFlag = false;
           StringBuilder buf=new StringBuilder();
        returnvalues val=new returnvalues();
        try {
            System.out.format("delete exist File: %s", fileName);
            dirFlag = ftpClient.deleteFile(fileName);
            buf.append(showServerReply(ftpClient));
            if (dirFlag) {
                buf.append(" Successfully deleted file: " + fileName);
                System.out.println("Successfully deleted file: " + fileName);
            } else {
                buf.append(" Failed to delete file. See server's reply.");
                System.out.println("Failed to delete file. See server's reply.");
            }

        } catch (IOException ex) {
             buf.append(ex.getMessage());
            System.err.println(ex);
        }
          val.setStatus(dirFlag);
        val.setMessage(buf.toString());
        return val;
    }
    
}
