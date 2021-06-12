package az.code.unisubapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootTest
class UniSubAppApplicationTests implements CommandLineRunner {

    @Test
    void contextLoads() {
    }

    @Autowired
    private JavaMailSender sender;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hellooo");
//        sendNotificationEmail();
    }

    public void sendNotificationEmail() {
        String email = "vusalra@code.edu.az";
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject("Subscription tracker notification: " + "TEst");
        mail.setText("testss");
        sender.send(mail);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("subscriptonmanagmentmailsender@gmail.com");
        mailSender.setPassword("32620155");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }

}
