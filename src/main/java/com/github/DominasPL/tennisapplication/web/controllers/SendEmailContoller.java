package com.github.DominasPL.tennisapplication.web.controllers;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class SendEmailContoller {
    // Wstrzykujemy bean'a typu MailSender. Spring automatycznie dostarczy poprawną implementację

    // na podstawie ustawień w pliku application.properties

    private MailSender mailSender;

    public SendEmailContoller(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping
    @ResponseBody
    public String sendMail(@RequestParam String recipient) {

        // Tworzymy obiekt typu SimpeMailMessage i ustawiamy w nim to, czego potrzebujemy

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);

        message.setFrom("Kubuś Puchatek");

        message.setSubject("Test wysyłki");

        message.setText("Jakie to wszystko jest proste :) ");



        // Wysyłamy obiekt typu SimpleMimeMessage z użyciem bean'a MailSender

        mailSender.send(message);

        return "Wysłano!";

    }

}
