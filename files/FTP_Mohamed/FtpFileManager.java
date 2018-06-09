/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohammed.ayad
 */
public class FtpFileManager {
    
    public static void createNewFile(String filePath, String fileContent) {
        System.out.format("Create New File:\n %s" + "\n with content:\n %s", filePath, fileContent);
        try {
            Path path = Paths.get(filePath);
            Files.write(path, fileContent.getBytes());
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
    }
    
    public static void createNewDirectory(String directoryPath) {
        System.out.format("Create New Directory: %s", directoryPath);
        try {
            Path path = Paths.get(directoryPath);
            Files.createDirectories(path);
        } catch (IOException ex) {
            System.err.println(ex);
            
        }
        
    }
    
    public static void deleteExistFileOrDirectory(String dirOrFilepath) {
        System.out.format("Delete Exist File Or Directory: %s", dirOrFilepath);
        try {
            Path path = Paths.get(dirOrFilepath);
            Files.delete(path);
        } catch (NoSuchFileException ex) {
            System.err.println(ex);
            System.err.format("%s: no such" + " file or directory%n", dirOrFilepath);
        } catch (DirectoryNotEmptyException ex) {
            System.err.println(ex);
            System.err.format("%s not empty%n", dirOrFilepath);
        } catch (IOException ex) {
            // File permission problems are caught here.
            System.err.println(ex);
            System.err.println(ex);
            
        }
        
    }
    
    public static void main(String[] args) {
        String xml = "<Root>\n"
                + "    <PsSystem>PS-ECC</PsSystem>\n"
                + "    <MessageType>Presentment</MessageType>\n"
                + "    <ResponseDate>2016-11-10</ResponseDate>\n"
                + "    <ResponseTime>173036</ResponseTime>\n"
                + "    <TranSequence>16</TranSequence>\n"
                + "    <ErrorCode>00</ErrorCode>\n"
                + "    <ErrorDescription>No row was found in DP_ACCT.</ErrorDescription>\n"
                + "    <ChequeSequence>1150000000</ChequeSequence>\n"
                + "</Root>";
        String filePath = "E:\\3yad\\private\\projects\\GardianPro\\FtpFilesTest\\ayad\\presentmenyRS.xml";
        String dirPath = "E:\\3yad\\private\\projects\\GardianPro\\FtpFilesTest\\ayad";

//        createNewFile(filePath, xml);
//        deleteExistFileOrDirectory(filePath);
//        createNewDirectory(dirPath);
        deleteExistFileOrDirectory(dirPath);

    }
    
}
