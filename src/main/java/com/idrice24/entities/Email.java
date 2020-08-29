package com.idrice24.entities;

public class Email{
private	String to;
private	String body;
	public Email(){
	}

	public Email(String to, String body){
		this.to = to;
		this.body = body;
	}
	public void setTo(String to){
		this.to = to;
	}
	public String getTo(){
		return to;
	}
	public void setBody(String body){
		this.body = body;
	}
	public String getBody(){
		return body;
	}
@Override
  public String toString() {
    return String.format("Email{to=%s, body=%s}", getTo(), getBody());
  }
}