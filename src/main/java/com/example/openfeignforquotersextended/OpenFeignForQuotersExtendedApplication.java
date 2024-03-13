package com.example.openfeignforquotersextended;

import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;

import java.util.List;


@SpringBootApplication
@EnableFeignClients
@Log4j2
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

        try {

            // ---> SHOW ALL<---
            List<QuoteExample> allQuotesResponse = quoterExtendClient.showAllQuotes();
            allQuotesResponse.forEach(System.out::println);

            // --->GET BY ID<---
            QuoteExample byIdResponse = quoterExtendClient.getById(3);
            System.out.println(byIdResponse);

            // --->GET RANDOM QUOTE<---
            QuoteExample randomQuoteResponse = quoterExtendClient.getRandomQuote();
            System.out.println(randomQuoteResponse);

            // --->GET BY PARAM<---
            QuoteExample byParamResponse = quoterExtendClient.getByParam(7);
            System.out.println(byParamResponse);

            // --->GET BY HEADER<---
            List<QuoteExample> allWithHeaderResponse = quoterExtendClient.getAllWithHeader();
            allWithHeaderResponse.forEach(System.out::println);

            // --->ADD QUOTE<---
            QuoteValue newQuoteValueAdder = new QuoteValue(null, "New quote ADDER");
            ResponseEntity<QuoteExample> response = quoterExtendClient.addQuote(newQuoteValueAdder);

            // --->DELETE BY ID<---
            quoterExtendClient.deleteById(13);

        } catch (FeignException.FeignClientException feignException) {
            log.error("Client exception: " + feignException.status());
        } catch (FeignException.FeignServerException feignException) {
            log.error("Server exception: " + feignException.status());
        } catch (RetryableException retryableException) {
            log.error("RetryableException: " + retryableException.getMessage());
        } catch (FeignException feignException) {
            log.error(feignException.status() + " " + feignException.getMessage());
        }

    }
}