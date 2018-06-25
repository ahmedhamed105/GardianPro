/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timer.schedual;

import Email.Encryption;
import Email.FTPLog;
import Entities.AccessoryHasGroup;
import Entities.ApplicationHasGroup;
import Entities.EmailLog;
import Entities.ParameterValues;
import Entities.Pgchild;
import Entities.TerminalHasParts;
import Entities.TgroupHasAccesory;
import Entities.TgroupHasGparameter;
import Entities.TgroupHasSoftware;
import Entities.TgroupHasTerminal;
import Entities.User;
import Facades.AccessoryGroupFacadeLocal;
import Facades.AccessoryHasGroupFacadeLocal;
import Facades.ApplicationGroupFacadeLocal;
import Facades.ApplicationHasGroupFacadeLocal;
import Facades.ConfigParmeterFacadeLocal;
import Facades.EmailLogFacadeLocal;
import Facades.FtpMessagesFacadeLocal;
import Facades.GroupHasParameterFacadeLocal;
import Facades.ParameterFacadeLocal;
import Facades.ParameterGroupFacadeLocal;
import Facades.ParameterValuesFacadeLocal;
import Facades.PgchildFacadeLocal;
import Facades.TerminalFacadeLocal;
import Facades.TerminalGroupFacadeLocal;
import Facades.TerminalHasPartsFacadeLocal;
import Facades.TerminalTemplateFacadeLocal;
import Facades.TgroupHasAccesoryFacadeLocal;
import Facades.TgroupHasGparameterFacadeLocal;
import Facades.TgroupHasSoftwareFacadeLocal;
import Facades.TgroupHasTerminalFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.File;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author martin
 */
//@Startup
@Singleton
@LocalBean
public class BusinessTimer {
     @EJB
    private PgchildFacadeLocal pgchildFacade;

    @EJB
    private ParameterValuesFacadeLocal parameterValuesFacade;


    @EJB
    private ParameterFacadeLocal parameterFacade;
    
     @EJB
    private GroupHasParameterFacadeLocal groupHasParameterFacade;

   
    @EJB
    private TgroupHasAccesoryFacadeLocal tgroupHasAccesoryFacade;

    @EJB
    private TgroupHasGparameterFacadeLocal tgroupHasGparameterFacade;

    @EJB
    private TgroupHasSoftwareFacadeLocal tgroupHasSoftwareFacade;

    @EJB
    private TgroupHasTerminalFacadeLocal tgroupHasTerminalFacade;

    @EJB
    private ParameterGroupFacadeLocal parameterGroupFacade;

    @EJB
    private AccessoryGroupFacadeLocal accessoryGroupFacade;

    @EJB
    private ApplicationGroupFacadeLocal applicationGroupFacade;
    
      @EJB
    private TerminalGroupFacadeLocal terminalGroupFacade;
      
        @EJB
    private UserFacadeLocal userFacade;
        
         @EJB
    private TerminalFacadeLocal terminalFacade;
         
          @EJB
    private TerminalTemplateFacadeLocal terminalTemplateFacade;
    @EJB
    private FtpMessagesFacadeLocal ftpMessagesFacade;

    @EJB
    private EmailLogFacadeLocal emailLogFacade;
     @EJB
    private ConfigParmeterFacadeLocal configParmeterFacade;
         @EJB
    private TerminalHasPartsFacadeLocal terminalHasPartsFacade;
    @EJB
    private AccessoryHasGroupFacadeLocal accessoryHasGroupFacade;
    @EJB
    private ApplicationHasGroupFacadeLocal applicationHasGroupFacade;
    
    
    
                  static String smtp_host="smtp.gmail.com"; //SMTP Server
		static String smtp_from="ahmed2000105@gmail.com";//from account
		static String smtp_password="P@ssw0rd0109045227";     //password from account
		static String smtp_to="ahmed.hamed0@me.com";//recipient account
                static String smtp_port="587";//recipient account
                static int smtp_TLS=1;//recipient account
                static String FTP_server = "localhost";
                static String FTP_port = "21";
                static String FTP_user = "ahmed";
                static String FTP_pass = "123456";  
                
                static String FTP_APP_DIR = "\\APPLICATION\\"; 
                static String FTP_APP_Live_DIR = "\\APP\\"; 
                static String FTP_LOCAL_DIR = "C:\\"; 
                static String FTP_XML_Live_DIR = "\\POS\\"; 
                static User login;
                static FTPClient ftpclien;
                boolean ftp_open=false;   
                int ftp_status=0; 
                
                
   List<TgroupHasTerminal> groupHasTerminal= new ArrayList<TgroupHasTerminal>();


