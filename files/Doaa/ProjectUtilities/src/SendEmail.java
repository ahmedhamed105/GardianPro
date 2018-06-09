
public class SendEmail {
	public static void main(String[] args) {

		String host="smtp.gmail.com"; //SMTP Server
		String from="doaa.elrshidy@gmail.com";//from account
		String password="";     //password from account
		String to="doaa.elrshidy@its.ws";//recipient account
		String subject="test3";
		String text="hello!";
       
		Email email=new Email(host,from,password,to,subject,text);
        EmailUtils.send(email);  

        System.out.print(Utilities.formatText("added", "admin", "terminal", false));
	}
}
