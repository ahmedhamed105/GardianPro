/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.InputType;
import Entities.Parameter;
import Entities.ParamterDefault;
import Entities.ParamterFieldType;
import Facades.InputTypeFacadeLocal;
import Facades.ParameterFacadeLocal;
import Facades.ParamterDefaultFacadeLocal;
import Facades.ParamterFieldTypeFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ahmed.elemam
 */
public class parameter {

    @EJB
    private ParameterFacadeLocal parameterFacade;
    
        @EJB
    private UserFacadeLocal userFacade;
        
         @EJB
    private InputTypeFacadeLocal inputTypeFacade;
         
          @EJB
    private ParamterFieldTypeFacadeLocal ParamterFieldTypeFacade;
          
           @EJB
    private ParamterDefaultFacadeLocal ParamterDefaultFacade;
   
         
        
        
         List<Parameter> parmeters = new ArrayList<Parameter>();
         
         List<InputType> input_types = new ArrayList<InputType>();
         
          List<ParamterFieldType> parameter_types = new ArrayList<ParamterFieldType>();
          
          
          ParamterDefault defaultv=new ParamterDefault();
     
           
         
         Parameter parmeter=new Parameter();
         
         Parameter selectparmeter=new Parameter();
         
          java.sql.Date date ;
          
          String defvalue =new String() ;
          
          boolean defvalue1 = false ;

