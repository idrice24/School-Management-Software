package org.idrice24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

import org.idrice24.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	private ContactRepository contactRepository;

	@Autowired
	public void setContactRepository(ContactRepository contactRepository){
		this.contactRepository = contactRepository;
	}

	@Override
	public boolean sentContact(String subject, String body){
		try{
			Properties props = System.getProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.port", contactRepository.getSmtp().getPort());
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props);

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(contactRepository.getFrom(), contactRepository.getFromName()));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(contactRepository.getTo()));
            msg.setSubject(subject);
            msg.setContent(body, "text/html");

            jakarta.mail.Transport transport = session.getTransport();
            transport.connect(contactRepository.getSmtp().getHost(), contactRepository.getSmtp().getUsername(), contactRepository.getSmtp().getPassword());
            transport.sendMessage(msg, msg.getAllRecipients());
            return true;



           } catch (Exception ex) {
            System.out.println("there is an error");

       
    }
     return false;

		}
}