   @Schedule(hour = "*", minute = "*", second = "*/30", persistent = false)
    public void execute(Timer timer) {

        System.out.println("XML Executing ...");
        
            smtp_host=configParmeterFacade.getparameter("smtp_host").getPValue(); //SMTP Server
              if(configParmeterFacade.getparameter("smtp_host").getEncryption()==1){
                smtp_host=Encryption.decrypt(configParmeterFacade.getparameter("smtp_host").getPValue());
                }
		smtp_from=configParmeterFacade.getparameter("smtp_from").getPValue();//from account
                if(configParmeterFacade.getparameter("smtp_from").getEncryption()==1){
                smtp_from=Encryption.decrypt(configParmeterFacade.getparameter("smtp_from").getPValue());
                }
		smtp_password=configParmeterFacade.getparameter("smtp_password").getPValue();     //password from account
		 if(configParmeterFacade.getparameter("smtp_password").getEncryption()==1){
                smtp_password=Encryption.decrypt(configParmeterFacade.getparameter("smtp_password").getPValue());
                }
                smtp_to=configParmeterFacade.getparameter("smtp_to").getPValue();//recipient account
                 if(configParmeterFacade.getparameter("smtp_to").getEncryption()==1){
                smtp_to=Encryption.decrypt(configParmeterFacade.getparameter("smtp_to").getPValue());
                }
                smtp_port=configParmeterFacade.getparameter("smtp_port").getPValue();//recipient account
                 if(configParmeterFacade.getparameter("smtp_port").getEncryption()==1){
                smtp_port=Encryption.decrypt(configParmeterFacade.getparameter("smtp_port").getPValue());
                }
                smtp_TLS=Integer.parseInt(configParmeterFacade.getparameter("smtp_TLS").getPValue());//recipient account
                 if(configParmeterFacade.getparameter("smtp_TLS").getEncryption()==1){
                smtp_TLS=Integer.parseInt(Encryption.decrypt(configParmeterFacade.getparameter("smtp_TLS").getPValue()));
                }
                FTP_server = configParmeterFacade.getparameter("FTP_server").getPValue();
                 if(configParmeterFacade.getparameter("FTP_server").getEncryption()==1){
                FTP_server=Encryption.decrypt(configParmeterFacade.getparameter("FTP_server").getPValue());
                }
                FTP_port = configParmeterFacade.getparameter("FTP_port").getPValue();
                 if(configParmeterFacade.getparameter("FTP_port").getEncryption()==1){
                FTP_port=Encryption.decrypt(configParmeterFacade.getparameter("FTP_port").getPValue());
                }
                FTP_user = configParmeterFacade.getparameter("FTP_user").getPValue();
                 if(configParmeterFacade.getparameter("FTP_user").getEncryption()==1){
                FTP_user=Encryption.decrypt(configParmeterFacade.getparameter("FTP_user").getPValue());
                }
                FTP_pass = configParmeterFacade.getparameter("FTP_pass").getPValue();  
                 if(configParmeterFacade.getparameter("FTP_pass").getEncryption()==1){
                FTP_pass=Encryption.decrypt(configParmeterFacade.getparameter("FTP_pass").getPValue());
                }
                FTP_APP_DIR = configParmeterFacade.getparameter("FTP_APP_DIR").getPValue(); 
                 if(configParmeterFacade.getparameter("FTP_APP_DIR").getEncryption()==1){
                FTP_APP_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_APP_DIR").getPValue());
                }
                FTP_APP_Live_DIR = configParmeterFacade.getparameter("FTP_APP_Live_DIR").getPValue(); 
                 if(configParmeterFacade.getparameter("FTP_APP_Live_DIR").getEncryption()==1){
                FTP_APP_Live_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_APP_Live_DIR").getPValue());
                }
                FTP_LOCAL_DIR = configParmeterFacade.getparameter("FTP_LOCAL_DIR").getPValue(); 
                 if(configParmeterFacade.getparameter("FTP_LOCAL_DIR").getEncryption()==1){
                FTP_LOCAL_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_LOCAL_DIR").getPValue());
                }
                FTP_XML_Live_DIR = configParmeterFacade.getparameter("FTP_XML_Live_DIR").getPValue(); 
                if(configParmeterFacade.getparameter("FTP_XML_Live_DIR").getEncryption()==1){
                FTP_XML_Live_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_XML_Live_DIR").getPValue());
                } 
                
                System.out.println("FTP_user "+FTP_user);
                System.out.println("FTP_pass "+FTP_pass);
         
                ftp_open =openftp();
                
                if(ftp_status == 0){
                
           
                if(ftp_open){
                    try {
                         if(!check_exist_DIR(FTP_APP_DIR)){
                        create_DIR_FTP(FTP_APP_DIR);
                    }
                    if(!check_exist_DIR(FTP_XML_Live_DIR)){
                        create_DIR_FTP(FTP_XML_Live_DIR);
                    }
                    if(!check_exist_DIR(FTP_APP_Live_DIR)){
                        create_DIR_FTP(FTP_APP_Live_DIR);
                    }
                    
                    ftp_status=1;
                    } catch (Exception e) {    
                              email("FTP ERROR","Error to create DIR");
                                ftp_status=0;
                    }
                   
                }else{
                 email("FTP ERROR","username or password is Wrong");
                  ftp_status=0;
                }
                }
                if(ftp_status == 1){
                
                
               
        
         groupHasTerminal=tgroupHasTerminalFacade.findAll();
       //  System.out.println("groupHasTerminal "+groupHasTerminal);
                    if (groupHasTerminal !=null) {
                        
                 
       
            for(TgroupHasTerminal d:groupHasTerminal){
         
               if(d.getTerminalID().getTerminalstatusID().getId()== 1) {
                   
                      if(ftp_open){
           
                    String XMLfilename = null ;
                    int XMLlength=1;
                    String DLLfilename = null ;
                     String APPfilename = null ;
                try {
        List<TgroupHasGparameter> gp=tgroupHasGparameterFacade.find_term_groups(d.getTerminalGroupID());
      //  System.out.println("TgroupHasGparameter "+ gp);
       for(TgroupHasGparameter f:gp){
         //  System.out.println("f.getXMLupdate() "+ f.getXMLupdate());
        if(f.getXMLupdate()==1){
        String xmlFilecontent =getXML(d);
        deletedir(d);
        createdir(d);
         XMLfilename = getxmlfilename(d, xmlFilecontent);
         f.setFilename(XMLfilename);
         f.setXMLupdate(0); 
        File f1=new  File(FTP_LOCAL_DIR+XMLfilename);
          f.setFileLength((int) f1.length());
         tgroupHasGparameterFacade.edit(f);
       FileUtils.write(f1, xmlFilecontent);
        saveXML(d,XMLfilename);
        break;
        }else{
        XMLfilename = f.getFilename();
        XMLlength=f.getFileLength();
        }
       }
       
       if(XMLfilename !=null ){
           if(d.getXMLupdate()==1){
            DLLfilename = getdllfilename(d);
    String DLLcontent=getDLL(d, XMLfilename, XMLlength);
    File f1=new  File(FTP_LOCAL_DIR+DLLfilename);
    FileUtils.write(f1, DLLcontent);
    saveDLL(d, DLLfilename);
     d.setDLLname(DLLfilename);
         d.setXMLupdate(0);
         tgroupHasTerminalFacade.edit(d);  
         break;
           }else{
          DLLfilename=d.getDLLname();
           }
 
       
       
        
       }
       
       
       if(XMLfilename !=null && DLLfilename !=null){
             List<TgroupHasSoftware> ss=tgroupHasSoftwareFacade.find_term_groups(d.getTerminalGroupID());
       for(TgroupHasSoftware f:ss){
           if(f.getXMLupdate()==1){
            saveapp(d);
            APPfilename= f.getAPPname();
             break;
           }else{
           APPfilename=f.getAPPname();
           }
       }
      
       }
        
        
                  
                } catch (Exception e) {
                    e.printStackTrace();
                    email("FTP Exporting","XML exporting ERROR :  "+e.getMessage());
                }
                
                   if(!closeftp())
                      email("FTP ERROR","FTP disconnect Error");
                   
                     ftp_open=false;
                
               }else{
               email("FTP ERROR","username or password is Wrong");
                    }
               
               }else if(d.getTerminalID().getTerminalstatusID().getId()== 2){
                   
                   Date date1 = d.getTerminalID().getScheduleStart();
		    Date date2 = d.getTerminalID().getScheduleEnd();
                    Date now = new Date();
                    
                    if (date2.before(now) && date1.after(now)) {
                        
   if(ftp_open){
           
                    String XMLfilename = null ;
                    int XMLlength=1;
                    String DLLfilename = null ;
                     String APPfilename = null ;
                try {
        List<TgroupHasGparameter> gp=tgroupHasGparameterFacade.find_term_groups(d.getTerminalGroupID());
        System.out.println("TgroupHasGparameter "+ gp);
       for(TgroupHasGparameter f:gp){
           System.out.println("f.getXMLupdate() "+ f.getXMLupdate());
        if(f.getXMLupdate()==1){
        String xmlFilecontent =getXML(d);
        deletedir(d);
        createdir(d);
         XMLfilename = getxmlfilename(d, xmlFilecontent);
         f.setFilename(XMLfilename);
         f.setXMLupdate(0); 
        File f1=new  File(FTP_LOCAL_DIR+XMLfilename);
          f.setFileLength((int) f1.length());
         tgroupHasGparameterFacade.edit(f);
       FileUtils.write(f1, xmlFilecontent);
        saveXML(d,XMLfilename);
        break;
        }else{
        XMLfilename = f.getFilename();
        XMLlength=f.getFileLength();
        }
       }
       
       if(XMLfilename !=null ){
           if(d.getXMLupdate()==1){
            DLLfilename = getdllfilename(d);
    String DLLcontent=getDLL(d, XMLfilename, XMLlength);
    File f1=new  File(FTP_LOCAL_DIR+DLLfilename);
    FileUtils.write(f1, DLLcontent);
    saveDLL(d, DLLfilename);
     d.setDLLname(DLLfilename);
         d.setXMLupdate(0);
         tgroupHasTerminalFacade.edit(d);  
         break;
           }else{
          DLLfilename=d.getDLLname();
           }
 
       
       
        
       }
       
       
       if(XMLfilename !=null && DLLfilename !=null){
             List<TgroupHasSoftware> ss=tgroupHasSoftwareFacade.find_term_groups(d.getTerminalGroupID());
       for(TgroupHasSoftware f:ss){
           if(f.getXMLupdate()==1){
            saveapp(d);
            APPfilename= f.getAPPname();
             break;
           }else{
           APPfilename=f.getAPPname();
           }
       }
      
       }
        
        
                  
                } catch (Exception e) {
                      e.printStackTrace();
                     email("FTP Exporting","XML exporting ERROR :  "+e.getMessage());
                }
                
                if(!closeftp())
                      email("FTP ERROR","FTP disconnect Error");
                
                ftp_open=false;
                
               }else{
               email("FTP ERROR","username or password is Wrong");
   }
  
  
                    }else{
                    
                    }
                    
               
               }
                
                 }
                  
           
            }
            
             }

        System.out.println("Execution Time : " + new Date());
     
        System.out.println("____________________________________________");

    }

