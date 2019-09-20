package com.trilogyed.accountservice.controller;

import com.trilogyed.accountservice.model.Account;
import com.trilogyed.accountservice.util.messages.EmailListEntry;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    public static final String EXCHANGE = "queue-demo-exchange";
    public static final String ROUTING_KEY = "email.list.add.account.controller";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public AccountController(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(path="/account", method = RequestMethod.POST)
    public String createAccount(@RequestBody Account account){
        EmailListEntry msg = new EmailListEntry(account.getFirstName()+" "+account.getLastName(), account.getEmail());
        System.out.println("Sending message.....");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
        System.out.println("Message sent");

        return "Account Created";
    }
}
