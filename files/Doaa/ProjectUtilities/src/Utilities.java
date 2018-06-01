
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Utilities {

	public static String formatText(String action, String user,String component, boolean status){
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
