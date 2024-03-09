package com.example.openfeignforquotersextended;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
        List<QuoteExample> quoteExamples = quoterExtendClient.showAllQuotes();
        quoteExamples.forEach(System.out::println);

        // --->GET BY ID<---
//        QuoteExample byId = quoterExtendClient.getById(1);
//        System.out.println(byId);

        // --->GET RANDOM QUOTE<---
//        QuoteExample randomQuote = quoterExtendClient.getRandomQuote();
//        System.out.println(randomQuote);

        // --->GET BY PARAM<---
//        QuoteExample byParam = quoterExtendClient.getByParam(2);
//        System.out.println(byParam);

        // --->GET BY HEADER<---
//        List<QuoteExample> allWithHeader = quoterExtendClient.getAllWithHeader();
//        System.out.println(allWithHeader);

        // --->ADD QUOTE<---
        QuoteValue newQuoteValueAdder = new QuoteValue(13L,"New quote ADDER");
        ResponseEntity<QuoteExample> response = quoterExtendClient.addQuote(newQuoteValueAdder);

        // --->DELETE BY ID <---
//        quoterExtendClient.deleteById(13);

    }
}