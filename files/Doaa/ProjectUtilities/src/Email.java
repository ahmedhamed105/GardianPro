
public class Email {
	private String host;
	private String from;
	private String password;
	private String to;
	private String subject;
	private String text;
	
	
	public Email(String host, String from, String password, String to,
			String subject, String text) {
		super();
		this.host = host;
		this.from = from;
		this.password = password;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