    /**
     * Creates a new instance of parameter
     */
    public parameter() {
    }
    
    
       public void init(){ 
           
           FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
if(session==null){
                 try {
                     Login.login=null;
                     ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                     
                     ec.redirect(ec.getRequestContextPath()
                             + "/faces/index.xhtml");
                 } catch (IOException ex) {
                     Logger.getLogger(accessgroup.class.getName()).log(Level.SEVERE, null, ex);
                 }
}
             //Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/index.xhtml");

        }else{
         parmeters  = parameterFacade.findAll();
         input_types = inputTypeFacade.findAll();
         parameter_types=ParamterFieldTypeFacade.findAll();
         
          
        
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 21);
                /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 21);
                /*end mohammed.ayad*/
            }
}
   
    }

    public String getDefvalue() {
        return defvalue;
    }

    public void setDefvalue(String defvalue) {
        this.defvalue = defvalue;
    }

    public boolean isDefvalue1() {
        return defvalue1;
    }

    public void setDefvalue1(boolean defvalue1) {
        this.defvalue1 = defvalue1;
    }



    public ParamterDefault getDefaultv() {
        return defaultv;
    }

    public void setDefaultv(ParamterDefault defaultv) {
        this.defaultv = defaultv;
    }


       
       
       

    public List<ParamterFieldType> getParameter_types() {
        return parameter_types;
    }

    public void setParameter_types(List<ParamterFieldType> parameter_types) {
        this.parameter_types = parameter_types;
    }
       

    public List<Parameter> getParmeters() {
        return parmeters;
    }

    public void setParmeters(List<Parameter> parmeters) {
        this.parmeters = parmeters;
    }

    public Parameter getParmeter() {
        return parmeter;
    }

    public void setParmeter(Parameter parmeter) {
        this.parmeter = parmeter;
    }

    public Parameter getSelectparmeter() {
        return selectparmeter;
    }

    public void setSelectparmeter(Parameter selectparmeter) {
        this.selectparmeter = selectparmeter;
    }

    public List<InputType> getInput_types() {
        return input_types;
    }

    public void setInput_types(List<InputType> input_types) {
        this.input_types = input_types;
    }
    
 
   public void accdefault(ActionEvent actionEvent){
   
   date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                 int y=0;
                 int y1=0;
                 int add=0;
           
                List<ParamterDefault> a=  ParamterDefaultFacade.get_default(parmeter);
                
                 for(ParamterDefault b :a){
                     
                if(b.getParameterID().getParamtertypeID().getId() == 1){
                y++;
                }else if(b.getParameterID().getParamtertypeID().getId() == 2){       
                y1++;
                }
                }
             
                // System.out.println();
              System.out.println("y "+y);
              System.out.println("y1 "+y1);
          if(null != parmeter.getParamtertypeID().getId())
            switch (parmeter.getParamtertypeID().getId()) {
            case 1:
                if(y>=1){              
                    Messages.addInfoMessage("please deleted and add again",1,21);        
                }else{
            parmeter.setDefaultvalue(String.valueOf(defvalue));
           parameterFacade.edit(parmeter);
                    defaultv.setPvalues(String.valueOf(defvalue));
                    add=1;
                }
                break;
            case 2:
                if(y1 >= 1){
                    Messages.addInfoMessage("please deleted and add again",1,21);
                }else{
                     parmeter.setDefaultvalue(String.valueOf(defvalue));
                      parmeter.setUpdateDate(date);
                      parameterFacade.edit(parmeter);
                    defaultv.setPvalues(String.valueOf(defvalue1));
                     add=1;
                }
                break;
            case 3:
                defaultv.setPvalues(String.valueOf(defvalue));
                 parmeter.setDefaultvalue(String.valueOf(defvalue));
                  parmeter.setUpdateDate(date);
        parameterFacade.edit(parmeter);
         add=1;
                break;
            default:
                break;
        }
          if(add==1){
          defaultv.setParameterID(parmeter);
          ParamterDefaultFacade.create(defaultv);
           Messages.addInfoMessage("ADDED",1,21);
          }
    
     }
   
     public String Rdefault(ActionEvent actionEvent){
         
          ParamterDefaultFacade.remove(defaultv);
        
           Messages.addInfoMessage("Removed Value",1,21);
      return "Login";
     }
    
    
      public List<ParamterDefault> return_default(Parameter para){
          List<ParamterDefault> a=new ArrayList<ParamterDefault>();
         try {
                a=  ParamterDefaultFacade.get_default(para);
        
               
          //   Messages.addInfoMessage("removed "+selectparmeter.getDisplayName(),1,21);
         } catch (Exception e) {
             e.printStackTrace();
          //    Messages.addInfoMessage("Not removed "+selectparmeter.getDisplayName()+" return to Admin "+e.getMessage(),3,21);
         }
                      return a;  
     
     }
     
      
          public boolean ret_defaultC(Parameter para){
          List<ParamterDefault> a=new ArrayList<ParamterDefault>();
         try {
                a=  ParamterDefaultFacade.get_default(para);
        if(a.get(0).getPvalues().toLowerCase().trim().equals("true")){
          return true; 
        }
               
          //   Messages.addInfoMessage("removed "+selectparmeter.getDisplayName(),1,21);
         } catch (Exception e) {
          //    Messages.addInfoMessage("Not removed "+selectparmeter.getDisplayName()+" return to Admin "+e.getMessage(),3,21);
         }
                      return false;  
     
     }
          
                public String ret_defaultT(Parameter para){
          List<ParamterDefault> a=new ArrayList<ParamterDefault>();
         try {
                a=  ParamterDefaultFacade.get_default(para);
           return a.get(0).getPvalues();
               
          //   Messages.addInfoMessage("removed "+selectparmeter.getDisplayName(),1,21);
         } catch (Exception e) {
          //    Messages.addInfoMessage("Not removed "+selectparmeter.getDisplayName()+" return to Admin "+e.getMessage(),3,21);
         }
                      return "";  
     
     }
    
    
    
      
      
      
         public void remove(ActionEvent actionEvent){
         try {
                   parameterFacade.remove(selectparmeter);
             Messages.addInfoMessage("removed "+selectparmeter.getDisplayName(),1,21);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectparmeter.getDisplayName()+" return to Admin "+e.getMessage(),3,21);
         }
         
     
     }
    


    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          parmeter=((Parameter) event.getObject());
            parmeter.setUpdateDate(date);
          parameterFacade.edit(parmeter);
          
          Messages.addInfoMessage("Edited "+((Parameter) event.getObject()).getDisplayName(),1,21);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((Parameter) event.getObject()).getDisplayName(),1,21);
    }
    
    
    
     public String ADD(ActionEvent actionEvent){
         
      if(parameterFacade.para_find(parmeter.getDisplayName())){
             Messages.addInfoMessage("Duplicated",2,21);
        }else{
             Messages.addInfoMessage("ADDED",1,21);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            parmeter.setCreateDate(date);
            parmeter.setUpdateDate(date);
          parameterFacade.create(parmeter);
        }
         
      return "Login";
     }
     
       public void updateText(ValueChangeEvent event){
           
           String  input = event.getNewValue().toString();
        Messages.addInfoMessage(input,1,21);
       
       }
       
    
}
