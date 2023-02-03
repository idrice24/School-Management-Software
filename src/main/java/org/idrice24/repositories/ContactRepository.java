package org.idrice24.repositories;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "mail")
public class ContactRepository {
	public static class SMTP{
		String host;
		String port;
		String username;
		String password;

		public String getHost(){
			return host;
		}

		public void setHost(String host){
			this.host = host;
		}

		public String getPort(){
			return port;
		}

		public void setPort(String port){
			this.port = port;
		}

		public void setUsername(String username){
			this.username = username;
		}

		public String getUsername(){
			return username;
		}

		public void setPassword(String password){
			this.password = password;
		}

		public String getPassword(){
			return password;
		}
	}


	private SMTP smtp;
	private String from;
	private String fromName;
	private String to;

	public void setSmtp(SMTP smtp){
		this.smtp = smtp;
	}

	public SMTP getSmtp(){
		return smtp;
	}

	public void setfrom(String from){
		this.from = from;
	}

	public String getFrom(){
		return from;
	}

	public void setFromName(String fromName){
		this.fromName = fromName;
	}

	public String getFromName(){
		return fromName;
	}

	public void setTo(String to){
		this.to = to;
	}

	public String getTo(){
		return to;
	}

}