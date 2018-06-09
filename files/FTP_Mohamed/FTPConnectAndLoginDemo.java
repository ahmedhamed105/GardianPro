package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPConnectAndLoginDemo {

    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("showServerReply SERVER: " + aReply);
            }
        }
    }

    public static boolean createNewDirectory(FTPClient ftpClient, String directoryName) {
        boolean dirFlag = false;
        try {
            System.out.format("Create New Directory: %s", directoryName);
            dirFlag = ftpClient.makeDirectory("/" + directoryName);
            showServerReply(ftpClient);
            if (dirFlag) {
                System.out.println("Successfully created directory: " + directoryName);
            } else {
                System.out.println("Failed to create directory. See server's reply.");
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
        return dirFlag;
    }

    public static boolean storeNewFile(FTPClient ftpClient, File newFile, String storedPath) {
        boolean fileFlag = false;
        String actualFilePath = null;
        try {
            System.out.format("store New File: %s", newFile);
            if (storedPath != null && !storedPath.equalsIgnoreCase("")) {//have folder name to store in
                System.out.println("has folders to store in ");
                actualFilePath = "/" + storedPath + "/" + newFile.getName();

            } else {
                System.out.println("hasn't folders to store in ");
                actualFilePath = newFile.getName();

            }
            System.out.println("actual File Path: " + actualFilePath);
            InputStream storedFile = new FileInputStream(newFile);
            fileFlag = ftpClient.storeFile(actualFilePath, storedFile);
            showServerReply(ftpClient);
            if (fileFlag) {
                System.out.println("Successfully created file: " + newFile.getName());
            } else {
                System.out.println("Failed to create file. See server's reply.");
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
        return fileFlag;
    }

    public static boolean deleteExistDirectory(FTPClient ftpClient, String directoryName) {
        boolean dirFlag = false;
        try {
            System.out.format("delete exist Directory: %s", directoryName);
            dirFlag = ftpClient.removeDirectory("/" + directoryName);
            showServerReply(ftpClient);
            if (dirFlag) {
                System.out.println("Successfully deleted directory: " + directoryName);
            } else {
                System.out.println("Failed to delete directory. See server's reply.");
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
        return dirFlag;
    }

    public static boolean deleteExistFile(FTPClient ftpClient, String fileName) {
        boolean dirFlag = false;
        try {
            System.out.format("delete exist File: %s", fileName);
            dirFlag = ftpClient.deleteFile(fileName);
            showServerReply(ftpClient);
            if (dirFlag) {
                System.out.println("Successfully deleted file: " + fileName);
            } else {
                System.out.println("Failed to delete file. See server's reply.");
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
        return dirFlag;
    }

    public static void main(String[] args) {
        String server = "localhost";
        int port = 21;
        String user = "ayad";
        String pass = "";

        FTPClient ftpClient = new FTPClient();

        try {

            ftpClient.connect(server, port);
            showServerReply(ftpClient);

            int replyCode = ftpClient.getReplyCode();
            System.out.println("Server reply code: " + replyCode);
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
//
            boolean success = ftpClient.login(user, pass);
            System.out.println("login status: " + success);
            showServerReply(ftpClient);
//
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
//                createNewDirectory(ftpClient, "download123");
                //store in shard folder directly
//                storeNewFile(ftpClient, new File("E:\\3yad\\private\\projects\\GardianPro\\new.txt"),"");
                //store in exist folder inside shard folder directly
//                storeNewFile(ftpClient, new File("E:\\3yad\\private\\projects\\GardianPro\\new.txt"), "upload123");
//                deleteExistDirectory(ftpClient, "download123");
//                deleteExistFile(ftpClient,"Projects.zip");
                deleteExistFile(ftpClient,"/upload123/new.txt");


                // logs out
                ftpClient.logout();
                ftpClient.disconnect();

            }

        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            System.err.println(ex);
        }
    }
}
