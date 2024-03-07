package com.example.openfeignforquotersextended;

import org.springframework.beans.factory.annotation.Autowired;
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

        // ---> SHOW ALL<---
        String showAllQuotes = quoterExtendClient.showAllQuotes();
        System.out.println(showAllQuotes);

        // --->GET BY ID<---
        String byId = quoterExtendClient.getById(3);
        System.out.println(byId);

        // --->GET RANDOM QUOTE<---
        String randomQuote = quoterExtendClient.getRandomQuote();
        System.out.println(randomQuote);

        // --->GET BY PARAM<---
        String byParam = quoterExtendClient.getByParam(3);
        System.out.println(byParam);

        // --->GET BY HEADER<---
        String withHeader = quoterExtendClient.getAllWithHeader();
        System.out.println(withHeader);

        // --->ADD QUOTE<---
        QuoteExtendResult newQuote = new QuoteExtendResult("Is that OK?");
        ResponseEntity<QuoteExtendResponse> responseEntity = quoterExtendClient.addQuote(newQuote);

        // --->DELETE BY ID <---
        quoterExtendClient.deleteById(14);
    }
}