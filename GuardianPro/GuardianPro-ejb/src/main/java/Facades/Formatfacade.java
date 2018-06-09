/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class Formatfacade implements FormatfacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    public  String formatText(String action, String user,String component, boolean status){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date d = Calendar.getInstance().getTime();        	
		String date = df.format(d);
		String formattedText="";
		if(status){
			formattedText = date+" "+user+" "+action+" "+component+" "+"successfully";
		}else{
			formattedText = date+" "+user+" "+action+" "+component+" "+"unsuccessfully";
		}
		return formattedText;
		
	}
}