    @PostConstruct
    public void init() {
        
          login = userFacade.find(1);
        System.out.println("intit..............");
//        parseTerminalsLogFiles("E:\\3yad\\private\\projects\\GardianPro\\20180602_001014_40000001.LOG");
   
    }
    
    
      public boolean openftp(){
           Date now = new Date();
           FTPLog ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);    
        ftp.setServerip(FTP_server);
        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR("//");
        ftp.setFilename("");
        ftp.setFtpDir("");
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
        
        ftpclien=ftpMessagesFacade.Ftp_open(ftp);
        
      if(ftpclien == null)
      return false;
      else
      return true; 
      
      }
      
      
       public boolean closeftp(){     
        return  ftpMessagesFacade.Ftp_Close(ftpclien,login);
  
      }
    
    public boolean deletedir(TgroupHasTerminal d){
         Date now = new Date();
          FTPLog ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);    
        ftp.setServerip(FTP_server);
        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR("//");
        ftp.setFilename("");
        ftp.setFtpDir(FTP_XML_Live_DIR+"//"+d.getTerminalID().getTid());
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
        boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,3,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
          return true;
        }else{
        return false;
        }
        
    
 
    }
    public boolean createdir(TgroupHasTerminal d){
         Date now = new Date();
         FTPLog ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);
        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR("//");
        ftp.setFilename("");
        ftp.setFtpDir(FTP_XML_Live_DIR+"//"+d.getTerminalID().getTid());
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
        boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,7,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
          return false;
        }else{
             ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);
        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR("//");
        ftp.setFilename("");
        ftp.setFtpDir(FTP_XML_Live_DIR+"//"+d.getTerminalID().getTid());
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
            ftp_S=ftpMessagesFacade.Ftp_action(ftp,2,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
          return true;
        }else{
        return false;
        
        }
        
        }
    
 
    }
    
    
    public boolean saveXML(TgroupHasTerminal d,String filename){
         Date now = new Date();
         FTPLog ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);

        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR(FTP_LOCAL_DIR);
        ftp.setFilename(filename);
        ftp.setFtpDir(FTP_XML_Live_DIR+"//"+d.getTerminalID().getTid()+"//"+filename);
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
      
        boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,7,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
          return false;
        }else{
            ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);
   
        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR(FTP_LOCAL_DIR);
        ftp.setFilename(filename);
        ftp.setFtpDir(FTP_XML_Live_DIR+"//"+d.getTerminalID().getTid()+"//");
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
 
        ftp_S=ftpMessagesFacade.Ftp_action(ftp,1,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
          return true;
        }else{
        return false;
        
        }
        
        }
    
 
    }
    
     public boolean saveDLL(TgroupHasTerminal d,String filename){
         Date now = new Date();
        FTPLog ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);

        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR(FTP_LOCAL_DIR);
        ftp.setFilename(filename);
        ftp.setFtpDir(FTP_XML_Live_DIR+"//"+d.getTerminalID().getTid()+"//"+filename);
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
    
        boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,7,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
          return false;
        }else{
           ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);
 
        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR(FTP_LOCAL_DIR);
        ftp.setFilename(filename);
        ftp.setFtpDir(FTP_XML_Live_DIR+"//"+d.getTerminalID().getTid()+"//");
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
     
         ftp_S=ftpMessagesFacade.Ftp_action(ftp,1,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
          return true;
        }else{
        return false;
        
        }
        
        }
    
 
    }
    
        public boolean deletefile(String filename){
         Date now = new Date();
         FTPLog ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);

        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR("//");
        ftp.setFilename(filename);
        ftp.setFtpDir(FTP_APP_Live_DIR);
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
     
        boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,4,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
          return true;
        }else{
        return false;
        }
        
    
 
    }
 
    
    
    public String saveapp(TgroupHasTerminal d){
         Date now = new Date();
         StringBuffer appnames=new StringBuffer();
    List<TgroupHasSoftware> groupApp = tgroupHasSoftwareFacade.find_term_groups(d.getTerminalGroupID());
                       System.out.println("com.guardian.Login.Terminalgroup.getXML() "+groupApp.size());
                         if ((groupApp != null) && (!groupApp.isEmpty())) {
		
                                for (TgroupHasSoftware ag : groupApp) {
                                    
                                    
          List<ApplicationHasGroup> appss=applicationHasGroupFacade.get_app_group(ag.getApplicationGroupID());
			
              
          for (ApplicationHasGroup app : appss) {
          
                            appnames.append(app.getApplicationID().getFilename()+";");
            deletefile(app.getApplicationID().getFilename());         
           FTPLog ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);
 
        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR("//");
        ftp.setFilename(app.getApplicationID().getFilename());
        ftp.setFtpDir(FTP_APP_Live_DIR);
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
    
        boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,5,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
        }else{
        System.out.println("Not Store file "+ftp_S);
        ftp=new FTPLog();
        ftp.setfPort(FTP_port);
        ftp.setfUsername(FTP_user);
        ftp.setServerip(FTP_server);
     
        ftp.setFpassword(FTP_pass);
        ftp.setLocalDIR(FTP_APP_Live_DIR);
        ftp.setFilename(app.getApplicationID().getFilename());
        ftp.setFtpDir(FTP_APP_DIR);
        ftp.setUpdateDate(now);
        ftp.setCreateDate(now);
        ftp.setUserID(login);
 
        ftp_S=ftpMessagesFacade.Ftp_action(ftp,6,ftpclien);
        if(ftp_S){
        System.out.println("file copy tpm app Live "+ftp_S);
        }else{
        System.out.println("Not file copy tpm app Live "+ftp_S);
        }
        
        
        }
        
        
        
        
                                                }			
        				
        ag.setAPPname(appnames.toString());
         ag.setXMLupdate(0);
          tgroupHasSoftwareFacade.edit(ag);
          appnames=new StringBuffer();
                                }
                                
                   return appnames.toString();
                                
                         }
                         
        return "";
    }
    
    public  String getXML(TgroupHasTerminal terminals){ 
        
        if(terminals.getTerminalGroupID() == null){
        
        }else{
        
        try {
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            dbfac.setValidating(true);
            
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            Element root = doc.createElement("TerminalXML"); 
            
            Element e = doc.createElement("terminalId");
	    e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getId())));
             root.appendChild(e);
             
            e = doc.createElement("tid");
            if(terminals.getTerminalID().getTid()!=null){
            e.appendChild(doc.createTextNode(terminals.getTerminalID().getTid()));
            }
	    root.appendChild(e);


			e = doc.createElement("detailAddress");
                         if(terminals.getTerminalID().getAddress()!=null){
          e.appendChild(doc.createTextNode(terminals.getTerminalID().getAddress()));
            }
	
			root.appendChild(e);

			
			e = doc.createElement("merchantName");
                         if(terminals.getTerminalID().getMerchantName()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getMerchantName())));
                         }
                        root.appendChild(e);

			e = doc.createElement("officeContact");
                         if(terminals.getTerminalID().getOfficeContact()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOfficeContact())));
                         }
                        root.appendChild(e);

			e = doc.createElement("officeTelNo");
                         if(terminals.getTerminalID().getOfficeTelNo()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOfficeTelNo())));
                         }
                        root.appendChild(e);

			e = doc.createElement("ownerName");
                         if(terminals.getTerminalID().getOwnerName()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOwnerName())));
                         }
                        root.appendChild(e);

			e = doc.createElement("posSerialNo");
                         if(terminals.getTerminalID().getPOSSerialNo()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getPOSSerialNo())));
                         }
                        root.appendChild(e);

			e = doc.createElement("recordNo");
                         if(terminals.getTerminalID().getId()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getId())));
                         }
			root.appendChild(e);

			e = doc.createElement("shopContact");
                         if(terminals.getTerminalID().getContactperson()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getContactperson())));
                         }
                        root.appendChild(e);

			e = doc.createElement("shopName");
                         if(terminals.getTerminalID().getShopName()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getShopName())));
                         }
			root.appendChild(e);

			e = doc.createElement("shopTelNo");
                         if(terminals.getTerminalID().getTelNo()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getTelNo())));
                         }
			root.appendChild(e);

			e = doc.createElement("status");
                         if(terminals.getTerminalID().getTerminalstatusID()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getTerminalstatusID().getTstatus())));
                         }
                         root.appendChild(e);
                         
                         
              	
                        if ((terminals.getTerminalID().getTerminaltemplateID() != null)) {
				
                                
                         List<TerminalHasParts> ter=terminalHasPartsFacade.get_part_group(terminals.getTerminalID().getTerminaltemplateID());
				if( ter !=null || ter.size()>0){
                         Element posTerminalTag = doc.createElement("PosTerminal");

				root.appendChild(posTerminalTag);
                         
				 for (TerminalHasParts ag : ter) {
                                   
					Element e2 = doc.createElement("Part");
					posTerminalTag.appendChild(e2);
					Element e3 = doc.createElement("partId");
					e3.appendChild(doc.createTextNode(String.valueOf(ag.getPartsID().getId())));
					e2.appendChild(e3);
					e3 = doc.createElement("qty");
					e3.appendChild(doc.createTextNode(String.valueOf(ag.getPartsID().getPName())));
					e2.appendChild(e3);
                                      
				}
                                 
                                }
			}     
                     
                         
                         
                        List<TgroupHasAccesory> groupacess = tgroupHasAccesoryFacade.find_term_groups(terminals.getTerminalGroupID());
                  	
                        if ((groupacess != null) && (!groupacess.isEmpty())) {
				Element accessoryTag = doc.createElement("Accessory");

				root.appendChild(accessoryTag);
				 for (TgroupHasAccesory ag : groupacess) {
                                        List<AccessoryHasGroup> acess=accessoryHasGroupFacade.get_app_group(ag.getAccessoryGroupID());
				
                                      for (AccessoryHasGroup as : acess) {
					Element e2 = doc.createElement("Accessory");

					accessoryTag.appendChild(e2);
					Element e3 = doc.createElement("accessoryId");
					e3.appendChild(doc.createTextNode(String.valueOf(as.getAccessoryID().getId())));
					e2.appendChild(e3);
					e3 = doc.createElement("qty");
					e3.appendChild(doc.createTextNode(String.valueOf(as.getAccessoryID().getAccName())));
					e2.appendChild(e3);
                                      }
				}
			}     
                         
                         
                         
                         
                       List<TgroupHasSoftware> groupApp = tgroupHasSoftwareFacade.find_term_groups(terminals.getTerminalGroupID());
                      //   System.out.println("com.guardian.Login.Terminalgroup.getXML() "+groupApp.size());
                         if ((groupApp != null) && (!groupApp.isEmpty())) {
				Element applicationTag = doc.createElement("ApplicationGroup");
                                root.appendChild(applicationTag);
                                for (TgroupHasSoftware ag : groupApp) {
                                    List<ApplicationHasGroup> appss=applicationHasGroupFacade.get_app_group(ag.getApplicationGroupID());
					for (ApplicationHasGroup app : appss) {
                                            
                                     
						Element e2 = doc.createElement("Application");

						applicationTag.appendChild(e2);

						Element e3 = doc.createElement("applicationId");
						e3.appendChild(doc.createTextNode(String.valueOf(app.getApplicationID().getId())));
						e2.appendChild(e3);
						e3 = doc.createElement("name");
						e3.appendChild(doc.createTextNode(app.getApplicationID().getAppName()));
						e2.appendChild(e3);
						e3 = doc.createElement("fieldName");
						e3.appendChild(doc.createTextNode(app.getApplicationID().getFilename()));
						e2.appendChild(e3);
						e3 = doc.createElement("fileSize");
						e3.appendChild(doc.createTextNode(String.valueOf(app.getApplicationID().getAppSize())));
						e2.appendChild(e3);

					}
				}
                                
                         }
                         
                         
                        
                        
                             List<TgroupHasGparameter> group= tgroupHasGparameterFacade.find_term_groups(terminals.getTerminalGroupID());
                        List<TgroupHasGparameter> group1=new ArrayList<>();
                         List<TgroupHasGparameter> group2=new ArrayList<>();
                        group2.addAll(group);
                        
                      //  System.out.println("gy "+group);
                         
                         for(int i=1;i<5;i++){
                             
                                for(TgroupHasGparameter gg:group){
                             
                                 if(null!=gg.getParameterGroupID().getParametertypeID().getId()){
                                     
                      if (gg.getParameterGroupID().getParametertypeID().getId() == i) {
                        //  System.out.println("group "+gg.getParameterGroupID().getParametertypeID().getId());
                             group1.add(gg);
                             group2.remove(gg);
                      }
                                 } 
                             }
                         
                         }
                     
                          //   System.out.println("gy1 "+group1);
                         //    System.out.println("gy2 "+group2);
                            if (((group1 != null) && (!group1.isEmpty())) || ((group2 != null) && (!group2.isEmpty())) ) {  
                              Element groupTag = doc.createElement("ParameterGroup");
                          if ((group1 != null) && (!group1.isEmpty())) {
                            
                            Pgchild pg = null;
                            Pgchild pg1 = null;
                            Pgchild pg2=null;
                            List<TgroupHasGparameter> terminal_pg = new ArrayList<>();
                            List<TgroupHasGparameter> Accq_pg = new ArrayList<>();
                            List<TgroupHasGparameter> Issuer_pg = new ArrayList<>();
                            
                            int terminal_count=0;
                            int Accq_count=0;
                            int Issuer_count=0;
                            int Card_count=0;
                             int select=0;
                             
                        // System.out.println("sd "+group1);     
                    for(TgroupHasGparameter gg:group1){
                        
                          List<ParameterValues> v=parameterValuesFacade.ParameterValues_find(gg);
                        
                      //  System.out.println("group "+gg);
                      
                      
    
                            Element groupName = doc.createElement(gg.getParameterGroupID().getParametertypeID().getXMLheader());
                        
                        groupName.setAttribute("ID", gg.getParameterGroupID().getId().toString());
						groupName.setIdAttribute("ID", true);

						if (groupName.getTagName().equals("Terminal"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("Acquirer"))
							groupName.setAttribute("Level", "2");
						else if (groupName.getTagName().equals("Issuer"))
							groupName.setAttribute("Level", "3");
						else if (groupName.getTagName().equals("CardRange"))
							groupName.setAttribute("Level", "4");
						else if (groupName.getTagName().equals("EMVLevel2Key"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("EMVLevel2App"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("EMVCtlApp"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("Other"))
							groupName.setAttribute("Level", "1");
                                                
                            
                              
                               e = doc.createElement("ID");
                               e.appendChild(doc.createTextNode(gg.getParameterGroupID().getId().toString()));
                         
			            groupName.appendChild(e);
                                    
                        if (groupName.getTagName().equals("Terminal")){
                        //    System.out.println("Terminal");
                             terminal_pg.add(gg);
                             terminal_count++;
                        }else if (groupName.getTagName().equals("Acquirer")&& terminal_pg != null)
                        {
                         //    System.out.println("Acquirer");
                        pg=  pgchildFacade.Pchild_find(terminal_pg.get(terminal_count-1),terminal_pg.get(terminal_count-1));                                  
                        e = doc.createElement("TerminalID");
			e.appendChild(doc.createTextNode(pg.getTgrouphasGparameterID().getParameterGroupID().getId().toString())); 
			groupName.appendChild(e);
                        Accq_pg.add(gg);
                        Accq_count++;
                                                 
                        }
			else if (groupName.getTagName().equals("Issuer") && pg !=null && Accq_pg !=null )
                         {              
                      //  System.out.println("Issuer");
                         e = doc.createElement("TerminalID");
			e.appendChild(doc.createTextNode(pg.getTgrouphasGparameterID().getParameterGroupID().getId().toString()));  
			groupName.appendChild(e);
                        // System.out.println("acc "+Accq_pg);
                               
                        e = doc.createElement("AcquirerID");  
                          for(int y=0;y<Accq_pg.size();y++){
                        // System.out.println("A "+Accq_pg.get(y)+" "+gg);
                             
                              try {
                                    pg1=  pgchildFacade.Pchild_find(Accq_pg.get(y),gg);
                                    if(pg1==null){
                                    continue;
                                    }
                                   select=y;
                                //           System.out.println("OK1");
                       
		                  break;
                              } catch (Exception em) {
                              //     System.out.println("Error1");
                              }
                            
                          }
                    	e.appendChild(doc.createTextNode(pg1.getTgrouphasGparameterID1().getParameterGroupID().getId().toString()));
			groupName.appendChild(e);
                        
                        Issuer_pg.add(gg);
                        Issuer_count++;
                                               
                                                }
			else if (groupName.getTagName().equals("CardRange")&& pg !=null && pg1 !=null && Accq_pg !=null && Issuer_pg != null)
                                                {
                                                    
                     
                         //  System.out.println("Issuer "+Issuer_pg);
                                                
                                 //     System.out.println("CardRange");               
                         e = doc.createElement("TerminalID");       
			e.appendChild(doc.createTextNode(pg.getTgrouphasGparameterID().getParameterGroupID().getId().toString()));
			groupName.appendChild(e);
                                                
                    e = doc.createElement("AcquirerID");
                     e.appendChild(doc.createTextNode(pg1.getTgrouphasGparameterID1().getParameterGroupID().getId().toString()));
                    groupName.appendChild(e);
                        
                    e = doc.createElement("IssuerID");
                    for(int y=0;y<Issuer_pg.size();y++){
                       //  System.out.println("getXML() "+Issuer_pg.get(y)+" "+gg);
                               
                        try {
                      
                            pg2=  pgchildFacade.Pchild_find(Issuer_pg.get(y),gg);
                             if(pg2==null){
                                    continue;
                                    }
                         //     System.out.println("OK");
                               break;
                        } catch (Exception ec) {
                         //    System.out.println("error");
                        }
                     
                    }
                     e.appendChild(doc.createTextNode(pg2.getTgrouphasGparameterID1().getParameterGroupID().getId().toString()));
                    groupName.appendChild(e); 
                    
                   
                    
                    Card_count++;    
                                                }
                        
                        
                      
                       		
					
                              
                              
                 for(ParameterValues val:v){
                          e = doc.createElement(val.getParameterID().getFieldName());
                         if(val.getValue() !=null){
			e.appendChild(doc.createTextNode(String.valueOf(val.getValue())));
                         }
			groupName.appendChild(e);
                                                }
                                
                        
                        groupTag.appendChild(groupName);
                    }
                     }
                                        
                     if ((group2 != null) && (!group2.isEmpty())) {
                         
                         System.out.println("com.guardian.Login.Terminalgroup.getXML()");
                    
                       for(TgroupHasGparameter gg:group2){
                        
                          List<ParameterValues> v=parameterValuesFacade.ParameterValues_find(gg);
                        
                      //  System.out.println("group "+gg);
                      
                      
    
                            Element groupName = doc.createElement(gg.getParameterGroupID().getParametertypeID().getXMLheader());
                        
                        groupName.setAttribute("ID", gg.getParameterGroupID().getId().toString());
						groupName.setIdAttribute("ID", true);

						if (groupName.getTagName().equals("Terminal"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("Acquirer"))
							groupName.setAttribute("Level", "2");
						else if (groupName.getTagName().equals("Issuer"))
							groupName.setAttribute("Level", "3");
						else if (groupName.getTagName().equals("CardRange"))
							groupName.setAttribute("Level", "4");
						else if (groupName.getTagName().equals("EMVLevel2Key"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("EMVLevel2App"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("EMVCtlApp"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("Other"))
							groupName.setAttribute("Level", "1");
                                                
                            
                              
                               e = doc.createElement("ID");
                               e.appendChild(doc.createTextNode(gg.getParameterGroupID().getId().toString()));
                         
			            groupName.appendChild(e);
                                    
                                    
                                       for(ParameterValues val:v){
                          e = doc.createElement(val.getParameterID().getFieldName());
                         if(val.getValue() !=null){
			e.appendChild(doc.createTextNode(String.valueOf(val.getValue())));
                         }
			groupName.appendChild(e);
                                                }
                                       
                                       
                                       groupTag.appendChild(groupName);
                                    
                       }
                       
                     }
                       
                    
                     root.appendChild(groupTag);    
                            }              
                         
                         

            doc.appendChild(root);
                        
                        
            TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();

			trans.setOutputProperty(OutputKeys.INDENT, "yes");

			trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			String xmlString = sw.toString().replaceAll("\n", "\r\n");
			// FileUtils.write(new File("D:\\ahmed.txt"), xmlString);

			return xmlString;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(BusinessTimer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(BusinessTimer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(BusinessTimer.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return "";
    }
    
    public String getxmlfilename(TgroupHasTerminal d,String xmlFilecontent){
    
        int sum=0;
                    
                    				for (int x = 0; x < xmlFilecontent.length(); x += 2) {
							int x0 = xmlFilecontent.charAt(x);
							int x1;
							if (x == xmlFilecontent.length() - 1) {
								x1 = 0;
							} else {
								x1 = xmlFilecontent.charAt(x + 1);
							}
							sum += x0 << 8 | x1;
						}
						String hexStr = Integer.toHexString(sum);
						if (hexStr.length() == 0) {
							hexStr = "0000";
						} else if (hexStr.length() == 1) {
							hexStr = "000" + hexStr;
						} else if (hexStr.length() == 2) {
							hexStr = "00" + hexStr;
						} else if (hexStr.length() == 3) {
							hexStr = "0" + hexStr;
						} else if (hexStr.length() > 4) {
							hexStr = hexStr.substring(hexStr.length() - 4);
						}
						//System.out.println("terminal tid : " + d.getTerminalID().getTid() + ", auto, sum : " + sum + ", hexStr : " + hexStr);
						Date date = d.getTerminalID().getCreateDate();
						String str = new SimpleDateFormat("yyyyMMdd").format(date);
						String xmlFilename = d.getTerminalID().getTid() + "_" + str + "_" + hexStr.toUpperCase() + ".edc";
                  return xmlFilename;
    }

    
     public  String getDLL(TgroupHasTerminal terminals,String xmlfilename,int XMLlength){
         StringBuffer a=new StringBuffer();
     a.append(xmlfilename + ", " + (int) XMLlength + ", 1");
     a.append("\n\n\n");
     
     
         List<TgroupHasSoftware> groupApp = tgroupHasSoftwareFacade.find_term_groups(terminals.getTerminalGroupID());
                      //   System.out.println("com.guardian.Login.Terminalgroup.getXML() "+groupApp.size());
                         if ((groupApp != null) && (!groupApp.isEmpty())) {
				
                                for (TgroupHasSoftware ag : groupApp) {
                                    List<ApplicationHasGroup> appss=applicationHasGroupFacade.get_app_group(ag.getApplicationGroupID());
					for (ApplicationHasGroup app : appss) {
                                     a.append(app.getApplicationID().getFilename()).append(", ").append((int) app.getApplicationID().getAPPlength()).append(", 1");
                                     a.append("\n\n\n");
						
					}
				}
                                
                         }
     
     return a.toString();
     }
  
     
      public String getdllfilename(TgroupHasTerminal d){
       String DLL = d.getTerminalID().getTid() + "_" + d.getTerminalID().getPOSSerialNo() + ".DLL";
      return DLL;
      }
      
      
      
      public void email(String text,String subject){
         Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        	EmailLog email=new EmailLog();
                email.setEsubject(text);
                email.setEtext(subject);
                email.setUserID(login);
                email.setUpdateDate(date);
                email.setCreateDate(date);
                emailLogFacade.create(email);
      }   

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
      
      
        public  boolean check_exist_DIR(String DirPath){
        
        FTPLog ftp=new FTPLog();
        ftp.setFtpDir(DirPath);
    
        boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,7,ftpclien);
        if(ftp_S){
          return true;
        }else{
         return false;
        }
        
        }
        
        
         public  boolean create_DIR_FTP(String DirPath){
        
          FTPLog  ftp=new FTPLog();
        ftp.setFtpDir(DirPath);
 
         boolean  ftp_S=ftpMessagesFacade.Ftp_action(ftp,2,ftpclien);
        if(ftp_S){
          return true;
        }else{
        return false;
        
        }
        
        }
      
}
