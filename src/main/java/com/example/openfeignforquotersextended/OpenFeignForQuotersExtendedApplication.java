package com.example.openfeignforquotersextended;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignForQuotersExtendedApplication {

    QuoterExtendProxy quoterExtendClient;

    public OpenFeignForQuotersExtendedApplication(QuoterExtendProxy quoterExtendClient) {
        this.quoterExtendClient = quoterExtendClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignForQuotersExtendedApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToQuoterExtend() {

//        String randomQuote = quoterExtendClient.getRandomQuote();
//        System.out.println(randomQuote);

//        String byId = quoterExtendClient.getById(3);
//        System.out.println(byId);

//        String allQuotes = quoterExtendClient.showAllQuotes();
//        System.out.println(allQuotes);

//        quoterExtendClient.deleteById(3);

//        String byParam = quoterExtendClient.getByParam(4);
//        System.out.println(byParam);


        // TO DO ->REPAIR THAT CODE
        ResponseEntity<String> stringResponseEntity = quoterExtendClient.addQuote("{\"content\":\"YourQuoteContent\"}");
        System.out.println(stringResponseEntity.getBody());

    }
}