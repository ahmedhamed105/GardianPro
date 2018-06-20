/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.RParameter;
import Entities.Reports;
import Facades.RParameterFacadeLocal;
import Facades.ReportsFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

/**
 *
 * @author ahmed.elemam
 */
public class Report {
    
      @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private RParameterFacadeLocal rParameterFacade;

    @EJB
    private ReportsFacadeLocal reportsFacade;
    
    
    
    
     List<Reports> reportf=new ArrayList<Reports>(); 
    
    Reports selectreportf;

    /**
     * Creates a new instance of Report
     */
    public Report() {
        
    }
    
      public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         reportf  = reportsFacade.findAll();
        
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 26);
            /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 26);
                /*end mohammed.ayad*/
            }
}
   
    }

    public List<Reports> getReportf() {
        return reportf;
    }

    public void setReportf(List<Reports> reportf) {
        this.reportf = reportf;
    }

    public Reports getSelectreportf() {
        return selectreportf;
    }

    public void setSelectreportf(Reports selectreportf) {
        this.selectreportf = selectreportf;
    }
    
    
    

    
    
     JasperPrint jasperPrint;
    public void initd() throws JRException{
    
        List<Data_report> a=new ArrayList<Data_report>(); 
        Data_report r=new Data_report();
        List<Object> st=reportsFacade.find_parameter(selectreportf.getReportSQL()); 
        
        System.out.println(st);
        
       for(int i=0;i<st.size();i=i+5){
           r.setField1(st.get(i));
          r.setField2(st.get(i+1));
            r.setField3(st.get(i+2));
            r.setField4(st.get(i+3));
             r.setField5(st.get(i+4));
             a.add(r);
       
       }
        
   
              Map<String, Object> parameters = new HashMap<String, Object>();
              List<Entities.RParameter> pa=rParameterFacade.find_parameter(selectreportf);
              
              for(RParameter p:pa){
               parameters.put(p.getRpara(), p.getParavalue());
              }
              
//               parameters.put("CHARACTER_ENCODING", "UTF-8");
//               parameters.put("parameter1", "parameter1");
//               parameters.put("parameter2", "parameter1");
//               parameters.put("parameter3", "parameter1");
//               parameters.put("parameter4", "parameter1");
//               parameters.put("parameter5", "parameter1");
//               parameters.put("Header", "Report");
//               parameters.put("Subheader", "Bank MISR");
            
        JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(a); 
        
        try {
        String  reportPath= selectreportf.getReportDIR();// FacesContext.getCurrentInstance().getExternalContext().getRealPath("D:\\GuadianPro\\Core\\GardianPro\\files\\report1.jrxml");    
    
        
            System.out.println(reportPath);
       


jasperPrint=JasperFillManager.fillReport(reportPath, parameters,beanCollectionDataSource);

 } catch (Exception e) {
     e.printStackTrace();
        }
    }
     
   public void PDF(ActionEvent actionEvent) throws JRException, IOException{
           if(selectreportf!=null){
             initd();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report1.pdf");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
       FacesContext.getCurrentInstance().responseComplete();
        }else{
             Messages.addInfoMessage("please Choose Report",2,26);
           }
  
        
        
   }
    public void DOCX(ActionEvent actionEvent) throws JRException, IOException{
         if(selectreportf!=null){
        initd();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
       httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.docx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRDocxExporter docxExporter=new JRDocxExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
       FacesContext.getCurrentInstance().responseComplete();
        }else{
             Messages.addInfoMessage("please Choose Report",2,26);
           }
   }
     public void XLSX(ActionEvent actionEvent) throws JRException, IOException{
          if(selectreportf!=null){
        initd();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.xlsx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRXlsxExporter docxExporter=new JRXlsxExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
       FacesContext.getCurrentInstance().responseComplete();
        }else{
             Messages.addInfoMessage("please Choose Report",2,26);
           }
   }
      public void ODT(ActionEvent actionEvent) throws JRException, IOException{
           if(selectreportf!=null){
       initd();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.odt");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JROdtExporter docxExporter=new JROdtExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
       FacesContext.getCurrentInstance().responseComplete();
 }else{
             Messages.addInfoMessage("please Choose Report",2,26);
           }
   }
       public void PPT(ActionEvent actionEvent) throws JRException, IOException{
            if(selectreportf!=null){
       initd();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pptx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRPptxExporter docxExporter=new JRPptxExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
       FacesContext.getCurrentInstance().responseComplete();
 }else{
             Messages.addInfoMessage("please Choose Report",2,26);
           }
   }
     
    
}
