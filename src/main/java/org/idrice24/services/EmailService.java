// package org.idrice24.services;


// import javax.mail.MessagingException;
// import javax.mail.internet.MimeMessage;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.idrice24.repositories.EmailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.scheduling.annotation.Async;
// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class EmailService implements EmailSender {

//     @Autowired
//     private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

//     @Autowired
//     private final JavaMailSender mailSender;

//     @Override
//     @Async
//     public void send(String to, String email) {
//         try {
//             MimeMessage mimeMessage = mailSender.createMimeMessage();
//             MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//             helper.setText(email, true);
//             helper.setTo(to);
//             helper.setSubject("Confirm your email");
//             helper.setFrom("hello@amigoscode.com");
//             mailSender.send(mimeMessage);
//         } catch (MessagingException e) {
//             LOGGER.error("failed to send email", e);
//             throw new IllegalStateException("failed to send email");
//         }
//     }
// }