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
            log.info(quoterExtendClient.showAllQuotes());

            // --->GET BY ID<---
            log.info(quoterExtendClient.getById(3));

            // --->GET RANDOM QUOTE<---
            log.info(quoterExtendClient.getRandomQuote());

            // --->GET BY PARAM<---
            log.info(quoterExtendClient.getByParam(7));

            // --->GET BY HEADER<---
            log.info(quoterExtendClient.getAllWithHeader());

            // --->ADD QUOTE<---
            QuoteValue newQuoteValueAdder = new QuoteValue(null, "New quote ADDER 15");
            log.info(quoterExtendClient.addQuote(newQuoteValueAdder));

            // --->DELETE BY ID<---
            log.info(quoterExtendClient.deleteById(14));

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